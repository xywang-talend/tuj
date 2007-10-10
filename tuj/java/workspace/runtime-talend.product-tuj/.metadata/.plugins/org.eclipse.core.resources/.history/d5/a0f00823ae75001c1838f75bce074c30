package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.CorePlugin;
import java.util.Vector;
import java.util.List;

public class FooterJava
{
  protected static String nl;
  public static synchronized FooterJava create(String lineSeparator)
  {
    nl = lineSeparator;
    FooterJava result = new FooterJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    public static boolean watch = false;" + NL + "    public static int portStats = 3334;" + NL + "    public static int portTraces = 4334;" + NL + "    public static String clientHost;" + NL + "    public static String defaultClientHost = \"localhost\";" + NL + "    public static String contextStr = \"";
  protected final String TEXT_2 = "\";" + NL + "    public static String pid = \"0\";" + NL + "    public static String rootPid = null;" + NL + "    public static String fatherPid = null;";
  protected final String TEXT_3 = NL + "    private static ThreadLocal threadLocal = new ThreadLocal();" + NL + "\tprivate static SyncInt runningThreadCount =new SyncInt();" + NL + "\t" + NL + "\tprivate static class SyncInt" + NL + "\t{" + NL + "\t\tprivate int count = 0;" + NL + "\t    public synchronized void add(int i)" + NL + "\t    {" + NL + "\t        count +=i;" + NL + "\t    }" + NL + "\t    " + NL + "\t    public synchronized int getCount()" + NL + "\t    {" + NL + "\t        return count;" + NL + "\t    }" + NL + "\t}";
  protected final String TEXT_4 = NL + "  " + NL + "    private static java.util.Properties context_param = new java.util.Properties();" + NL + "    " + NL + "    public static String status= \"\";" + NL + "    " + NL + "    public static void main(String[] args){" + NL + "        int exitCode = runJob(args);" + NL + "        System.exit(exitCode);" + NL + "    }" + NL + "    " + NL + "    public static int runJob(String[] args) {" + NL + "    \tfor (String arg : args) {" + NL + "    \t\tevalParam(arg);" + NL + "    \t}" + NL + "    \t" + NL + "    \tif(clientHost == null) {" + NL + "    \t\tclientHost = defaultClientHost;" + NL + "    \t}" + NL + "    \t" + NL + "    \t" + NL + "    \tpid = TalendString.getAsciiRandomString(6);" + NL + "    \tif (rootPid==null) {" + NL + "    \t\trootPid = pid;" + NL + "    \t}" + NL + "    \tif (fatherPid==null) {" + NL + "    \t\tfatherPid = pid;" + NL + "    \t}" + NL + "    \t" + NL + "    \ttry {" + NL + "    \t\tjava.io.InputStream inContext = ";
  protected final String TEXT_5 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_6 = "/";
  protected final String TEXT_7 = "/contexts/Default.properties\");    \t\t" + NL + "    \t\tif (inContext!=null) {" + NL + "\t    \t\tdefaultProps.load(inContext);" + NL + "    \t\t\tinContext.close();" + NL + "\t    \t\tcontext = new java.util.Properties(defaultProps);" + NL + "\t    \t}" + NL + "    \t\t" + NL + "    \t\tif (contextStr.compareTo(\"Default\")!=0) {" + NL + "    \t\t\tinContext = ";
  protected final String TEXT_8 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_9 = "/";
  protected final String TEXT_10 = "/contexts/\"+contextStr+\".properties\");" + NL + "    \t\t\tif (inContext!=null) {" + NL + "\t\t\t\t\tcontext.load(inContext);" + NL + "\t\t\t\t\tinContext.close();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(!context_param.isEmpty()) {\t\t\t\t\t\t" + NL + "\t\t\t    context.putAll(context_param);\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "    \t} catch (java.io.IOException ie) {" + NL + "    \t\tSystem.err.println(\"Could not load context \"+contextStr);" + NL + "    \t\tie.printStackTrace();" + NL + "    \t}" + NL;
  protected final String TEXT_11 = NL + "\ttry {" + NL + "\t\trunStat.startThreadStat(clientHost, portStats);" + NL + "\t} catch (java.io.IOException ioException) {" + NL + "\t\tioException.printStackTrace();" + NL + "\t}";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t\ttry {" + NL + "\t\trunTrace.startThreadTrace(clientHost, portTraces);" + NL + "\t} catch (java.io.IOException ioException) {" + NL + "\t\tioException.printStackTrace();" + NL + "\t}";
  protected final String TEXT_14 = NL + NL + "\tlong end = 0;" + NL + "\tlong start = java.util.Calendar.getInstance().getTimeInMillis();";
  protected final String TEXT_15 = NL + "\tfinal ";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = "Class = new ";
  protected final String TEXT_18 = "(); ";
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = "Class.";
  protected final String TEXT_21 = ".addMessage(\"begin\");\t";
  protected final String TEXT_22 = NL + "\t\trunningThreadCount.add(1);" + NL + "   \t\tnew Thread(){" + NL + "\t    \tpublic void run()" + NL + "\t   \t\t{" + NL + "                java.util.Map threadRunResultMap = new java.util.HashMap();" + NL + "                threadRunResultMap.put(errorCode, null);" + NL + "                threadRunResultMap.put(status, \"\");" + NL + "                threadLocal.set(threadRunResultMap);" + NL + "\t    \t    " + NL + "\t    \t    try {" + NL + "\t            \t";
  protected final String TEXT_23 = "Class.";
  protected final String TEXT_24 = "Process();" + NL + "\t            } catch (TalendException e) {" + NL + "\t                ((java.util.Map)threadLocal.get()).put(status, \"failure\");  " + NL + "\t            \te.printStackTrace();" + NL + "\t         \t}finally" + NL + "\t         \t{" + NL + "\t                Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get(errorCode));" + NL + "\t                String localStatus = (String)(((java.util.Map)threadLocal.get()).get(status));" + NL + "\t                if (localErrorCode != null) {" + NL + "\t                    if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {" + NL + "\t                       errorCode = localErrorCode;" + NL + "\t                    }" + NL + "\t                }else if(!status.equals(\"failure\")){" + NL + "\t                        status = localStatus;" + NL + "\t                }\t" + NL + "\t         \t    " + NL + "\t                runningThreadCount.add(-1);" + NL + "\t        \t}" + NL + "\t    \t}" + NL + "\t\t}.start();" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\twhile(";
  protected final String TEXT_26 = "Class.runningThreadCount.getCount()>0)" + NL + "    {" + NL + "        try {" + NL + "            Thread.sleep(10);" + NL + "        } catch (Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }            " + NL + "    }";
  protected final String TEXT_27 = NL + "\t";
  protected final String TEXT_28 = " ";
  protected final String TEXT_29 = "Class = new ";
  protected final String TEXT_30 = "();" + NL + "\ttry {";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = "Class.";
  protected final String TEXT_33 = ".addMessage(\"begin\");";
  protected final String TEXT_34 = NL + "\t\t";
  protected final String TEXT_35 = "Class.";
  protected final String TEXT_36 = "Process();";
  protected final String TEXT_37 = NL + "\t} catch(TalendException e) {" + NL + "\t\tstatus=\"failure\";" + NL + "\t\te.printStackTrace();" + NL + "\t} finally {";
  protected final String TEXT_38 = "\t" + NL + "\t\tend = java.util.Calendar.getInstance().getTimeInMillis();" + NL + "\t\tif (watch) {" + NL + "    \t\tSystem.out.println((end-start)+\" milliseconds\");" + NL + "\t    }";
  protected final String TEXT_39 = NL + "\trunStat.stopThreadStat();";
  protected final String TEXT_40 = NL + "\t\trunTrace.stopThreadTrace();";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = "Class.";
  protected final String TEXT_43 = ".addMessage(status==\"\"?\"end\":status, (end-start));" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_44 = "Class.";
  protected final String TEXT_45 = "Process();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "        " + NL + "\t}";
  protected final String TEXT_47 = NL + "    if(errorCode == null) {" + NL + "         return status != null && status.equals(\"failure\") ? 1 : 0;\t" + NL + "    } else {   " + NL + "         return errorCode.intValue();" + NL + "    }" + NL + "  }" + NL + "\t" + NL + "\tpublic static void evalParam(String arg) {\t   " + NL + "\t\tif (arg.startsWith(\"--watch\")) {" + NL + "    \t\twatch = true;" + NL + "    \t} else if (arg.startsWith(\"--stat_port=\")) {" + NL + "    \t\tportStats = Integer.parseInt(arg.substring(12));" + NL + "    \t} else if (arg.startsWith(\"--trace_port=\")) {" + NL + "    \t\tportTraces = Integer.parseInt(arg.substring(13));" + NL + "    \t} else if (arg.startsWith(\"--client_host=\")) {" + NL + "    \t\tclientHost = arg.substring(14);" + NL + "    \t} else if (arg.startsWith(\"--context=\")) {" + NL + "    \t\tcontextStr = arg.substring(10);" + NL + "    \t} else if (arg.startsWith(\"--father_pid=\")) {" + NL + "    \t\tfatherPid = arg.substring(13);" + NL + "    \t} else if (arg.startsWith(\"--root_pid=\")) {" + NL + "    \t\trootPid = arg.substring(11);" + NL + "    \t} else if (arg.startsWith(\"--context_param\")) {   \t\t " + NL + "            String keyValue = arg.substring(16);           " + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));" + NL + "            }" + NL + "    \t}" + NL + "    \t" + NL + "\t}" + NL + "}";
  protected final String TEXT_48 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    List<INode> rootNodes = (List<INode>)v.get(1);

	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeGenArgument.getContextName() );
    stringBuffer.append(TEXT_2);
    
	if(isRunInMultiThread){

    stringBuffer.append(TEXT_3);
    
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(codeGenArgument.getJobName().toLowerCase() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(codeGenArgument.getJobName().toLowerCase() );
    stringBuffer.append(TEXT_10);
    
		if (stats) {

    stringBuffer.append(TEXT_11);
    
		}

    stringBuffer.append(TEXT_12);
    
		if (trace) {

    stringBuffer.append(TEXT_13);
    
		}

    stringBuffer.append(TEXT_14);
    
	if(isRunInMultiThread){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_18);
    
		for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_21);
    
    	}
		for (INode rootNode : rootNodes) {
			String componentName = (String) rootNode.getComponent().getName();
            if (!componentName.equals("tLogCatcher") && !componentName.equals("tFlowMeterCatcher") && !componentName.equals("tAssertCatcher") && !componentName.equals("tStatCatcher")) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rootNode.getUniqueName() );
    stringBuffer.append(TEXT_24);
    
			}
		}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_26);
    
	}else{ // isRunInMultiThread

    stringBuffer.append(TEXT_27);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_30);
    
   		for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_33);
    
    	}
		for (INode rootNode : rootNodes) {
			String componentName = (String) rootNode.getComponent().getName();
            if (!componentName.equals("tLogCatcher") && !componentName.equals("tFlowMeterCatcher") && !componentName.equals("tAssertCatcher") && !componentName.equals("tStatCatcher")) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(rootNode.getUniqueName() );
    stringBuffer.append(TEXT_36);
    
			}
		}

    stringBuffer.append(TEXT_37);
    
	}// end if(isRunInMultiThread)

    stringBuffer.append(TEXT_38);
    
	if (stats) {

    stringBuffer.append(TEXT_39);
    	
	}

	if (trace) {

    stringBuffer.append(TEXT_40);
    
	}
	
	for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_45);
    
    }
    if(!isRunInMultiThread){
    // next brace is end of finally.

    stringBuffer.append(TEXT_46);
    
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}
