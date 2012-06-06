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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendCopybookItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class RetrieveSchemaTest extends TalendSwtBotForTos {

    private TalendCopybookItem copybookItem;

    private static final String COPYBOOK_NAME = "copybookTest";

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.METADATA_FILE_EBCDIC);
        copybookItem = new TalendCopybookItem(COPYBOOK_NAME);
        copybookItem.create();
    }

    @Test
    public void retrieveSchema() {
        SWTBotShell tempShell = null;
        int expectCount = 0;
        int actualCount = 0;
        try {
            copybookItem.getItem().contextMenu("Retrieve Schema").click();
            tempShell = gefBot.shell("Schema").activate();
            gefBot.button("Next >").click();
            expectCount = gefBot.table(0).rowCount();
            gefBot.button("Select All").click();
            gefBot.button("Next >").click();
            gefBot.button("Finish").click();

            actualCount = copybookItem.getItem().expand().rowCount();
            Assert.assertEquals("schemas did not retrieve", expectCount, actualCount);
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
    }

}
