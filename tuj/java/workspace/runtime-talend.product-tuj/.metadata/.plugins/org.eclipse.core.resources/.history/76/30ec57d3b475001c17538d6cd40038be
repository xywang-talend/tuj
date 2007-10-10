package org.talend.designer.codegen.translators.business;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;

public class TJasperOutputExecMainJava
{
  protected static String nl;
  public static synchronized TJasperOutputExecMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJasperOutputExecMainJava result = new TJasperOutputExecMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "    net.sf.jasperreports.engine.xml.JRXmlDigester digester_";
  protected final String TEXT_2 = " = new net.sf.jasperreports.engine.xml.JRXmlDigester();" + NL + "    net.sf.jasperreports.engine.xml.JRXmlDigesterFactory.configureDigester(digester_";
  protected final String TEXT_3 = ");" + NL + "    net.sf.jasperreports.engine.xml.JRXmlLoader xmlLoader_";
  protected final String TEXT_4 = " = new net.sf.jasperreports.engine.xml.JRXmlLoader(" + NL + "            digester_";
  protected final String TEXT_5 = ");" + NL + "    net.sf.jasperreports.engine.design.JasperDesign jasperDesign_";
  protected final String TEXT_6 = " = xmlLoader_";
  protected final String TEXT_7 = NL + "            .loadXML(new java.io.FileInputStream(";
  protected final String TEXT_8 = "));" + NL + "    net.sf.jasperreports.engine.JasperCompileManager.compileReportToFile(jasperDesign_";
  protected final String TEXT_9 = ", jasperFile_";
  protected final String TEXT_10 = ");" + NL + "" + NL + "    java.util.Map<String, Object> hm_";
  protected final String TEXT_11 = " = new java.util.HashMap<String, Object>();" + NL + "    hm_";
  protected final String TEXT_12 = ".put(net.sf.jasperreports.engine.JRParameter.REPORT_LOCALE, java.util.Locale.SIMPLIFIED_CHINESE);" + NL + "" + NL + "    net.sf.jasperreports.engine.data.JRCsvDataSource ds_";
  protected final String TEXT_13 = " = new net.sf.jasperreports.engine.data.JRCsvDataSource(" + NL + "            new java.io.File(sourceFile_";
  protected final String TEXT_14 = "));" + NL + "" + NL + "    ds_";
  protected final String TEXT_15 = ".setFieldDelimiter(',');" + NL + "    ds_";
  protected final String TEXT_16 = ".setRecordDelimiter(\"\\n\");" + NL + "    ds_";
  protected final String TEXT_17 = ".setUseFirstRowAsHeader(true);" + NL + "    net.sf.jasperreports.engine.JasperPrint print_";
  protected final String TEXT_18 = " = net.sf.jasperreports.engine.JasperFillManager.fillReport(" + NL + "            jasperFile_";
  protected final String TEXT_19 = ", hm_";
  protected final String TEXT_20 = ", ds_";
  protected final String TEXT_21 = ");" + NL;
  protected final String TEXT_22 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_23 = " = new net.sf.jasperreports.engine.export.JRHtmlExporter();\t\t";
  protected final String TEXT_24 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_25 = " = new net.sf.jasperreports.engine.export.JRPdfExporter();\t\t";
  protected final String TEXT_26 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_27 = " = new net.sf.jasperreports.engine.export.JRXlsExporter();\t\t";
  protected final String TEXT_28 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_29 = " = new net.sf.jasperreports.engine.export.JRRtfExporter();\t\t";
  protected final String TEXT_30 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_31 = " = new net.sf.jasperreports.engine.export.JRTextExporter();\t\t" + NL + "\texporter_";
  protected final String TEXT_32 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.PAGE_WIDTH, 255);" + NL + "    exporter_";
  protected final String TEXT_33 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.CHARACTER_WIDTH, 10);" + NL + "    exporter_";
  protected final String TEXT_34 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.PAGE_HEIGHT, 61);" + NL + "    exporter_";
  protected final String TEXT_35 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.CHARACTER_HEIGHT, 20);        ";
  protected final String TEXT_36 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_37 = " = new net.sf.jasperreports.engine.export.oasis.JROdtExporter();\t\t";
  protected final String TEXT_38 = NL + "    exporter_";
  protected final String TEXT_39 = ".setParameter(net.sf.jasperreports.engine.JRExporterParameter.OUTPUT_FILE_NAME, reportFile_";
  protected final String TEXT_40 = ");" + NL + "    exporter_";
  protected final String TEXT_41 = ".setParameter(net.sf.jasperreports.engine.JRExporterParameter.JASPER_PRINT, print_";
  protected final String TEXT_42 = ");" + NL + "    exporter_";
  protected final String TEXT_43 = ".exportReport();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String filename = ElementParameterParser.getValue(node,"__JRXML_FILE__");
String reportType = ElementParameterParser.getValue(node,"__REPORT_TYPE__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			if(reportType.equalsIgnoreCase("html")){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
			}else if(reportType.equalsIgnoreCase("pdf")){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
			}else if(reportType.equalsIgnoreCase("xls")){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
			}else if(reportType.equalsIgnoreCase("rtf")){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
			}else if(reportType.equalsIgnoreCase("txt")){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			}else if(reportType.equalsIgnoreCase("odt")){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
