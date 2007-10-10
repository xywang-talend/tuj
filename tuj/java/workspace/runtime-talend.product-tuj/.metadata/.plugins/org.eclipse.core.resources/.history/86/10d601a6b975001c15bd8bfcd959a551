package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TIterateToFlowOutBeginJava
{
  protected static String nl;
  public static synchronized TIterateToFlowOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TIterateToFlowOutBeginJava result = new TIterateToFlowOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "ThenRunStruct";
  protected final String TEXT_3 = " struct_";
  protected final String TEXT_4 = " = new ThenRunStruct";
  protected final String TEXT_5 = "();";
  protected final String TEXT_6 = NL + "struct_";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "  = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "if(globalMap.containsKey(\"";
  protected final String TEXT_11 = "\")){" + NL + "\tjava.util.List<ThenRunStruct";
  protected final String TEXT_12 = "> list_";
  protected final String TEXT_13 = " = (java.util.List<ThenRunStruct";
  protected final String TEXT_14 = ">)globalMap.get(\"";
  protected final String TEXT_15 = "\"); " + NL + "\tlist_";
  protected final String TEXT_16 = ".add(struct_";
  protected final String TEXT_17 = ");" + NL + "}else{" + NL + "\tjava.util.List<ThenRunStruct";
  protected final String TEXT_18 = "> list_";
  protected final String TEXT_19 = " = new java.util.ArrayList<ThenRunStruct";
  protected final String TEXT_20 = ">();" + NL + "\tlist_";
  protected final String TEXT_21 = ".add(struct_";
  protected final String TEXT_22 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_23 = "\",list_";
  protected final String TEXT_24 = ");" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String destination = ElementParameterParser.getValue(
    node,
    "__DESTINATION__"
);

List<Map<String, String>> mapping =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__MAPPING__"
    );

    stringBuffer.append(TEXT_2);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_5);
    
for (Map<String, String> mappingColumn : mapping) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mappingColumn.get("SCHEMA_COLUMN"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(mappingColumn.get("VALUE"));
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
