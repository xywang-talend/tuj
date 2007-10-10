package org.talend.designer.codegen.translators.databases.mssqlserver;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMSSqlBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TMSSqlBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlBulkExecBeginJava result = new TMSSqlBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "java.lang.Class.forName(\"net.sourceforge.jtds.jdbc.Driver\").newInstance();" + NL + "String url_";
  protected final String TEXT_2 = " = \"jdbc:jtds:sqlserver://\"+";
  protected final String TEXT_3 = "+\":\"+";
  protected final String TEXT_4 = "+\"//\"+";
  protected final String TEXT_5 = ";" + NL + "java.sql.Connection con_";
  protected final String TEXT_6 = "=java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ");" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_10 = "=con_";
  protected final String TEXT_11 = ".createStatement();" + NL + "" + NL + "stmt_";
  protected final String TEXT_12 = ".execute(\"BULK INSERT \"+";
  protected final String TEXT_13 = "+\"..\"+";
  protected final String TEXT_14 = "+\" FROM '\"+";
  protected final String TEXT_15 = "+\"' WITH ( DATAFILETYPE='";
  protected final String TEXT_16 = "',FIELDTERMINATOR='\"+";
  protected final String TEXT_17 = "+\"',FIRSTROW =\"+";
  protected final String TEXT_18 = "+\",ROWTERMINATOR='\"+";
  protected final String TEXT_19 = "+\"')\");" + NL + "stmt_";
  protected final String TEXT_20 = ".close();" + NL + "con_";
  protected final String TEXT_21 = ".close();" + NL;
  protected final String TEXT_22 = NL + "Runtime runtime_";
  protected final String TEXT_23 = " = Runtime.getRuntime();" + NL + "final Process ps";
  protected final String TEXT_24 = " = runtime_";
  protected final String TEXT_25 = ".exec(\"";
  protected final String TEXT_26 = "\");" + NL + "Thread normal_";
  protected final String TEXT_27 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps";
  protected final String TEXT_28 = ".getInputStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_29 = NL + "\t\t\t\t\tSystem.out.println(line);";
  protected final String TEXT_30 = NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_31 = "_OUTPUT\",(String)globalMap.get(\"";
  protected final String TEXT_32 = "_OUTPUT\")+\"\\n\"+line);";
  protected final String TEXT_33 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "normal_";
  protected final String TEXT_34 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_35 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps";
  protected final String TEXT_36 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_37 = NL + "\t\t\t\t\tSystem.err.println(line);";
  protected final String TEXT_38 = NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_39 = "_OUTPUT\",(String)globalMap.get(\"";
  protected final String TEXT_40 = "_OUTPUT\")+\"\\n\"+line);";
  protected final String TEXT_41 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_42 = ".start();" + NL + "" + NL + "ps";
  protected final String TEXT_43 = ".waitFor();" + NL + "normal_";
  protected final String TEXT_44 = ".interrupt();" + NL + "error_";
  protected final String TEXT_45 = ".interrupt();" + NL;
  protected final String TEXT_46 = NL + NL + NL + NL + NL + NL + NL;
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String action = ElementParameterParser.getValue(node, "__ACTION__");
String outputAction = ElementParameterParser.getValue(node, "__OUTPUT__");

String field_separator = ElementParameterParser.getValue(node, "__FIELDS_TERMINATED_BY__");
String row_separator = ElementParameterParser.getValue(node, "__ROW_TERMINATED_BY__");
String first_row = ElementParameterParser.getValue(node, "__FIRST_ROW__");
String file = ElementParameterParser.getValue(node, "__REMOTE_FILENAME__");
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String db = ElementParameterParser.getValue(node, "__DBNAME__");
String user = ElementParameterParser.getValue(node, "__USER__");
String pas = ElementParameterParser.getValue(node, "__PASS__");
String table = ElementParameterParser.getValue(node, "__TABLE__");
String data_file_type = ElementParameterParser.getValue(node, "__DATA_FILE_TYPE__");

if(action.equals("INSERT")){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(pas);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(data_file_type);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(field_separator);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(first_row);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(row_separator);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
}else if(action.equals("EXPORT")){

String bcp_utility = ElementParameterParser.getValue(node, "__BCP_UTILITY__");
String server = ElementParameterParser.getValue(node, "__SERVER__");
String query_statement = ElementParameterParser.getValue(node, "__QUERY__");
	   query_statement = query_statement.replaceAll("\n"," ");
	   query_statement = query_statement.replaceAll("\r"," ");
	   
String output_file_name = ElementParameterParser.getValue(node, "__OUTPUT_FILE_NAME__");
String row_terminated_export = ElementParameterParser.getValue(node, "__ROW_TERMINATED_EXPORT__");

String char_type =  "char type error!";
if(data_file_type.equals("char")){
	char_type = "-c";
}else if(data_file_type.equals("native")){
	char_type = "-n";
}else{
	char_type = "-w";
}

StringBuffer command =  new StringBuffer();
command.append(bcp_utility.replaceAll("\"",""));
command.append(" ");
command.append(query_statement.replaceAll("\"","\\\\\""));
command.append(" queryout ");
command.append(output_file_name.replaceAll("\"","\\\\\""));
command.append(" ");
command.append(char_type);
if(!server.equals("")&&!server.equals("\"\"")&&!(server==null)){
	command.append(" -S");
	command.append(server.replaceAll("\"",""));
}
if((user.equals("")||user.equals("\"\"")||user==null)&&(pas.equals("")||pas==null||pas.equals("\"\""))){
	command.append(" -T");
}else{
	command.append(" -U");
	command.append(user.replaceAll("\"",""));
	command.append(" -P");
	command.append(pas.replaceAll("\"",""));
}
command.append(" -t");
command.append(field_separator.replaceAll("\"",""));
command.append(" -r");
command.append(row_terminated_export.replaceAll("\"",""));


    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(command.toString());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
	if (outputAction.equals("OUTPUT_TO_CONSOLE")) {

    stringBuffer.append(TEXT_29);
    
	} else if (outputAction.equals("RETRIEVE_OUTPUT")) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
	if (outputAction.equals("OUTPUT_TO_CONSOLE")) {

    stringBuffer.append(TEXT_37);
    
	} else if (outputAction.equals("RETRIEVE_OUTPUT")) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
	}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
}

    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
