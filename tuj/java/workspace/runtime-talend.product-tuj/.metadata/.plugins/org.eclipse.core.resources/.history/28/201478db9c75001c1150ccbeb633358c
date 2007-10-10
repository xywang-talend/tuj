package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.lang.StringBuffer;

public class TSSHMainJava
{
  protected static String nl;
  public static synchronized TSSHMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHMainJava result = new TSSHMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t/* Create a session */" + NL + "\t\t\tsess_";
  protected final String TEXT_3 = ".execCommand(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t\t" + NL + "\t\t\tjava.io.InputStream stdout_";
  protected final String TEXT_5 = " = sess_";
  protected final String TEXT_6 = ".getStdout();" + NL + "\t\t\tjava.io.BufferedReader brout_";
  protected final String TEXT_7 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stdout_";
  protected final String TEXT_8 = "));" + NL + "            String line_";
  protected final String TEXT_9 = " = \"\";" + NL + "            StringBuffer stringStdout_";
  protected final String TEXT_10 = " =new StringBuffer();" + NL + "" + NL + "            if((line_";
  protected final String TEXT_11 = " = brout_";
  protected final String TEXT_12 = ".readLine()) != null)" + NL + "            {" + NL + "                stringStdout_";
  protected final String TEXT_13 = ".append(line_";
  protected final String TEXT_14 = ");" + NL + "            }" + NL + "\t\t\twhile((line_";
  protected final String TEXT_15 = " = brout_";
  protected final String TEXT_16 = ".readLine()) != null) {" + NL + "\t\t\t\tstringStdout_";
  protected final String TEXT_17 = ".append(\"\\n\"+line_";
  protected final String TEXT_18 = ");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t    brout_";
  protected final String TEXT_19 = ".close();" + NL + "\t\t\tstdout_";
  protected final String TEXT_20 = ".close();" + NL + "\t\t\t" + NL + "\t\t\tjava.io.InputStream stderr_";
  protected final String TEXT_21 = " = sess_";
  protected final String TEXT_22 = ".getStderr();" + NL + "            java.io.BufferedReader breer_";
  protected final String TEXT_23 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stderr_";
  protected final String TEXT_24 = "));" + NL + "            String line1_";
  protected final String TEXT_25 = " = \"\";" + NL + "            StringBuffer stringStderr_";
  protected final String TEXT_26 = " =new StringBuffer();" + NL + "" + NL + "            if((line1_";
  protected final String TEXT_27 = " = breer_";
  protected final String TEXT_28 = ".readLine()) != null)" + NL + "            {" + NL + "            \tstringStderr_";
  protected final String TEXT_29 = ".append(line1_";
  protected final String TEXT_30 = ");" + NL + "            }" + NL + "\t\t\twhile((line1_";
  protected final String TEXT_31 = " = breer_";
  protected final String TEXT_32 = ".readLine()) != null) {" + NL + "\t\t\t\tstringStderr_";
  protected final String TEXT_33 = ".append(\"\\n\"+line1_";
  protected final String TEXT_34 = ");" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tbreer_";
  protected final String TEXT_35 = ".close();" + NL + "\t\t\tstderr_";
  protected final String TEXT_36 = ".close();" + NL + "\t\t\t" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_37 = "_STDOUT\",stringStdout_";
  protected final String TEXT_38 = ".toString());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_39 = "_STDERR\",stringStderr_";
  protected final String TEXT_40 = ".toString());" + NL + "            globalMap.put(\"";
  protected final String TEXT_41 = "_EXIT_CODE\",sess_";
  protected final String TEXT_42 = ".getExitStatus());";
  protected final String TEXT_43 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean stats = codeGenArgument.isStatistics();

List<IMetadataTable> metadatas = node.getMetadataList();
String cid = node.getUniqueName();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
       	String commandSeparator = ElementParameterParser.getValue(
            node,
            "__COMMANDSEPARATOR__"
        );
        commandSeparator = commandSeparator.replace("\"", "");
        
        StringBuffer command = new StringBuffer();
        List<Map<String, String>> commands =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,"__COMMANDS__");
                
        if(commands.size() > 0)
        {
            for(Map<String, String> map : commands)  
            {
                if(command.length() > 0)
                {
                	command.append(commandSeparator);
                }
       		    command.append(map.get("COMMAND"));
            } 
        }            

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(command);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
    }
}

    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
