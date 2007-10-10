package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Enumeration;

public class TContextDumpBeginJava
{
  protected static String nl;
  public static synchronized TContextDumpBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextDumpBeginJava result = new TContextDumpBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.util.List<String> assignList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();" + NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t" + NL + "\tfor( java.util.Enumeration<?> en_";
  protected final String TEXT_4 = " = context.propertyNames();en_";
  protected final String TEXT_5 = ".hasMoreElements();)" + NL + "    {" + NL + "        nb_line_";
  protected final String TEXT_6 = "++;" + NL + "        Object key_";
  protected final String TEXT_7 = " = en_";
  protected final String TEXT_8 = ".nextElement();" + NL + "        Object value_";
  protected final String TEXT_9 = " = context.getProperty(key_";
  protected final String TEXT_10 = ".toString());" + NL + "    \t" + NL + "       \t";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = key_";
  protected final String TEXT_13 = ".toString();" + NL + "       \t";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " = value_";
  protected final String TEXT_16 = ".toString();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata!=null) {
    		List<IMetadataColumn> columns=metadata.getListColumns();
    		if (conns!=null && conns.size()>0) {
    			IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columns.get(0).getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columns.get(1).getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
	}

    return stringBuffer.toString();
  }
}
