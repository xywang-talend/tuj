package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSystemMainJava
{
  protected static String nl;
  public static synchronized TSystemMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSystemMainJava result = new TSystemMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "Runtime runtime_";
  protected final String TEXT_3 = " = Runtime.getRuntime();" + NL + "final Process ps_";
  protected final String TEXT_4 = " = runtime_";
  protected final String TEXT_5 = ".exec(";
  protected final String TEXT_6 = ");" + NL + "Thread normal_";
  protected final String TEXT_7 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_8 = ".getInputStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_9 = NL + "\t\t\t\t\tSystem.out.println(line);";
  protected final String TEXT_10 = NL + "\t\t\t\t\tif (globalMap.get(\"";
  protected final String TEXT_11 = "_OUTPUT\") != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_12 = "_OUTPUT\", (String)globalMap.get(\"";
  protected final String TEXT_13 = "_OUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_14 = "_OUTPUT\", line);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_15 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "normal_";
  protected final String TEXT_16 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_17 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_18 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_19 = NL + "\t\t\t\t\tSystem.err.println(line);";
  protected final String TEXT_20 = NL + "\t\t\t\t\tif (globalMap.get(\"";
  protected final String TEXT_21 = "_OUTPUT\") != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_22 = "_OUTPUT\", (String)globalMap.get(\"";
  protected final String TEXT_23 = "_OUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_24 = "_OUTPUT\", line);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_25 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_26 = ".start();" + NL + "" + NL + "ps_";
  protected final String TEXT_27 = ".waitFor();" + NL + "normal_";
  protected final String TEXT_28 = ".interrupt();" + NL + "error_";
  protected final String TEXT_29 = ".interrupt();";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String command = ElementParameterParser.getValue(node, "__COMMAND__");
		
	String outputAction  = ElementParameterParser.getValue(node, "__OUTPUT__");
	
	// To launch an internal command to cmd.exe (XP), you have to call :
	// cmd.exe /c dir (for example)

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(command );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
	if (outputAction.equals("OUTPUT_TO_CONSOLE")) {

    stringBuffer.append(TEXT_9);
    
	} else if (outputAction.equals("RETRIEVE_OUTPUT")) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
	if (outputAction.equals("OUTPUT_TO_CONSOLE")) {

    stringBuffer.append(TEXT_19);
    
	} else if (outputAction.equals("RETRIEVE_OUTPUT")) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
