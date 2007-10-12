package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TVtigerCRMInputBeginJava
{
  protected static String nl;
  public static synchronized TVtigerCRMInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMInputBeginJava result = new TVtigerCRMInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.talend.vtiger.IVtigerManager vtigerManager_";
  protected final String TEXT_2 = " = new org.talend.vtiger.VtigerManager(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL;
  protected final String TEXT_8 = NL + "                org.talend.vtiger.module.outlook.Contactdetail [] details_";
  protected final String TEXT_9 = " =  vtigerManager_";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "                org.talend.vtiger.module.outlook.Taskdetail [] details_";
  protected final String TEXT_13 = " = vtigerManager_";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "();                ";
  protected final String TEXT_16 = NL + "                org.talend.vtiger.module.outlook.Clndrdetail [] details_";
  protected final String TEXT_17 = " = vtigerManager_";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "();";
  protected final String TEXT_20 = NL + "                org.talend.vtiger.module.customerportal.Kbase_detail [] details_";
  protected final String TEXT_21 = " = vtigerManager_";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = "();";
  protected final String TEXT_24 = NL + "            for(int i = 0 ; i < details_";
  protected final String TEXT_25 = ".length ; i++) {";
  protected final String TEXT_26 = NL + "                        ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " = details_";
  protected final String TEXT_29 = "[i].get";
  protected final String TEXT_30 = "();";
  protected final String TEXT_31 = NL + "                        ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = details_";
  protected final String TEXT_34 = "[i];";
  protected final String TEXT_35 = NL + "            //}";
  protected final String TEXT_36 = NL + "                ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " = vtigerManager_";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = "();";
  protected final String TEXT_41 = NL + NL + NL + NL;
  protected final String TEXT_42 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String serverAddr = ElementParameterParser.getValue(node, "__SERVERADDR__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String userName = ElementParameterParser.getValue(node, "__USERNAME__");
String password = ElementParameterParser.getValue(node, "__PASSWORD__");
String version = ElementParameterParser.getValue(node, "__VERSION__");
String method = ElementParameterParser.getValue(node, "__METHODNAME__");
String outgoingConnName = null;
List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if(conns != null && conns.size() > 0) {
    IConnection conn = conns.get(0);
    outgoingConnName = conn.getName();
}
List<IMetadataColumn> metadataColumns = null;
List<IMetadataTable> metadataTables = node.getMetadataList();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serverAddr);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    
if(metadataTables != null && metadataTables.size() > 0) {
    IMetadataTable metadataTable = metadataTables.get(0);
    if(metadataTable != null) {
        metadataColumns = metadataTable.getListColumns();
        if(method.equals("searchContactsByEmail") || method.equals("getContacts") || method.equals("getTasks") || method.equals("getClndr") || method.equals("get_KBase_details")) {
            if(method.equals("searchContactsByEmail") || method.equals("getContacts")) {
                
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_11);
    
            } else if(method.equals("getTasks")) {
                
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_15);
    
            } else if(method.equals("getClndr")) {
                
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_19);
    
            } else if(method.equals("get_KBase_details")) {
                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_23);
    
            }
            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
                for(IMetadataColumn metadataColumn : metadataColumns) {
                    if(method.equals("searchContactsByEmail") || method.equals("getContacts") || method.equals("getTasks") || method.equals("getClndr")) {
                        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(metadataColumn.getLabel().substring(0,1).toUpperCase());
    stringBuffer.append(metadataColumn.getLabel().substring(1));
    stringBuffer.append(TEXT_30);
    
                    } else if(method.equals("get_KBase_details")) {
                        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
                    }
                }
                
    stringBuffer.append(TEXT_35);
    
        } else {
            for(IMetadataColumn metadataColumn : metadataColumns) {
                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_40);
    
            }
        }
    }
}    

    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
