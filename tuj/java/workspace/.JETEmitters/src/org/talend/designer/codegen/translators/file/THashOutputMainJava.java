package org.talend.designer.codegen.translators.file;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;

public class THashOutputMainJava
{
  protected static String nl;
  public static synchronized THashOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashOutputMainJava result = new THashOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "Struct ";
  protected final String TEXT_3 = "_HashRow = new ";
  protected final String TEXT_4 = "Struct();";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "_HashRow.";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "tHash_";
  protected final String TEXT_11 = ".put(";
  protected final String TEXT_12 = "_HashRow, ";
  protected final String TEXT_13 = "_HashRow);" + NL;
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();
            IMetadataTable metadataTable = connection.getMetadataTable();
            

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    
			
            List<IMetadataColumn> listColumns = metadataTable.getListColumns();
            for (IMetadataColumn column : listColumns) {
                String columnName = column.getLabel();

    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    
            }


    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_13);
    
		}
	}


    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
