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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendSqlTemplateItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DuplicateSqlTemplateTest extends TalendSwtBotForTos {

    private TalendSqlTemplateItem sqlTemplateItem;

    private static final String SQLTEMPLATENAME = "sqlTemplate1"; //$NON-NLS-1$

    private static final String NEW_SQLTEMPLATENAME = "duplicate_sqlTemplate1"; //$NON-NLS-1$

    private static final String FOLDERPATH = "Generic/UserDefined"; //$NON-NLS-1$

    @Before
    public void createSqlTemplate() {
        sqlTemplateItem = new TalendSqlTemplateItem(SQLTEMPLATENAME);
        sqlTemplateItem.setFolderPath(FOLDERPATH);
        sqlTemplateItem.create();
    }

    @Test
    public void duplicateSqlTemplate() {
        sqlTemplateItem.duplicate(NEW_SQLTEMPLATENAME);
    }

    @After
    public void removePreviouslyCreateItems() {
        sqlTemplateItem.getEditor().saveAndClose();
        Utilities.cleanUpRepository(sqlTemplateItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
