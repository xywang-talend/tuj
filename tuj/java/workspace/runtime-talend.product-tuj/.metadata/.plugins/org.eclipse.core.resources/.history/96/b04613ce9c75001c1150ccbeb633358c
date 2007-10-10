package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IExternalNode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Component_part_footerJava
{
  protected static String nl;
  public static synchronized Component_part_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Component_part_footerJava result = new Component_part_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + " runStat.updateStatOnConnection(\"";
  protected final String TEXT_3 = "\",2, 0); ";
  protected final String TEXT_4 = NL + "  if (";
  protected final String TEXT_5 = " !=null) {" + NL + "   // here we dump the line content for trace purpose" + NL + "   runTrace.sendTrace(\"";
  protected final String TEXT_6 = "\",\"";
  protected final String TEXT_7 = "=\"+";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "+\"|";
  protected final String TEXT_10 = "\");" + NL + "  }";
  protected final String TEXT_11 = NL + " ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + NL + "ok_Hash.put(\"";
  protected final String TEXT_17 = "\", true);" + NL + "end_Hash.put(\"";
  protected final String TEXT_18 = "\", java.util.Calendar.getInstance().getTimeInMillis());" + NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = ".addMessage(\"end\",\"";
  protected final String TEXT_21 = "\", end_Hash.get(\"";
  protected final String TEXT_22 = "\")-start_Hash.get(\"";
  protected final String TEXT_23 = "\"));";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = "Process();";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = "Process();";
  protected final String TEXT_28 = NL + "   if (";
  protected final String TEXT_29 = ") {";
  protected final String TEXT_30 = NL + "    ";
  protected final String TEXT_31 = "Process();" + NL + "   }";
  protected final String TEXT_32 = NL + "/**" + NL + " * [";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = " ] stop" + NL + " */";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
ECodePart codePart = codeGenArgument.getCodePart();
boolean trace = codeGenArgument.isTrace();
boolean stat = codeGenArgument.isStatistics();
Set<IConnection> connSet =  new HashSet<IConnection>();
connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));

    stringBuffer.append(TEXT_1);
    
if((codePart.equals(ECodePart.END))&&(stat)&&connSet.size()>0){
  for(IConnection con:connSet){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_3);
    
  }
}

 if (codePart.equals(ECodePart.MAIN)) {
  for (IConnection conn : node.getOutgoingConnections()) {
   IMetadataTable metadata = conn.getMetadataTable();
   if (metadata!=null) {
    if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
     if (trace) {    

    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_6);
    
         for (IMetadataColumn column : metadata.getListColumns()) {
   
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_9);
    
         }

    stringBuffer.append(TEXT_10);
    
     }
    }
   }
  }
  
  String inputColName = null;
  if (node.getIncomingConnections()!=null) {
   for (IConnection incomingConn : node.getIncomingConnections()) {
    if (incomingConn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
     inputColName = incomingConn.getName();
     break;
    }
   }
  }
  List<IMetadataTable> metadatas = node.getMetadataList();
  if ((!node.isSubProcessStart())&&(node.getComponent().isDataAutoPropagated())) {
   if (inputColName!=null) {
    if ((metadatas != null) && (metadatas.size() > 0)) {
     IMetadataTable metadata = metadatas.get(0);
     if (metadata != null) {
      for (IConnection conn : node.getOutgoingConnections()) {
       if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
        for (IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inputColName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
     
        }
       }
      }
     }
    }
   }
  }
 }
 if (codePart.equals(ECodePart.END)) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_18);
    
  String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
  if ((node.getProcess().getNodesOfType("tStatCatcher").size() > 0) & (statCatcher.equals("true"))) {
   for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_25);
    
   }
  }
  
  for (IConnection outgoingConn : node.getOutgoingConnections()) {
  	if (outgoingConn.getTarget().isActivate()) {
  		if (outgoingConn.getLineStyle().equals(EConnectionType.RUN_IF_OK)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingConn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_27);
    
   		}
   		if (outgoingConn.getLineStyle().equals(EConnectionType.RUN_IF)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(outgoingConn.getCondition() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outgoingConn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_31);
    
   		}
   	}
  }
 }

    stringBuffer.append(TEXT_32);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(codePart );
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
