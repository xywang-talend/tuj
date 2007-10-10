package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputCSVBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputCSVBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputCSVBeginJava result = new TFileOutputCSVBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        " + NL + " int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + " int splitEvery_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + " int splitedFileNo_";
  protected final String TEXT_5 = " =0;" + NL + " int currentRow_";
  protected final String TEXT_6 = " = 0;";
  protected final String TEXT_7 = NL + "\t //create directory only if not exists" + NL + "\t String fileNewName_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "\t java.io.File createFile";
  protected final String TEXT_10 = " = new java.io.File(fileNewName_";
  protected final String TEXT_11 = ");" + NL + "\t if(!createFile";
  protected final String TEXT_12 = ".exists()){" + NL + "\t \t(new java.io.File(fileNewName_";
  protected final String TEXT_13 = ".substring(0,fileNewName_";
  protected final String TEXT_14 = ".lastIndexOf(\"/\")))).mkdirs();" + NL + "\t }" + NL;
  protected final String TEXT_15 = NL + "    com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_16 = "=new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                new java.io.FileOutputStream(";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = "),";
  protected final String TEXT_19 = ")), '";
  protected final String TEXT_20 = "');  " + NL + "                java.io.File file";
  protected final String TEXT_21 = "=new java.io.File(";
  protected final String TEXT_22 = ");\t";
  protected final String TEXT_23 = NL + "\t  com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_24 = "=new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                new java.io.FileOutputStream(";
  protected final String TEXT_25 = "\"+splitedFileNo_";
  protected final String TEXT_26 = "+\"";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = "),";
  protected final String TEXT_29 = ")), '";
  protected final String TEXT_30 = "');" + NL + "                java.io.File file";
  protected final String TEXT_31 = "=new java.io.File(";
  protected final String TEXT_32 = "\"+splitedFileNo_";
  protected final String TEXT_33 = "+\"";
  protected final String TEXT_34 = ");\t  ";
  protected final String TEXT_35 = NL + "\t\tString fn_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "\t\tString prefix_fn_";
  protected final String TEXT_38 = " = fn_";
  protected final String TEXT_39 = ".substring(0,fn_";
  protected final String TEXT_40 = ".lastIndexOf(\".\"));" + NL + "\t\tString suffix_fn_";
  protected final String TEXT_41 = "=fn_";
  protected final String TEXT_42 = ".substring(fn_";
  protected final String TEXT_43 = ".lastIndexOf(\".\"),fn_";
  protected final String TEXT_44 = ".length());" + NL + "\t  \tcom.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_45 = "=new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "        \tnew java.io.FileOutputStream(prefix_fn_";
  protected final String TEXT_46 = "+splitedFileNo_";
  protected final String TEXT_47 = "+suffix_fn_";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = "),";
  protected final String TEXT_50 = ")), '";
  protected final String TEXT_51 = "');" + NL + "        java.io.File file";
  protected final String TEXT_52 = "=new java.io.File(prefix_fn_";
  protected final String TEXT_53 = "+splitedFileNo_";
  protected final String TEXT_54 = "+suffix_fn_";
  protected final String TEXT_55 = ");\t  ";
  protected final String TEXT_56 = NL + "   \t\tString[] headColu";
  protected final String TEXT_57 = "=new String[";
  protected final String TEXT_58 = "];";
  protected final String TEXT_59 = NL + "   \t\t\t\theadColu";
  protected final String TEXT_60 = "[";
  protected final String TEXT_61 = "]=\"";
  protected final String TEXT_62 = "\";";
  protected final String TEXT_63 = NL + "    \t\tCsvWriter";
  protected final String TEXT_64 = ".writeRecord(headColu";
  protected final String TEXT_65 = ");\t";
  protected final String TEXT_66 = "\t\t   " + NL + "     \t      if(file";
  protected final String TEXT_67 = ".length()==0)  " + NL + "     \t      {";
  protected final String TEXT_68 = "\t      \t" + NL + "     \t     \theadColu";
  protected final String TEXT_69 = "[";
  protected final String TEXT_70 = "]=\"";
  protected final String TEXT_71 = "\";";
  protected final String TEXT_72 = "\t " + NL + "      \t\tCsvWriter";
  protected final String TEXT_73 = ".writeRecord(headColu";
  protected final String TEXT_74 = ");    \t" + NL + "     \t      }" + NL + " ";
  protected final String TEXT_75 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
     	String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");
        String prefixfileName = filename.substring(0,filename.lastIndexOf("."));
        String suffixfileName=filename.substring(filename.lastIndexOf("."),filename.length());
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    	String delim = delim1.substring(1,delim1.length()-1);
    	boolean isAppend = ElementParameterParser.getValue(node,"__APPEND__").equals("true");
    	boolean isIncludeHeader = ElementParameterParser.getValue(node,"__INCLUDEHEADER__").equals("true");
    	boolean split = ElementParameterParser.getValue(node, "__SPLIT__").equals("true");
        String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
	}
	
 	if(!split){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_22);
    
 	}else{
 		if(filename.startsWith("\"") && filename.endsWith("\"")){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(prefixfileName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(suffixfileName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(prefixfileName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(suffixfileName);
    stringBuffer.append(TEXT_34);
    
 		}else{

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
 		}
    }
    List<IMetadataColumn> columns = metadata.getListColumns();
    	int sizeColumns = columns.size();
   
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_58);
     		
 		  if(isIncludeHeader&&!isAppend)
 		  {
 		  	for(int i = 0; i < sizeColumns; i++)
    		{
    			IMetadataColumn column = columns.get(i);
 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    
    		}
    
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    		
 		  }
 		   if(isIncludeHeader&&isAppend)
 		   {
 		   
 	
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    			
     			for(int i = 0; i < sizeColumns; i++)
    			{
    				IMetadataColumn column = columns.get(i);
     
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    
     			}
      
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    		  } 
    	}
    }

    stringBuffer.append(TEXT_75);
    return stringBuffer.toString();
  }
}
