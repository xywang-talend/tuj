package org.talend.designer.codegen.translators.databases.db2;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TDB2OutputEndJava
{
  protected static String nl;
  public static synchronized TDB2OutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDB2OutputEndJava result = new TDB2OutputEndJava();
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
  protected final String TEXT_16 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_17 = "=nb_line_deleted_";
  protected final String TEXT_18 = "+ deletedCount_";
  protected final String TEXT_19 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_20 = "=nb_line_update_";
  protected final String TEXT_21 = " + updatedCount_";
  protected final String TEXT_22 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_23 = "=nb_line_inserted_";
  protected final String TEXT_24 = " + insertedCount_";
  protected final String TEXT_25 = ";" + NL + "" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_26 = "_NB_LINE\",nb_line_";
  protected final String TEXT_27 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_28 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_29 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_30 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_31 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_32 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_33 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
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
    return stringBuffer.toString();
  }
}
