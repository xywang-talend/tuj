package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TVtigerCRMOutputMainJava
{
  protected static String nl;
  public static synchronized TVtigerCRMOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMOutputMainJava result = new TVtigerCRMOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            org.talend.vtiger.module.outlook.Clndrdetail clndrdetail_";
  protected final String TEXT_2 = " = new org.talend.vtiger.module.outlook.Clndrdetail();";
  protected final String TEXT_3 = NL + "            org.talend.vtiger.module.outlook.Contactdetail contactdetail_";
  protected final String TEXT_4 = " = new org.talend.vtiger.module.outlook.Contactdetail();";
  protected final String TEXT_5 = NL + "            org.talend.vtiger.module.outlook.Taskdetail taskdetail_";
  protected final String TEXT_6 = " = new org.talend.vtiger.module.outlook.Taskdetail();";
  protected final String TEXT_7 = NL + "            String contactid_";
  protected final String TEXT_8 = " = null;" + NL + "            org.talend.vtiger.module.outlook.Emailmsgdetail emailmsgdetail_";
  protected final String TEXT_9 = " = new org.talend.vtiger.module.outlook.Emailmsgdetail();";
  protected final String TEXT_10 = NL + "                clndrdetail_";
  protected final String TEXT_11 = ".set";
  protected final String TEXT_12 = "(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ");            ";
  protected final String TEXT_15 = NL + "                contactdetail_";
  protected final String TEXT_16 = ".set";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                taskdetail_";
  protected final String TEXT_21 = ".set";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "                    contactid_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL + "                    emailmsgdetail_";
  protected final String TEXT_30 = ".set";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "            clndrDetais_";
  protected final String TEXT_35 = ".add(clndrdetail_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "            contactdetails_";
  protected final String TEXT_38 = ".add(contactdetail_";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "            taskdetails_";
  protected final String TEXT_41 = ".add(taskdetail_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "            vtigerManager_";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = "(contactid_";
  protected final String TEXT_46 = ",emailmsgdetail_";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "                vtigerManager_";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                vtigerManager_";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = "();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String method = ElementParameterParser.getValue(node, "__METHODNAME__");
String incomingConnName = null;
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns != null && conns.size() > 0) {
    IConnection conn = conns.get(0);
    incomingConnName = conn.getName();
}
List<IMetadataColumn> metadataColumns = null;
List<IMetadataTable> metadataTables = node.getMetadataList();
if(metadataTables != null && metadataTables.size() > 0) {
    IMetadataTable metadataTable = metadataTables.get(0);
    if(metadataTable != null) {
        metadataColumns = metadataTable.getListColumns();
        StringBuffer paramString = null;
        if(method.equals("addClndr") || method.equals("updateClndr")) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
        } else if(method.equals("addContacts") || method.equals("updateContacts")) {
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
        } else if(method.equals("addTasks") || method.equals("updateTasks")) {
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
        } else if (method.equals("addMessageToContact")) {
            
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
        } else {
            paramString = new StringBuffer();
        }
        for(IMetadataColumn metadataColumn : metadataColumns) {
            if(method.equals("addClndr") || method.equals("updateClndr")) {
                
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(metadataColumn.getLabel().substring(0,1).toUpperCase());
    stringBuffer.append(metadataColumn.getLabel().substring(1));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_14);
    
            } else if(method.equals("addContacts") || method.equals("updateContacts")) {
                
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(metadataColumn.getLabel().substring(0,1).toUpperCase());
    stringBuffer.append(metadataColumn.getLabel().substring(1));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_19);
    
            } else if(method.equals("addTasks") || method.equals("updateTasks")) {
                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(metadataColumn.getLabel().substring(0,1).toUpperCase());
    stringBuffer.append(metadataColumn.getLabel().substring(1));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_24);
    
            } else if(method.equals("addMessageToContact")) {
                if(metadataColumn.getLabel().equals("contactid")) {
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_28);
    
                } else {
                    
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(metadataColumn.getLabel().substring(0,1).toUpperCase());
    stringBuffer.append(metadataColumn.getLabel().substring(1));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_33);
    
                }
            } else {
                paramString.append(incomingConnName + "." + metadataColumn.getLabel() + ", ");
            }
        }
        if(method.equals("addClndr") || method.equals("updateClndr")) {
            
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
        } else if(method.equals("addContacts") || method.equals("updateContacts")) {
            
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
        } else if(method.equals("addTasks") || method.equals("updateTasks")) {
            
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
        } else if(method.equals("addMessageToContact")) {
            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
        } else {
            if(paramString.toString().length() > 0) {            
                
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(paramString.toString().substring(0,paramString.toString().lastIndexOf(",")));
    stringBuffer.append(TEXT_51);
    
            } else {
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_54);
    
            }
        }  
    }
}

    return stringBuffer.toString();
  }
}
