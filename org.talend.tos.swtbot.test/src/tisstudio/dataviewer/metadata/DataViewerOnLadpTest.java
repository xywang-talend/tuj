// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tisstudio.dataviewer.metadata;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendLdapItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnLadpTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendLdapItem ldapItem;

    private static final String JOBNAME = "jobTest"; // $NON-NLS-1$

    private static final String METADATA_NAME = "ldapTest"; // $NON-NLS-1$

    @Before
    public void createJobAndMetadata() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_LDAP_SCHEMA);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        ldapItem = new TalendLdapItem(METADATA_NAME);
        ldapItem.create();
    }

    @Test
    public void testDataView() {
        ldapItem.setComponentType("tLDAPInput");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), ldapItem.getItem(), ldapItem.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart ldap = getTalendComponentPart(jobItem.getEditor(), METADATA_NAME);
        Assert.assertNotNull("cann't get component " + ldapItem.getComponentType() + "", ldap);
        Utilities.dataView(jobItem, ldap, "tLDAPInput");
        int rows = gefBot.tree(0).rowCount();
        Assert.assertEquals("the result is not the expected result", 8, rows);
        gefBot.activeShell().close();
    }

}
