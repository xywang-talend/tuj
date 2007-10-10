package org.talend.designer.codegen.translators.file;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;

public class THashInputBeginJava
{
  protected static String nl;
  public static synchronized THashInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashInputBeginJava result = new THashInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "  int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "  java.util.Map <";
  protected final String TEXT_4 = "Struct, ";
  protected final String TEXT_5 = "Struct>  tHash_";
  protected final String TEXT_6 = " = (java.util.Map<";
  protected final String TEXT_7 = "Struct, ";
  protected final String TEXT_8 = "Struct>) globalMap.get( \"tHash_";
  protected final String TEXT_9 = "\" );" + NL + "\tjava.util.Collection values";
  protected final String TEXT_10 = "= tHash_";
  protected final String TEXT_11 = ".values();" + NL + "\t\tObject[] oValue";
  protected final String TEXT_12 = " = values";
  protected final String TEXT_13 = ".toArray();\t" + NL + "\t\tfor(int i=0;i<oValue";
  protected final String TEXT_14 = ".length;i++)" + NL + "\t\t{";
  protected final String TEXT_15 = NL + "  \t\t\t";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = "=((";
  protected final String TEXT_18 = "Struct)oValue";
  protected final String TEXT_19 = "[i]).";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + NL + NL + NL + " " + NL + " " + NL + "            ";
  protected final String TEXT_22 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	String cid = node.getUniqueName();
    	String sourceComponent = ElementParameterParser.getValue(node, "__LIST__");
    	INode sourceNode=null;
    	for (INode currentNode : (List<INode>) node.getProcess().getGeneratingNodes()) {
    	   if (currentNode.getUniqueName().equals(sourceComponent)) {
    	      sourceNode = currentNode;
    	   }
    	}
    	if (sourceNode != null) {
    	List<IConnection> connections = (List<IConnection>) sourceNode.getIncomingConnections();
    	if (connections != null && connections.size() > 0) {
    	  	IConnection connection=connections.get(0);
          	String connectionName = connection.getName();
          	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();  
 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sourceComponent);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sourceComponent);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(sourceComponent);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
 if(conns!=null){
    		if (conns.size()>0){
       		IConnection conn =conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int j = 0; j < sizeColumns; j++) {
    			IMetadataColumn column = columns.get(j);
    			String columnName = column.getLabel();
  
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
      			
 							}
 						}
 					}
 				}
    		}         
   		}
   	}
   }

    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
