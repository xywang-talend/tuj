package org.talend.designer.codegen.translators.file;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IHashableColumn;
import org.talend.core.model.process.IMatchingMode;
import java.util.HashSet;
import java.util.Set;
import org.talend.core.model.process.EConnectionType;

public class TAdvancedHashBeginJava
{
  protected static String nl;
  public static synchronized TAdvancedHashBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedHashBeginJava result = new TAdvancedHashBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t   \t\torg.talend.designer.components.commons.AdvancedLookup.MATCHING_MODE matchingModeEnum = " + NL + "\t\t\t   \t\t\torg.talend.designer.components.commons.AdvancedLookup.MATCHING_MODE.";
  protected final String TEXT_3 = ";" + NL + "\t   \t\t\torg.talend.designer.components.commons.AdvancedLookup<";
  protected final String TEXT_4 = "Struct> tHash_Lookup_";
  protected final String TEXT_5 = " = " + NL + "\t   \t\t\t\torg.talend.designer.components.commons.AdvancedLookup." + NL + "\t   \t\t\t\t\t<";
  protected final String TEXT_6 = "Struct>getLookup(matchingModeEnum);" + NL + "   \t   \t   globalMap.put(\"tHash_Lookup_";
  protected final String TEXT_7 = "\", tHash_Lookup_";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "            ";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();


    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
    List<IConnection> outConnections = (List<IConnection>) node.getOutgoingConnections();
    
    List<INode> graphicalNodes = (List<INode>) node.getProcess().getGraphicalNodes();
    
	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();

   INode nodeSource = connection.getSource();
   
   INode validTarget = null;
   INode currentTarget = null;
   
      List<IConnection> outGraphicalConnections = (List<IConnection>) nodeSource.getOutgoingConnections(EConnectionType.FLOW_REF);
      for(IConnection outGraphicalConnection : outGraphicalConnections) {
       if(outGraphicalConnection.getUniqueName().equals(connectionName)) {
        currentTarget = outGraphicalConnection.getTarget();
       }
      }
			

			if(!(currentTarget instanceof IHashableInputConnections)) {
				currentTarget = currentTarget.getExternalNode();
			}
			if(currentTarget instanceof IHashableInputConnections) {
				validTarget = currentTarget;
			}

			// System.out.println(connectionName + " ######## " + validTarget + " " + validTarget.getClass());

			if(validTarget != null) {
					IHashableInputConnections target = (IHashableInputConnections) validTarget;
					IHashConfiguration hashConfiguration = target.getHashConfiguration(connection.getName());
					List<IHashableColumn> hashableColumns = null;
					IMatchingMode matchingMode = null;
					if(hashConfiguration == null) {
						hashableColumns = new ArrayList(0);
					} else {
						hashableColumns = hashConfiguration.getHashableColumns();
						matchingMode = hashConfiguration.getMatchingMode();
					}
					
					String matchingModeStr = null;
					if(matchingMode == null) {
						if(hashableColumns.size() > 0) {
							matchingModeStr = "UNIQUE_MATCH";
						} else {
							matchingModeStr = "ALL_ROWS";
						}
					} else {
						matchingModeStr = matchingMode.toString();
					}
					
			   
    stringBuffer.append(TEXT_2);
    stringBuffer.append( matchingModeStr );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
    
			} else { 
				// System.out.println(connectionName + " ######## Valid target not found" );
			}
		}
	}


    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
