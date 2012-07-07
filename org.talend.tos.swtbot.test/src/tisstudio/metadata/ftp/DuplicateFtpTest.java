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
package tisstudio.metadata.ftp;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendFtpItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DuplicateFtpTest extends TalendSwtBotForTos {

    private TalendFtpItem ftpItem;

    private static final String FTPNAME = "ftpTest";

    private static final String NEW_FTPNAME = "dup_ftpTest";

    @Before
    public void createFtp() {
        repositories.add(ERepositoryObjectType.METADATA_FILE_FTP);

        ftpItem = new TalendFtpItem(FTPNAME);
        ftpItem.create();
    }

    @Test
    public void duplicateFtp() {
        ftpItem.duplicate(NEW_FTPNAME);
    }

}
