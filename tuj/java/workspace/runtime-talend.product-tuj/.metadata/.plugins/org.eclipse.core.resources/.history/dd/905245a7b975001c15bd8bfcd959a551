package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMysqlRowEndJava
{
  protected static String nl;
  public static synchronized TMysqlRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlRowEndJava result = new TMysqlRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        if(commitEvery_";
  protected final String TEXT_3 = ">commitCounter_";
  protected final String TEXT_4 = "){" + NL + "        " + NL + "        \tconn_";
  protected final String TEXT_5 = ".commit();" + NL + "        \t" + NL + "        \tcommitCounter_";
  protected final String TEXT_6 = "=0;" + NL + "        \t" + NL + "        }";
  protected final String TEXT_7 = NL + "    pstmt_";
  protected final String TEXT_8 = ".close();";
  protected final String TEXT_9 = NL + "    \tconn_";
  protected final String TEXT_10 = " .close();" + NL + "    \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

	if(!useExistingConn.equals("true"))
	{
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
    }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
	if(!useExistingConn.equals("true"))
	{
    	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
	}

    return stringBuffer.toString();
  }
}
