package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileOutputLDIFBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFBeginJava result = new TFileOutputLDIFBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//create directory only if not exists" + NL + "\t\t String fileNewName_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";" + NL + "\t\t java.io.File createFile";
  protected final String TEXT_4 = " = new java.io.File(fileNewName_";
  protected final String TEXT_5 = ");" + NL + "\t\t if(!createFile";
  protected final String TEXT_6 = ".exists()){" + NL + "\t\t \t(new java.io.File(fileNewName_";
  protected final String TEXT_7 = ".substring(0,fileNewName_";
  protected final String TEXT_8 = ".lastIndexOf(\"/\")))).mkdirs();" + NL + "\t\t }";
  protected final String TEXT_9 = "\t" + NL + "\t\t    class Util_";
  protected final String TEXT_10 = NL + "            {" + NL + "                public void breakString( StringBuilder pw, String value, int max) {" + NL + "                    int leftToGo = value.length();" + NL + "                    int written = 0;" + NL + "                    int maxChars = max;" + NL + "                    while( leftToGo > 0 ) {" + NL + "                        int toWrite = Math.min( maxChars, leftToGo );" + NL + "                        String s = value.substring( written, written+toWrite);" + NL + "                        if ( written != 0 ) {" + NL + "                        \tpw.append( \" \" + s );" + NL + "                        } else {" + NL + "                        \tpw.append( s );" + NL + "                            maxChars -= 1;" + NL + "                        }" + NL + "                        written += toWrite;" + NL + "                        leftToGo -= toWrite;" + NL + "                        pw.append( '\\n' );" + NL + "                    }" + NL + "                }" + NL + "            } " + NL + "            " + NL + "\t\tUtil_";
  protected final String TEXT_11 = " util_";
  protected final String TEXT_12 = " = new Util_";
  protected final String TEXT_13 = "();" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_14 = " = 0;" + NL + "\t\tfinal String dn_";
  protected final String TEXT_15 = " = \"dn: \";" + NL + "\t\tfinal String changetype_";
  protected final String TEXT_16 = " = \"changetype: \";" + NL + "\t\tfinal int wrap_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "" + NL + "       \tjava.io.PrintWriter pw_";
  protected final String TEXT_19 = " = new java.io.PrintWriter(new java.io.File(";
  protected final String TEXT_20 = "),";
  protected final String TEXT_21 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();

        // component id        
        String cid = node.getUniqueName();
        String wrap = ElementParameterParser.getValue(node, "__WRAP__");
        String filename = ElementParameterParser.getValue(node, "__FILENAME__");
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");       

    if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(wrap );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
