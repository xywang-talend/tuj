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
package tosstudio.sqltemplates;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCTabItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendSqlTemplateItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenAnotherVersionOfSqlTemplateTest extends TalendSwtBotForTos {

    private TalendSqlTemplateItem sqlTemplateItem;

    private static final String SQLTEMPLATE_NAME = "sqlTemplateTest"; //$NON-NLS-1$

    private static final String FOLDERPATH = "Hive/UserDefined"; //$NON-NLS-1$

    @Before
    public void createAJob() {
        repositories.add(ERepositoryObjectType.SQLPATTERNS);
        sqlTemplateItem = new TalendSqlTemplateItem(SQLTEMPLATE_NAME);
        sqlTemplateItem.setFolderPath(FOLDERPATH);
        sqlTemplateItem.create();
        sqlTemplateItem.getEditor().saveAndClose();
    }

    @Test
    public void openAnotherVersionOfSqlTemplate() {
        sqlTemplateItem.getItem().contextMenu("Open an other version").click();

        gefBot.shell("New job").activate();
        gefBot.checkBox("Create new version and open it?").click();
        gefBot.button("M").click();
        gefBot.button("m").click();
        gefBot.button("Finish").click();

        SWTBotCTabItem newTabItem1 = gefBot.cTabItem(SQLTEMPLATE_NAME + " 1.1");
        Assert.assertNotNull("sql template tab is not opened", newTabItem1);
    }

}
