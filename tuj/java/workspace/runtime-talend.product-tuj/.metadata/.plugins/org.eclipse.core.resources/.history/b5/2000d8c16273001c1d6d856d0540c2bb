package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileCopyMainJava
{
  protected static String nl;
  public static synchronized TFileCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileCopyMainJava result = new TFileCopyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = "     " + NL + "        String directory_";
  protected final String TEXT_3 = "=";
  protected final String TEXT_4 = ";" + NL + "        java.io.File file_";
  protected final String TEXT_5 = " = new java.io.File( ";
  protected final String TEXT_6 = ");" + NL + "        if(!directory_";
  protected final String TEXT_7 = ".endsWith(\"/\")){" + NL + "           directory_";
  protected final String TEXT_8 = " = directory_";
  protected final String TEXT_9 = " + \"/\";" + NL + "        }" + NL + "        ";
  protected final String TEXT_10 = NL + "\t\tdirectory_";
  protected final String TEXT_11 = "=directory_";
  protected final String TEXT_12 = "+\"";
  protected final String TEXT_13 = "\";     ";
  protected final String TEXT_14 = NL + "\t\tdirectory_";
  protected final String TEXT_15 = "=directory_";
  protected final String TEXT_16 = "+";
  protected final String TEXT_17 = "; ";
  protected final String TEXT_18 = "        " + NL + "        " + NL + "        java.io.File dirfile_";
  protected final String TEXT_19 = "=new java.io.File(directory_";
  protected final String TEXT_20 = ");" + NL + "        if(dirfile_";
  protected final String TEXT_21 = ".exists()&& !";
  protected final String TEXT_22 = ")" + NL + "        {" + NL + "        \tthrow new Exception();" + NL + "        }else" + NL + "        {" + NL + "            java.io.BufferedInputStream in_";
  protected final String TEXT_23 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(file_";
  protected final String TEXT_24 = "));";
  protected final String TEXT_25 = NL + "            java.io.File creatFile";
  protected final String TEXT_26 = "=new java.io.File(";
  protected final String TEXT_27 = ");" + NL + "            if (!creatFile";
  protected final String TEXT_28 = ".exists()) {" + NL + "               (new java.io.File(";
  protected final String TEXT_29 = ")).mkdirs();" + NL + "            }";
  protected final String TEXT_30 = NL + "            java.io.BufferedOutputStream out_";
  protected final String TEXT_31 = " = new java.io.BufferedOutputStream(new java.io.FileOutputStream(dirfile_";
  protected final String TEXT_32 = "));" + NL + "            byte[] buf_";
  protected final String TEXT_33 = "=new byte[1024];" + NL + "            int readLen_";
  protected final String TEXT_34 = ";" + NL + "            if(!file_";
  protected final String TEXT_35 = ".equals(dirfile_";
  protected final String TEXT_36 = "))" + NL + "            {" + NL + "            \t" + NL + "                while ((readLen_";
  protected final String TEXT_37 = " = in_";
  protected final String TEXT_38 = ".read(buf_";
  protected final String TEXT_39 = ",0,1024)) != -1)" + NL + "                       out_";
  protected final String TEXT_40 = ".write(buf_";
  protected final String TEXT_41 = ", 0, readLen_";
  protected final String TEXT_42 = ");   " + NL + "            }  " + NL + "             if(in_";
  protected final String TEXT_43 = " != null){" + NL + "                   in_";
  protected final String TEXT_44 = ".close(); " + NL + "                }     " + NL + "             if(out_";
  protected final String TEXT_45 = " != null){" + NL + "                    out_";
  protected final String TEXT_46 = ".close();" + NL + "                }" + NL + "            if( ";
  protected final String TEXT_47 = " &&!file_";
  protected final String TEXT_48 = ".equals(dirfile_";
  protected final String TEXT_49 = "))" + NL + "                {" + NL + "                \tfile_";
  protected final String TEXT_50 = ".delete();" + NL + "                }" + NL + "       \t }" + NL + "        " + NL + "" + NL + "      ";
  protected final String TEXT_51 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");	
	String destination  = ElementParameterParser.getValue(node, "__DESTINATION__");
	String destination_filename  = ElementParameterParser.getValue(node, "__DESTINATION_RENAME__");
	
	boolean reFile=ElementParameterParser.getValue(node, "__REMOVE_FILE__").equals("true");
	boolean rpFile=ElementParameterParser.getValue(node,"__REPLACE_FILE__").equals("true");
    boolean creatDir=ElementParameterParser.getValue(node,"__CREATE_DIRECTORY__").equals("true");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
		if(destination_filename=="" || destination_filename.equals("\"\"")){
			destination_filename= fileName.substring(fileName.lastIndexOf("/")+1,fileName.length()-1);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(destination_filename);
    stringBuffer.append(TEXT_13);
    
		}else{

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(destination_filename);
    stringBuffer.append(TEXT_17);
    		
		}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rpFile);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    if(creatDir==true){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(reFile);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
