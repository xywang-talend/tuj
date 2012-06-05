package org.talend.mdm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Results {
	
	public Document getResults(List<TestCase> tcs){
        Document document = DocumentHelper.createDocument();
        Element results = document.addElement("results");

        for(TestCase tc : tcs) {
        	results.addComment(tc.getComment());
            Element testcase = results.addElement("testcase");
            testcase.addAttribute("id", tc.getId()+"");

            Element result = testcase.addElement("result");
            result.setText(tc.getResult().toString());
            Element notes = testcase.addElement("notes");
            notes.setText(tc.getNote());
        }
        return document;
	}
	
	public void crateXmlFile(Document document, String fileName) {
        XMLWriter output;
        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            output = new XMLWriter(new FileWriter(fileName), format);
            output.write(document);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}