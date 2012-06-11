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
package tisstudio.metadata.useinjob;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendWebServiceItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseSimpleWebServiceTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendWebServiceItem wsItem;

    private static final String JOBNAME = "jobTest"; // $NON-NLS-1$

    private static final String METADATA_NAME = "webServiceTest"; // $NON-NLS-1$

    @Before
    public void createJobAndMetadata() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_WSDL_SCHEMA);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        wsItem = new TalendWebServiceItem(METADATA_NAME);
        wsItem.setTypeAsSimple();
        wsItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        String[] resultArray = { "Sunny", "Party Cloudy", "Rain", "Cloudy" };
        String results = "";
        for (int i = 0; i < resultArray.length; i++) {
            results += resultArray[i] + ",";
        }
        wsItem.setExpectResult(results);
        // wsItem.setComponentType("tWebServiceInput");
        MetadataHelper.output2Console(jobItem.getEditor(), wsItem);

        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, wsItem);
    }

}
