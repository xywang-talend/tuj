package org.talend.designer.codegen.translators.databases.sybase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.lang.StringBuffer;;

public class TSybaseBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TSybaseBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSybaseBulkExecBeginJava result = new TSybaseBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "StringBuffer command_";
  protected final String TEXT_3 = " =  new StringBuffer();" + NL + "" + NL + "command_";
  protected final String TEXT_4 = ".append(";
  protected final String TEXT_5 = ");" + NL + "" + NL + "command_";
  protected final String TEXT_6 = ".append(\" \");" + NL;
  protected final String TEXT_7 = NL + "command_";
  protected final String TEXT_8 = ".append(";
  protected final String TEXT_9 = ");" + NL + "\t" + NL + "command_";
  protected final String TEXT_10 = ".append(\"..\");" + NL + "\t" + NL + "command_";
  protected final String TEXT_11 = ".append(";
  protected final String TEXT_12 = ");" + NL + "\t";
  protected final String TEXT_13 = NL + NL + "command_";
  protected final String TEXT_14 = ".append(";
  protected final String TEXT_15 = ");" + NL + "\t";
  protected final String TEXT_16 = NL + "command_";
  protected final String TEXT_17 = ".append(\" in \");" + NL + "" + NL + "command_";
  protected final String TEXT_18 = ".append(";
  protected final String TEXT_19 = ");" + NL;
  protected final String TEXT_20 = NL + "command_";
  protected final String TEXT_21 = ".append(\" -F\");" + NL + "\t" + NL + "command_";
  protected final String TEXT_22 = ".append(";
  protected final String TEXT_23 = ");" + NL + "\t";
  protected final String TEXT_24 = NL + "command_";
  protected final String TEXT_25 = ".append(\" -t\");" + NL + "" + NL + "command_";
  protected final String TEXT_26 = ".append(";
  protected final String TEXT_27 = ");" + NL + "" + NL + "command_";
  protected final String TEXT_28 = ".append(\" -r\");" + NL + "" + NL + "command_";
  protected final String TEXT_29 = ".append(";
  protected final String TEXT_30 = ");" + NL + "" + NL + "command_";
  protected final String TEXT_31 = ".append(\" -c -U\");" + NL + "" + NL + "command_";
  protected final String TEXT_32 = ".append(";
  protected final String TEXT_33 = ");" + NL + "" + NL + "command_";
  protected final String TEXT_34 = ".append(\" -P\");" + NL + "" + NL + "command_";
  protected final String TEXT_35 = ".append(";
  protected final String TEXT_36 = ");" + NL;
  protected final String TEXT_37 = NL + "command_";
  protected final String TEXT_38 = ".append(\" -S\");" + NL + "" + NL + "command_";
  protected final String TEXT_39 = ".append(";
  protected final String TEXT_40 = ");" + NL;
  protected final String TEXT_41 = NL + "command_";
  protected final String TEXT_42 = ".append(\" -J\");" + NL + "" + NL + "command_";
  protected final String TEXT_43 = ".append(\"";
  protected final String TEXT_44 = "\");";
  protected final String TEXT_45 = NL + NL + NL + NL + NL + NL + "Runtime runtime_";
  protected final String TEXT_46 = " = Runtime.getRuntime();" + NL + "final Process ps_";
  protected final String TEXT_47 = " = runtime_";
  protected final String TEXT_48 = ".exec(command_";
  protected final String TEXT_49 = ".toString());" + NL + "Thread normal_";
  protected final String TEXT_50 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_51 = ".getInputStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_52 = NL + "\t\t\t\t\tSystem.out.println(line);";
  protected final String TEXT_53 = NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_54 = "_OUTPUT\",(String)globalMap.get(\"";
  protected final String TEXT_55 = "_OUTPUT\")+\"\\n\"+line);";
  protected final String TEXT_56 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "normal_";
  protected final String TEXT_57 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_58 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_59 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_60 = NL + "\t\t\t\t\tSystem.err.println(line);";
  protected final String TEXT_61 = NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_62 = "_OUTPUT\",(String)globalMap.get(\"";
  protected final String TEXT_63 = "_OUTPUT\")+\"\\n\"+line);";
  protected final String TEXT_64 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_65 = ".start();" + NL + "" + NL + "ps_";
  protected final String TEXT_66 = ".waitFor();" + NL + "normal_";
  protected final String TEXT_67 = ".interrupt();" + NL + "error_";
  protected final String TEXT_68 = ".interrupt();";
  protected final String TEXT_69 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String bcpUtility  = ElementParameterParser.getValue(node, "__BCP_UTILITY__");
	String server = ElementParameterParser.getValue(node, "__SERVER__");
	String database = ElementParameterParser.getValue(node, "__DBNAME__");
	String user = ElementParameterParser.getValue(node, "__USER__");
	String pwd = ElementParameterParser.getValue(node, "__PASS__");
	String table = ElementParameterParser.getValue(node, "__TABLE__");
	String dataFile  = ElementParameterParser.getValue(node, "__FILENAME__");
	String fieldTerminator = ElementParameterParser.getValue(node, "__FIELDS_TERMINATOR__");
	String rowTerminator =  ElementParameterParser.getValue(node, "__ROW_TERMINATOR__");
	String headRow =  ElementParameterParser.getValue(node, "__HEAD__");
	
	String encoding  = ElementParameterParser.getValue(node, "__ENCODING__");
	encoding= encoding.toUpperCase();
     if(encoding.equals("\"UTF-8\"")){
          encoding = "UTF8";
     }else if(encoding.equals("\"ISO-8859-15\"")){
   		encoding = "WE8ISO8859P15";
     }else if(encoding.equals("\"GBK\"")){
   		encoding = "ZHS16GBK";
     }else if(encoding.equals("\"GB2312\"")){
     	encoding = "ZHS16CGB231280";//ZHS16MACCGB231280 ?
     }else if(encoding.equals("\"BIG5\"")){
        encoding = "ZHT16BIG5";
     } else {
       //will be enhanced later, now default with utf-16
   		encoding = "AL16UTF16";
     }
    
	String outputAction  = ElementParameterParser.getValue(node, "__OUTPUT__");	
		

	
	
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(bcpUtility);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    if(database!=null&&!database.equals("\"\"")&&!database.equals("")){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_12);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dataFile);
    stringBuffer.append(TEXT_19);
    if(headRow!=null&&!headRow.equals("\"\"")&&!headRow.equals("")){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(headRow );
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(fieldTerminator);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rowTerminator);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(pwd);
    stringBuffer.append(TEXT_36);
    if(server!=null&&!server.equals("\"\"")&&!encoding.equals("")){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(server);
    stringBuffer.append(TEXT_40);
    }
    if(encoding!=null&&!encoding.equals("\"\"")&&!encoding.equals("")){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
	if (outputAction.equals("OUTPUT_TO_CONSOLE")) {

    stringBuffer.append(TEXT_52);
    
	} else if (outputAction.equals("RETRIEVE_OUTPUT")) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
	}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
	if (outputAction.equals("OUTPUT_TO_CONSOLE")) {

    stringBuffer.append(TEXT_60);
    
	} else if (outputAction.equals("RETRIEVE_OUTPUT")) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
	}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}
