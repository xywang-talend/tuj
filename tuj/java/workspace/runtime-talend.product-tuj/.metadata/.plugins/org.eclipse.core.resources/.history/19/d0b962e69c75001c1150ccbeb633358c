package org.talend.designer.codegen.translators.file;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class THashOutputBeginJava
{
  protected static String nl;
  public static synchronized THashOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashOutputBeginJava result = new THashOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            java.util.Map<";
  protected final String TEXT_3 = "Struct, ";
  protected final String TEXT_4 = "Struct> tHash_";
  protected final String TEXT_5 = " = new java.util.HashMap<";
  protected final String TEXT_6 = "Struct, ";
  protected final String TEXT_7 = "Struct>();" + NL + "            if(";
  protected final String TEXT_8 = ")" + NL + "            {" + NL + "               if(globalMap.get(\"tHash_";
  protected final String TEXT_9 = "\") != null){" + NL + "                   tHash_";
  protected final String TEXT_10 = "=(java.util.Map<";
  protected final String TEXT_11 = "Struct, ";
  protected final String TEXT_12 = "Struct>)globalMap.get(\"tHash_";
  protected final String TEXT_13 = "\");" + NL + "                   if(!tHash_";
  protected final String TEXT_14 = ".isEmpty()){" + NL + "                     tHash_";
  protected final String TEXT_15 = ".clear();" + NL + "                   }" + NL + "               }" + NL + "            }" + NL + "           " + NL + "            globalMap.put(\"tHash_";
  protected final String TEXT_16 = "\", tHash_";
  protected final String TEXT_17 = ");" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean clearData = ElementParameterParser.getValue(node, "__CLEAR_DATA__").equals("true");
	String comName=ElementParameterParser.getValue(node, "__COMPNAME__");
	String cid = node.getUniqueName();
    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(clearData);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
		}
	}


    return stringBuffer.toString();
  }
}
