package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import java.util.Map;
import java.util.List;

public class TRunJobMainJava
{
  protected static String nl;
  public static synchronized TRunJobMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMainJava result = new TRunJobMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = NL + "        ";
  protected final String TEXT_3 = ".runJob(new String[]{";
  protected final String TEXT_4 = NL + "          \"";
  protected final String TEXT_5 = "\",";
  protected final String TEXT_6 = NL + "          \"";
  protected final String TEXT_7 = "\"";
  protected final String TEXT_8 = "   ";
  protected final String TEXT_9 = NL + "          ";
  protected final String TEXT_10 = " " + NL + "          });";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = "  " + NL;
  protected final String TEXT_13 = NL + "        ((java.util.Map)threadLocal.get()).put(errorCode, ";
  protected final String TEXT_14 = ".errorCode); " + NL + "" + NL + "        if (";
  protected final String TEXT_15 = ".errorCode != null || ";
  protected final String TEXT_16 = ".status.equals(\"failure\")) {" + NL + "            throw new TRunJobException();" + NL + "        }";
  protected final String TEXT_17 = NL + "        errorCode = ";
  protected final String TEXT_18 = ".errorCode;" + NL + "        if (";
  protected final String TEXT_19 = ".errorCode != null || ";
  protected final String TEXT_20 = ".status.equals(\"failure\")) {" + NL + "            throw new TRunJobException();" + NL + "        }";
  protected final String TEXT_21 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	
    List<Map<String, String>> contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
    String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
    String context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
    String[] codeOptions = new String[] {"--father_pid=\"+pid+\"", "--root_pid=\"+rootPid+\""};
    String[] commandLineWindows = new String[] {"<command>"};
    String[] commandLineUnix = new String[] {"<command>"};
    String[] commandLine = new String[] {"<command>"};
    try {
        // for windows
       	//commandLineWindows = ProcessorUtilities.getCommandLine("win32", true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
        // for linux
        //commandLineUnix = ProcessorUtilities.getCommandLine("linux", true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
        // for current OS
       	//commandLine = ProcessorUtilities.getCommandLine(true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
    	commandLine = ProcessorUtilities.getMainCommand(process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
    } catch (ProcessorException e) {
    }
    
    
StringBuffer contextStr = new StringBuffer();
for (int i=0; i<contextParams.size(); i++) {
    Map<String, String> contextParam = contextParams.get(i);
    String name = contextParam.get("PARAM_NAME_COLUMN");
    String value = contextParam.get("PARAM_VALUE_COLUMN");    
    contextStr.append(",\"--context_param ");
    contextStr.append(name);

    contextStr.append("=\"+");
    contextStr.append(value);
  }

   String childJob = null;

   for (int i=0; i<commandLine.length; i++) {
      if(i==0){
          childJob = commandLine[i];
      
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(commandLine[i]);
    stringBuffer.append(TEXT_3);
    
      }else{
          if (i <= (commandLine.length -2)) {
          
    stringBuffer.append(TEXT_4);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_5);
    
          }else{
          
    stringBuffer.append(TEXT_6);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_7);
    
          }
      }
   }
   if(commandLine.length>0){
   
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(contextStr.toString() );
    stringBuffer.append(TEXT_10);
    
    }
    
    stringBuffer.append(TEXT_11);
    
    if (childJob!=null) {

    stringBuffer.append(TEXT_12);
    
        if(isRunInMultiThread ){
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_16);
    
        }else {
    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_20);
    
        }
    
    
    }

    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
