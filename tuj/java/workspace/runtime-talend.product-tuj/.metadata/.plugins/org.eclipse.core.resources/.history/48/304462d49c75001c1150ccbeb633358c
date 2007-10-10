package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TArrayInBeginJava
{
  protected static String nl;
  public static synchronized TArrayInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TArrayInBeginJava result = new TArrayInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0; " + NL + "for(ThenRunStruct";
  protected final String TEXT_4 = " row_";
  protected final String TEXT_5 = " : (java.util.List<ThenRunStruct";
  protected final String TEXT_6 = ">)globalMap.get(\"";
  protected final String TEXT_7 = "\")){" + NL;
  protected final String TEXT_8 = "\t\t\t\t\t";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " = row_";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "      \t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    String origin = ElementParameterParser.getValue(node, "__ORIGIN__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_7);
    
//begin
//
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
//
//end
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    
//start
//
					}
				}
			}
			if (conns.size()>1) {
				for (int i=1;i<conns.size();i++) {
					IConnection connection = conns.get(i);
					if ((connection.getName().compareTo(firstConnName)!=0)&&(connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    		for (IMetadataColumn column: metadata.getListColumns()) {
//
//end
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connection.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    
//start
//
						}
					}
				}
			}
		}
    }
}

    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
