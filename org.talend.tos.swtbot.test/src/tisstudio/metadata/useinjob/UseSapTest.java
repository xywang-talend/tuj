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
import org.talend.swtbot.items.TalendSapItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseSapTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendSapItem sapItem;

    private TalendSapItem sapFunction;

    private TalendSchemaItem schema;

    private static final String JOB_NAME = "jobTest";

    private static final String SAP_NAME = "sapTest";

    @Before
    public void creataJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_SAPCONNECTIONS);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        sapItem = new TalendSapItem(SAP_NAME);
        sapItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        sapItem.retrieveSapFunction("RFC_READ_TABLE");
        sapFunction = sapItem.getSapFunction("RFC_READ_TABLE");
        sapFunction.retrieveSchema("DATA");
        schema = sapFunction.getSchema("DATA");
        MetadataHelper.output2Console(jobItem.getEditor(), schema, "row_DATA_1");
        String actualResult = JobHelper.getExecutionResult();
        schema.setExpectResultFromFile("sap.result");
        MetadataHelper.assertResult(actualResult, schema);
    }

}
