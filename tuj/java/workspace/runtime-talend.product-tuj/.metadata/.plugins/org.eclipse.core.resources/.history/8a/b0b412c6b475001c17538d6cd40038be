package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TUniteMainJava
{
  protected static String nl;
  public static synchronized TUniteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniteMainJava result = new TUniteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//////////" + NL;
  protected final String TEXT_2 = " " + NL + "" + NL + "// for output";
  protected final String TEXT_3 = NL + "\t\t\t";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();" + NL + "\t\t\t";
  protected final String TEXT_6 = "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t";
  protected final String TEXT_12 = " = new ";
  protected final String TEXT_13 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "      \t\t\t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_19 = NL + NL + "\t\t\tnb_line_";
  protected final String TEXT_20 = "++;" + NL + "" + NL + "//////////";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String incomingName = (String)codeGenArgument.getIncomingName();
    
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//b
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {//a	

    stringBuffer.append(TEXT_1);
    
	    //get the right input connection and the previous input node and metadatas
	    
    	List< ? extends IConnection> incomingConns = node.getIncomingConnections();
    	
    	//Notice here: only for the code viewer, because when click the tUnite component, it doesn't know which is the right input connection. 
    	if (incomingName == null && incomingConns.size() > 0) 
    	{ 
    	   incomingName = incomingConns.get(0).getName(); 
    	}
    	
    	IConnection incomingConn = null;
    	INode preNode = null;
    	List<IMetadataTable> preMetadatas = null;
    	for (IConnection conn : incomingConns) {//3
    		if ( conn.getLineStyle().equals(EConnectionType.FLOW_MERGE) && conn.getName().equals(incomingName) ) {//4
				
				incomingConn = conn;
				preNode = incomingConn.getSource();
				preMetadatas = preNode.getMetadataList();
    		    break;	
    		}//4
    	}//3	
	

    stringBuffer.append(TEXT_2);
    

	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_5);
    			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//3
			
			List<IMetadataColumn> columns = metadata.getListColumns();
			int columnSize = columns.size();
			
			List<IMetadataColumn> preColumns = preMetadatas.get(0).getListColumns();
			int preColumnSize = preColumns.size();
			int minSize = Math.min(columnSize, preColumnSize);
			for (int i=0; i<minSize; i++) {//4
					IMetadataColumn column = columns.get(i);
					IMetadataColumn preColumn = preColumns.get(i);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(preColumn.getLabel() );
    stringBuffer.append(TEXT_10);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN))) {
				
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_13);
    
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    
				 	}
				}
			}
		}	
		
	}//2
	
}//1


    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
  }
 }	

    return stringBuffer.toString();
  }
}
