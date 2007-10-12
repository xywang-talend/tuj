package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPOPEndJava
{
  protected static String nl;
  public static synchronized TPOPEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPOPEndJava result = new TPOPEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "   }  " + NL + "" + NL + "    if (folder_";
  protected final String TEXT_2 = " != null)    ";
  protected final String TEXT_3 = NL + "     folder_";
  protected final String TEXT_4 = ".close(true); ";
  protected final String TEXT_5 = " " + NL + "    folder_";
  protected final String TEXT_6 = ".close(false);";
  protected final String TEXT_7 = NL + "\tif (store_";
  protected final String TEXT_8 = " != null)" + NL + "       store_";
  protected final String TEXT_9 = ".close();" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_EMAIL\", nb_email_";
  protected final String TEXT_11 = ");\t  ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
		
	// component id
	String cid = node.getUniqueName();
	String deleteFromServer = ElementParameterParser.getValue(node, "__DELETE_FROM_SERVER__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
   if (deleteFromServer.equals("true")) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
  } else
  {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
  }    

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
