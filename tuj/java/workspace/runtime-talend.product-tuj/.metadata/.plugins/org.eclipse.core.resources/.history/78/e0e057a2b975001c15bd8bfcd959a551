package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFixedFlowInputBeginJava
{
  protected static String nl;
  public static synchronized TFixedFlowInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFixedFlowInputBeginJava result = new TFixedFlowInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tglobalMap.put(\"NB_LINE\", ";
  protected final String TEXT_3 = ");" + NL + "" + NL + "\tfor (int i_";
  protected final String TEXT_4 = "=0;i_";
  protected final String TEXT_5 = "<";
  protected final String TEXT_6 = ";i_";
  protected final String TEXT_7 = "++) {";
  protected final String TEXT_8 = NL + "        ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String nbRows = ElementParameterParser.getValue(node, "__NB_ROWS__");

	List<Map<String, String>> tableValues =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__VALUES__"
    );
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(nbRows);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(nbRows);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			for (Map<String, String> tableValue : tableValues) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tableValue.get("SCHEMA_COLUMN") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tableValue.get("VALUE"));
    stringBuffer.append(TEXT_11);
    
			}
		}
	}

    return stringBuffer.toString();
  }
}
