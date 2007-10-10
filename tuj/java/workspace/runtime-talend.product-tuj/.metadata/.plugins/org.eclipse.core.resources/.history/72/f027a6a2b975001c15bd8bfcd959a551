package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;

public class TRSSOutputBeginJava
{
  protected static String nl;
  public static synchronized TRSSOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRSSOutputBeginJava result = new TRSSOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tint nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "\tjava.io.File file";
  protected final String TEXT_3 = "=new java.io.File(";
  protected final String TEXT_4 = ");" + NL + "\torg.dom4j.Document document";
  protected final String TEXT_5 = " =null;" + NL + "\torg.dom4j.Element channelElement";
  protected final String TEXT_6 = " =null;" + NL + "\torg.dom4j.Element titleHElement";
  protected final String TEXT_7 = "=null;" + NL + "\torg.dom4j.Element descriptionHElement";
  protected final String TEXT_8 = "=null;" + NL + "\torg.dom4j.Element pubdateHElement";
  protected final String TEXT_9 = "=null;" + NL + "\torg.dom4j.Element linkHElement";
  protected final String TEXT_10 = "=null;" + NL + "\t" + NL + "\tif(";
  protected final String TEXT_11 = " && file";
  protected final String TEXT_12 = ".exists())" + NL + "\t\t{" + NL + "" + NL + "\t\torg.dom4j.io.SAXReader saxReader";
  protected final String TEXT_13 = " = new org.dom4j.io.SAXReader();" + NL + "        document";
  protected final String TEXT_14 = " = saxReader";
  protected final String TEXT_15 = " .read(new java.io.File(";
  protected final String TEXT_16 = "));" + NL + "" + NL + "" + NL + "\t\t}else" + NL + "\t\t{" + NL + "" + NL + "\t\t document";
  protected final String TEXT_17 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "\t\t org.dom4j.Element rssElement";
  protected final String TEXT_18 = " = document";
  protected final String TEXT_19 = ".addElement(\"rss\");" + NL + "\t\t rssElement";
  protected final String TEXT_20 = ".addAttribute(\"version\",\"2.0\");" + NL + "\t\t channelElement";
  protected final String TEXT_21 = " = rssElement";
  protected final String TEXT_22 = ".addElement(\"channel\");" + NL + "\t\t titleHElement";
  protected final String TEXT_23 = "=channelElement";
  protected final String TEXT_24 = ".addElement(\"title\");" + NL + "\t\t titleHElement";
  protected final String TEXT_25 = ".setText(";
  protected final String TEXT_26 = ");" + NL + "\t\t descriptionHElement";
  protected final String TEXT_27 = "=channelElement";
  protected final String TEXT_28 = ".addElement(\"description\");" + NL + "\t\t descriptionHElement";
  protected final String TEXT_29 = ".setText(";
  protected final String TEXT_30 = ");" + NL + "\t\t pubdateHElement";
  protected final String TEXT_31 = "=channelElement";
  protected final String TEXT_32 = ".addElement(\"pubdate\");" + NL + "\t\t pubdateHElement";
  protected final String TEXT_33 = ".setText(";
  protected final String TEXT_34 = ");" + NL + "\t\t linkHElement";
  protected final String TEXT_35 = "=channelElement";
  protected final String TEXT_36 = ".addElement(\"link\");" + NL + "\t\t linkHElement";
  protected final String TEXT_37 = ".setText(";
  protected final String TEXT_38 = ");" + NL + "\t\t " + NL + "\t }";
  protected final String TEXT_39 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
      	String title= ElementParameterParser.getValue(node,"__TITLE__");
      	String description= ElementParameterParser.getValue(node,"__DESCRIPTION__");
      	String pubdate= ElementParameterParser.getValue(node,"__PUBDATE__");
      	String link= ElementParameterParser.getValue(node,"__LINK__");
        boolean isAppend = ElementParameterParser.getValue(node,"__APPEND__").equals("true");
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(filename);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(title);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(description);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pubdate);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(link);
    stringBuffer.append(TEXT_38);
    	
			
 		}
	}

    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
