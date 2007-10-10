package org.talend.designer.codegen.translators.dataquality;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TUniqRowBeginJava
{
  protected static String nl;
  public static synchronized TUniqRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowBeginJava result = new TUniqRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "int nb_uniques_";
  protected final String TEXT_3 = " = 0;" + NL + "int nb_duplicates_";
  protected final String TEXT_4 = " = 0;";
  protected final String TEXT_5 = NL + "java.util.Set<String> keys";
  protected final String TEXT_6 = " = new java.util.HashSet<String>();" + NL + "String currentRowKey";
  protected final String TEXT_7 = " = \"\";";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__UNIQUE_KEY__");
boolean hasKey = false;
for(Map<String, String> keyColumn:keyColumns){
	if(keyColumn.get("KEY_ATTRIBUTE").equals("true")){
		hasKey = true;
		break;
	}
}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
if(hasKey){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
}
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
