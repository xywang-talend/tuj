package org.talend.designer.codegen.translators.databases.dbjdbc;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TJDBCOutputEndJava
{
  protected static String nl;
  public static synchronized TJDBCOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCOutputEndJava result = new TJDBCOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tconnection_";
  protected final String TEXT_3 = ".commit();" + NL + "\t";
  protected final String TEXT_4 = NL + "\tif (statementUpdate_";
  protected final String TEXT_5 = " != null) {" + NL + "\t\tstatementUpdate_";
  protected final String TEXT_6 = ".close();" + NL + "\t}" + NL + "\tif (statementInsert_";
  protected final String TEXT_7 = " != null) {" + NL + "\t\tstatementInsert_";
  protected final String TEXT_8 = ".close();" + NL + "\t}" + NL + "\tif (statement_";
  protected final String TEXT_9 = " != null) {" + NL + "\t\tstatement_";
  protected final String TEXT_10 = ".close();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = NL + "\tstatement_";
  protected final String TEXT_12 = ".close();" + NL + "\t";
  protected final String TEXT_13 = NL + NL + "connection_";
  protected final String TEXT_14 = ".close();" + NL + "" + NL + "\tnb_line_deleted_";
  protected final String TEXT_15 = "=nb_line_deleted_";
  protected final String TEXT_16 = "+ deletedCount_";
  protected final String TEXT_17 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_18 = "=nb_line_update_";
  protected final String TEXT_19 = " + updatedCount_";
  protected final String TEXT_20 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_21 = "=nb_line_inserted_";
  protected final String TEXT_22 = " + insertedCount_";
  protected final String TEXT_23 = ";" + NL + "" + NL + "" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_24 = "_NB_LINE\", nb_line_";
  protected final String TEXT_25 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_26 = "_NB_LINE_UPDATED\", nb_line_update_";
  protected final String TEXT_27 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_28 = "_NB_LINE_INSERTED\", nb_line_inserted_";
  protected final String TEXT_29 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_30 = "_NB_LINE_DELETED\", nb_line_deleted_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

// Commit if needed
if (!commitEvery.equals("") && !commitEvery.equals("0")) {
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
}

// Close SQL statements
if (dataAction.equals("INSERT_OR_UPDATE") || dataAction.equals("UPDATE_OR_INSERT")) {
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
} else {
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
