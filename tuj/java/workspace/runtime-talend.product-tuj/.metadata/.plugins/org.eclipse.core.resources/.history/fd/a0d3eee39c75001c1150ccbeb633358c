package org.talend.designer.codegen.translators.databases.postgresql;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TPostgresqlRowEndJava
{
  protected static String nl;
  public static synchronized TPostgresqlRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlRowEndJava result = new TPostgresqlRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\tpstmt_";
  protected final String TEXT_3 = ".close();" + NL;
  protected final String TEXT_4 = NL + "            if(commitEvery_";
  protected final String TEXT_5 = " > commitCounter_";
  protected final String TEXT_6 = "){" + NL + "                    " + NL + "        \t\tconn_";
  protected final String TEXT_7 = ".commit();" + NL + "    \t\t}" + NL + "            \t" + NL + "        \tcommitCounter_";
  protected final String TEXT_8 = "=0;" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_9 = "    \t" + NL + "    \tconn_";
  protected final String TEXT_10 = " .close();" + NL + "    \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	if(!useExistingConn.equals("true"))
	{
    	if(!commitEvery.equals("")&&!commitEvery.equals("0")){
    	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
    	}
    	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
	}

    return stringBuffer.toString();
  }
}
