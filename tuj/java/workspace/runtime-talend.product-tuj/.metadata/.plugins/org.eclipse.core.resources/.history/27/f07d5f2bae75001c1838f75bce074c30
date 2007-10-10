package org.talend.designer.codegen.translators.dataquality;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFuzzyMatchBeginJava
{
  protected static String nl;
  public static synchronized TFuzzyMatchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFuzzyMatchBeginJava result = new TFuzzyMatchBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0; " + NL + "" + NL + "int invalid_dis_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = " + 1;" + NL + "" + NL + "java.util.Set<";
  protected final String TEXT_6 = "Struct> tSet_";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = " = ((java.util.Map<";
  protected final String TEXT_9 = "Struct, ";
  protected final String TEXT_10 = "Struct>) globalMap.get(\"tHash_";
  protected final String TEXT_11 = "\")).keySet();" + NL;
  protected final String TEXT_12 = NL + "org.apache.commons.codec.language.Metaphone metaphone_";
  protected final String TEXT_13 = " = new org.apache.commons.codec.language.Metaphone();" + NL + "\t";
  protected final String TEXT_14 = NL + "org.apache.commons.codec.language.DoubleMetaphone doublemetaphone_";
  protected final String TEXT_15 = " = new org.apache.commons.codec.language.DoubleMetaphone();" + NL + "\t";
  protected final String TEXT_16 = NL + "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String matchingType = ElementParameterParser.getValue(node, "__MATCHING_TYPE__");
String max = ElementParameterParser.getValue(node, "__MAX__");
    if(max.equals("")){
    	max="0";
    }
List<IConnection> inputConnections;
inputConnections = (List<IConnection>) node.getIncomingConnections();
for (IConnection connection : inputConnections) {
	if (connection == null) {
		continue;
	}
    EConnectionType connectionType = connection.getLineStyle();
    if (connectionType == EConnectionType.FLOW_MAIN) {
        continue;
    } else if (connectionType == EConnectionType.FLOW_REF) {
        String connectionName = connection.getName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(max );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName 
	);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName );
    stringBuffer.append(TEXT_11);
    	
		if(matchingType.equals("matchMetaphone")){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		}
		if(matchingType.equals("matchDoubleMetaphone")){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
		}

    stringBuffer.append(TEXT_16);
    
	}
}

    return stringBuffer.toString();
  }
}
