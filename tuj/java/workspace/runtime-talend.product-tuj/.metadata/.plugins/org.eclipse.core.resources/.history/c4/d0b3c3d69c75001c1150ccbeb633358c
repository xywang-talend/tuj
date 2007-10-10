package org.talend.designer.codegen.translators.databases.javadb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TJavaDBRowEndJava
{
  protected static String nl;
  public static synchronized TJavaDBRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJavaDBRowEndJava result = new TJavaDBRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "if(commitEvery_";
  protected final String TEXT_3 = ">commitCounter_";
  protected final String TEXT_4 = "){" + NL + "" + NL + "\tconn_";
  protected final String TEXT_5 = ".commit();" + NL + "\t" + NL + "\tcommitCounter_";
  protected final String TEXT_6 = "=0;" + NL + "\t" + NL + "}";
  protected final String TEXT_7 = NL + "pstmt_";
  protected final String TEXT_8 = ".close();" + NL + "conn_";
  protected final String TEXT_9 = " .close();" + NL;
  protected final String TEXT_10 = NL + "\ttry" + NL + "\t{" + NL + "\t\tjava.sql.DriverManager.getConnection(\"jdbc:derby:;shutdown=true\");" + NL + "\t}" + NL + "\tcatch(java.sql.SQLException se)" + NL + "\t{" + NL + "        /*" + NL + "           In embedded mode, an application should shut down Derby." + NL + "           If the application fails to shut down Derby explicitly," + NL + "           the Derby does not perform a checkpoint when the JVM shuts down, which means" + NL + "           that the next connection will be slower." + NL + "           Explicitly shutting down Derby with the URL is preferred." + NL + "           This style of shutdown will always throw an \"exception\"." + NL + "         */" + NL + "\t}\t";
  protected final String TEXT_11 = NL + "\tserverControl_";
  protected final String TEXT_12 = ".shutdown();" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String frameworkType = ElementParameterParser.getValue(node,"__FRAMEWORK_TYPE__");
	
	String connectionFlag = ElementParameterParser.getValue(node, "__CONNECTION_FLAG__");		
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
if(frameworkType.equals("EMBEDED"))
{
    stringBuffer.append(TEXT_10);
    
}
else
{
	if(connectionFlag.equals("false"))
	{
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
	}
}

    return stringBuffer.toString();
  }
}
