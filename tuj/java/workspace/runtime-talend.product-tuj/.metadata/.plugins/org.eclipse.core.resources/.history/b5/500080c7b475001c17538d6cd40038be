package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TReplaceMainJava
{
  protected static String nl;
  public static synchronized TReplaceMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TReplaceMainJava result = new TReplaceMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            if(";
  protected final String TEXT_3 = NL + "                         && ";
  protected final String TEXT_4 = NL + "                    java.util.regex.Pattern.compile(";
  protected final String TEXT_5 = ").matcher(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ").matches()";
  protected final String TEXT_8 = NL + "            ) {";
  protected final String TEXT_9 = NL + "                    ";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".replaceAll(";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "            nb_line_ok_";
  protected final String TEXT_17 = "++;";
  protected final String TEXT_18 = NL + "        }";
  protected final String TEXT_19 = NL + "                ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "    nb_line_";
  protected final String TEXT_25 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String incomingConnName = null;
List<? extends IConnection> inConns = node.getIncomingConnections();
if(inConns != null && inConns.size() > 0) {
    IConnection inConn = inConns.get(0);
    incomingConnName = inConn.getName();
}
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadataTables = node.getMetadataList();
if(metadataTables != null && metadataTables.size() > 0) {
    IMetadataTable metadataTable = metadataTables.get(0);
    columnList = metadataTable.getListColumns();
}
List<? extends IConnection> outgoingConns = node.getOutgoingConnections();
if(incomingConnName != null && columnList != null && columnList.size() > 0) {
    String advancedMode = ElementParameterParser.getValue( node, "__ADVANCED_MODE__" );
    String simpleMode = ElementParameterParser.getValue( node, "__SIMPLE_MODE__" );
    List<Map<String, String>> patterns = null;
    if(advancedMode.equals("true")) {
        patterns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADVANCED_SUBST__");
        if(patterns != null && patterns.size() > 0) {
            boolean whetherFirst = true;
            
    stringBuffer.append(TEXT_2);
    
            for(Map<String,String> pattern : patterns) {
                String patternStr = pattern.get("SEARCH_REPLACE");
                if(patternStr != null && !patternStr.equals("")) {
                    if(!whetherFirst) {
                        
    stringBuffer.append(TEXT_3);
    
                    }
                    whetherFirst = false;
                    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(patternStr);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(pattern.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_7);
    
                }
            }
            
    stringBuffer.append(TEXT_8);
    
        }
    }
    if(simpleMode.equals("true")) {
        List<Map<String, String>> substitutions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__SUBSTITUTIONS__");
        if(substitutions != null && substitutions.size() > 0) {
            for(Map<String,String> substitution : substitutions) {
                String replaceStr = substitution.get("REPLACE_STRING");
                if(replaceStr != null && !replaceStr.equals("")) {
                    String searchStr = substitution.get("SEARCH_PATTERN");
                    if(substitution.get("CASE_SENSITIVE").equals("false")) {
                        searchStr = "\"(?i)\" + " + searchStr;
                    }
                    if(substitution.get("WHOLE_WORD").equals("true")) {
                        searchStr = "\"\\\\b\" + " + searchStr + " + \"\\\\b\"";
                    }
                    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(substitution.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(substitution.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(searchStr);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(replaceStr);
    stringBuffer.append(TEXT_15);
    
                }
            }
            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
        }
    }
    if(advancedMode.equals("true") && patterns != null && patterns.size() > 0) {
        
    stringBuffer.append(TEXT_18);
    
    }
    if(outgoingConns != null && outgoingConns.size() > 0) {
        for(IConnection outgoingConn : outgoingConns) {
            for(IMetadataColumn metadataColumn : columnList) {
                
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_23);
    
            }
        }
    }
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
}

    return stringBuffer.toString();
  }
}
