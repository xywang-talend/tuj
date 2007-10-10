package org.talend.designer.codegen.translators.databases.firebird;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFirebirdRowEndJava
{
  protected static String nl;
  public static synchronized TFirebirdRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFirebirdRowEndJava result = new TFirebirdRowEndJava();
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
  protected final String TEXT_9 = " .close();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
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
    return stringBuffer.toString();
  }
}
