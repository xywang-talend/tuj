package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Component_part_headerJava
{
  protected static String nl;
  public static synchronized Component_part_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Component_part_headerJava result = new Component_part_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/**" + NL + " * [";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = " ] start" + NL + " */" + NL;
  protected final String TEXT_4 = NL + NL + NL + "ok_Hash.put(\"";
  protected final String TEXT_5 = "\", false);" + NL + "start_Hash.put(\"";
  protected final String TEXT_6 = "\", java.util.Calendar.getInstance().getTimeInMillis());";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = ".addMessage(\"begin\",\"";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = "Process();";
  protected final String TEXT_12 = NL + "   MetterCatcherUtils.addLineToRow(\"";
  protected final String TEXT_13 = "_count\");";
  protected final String TEXT_14 = NL + "   MetterCatcherUtils.addLineToRow(\"";
  protected final String TEXT_15 = "_count\");";
  protected final String TEXT_16 = NL + "currentComponent=\"";
  protected final String TEXT_17 = "\";" + NL;
  protected final String TEXT_18 = NL + "\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_19 = "\",0, 0); ";
  protected final String TEXT_20 = NL + NL + "//";
  protected final String TEXT_21 = NL + "//";
  protected final String TEXT_22 = NL + NL;
  protected final String TEXT_23 = NL + "  runStat.updateStatOnConnection(\"";
  protected final String TEXT_24 = "\",1, 1);";
  protected final String TEXT_25 = NL + " runStat.updateStatOnConnection(\"";
  protected final String TEXT_26 = "\",1, 1);";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;

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
	String incomingName = codeGenArgument.getIncomingName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codePart );
    stringBuffer.append(TEXT_3);
    
	if (codePart.equals(ECodePart.BEGIN)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_6);
    
		String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
		if ((node.getProcess().getNodesOfType("tStatCatcher").size() > 0) && (statCatcher.equals("true"))) {
			for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_11);
    
			}
		}
	}
	if(codePart.equals(ECodePart.MAIN)) {
	    if ((node.getProcess().getNodesOfType("tFlowMeter").size() > 0))
	    {
        	for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MAIN))
        	{
        	    String name_conn = temp_conn.getUniqueName();
        	    if(temp_conn.isUseByMetter())
        	    { 	    	

    stringBuffer.append(TEXT_12);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_13);
    
				}
			}
			
			for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MERGE))
        	{
        	    String name_conn = temp_conn.getUniqueName();
        	    if(name_conn == incomingName && temp_conn.isUseByMetter())
        	    { 	    	

    stringBuffer.append(TEXT_14);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_15);
    
				}
			}			
	    }
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_17);
    
	connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MERGE));
	
	if ((codePart.equals(ECodePart.BEGIN))&&(stat)&&connSet.size()>0) {
		for(IConnection con:connSet){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_19);
    		}
	}
	
	if((codePart.equals(ECodePart.MAIN))&&(stat)&&connSet.size()>0){
		for(IConnection con:connSet){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append((String)codeGenArgument.getIncomingName());
    stringBuffer.append(TEXT_22);
    if (!node.getComponent().useMerge()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_24);
    
	} else if(con.getUniqueName().equals((String)codeGenArgument.getIncomingName())){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    
		}
	}

    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
