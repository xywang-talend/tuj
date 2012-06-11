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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendWebServiceItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseAdvanceWebServiceTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendWebServiceItem webServiceItem;

    private static final String JOB_NAME = "jobTest";

    private static final String METADATA_NAME = "webServiceTest";

    @Before
    public void createJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_WSDL_SCHEMA);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        webServiceItem = new TalendWebServiceItem(METADATA_NAME);
        webServiceItem.setTypeAsAdvanced();
        webServiceItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tFixedFlowInput", new Point(100, 100));
        SWTBotGefEditPart fixedFlowInput = getTalendComponentPart(jobItem.getEditor(), "tFixedFlowInput_1");
        Assert.assertNotNull("can not get component 'fixedFlowInput'", fixedFlowInput);
        jobItem.getEditor().click(fixedFlowInput);
        gefBot.viewByTitle("Component").setFocus();
        selecteAllTalendTabbedPropertyListIndex(0);
        gefBot.button(2).click();
        gefBot.shell("Schema of tFixedFlowInput_1").activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();
        SWTBotTable schemaTable = gefBot.tableInGroup("Mode");
        gefBot.waitUntil(Conditions.tableHasRows(schemaTable, 1));
        gefBot.tableInGroup("Mode").click(0, 2);
        gefBot.text(1).setText("\"test\"");
        // webServiceItem.setComponentType("tWebService");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), webServiceItem.getItem(), webServiceItem.getComponentType(), new Point(
                300, 100));
        SWTBotGefEditPart webService = getTalendComponentPart(jobItem.getEditor(), webServiceItem.getItemName());
        Assert.assertNotNull("can not get component '" + webServiceItem.getComponentType() + "'", webService);

        JobHelper.connect(jobItem.getEditor(), fixedFlowInput, webService);
        JobHelper.connect2TLogRow(jobItem.getEditor(), webService, new Point(500, 100));

        JobHelper.runJob(jobItem.getEditor());

        String[] resultArray = { "Sunny", "Party Cloudy", "Rain", "Cloudy" };
        String results = "";
        for (int i = 0; i < resultArray.length; i++) {
            results += resultArray[i] + ",";
        }
        webServiceItem.setExpectResult(results);
        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, webServiceItem);
    }

}
