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
package tisstudio.metadata.copybook;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendCopybookItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DuplicateCopybookTest extends TalendSwtBotForTos {

    private TalendCopybookItem copybookItem;

    private static final String COPYBOOKNAME = "copybook1"; //$NON-NLS-1$

    private static final String NEW_COPYBOOKNAME = "dplicate_copybook1"; //$NON-NLS-1$

    @Before
    public void createCopybook() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.METADATA_FILE_EBCDIC);
        copybookItem = new TalendCopybookItem(COPYBOOKNAME);
        copybookItem.create();
    }

    @Test
    public void duplicateCopybookTest() {
        copybookItem.duplicate(NEW_COPYBOOKNAME);
    }

}
