package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.temp.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.GlobalServiceRegister;
import java.util.List;
import java.util.Vector;

public class HeaderJava
{
  protected static String nl;
  public static synchronized HeaderJava create(String lineSeparator)
  {
    nl = lineSeparator;
    HeaderJava result = new HeaderJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// ============================================================================" + NL + "//" + NL + "// ";
  protected final String TEXT_2 = NL + "//" + NL + "// ";
  protected final String TEXT_3 = NL + "// ";
  protected final String TEXT_4 = NL + "// ";
  protected final String TEXT_5 = NL + "// ";
  protected final String TEXT_6 = NL + "// ";
  protected final String TEXT_7 = NL + "//" + NL + "// ============================================================================";
  protected final String TEXT_8 = " " + NL + "package ";
  protected final String TEXT_9 = ";" + NL;
  protected final String TEXT_10 = NL + "import routines.";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "import routines.system.*;" + NL + "" + NL + "import java.text.ParseException;" + NL + "import java.text.SimpleDateFormat;" + NL + "import java.util.Date;" + NL + "import java.util.List;" + NL + "" + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_13 = " Purpose: ";
  protected final String TEXT_14 = "<br>" + NL + " * Description: ";
  protected final String TEXT_15 = " <br>" + NL + " * @author ";
  protected final String TEXT_16 = NL + " * @version ";
  protected final String TEXT_17 = NL + " * @status ";
  protected final String TEXT_18 = " " + NL + " */" + NL + " public class ";
  protected final String TEXT_19 = " {    " + NL + "    // create and load default properties" + NL + "\tprivate static java.util.Properties defaultProps = new java.util.Properties();" + NL + "\t// create application properties with default" + NL + "\tprivate static java.util.Properties context = new java.util.Properties();" + NL + "" + NL + "\tprivate static final String jobName = \"";
  protected final String TEXT_20 = "\";" + NL + "\tprivate static final String projectName = \"";
  protected final String TEXT_21 = "\";" + NL + "\tpublic static Integer errorCode = null;";
  protected final String TEXT_22 = NL + "\tprivate static String currentComponent = \"\";";
  protected final String TEXT_23 = NL + "\tprivate static final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>(); " + NL + "\tprivate static final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();" + NL + "\tprivate static final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();" + NL + "\tprivate static final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();" + NL;
  protected final String TEXT_24 = NL + "private static RunStat runStat = new RunStat();";
  protected final String TEXT_25 = NL + "private static RunTrace runTrace = new RunTrace();";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\tLogCatcherUtils ";
  protected final String TEXT_28 = " = new LogCatcherUtils(); ";
  protected final String TEXT_29 = NL + "\tStatCatcherUtils ";
  protected final String TEXT_30 = " = new StatCatcherUtils(\"";
  protected final String TEXT_31 = "\", \"";
  protected final String TEXT_32 = "\"); ";
  protected final String TEXT_33 = NL + "\tMetterCatcherUtils ";
  protected final String TEXT_34 = " = new MetterCatcherUtils(\"";
  protected final String TEXT_35 = "\", \"";
  protected final String TEXT_36 = "\"); ";
  protected final String TEXT_37 = NL + "\tAssertCatcherUtils ";
  protected final String TEXT_38 = " = new AssertCatcherUtils(); ";
  protected final String TEXT_39 = NL + "private class TalendException extends Exception {" + NL + "\tprivate Exception e = null;" + NL + "\tprivate ";
  protected final String TEXT_40 = " c = null;";
  protected final String TEXT_41 = "\t" + NL + "\tprivate String currentComponent = null;" + NL + "\tprivate TalendException(";
  protected final String TEXT_42 = " c, Exception e,String errorComponent) {" + NL + "\t\tthis.currentComponent= errorComponent;";
  protected final String TEXT_43 = NL + "\tprivate TalendException(";
  protected final String TEXT_44 = " c, Exception e) {";
  protected final String TEXT_45 = NL + "\t\tthis.e = e;" + NL + "\t\tthis.c = c;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic void printStackTrace() {" + NL + "\t    if (!(e instanceof TalendException || e instanceof TDieException)) {" + NL + "\t        System.err.println(\"Exception in component \" + currentComponent);" + NL + "\t    }" + NL + "\t    if (!(e instanceof TDieException)) {" + NL + "\t        e.printStackTrace();" + NL + "\t    }" + NL + "\t\tif (!(e instanceof TalendException)) {" + NL + "\t\ttry {" + NL + "\t\t\tfor (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {" + NL + "\t\t\t\tif (m.getName().compareTo(currentComponent + \"_error\") == 0) {" + NL + "\t\t\t\t\tm.invoke(c, (Object[])null);" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_46 = NL + "\t\t  if(!(e instanceof TDieException)){";
  protected final String TEXT_47 = NL + "            ";
  protected final String TEXT_48 = ".addMessage(\"Java Exception\", currentComponent, 6, e.getMessage(), 1);";
  protected final String TEXT_49 = NL + "\t\t\t";
  protected final String TEXT_50 = "Process();" + NL + "\t\t  }";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL + "        if(!(e instanceof TDieException)){" + NL + "\t\t\t";
  protected final String TEXT_53 = ".addMessage(pid, projectName, jobName, \"java\", null, \"Failed\", \"Job execution error\", e.getMessage());";
  protected final String TEXT_54 = NL + "\t\t\t";
  protected final String TEXT_55 = "Process();" + NL + "        }";
  protected final String TEXT_56 = NL + NL + "\t\t} catch (java.lang.SecurityException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t} catch (java.lang.IllegalArgumentException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t} catch (java.lang.IllegalAccessException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t} catch (java.lang.reflect.InvocationTargetException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t}";
  protected final String TEXT_57 = NL + "\t\tcatch (TalendException e) {" + NL + "\t\t// do nothing" + NL + "\t\t}";
  protected final String TEXT_58 = NL + "\t\t}" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_59 = NL + "public void ";
  protected final String TEXT_60 = "_error() throws TalendException {" + NL + "\tend_Hash.put(\"";
  protected final String TEXT_61 = "\", java.util.Calendar.getInstance().getTimeInMillis());";
  protected final String TEXT_62 = NL + "\t";
  protected final String TEXT_63 = ".addMessage(\"failure\",\"";
  protected final String TEXT_64 = "\", end_Hash.get(\"";
  protected final String TEXT_65 = "\")-start_Hash.get(\"";
  protected final String TEXT_66 = "\"));" + NL + "\t";
  protected final String TEXT_67 = "Process();";
  protected final String TEXT_68 = NL + "\ttry {\t    " + NL + "\t" + NL + "\t";
  protected final String TEXT_69 = NL + "\t    ((java.util.Map)threadLocal.get()).put(errorCode, null); ";
  protected final String TEXT_70 = NL + "        ";
  protected final String TEXT_71 = "Process();" + NL + "        ((java.util.Map)threadLocal.get()).put(status, \"end\");" + NL + "\t";
  protected final String TEXT_72 = NL + "        errorCode = null;";
  protected final String TEXT_73 = NL + "        ";
  protected final String TEXT_74 = "Process();" + NL + "        status=\"end\";";
  protected final String TEXT_75 = NL + "    \t" + NL + "    \t" + NL + "    } catch (Exception e) {" + NL + "    \te.printStackTrace();" + NL + "    }";
  protected final String TEXT_76 = NL + "}";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess)v.get(0);
    String version = (String)v.get(1);
	
	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGeneratingNodes();
	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(Messages.getString("generatedcode.copyright.title"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(Messages.getString("generatedcode.copyright.body1", ((IBrandingService) GlobalServiceRegister.getDefault().getService(
                IBrandingService.class)).getFullProductName()) );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(Messages.getString("generatedcode.copyright.body2", version) );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(Messages.getString("generatedcode.copyright.body3") );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(Messages.getString("generatedcode.copyright.body4") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(Messages.getString("generatedcode.copyright.body5") );
    stringBuffer.append(TEXT_7);
    
  String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + codeGenArgument.getJobName().toLowerCase();

    stringBuffer.append(TEXT_8);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_9);
    for (String routine : CodeGeneratorRoutine.getRoutineName()) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(routine);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(process, "__VERSION__") );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_21);
    
	if(!isRunInMultiThread ){

    stringBuffer.append(TEXT_22);
    
	}

    stringBuffer.append(TEXT_23);
    
    if (stats) {

    stringBuffer.append(TEXT_24);
    
    }

    
    if (trace) {

    stringBuffer.append(TEXT_25);
    
    }

    stringBuffer.append(TEXT_26);
     
	for (INode logCatcher : process.getNodesOfType("tLogCatcher")) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_28);
    
	}

	for (INode statCatcher : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(statCatcher.getUniqueName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_32);
    
	}
	
	for (INode metterCatcher : process.getNodesOfType("tFlowMeterCatcher")) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(metterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_36);
    
	}
	
	for (INode assertCatcher : process.getNodesOfType("tAssertCatcher")) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_38);
    
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_40);
    
	if(isRunInMultiThread ){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_42);
    
	}else{

    stringBuffer.append(TEXT_43);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_44);
    
	}

    stringBuffer.append(TEXT_45);
    
		if (process.getNodesOfType("tLogCatcher").size() > 0) {
			List<INode> logCatchers = (List<INode>)process.getNodesOfType("tLogCatcher");
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					// 1) add the message to the stack

    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_48);
    
					// 2) launch logCatcher subProcess

    stringBuffer.append(TEXT_49);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_50);
    
				}
			}
		}

    stringBuffer.append(TEXT_51);
         
		if (process.getNodesOfType("tAssertCatcher").size() > 0) {
			List<INode> assertCatchers = (List<INode>)process.getNodesOfType("tAssertCatcher");
			for (INode assertCatcher : assertCatchers) {
				if (ElementParameterParser.getValue(assertCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					// 1) add the message to the stack

    stringBuffer.append(TEXT_52);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_53);
    
					// 2) launch assertCatcher subProcess

    stringBuffer.append(TEXT_54);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_55);
    
				}
			}
		}

    stringBuffer.append(TEXT_56);
     		
		boolean needCatchTalendException = false;
		if (process.getNodesOfType("tLogCatcher").size() > 0) {
			for(INode node:process.getNodesOfType("tLogCatcher")){ 
				if(ElementParameterParser.getValue(node, "__CATCH_JAVA_EXCEPTION__").equals("true")){
				needCatchTalendException = true; 
				break;
				} 
			} 
		}
		
		if ((!needCatchTalendException) && (process.getNodesOfType("tAssertCatcher").size() > 0)) {
			for(INode node:process.getNodesOfType("tAssertCatcher")){ 
				if(ElementParameterParser.getValue(node, "__CATCH_JAVA_EXCEPTION__").equals("true")){
				needCatchTalendException = true; 
				break;
				} 
			} 
		}
		if(needCatchTalendException) {

    stringBuffer.append(TEXT_57);
    
       }

    stringBuffer.append(TEXT_58);
     // Methods for RUN IF Error links 
    
	for (INode node : processNodes) {
		if (node.isActivate()) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_61);
    
if (!node.getComponent().getName().equals("tDie")) {
    String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
	if (statCatcher.compareTo("true")==0) {
		for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_67);
    
		}
	}
}
	List< ? extends IConnection> conns = node.getOutgoingConnections();
   	for (IConnection conn : conns) {
   		if (conn.getLineStyle().equals(EConnectionType.RUN_IF_ERROR)) {

    stringBuffer.append(TEXT_68);
    
	    if(isRunInMultiThread ){
	
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_71);
    
	    }else {
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_74);
    
	    }
    
    stringBuffer.append(TEXT_75);
    
		}
	}

    stringBuffer.append(TEXT_76);
    
		}
	}

    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
