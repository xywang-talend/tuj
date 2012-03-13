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
package org.talend.swtbot.refactor;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendXmlFileItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateXmlFileWithXsdTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendXmlFileItem fileItem;

    private static final String JOB_NAME = "jobTest";

    private static final String FILE_NAME = "fileXml";

    private String defaultProp_loop = null;

    private String defaultProp_schema0 = null;

    private String defaultProp_schema1 = null;

    private String defaultProp_schema2 = null;

    @Before
    public void createJobAndMetadata() {
        fileItem = new TalendXmlFileItem(FILE_NAME);
        fileItem.setFilePath("test.xsd");
        defaultProp_loop = System.getProperty("filexml.loop");
        defaultProp_schema0 = System.getProperty("filexml.schema0");
        defaultProp_schema1 = System.getProperty("filexml.schema1");
        defaultProp_schema2 = System.getProperty("filexml.schema2");
        System.setProperty("filexml.loop", "Root/Customers/Customer");
        System.setProperty("filexml.schema0", "@CustomerID");
        System.setProperty("filexml.schema1", "CompanyName");
        System.setProperty("filexml.schema2", "ContactName");
        fileItem.create();

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void createXmlFileWithXsdTest() throws IOException, URISyntaxException {
        fileItem.setComponentType("tFileInputXML");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), fileItem.getItem(), fileItem.getComponentType(), new Point(100, 100));
        String filePath = Utilities.getFileFromCurrentPluginSampleFolder("test.xml").getAbsolutePath();
        gefBot.textWithLabel("File Name: ").setText(filePath);
        gefBot.button("Confirm").click();
        getTalendComponentPart(jobItem.getEditor(), fileItem.getItemName()).doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        String fileName = gefBot.text(2).getText(); // gefBot.textWithLabel("Filename/InputStream").getText()
        String expectedName = "\"" + filePath.replace("\\", "/") + "\"";
        Assert.assertEquals("the path to XML did not change", expectedName, fileName);
    }

    @After
    public void removePreviousCreateItem() {
        System.setProperty("filexml.loop", defaultProp_loop);
        System.setProperty("filexml.schema0", defaultProp_schema0);
        System.setProperty("filexml.schema1", defaultProp_schema1);
        System.setProperty("filexml.schema2", defaultProp_schema2);
    }
}
