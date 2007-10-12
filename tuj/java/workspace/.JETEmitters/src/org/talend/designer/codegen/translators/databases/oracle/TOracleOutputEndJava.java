package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TOracleOutputEndJava
{
  protected static String nl;
  public static synchronized TOracleOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputEndJava result = new TOracleOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "        if(pstmtUpdate_";
  protected final String TEXT_3 = " != null){" + NL + "        " + NL + "        \tpstmtUpdate_";
  protected final String TEXT_4 = ".close();" + NL + "        \t" + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_5 = " != null){" + NL + "        " + NL + "        \tpstmtInsert_";
  protected final String TEXT_6 = ".close();" + NL + "        \t" + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_7 = " != null) {" + NL + "        " + NL + "        \tpstmt_";
  protected final String TEXT_8 = ".close();" + NL + "        \t" + NL + "        }" + NL;
  protected final String TEXT_9 = NL + "        pstmt_";
  protected final String TEXT_10 = ".close();" + NL + "\t\t";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t\tconn_";
  protected final String TEXT_13 = ".commit();";
  protected final String TEXT_14 = "\t" + NL + "    \tconn_";
  protected final String TEXT_15 = " .close();" + NL + "    \t";
  protected final String TEXT_16 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_17 = "=nb_line_deleted_";
  protected final String TEXT_18 = "+ deletedCount_";
  protected final String TEXT_19 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_20 = "=nb_line_update_";
  protected final String TEXT_21 = " + updatedCount_";
  protected final String TEXT_22 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_23 = "=nb_line_inserted_";
  protected final String TEXT_24 = " + insertedCount_";
  protected final String TEXT_25 = ";" + NL + "" + NL + "globalMap.put(\"";
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
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
	if(dataAction.equals("INSERT_OR_UPDATE")||dataAction.equals("UPDATE_OR_INSERT")){
    	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    	
	}else{
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    
	if(!useExistingConn.equals("true"))
	{
		if(!commitEvery.equals("") && !commitEvery.equals("0"))
		{

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		}

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
