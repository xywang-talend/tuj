package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TOracleSCDEndJava
{
  protected static String nl;
  public static synchronized TOracleSCDEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleSCDEndJava result = new TOracleSCDEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tinsertQuery_";
  protected final String TEXT_3 = ".close();" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tl1Query_";
  protected final String TEXT_5 = ".close();" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\tl2Query_";
  protected final String TEXT_7 = ".close();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tl3Query_";
  protected final String TEXT_9 = ".close();" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\tif (!connection_";
  protected final String TEXT_11 = ".getAutoCommit()) {" + NL + "\t\t\tconnection_";
  protected final String TEXT_12 = ".commit();" + NL + "    \t}" + NL + "    \tconnection_";
  protected final String TEXT_13 = ".close();" + NL + "    \t";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Search incoming schema
IMetadataTable inMetadata = null;

List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
    inMetadata = incomingConnections.get(0).getMetadataTable();
}

// Search outgoing schema
IMetadataTable metadata = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    metadata = metadatas.get(0);
}

// We only generate output if incoming and outgoing schema are defined
if (inMetadata != null && metadata != null) {
    boolean useExistingConnection = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__").equals("true");
	boolean useL1 = ElementParameterParser.getValue(node, "__USE_L1__").equals("true");
	boolean useL2 = ElementParameterParser.getValue(node, "__USE_L2__").equals("true");
	boolean useL3 = ElementParameterParser.getValue(node, "__USE_L3__").equals("true");
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if (useL1) {
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}
	
	if (useL2) {
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}
	
	if (useL3) {
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	}
	
	if (!useExistingConnection) {
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
	}
}

    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
