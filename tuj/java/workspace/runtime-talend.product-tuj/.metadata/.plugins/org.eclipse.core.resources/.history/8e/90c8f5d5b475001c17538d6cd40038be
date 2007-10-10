package org.talend.designer.codegen.translators.databases.javadb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TJavaDBOutputEndJava
{
  protected static String nl;
  public static synchronized TJavaDBOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJavaDBOutputEndJava result = new TJavaDBOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "conn_";
  protected final String TEXT_2 = ".commit();";
  protected final String TEXT_3 = NL + NL + "if(pstmtUpdate_";
  protected final String TEXT_4 = " != null){" + NL + "" + NL + "\tpstmtUpdate_";
  protected final String TEXT_5 = ".close();" + NL + "\t" + NL + "} " + NL + "if(pstmtInsert_";
  protected final String TEXT_6 = " != null){" + NL + "" + NL + "\tpstmtInsert_";
  protected final String TEXT_7 = ".close();" + NL + "\t" + NL + "}" + NL + "if(pstmt_";
  protected final String TEXT_8 = " != null) {" + NL + "" + NL + "\tpstmt_";
  protected final String TEXT_9 = ".close();" + NL + "\t" + NL + "}" + NL + "" + NL + "conn_";
  protected final String TEXT_10 = " .close();" + NL;
  protected final String TEXT_11 = NL + "conn_";
  protected final String TEXT_12 = ".commit();";
  protected final String TEXT_13 = NL + "pstmt_";
  protected final String TEXT_14 = ".close();" + NL + "conn_";
  protected final String TEXT_15 = " .close();";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\ttry" + NL + "\t{" + NL + "\t\tjava.sql.DriverManager.getConnection(\"jdbc:derby:;shutdown=true\");" + NL + "\t}" + NL + "\tcatch(java.sql.SQLException se)" + NL + "\t{" + NL + "        /*" + NL + "           In embedded mode, an application should shut down Derby." + NL + "           If the application fails to shut down Derby explicitly," + NL + "           the Derby does not perform a checkpoint when the JVM shuts down, which means" + NL + "           that the next connection will be slower." + NL + "           Explicitly shutting down Derby with the URL is preferred." + NL + "           This style of shutdown will always throw an \"exception\"." + NL + "         */" + NL + "\t}\t";
  protected final String TEXT_18 = NL + "\tserverControl_";
  protected final String TEXT_19 = ".shutdown();" + NL + "\t";
  protected final String TEXT_20 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_21 = "=nb_line_deleted_";
  protected final String TEXT_22 = "+ deletedCount_";
  protected final String TEXT_23 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_24 = "=nb_line_update_";
  protected final String TEXT_25 = " + updatedCount_";
  protected final String TEXT_26 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_27 = "=nb_line_inserted_";
  protected final String TEXT_28 = " + insertedCount_";
  protected final String TEXT_29 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_30 = "_NB_LINE\",nb_line_";
  protected final String TEXT_31 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_32 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_33 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_34 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_35 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_36 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_37 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String frameworkType = ElementParameterParser.getValue(node,"__FRAMEWORK_TYPE__");
	
	String connectionFlag = ElementParameterParser.getValue(node, "__CONNECTION_FLAG__");	
	
	if(dataAction.equals("INSERT_OR_UPDATE")||dataAction.equals("UPDATE_OR_INSERT")){
	
	if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    	
	}else{
		if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    	
		}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    
if(frameworkType.equals("EMBEDED"))
{
    stringBuffer.append(TEXT_17);
    
}
else
{
	if(connectionFlag.equals("false"))
	{
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
	}
}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
