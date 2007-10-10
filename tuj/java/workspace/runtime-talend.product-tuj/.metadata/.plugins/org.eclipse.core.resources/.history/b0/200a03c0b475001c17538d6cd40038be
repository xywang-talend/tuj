package org.talend.designer.codegen.translators.databases.sqlite;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.builder.database.ExtractMetaDataUtils;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TSQLiteInputBeginJava
{
  protected static String nl;
  public static synchronized TSQLiteInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQLiteInputBeginJava result = new TSQLiteInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "java.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");" + NL + "" + NL + "String url_";
  protected final String TEXT_4 = " = \"jdbc:sqlite:\" + \"/\" + ";
  protected final String TEXT_5 = ".toLowerCase();" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_6 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_7 = ");" + NL + "" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_8 = " = conn_";
  protected final String TEXT_9 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_10 = " = stmt_";
  protected final String TEXT_11 = ".executeQuery(";
  protected final String TEXT_12 = ");" + NL + "java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_13 = " = rs_";
  protected final String TEXT_14 = ".getMetaData();" + NL + "int colQtyInRs_";
  protected final String TEXT_15 = " = rsmd_";
  protected final String TEXT_16 = ".getColumnCount();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_QUERY\",";
  protected final String TEXT_18 = ");" + NL + NL;
  protected final String TEXT_19 = NL + "while (rs_";
  protected final String TEXT_20 = ".next()) {" + NL + "nb_line_";
  protected final String TEXT_21 = "++;" + NL;
  protected final String TEXT_22 = " \t" + NL + " \t\tif(colQtyInRs_";
  protected final String TEXT_23 = "<";
  protected final String TEXT_24 = "){" + NL + " \t\t" + NL + " \t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = "=";
  protected final String TEXT_27 = ";" + NL + " \t\t\t" + NL + " \t\t}else{" + NL + " \t  \t  ";
  protected final String TEXT_28 = NL + "\t\t\t  \tif(rs_";
  protected final String TEXT_29 = ".getString(";
  protected final String TEXT_30 = ")!=null&&(rs_";
  protected final String TEXT_31 = ".getString(";
  protected final String TEXT_32 = ")).length()>0){" + NL + "\t\t\t  \t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = "=rs_";
  protected final String TEXT_35 = ".getString(";
  protected final String TEXT_36 = ").charAt(0);" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t}else{\t\t\t  \t" + NL + "\t\t\t  \t    ";
  protected final String TEXT_37 = NL + "\t\t\t  \t    " + NL + "\t\t\t  \t   \tif((rs_";
  protected final String TEXT_38 = ".getString(";
  protected final String TEXT_39 = "))==null){" + NL + "\t\t\t  \t   \t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = "=null;" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = "='\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}" + NL + "\t\t\t  \t\t";
  protected final String TEXT_44 = NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\tif((rs_";
  protected final String TEXT_45 = ".getString(";
  protected final String TEXT_46 = ")).equals(\"\")){" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = '\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\tthrow new RuntimeException(" + NL + "\t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_49 = "', value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_50 = NL + "\t\t\t  \t}\t\t\t" + NL + "\t\t\t  ";
  protected final String TEXT_51 = NL + "\t\t\t if(rs_";
  protected final String TEXT_52 = ".getTimestamp(";
  protected final String TEXT_53 = ")!=null){" + NL + "\t\t\t \t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = "=new java.util.Date(rs_";
  protected final String TEXT_56 = ".getTimestamp(";
  protected final String TEXT_57 = ").getTime());" + NL + "\t\t\t }else{" + NL + "\t\t\t \t";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " =  null;" + NL + "\t\t\t }" + NL + "\t\t\t ";
  protected final String TEXT_60 = NL + "         \t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = (List)rs_";
  protected final String TEXT_63 = ".getObject(";
  protected final String TEXT_64 = ");" + NL + "\t\t\t ";
  protected final String TEXT_65 = NL + " \t   \t\t \tif(rs_";
  protected final String TEXT_66 = ".getObject(";
  protected final String TEXT_67 = ") != null)" + NL + " \t   \t\t \t{" + NL + " \t\t\t \t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = rs_";
  protected final String TEXT_70 = ".get";
  protected final String TEXT_71 = "(";
  protected final String TEXT_72 = ");" + NL + " \t\t\t \t}" + NL + " \t\t\t \telse" + NL + " \t\t\t \t{" + NL + "\t\t \t\t\t";
  protected final String TEXT_73 = NL + "\t\t \t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = null;" + NL + "\t\t \t\t\t";
  protected final String TEXT_76 = NL + " \t\t\t \t}" + NL + " \t\t\t ";
  protected final String TEXT_77 = NL + " \t\t}" + NL + " \t\t" + NL + "   \t ";
  protected final String TEXT_78 = NL + " \t\t   \t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = "=";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ";" + NL + " \t\t  ";
  protected final String TEXT_83 = NL;
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    String javaDbDriver   = "org.sqlite.JDBC";    
    
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String dbquery = ElementParameterParser.getValue(node, "__QUERY__");
		   dbquery = dbquery.replaceAll("\n"," ");
		   dbquery = dbquery.replaceAll("\r"," ");
		      
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( dbname);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_18);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
if(conns != null && conns.size()>0){
 	IConnection conn = conns.get(0);
 	String firstConnName = conn.getName();
 	int currentColNo = 1;
 	for(IMetadataColumn column:columnList){
 	
 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
 	String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
 	
 	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
 	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_27);
    
 	  	  if(typeToGenerate.equals("byte[]")){
 	  	   	typeToGenerate = "Bytes";
 	   	  }else if(typeToGenerate.equals("java.util.Date")){
 	   	  	typeToGenerate = "Timestamp";
 	   	  }else if(typeToGenerate.equals("Integer")){
 	   	  	typeToGenerate = "Int";
 	   	  }else{
			typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		  }
		  
			  if(typeToGenerate.equals("Char")||typeToGenerate.equals("Character")){
			  
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_36);
    if(typeToGenerate.equals("Character")){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    }else{
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    
			  }else if(typeToGenerate.equals("Timestamp")){
			 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
    
           	 }else if (typeToGenerate.equals("List")) {
          	 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_64);
     	
			 }else{
 	   		 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_72);
    
		 			if(column.isNullable())
		 			{
		 			
    stringBuffer.append(TEXT_73);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    
		 			}
		 			
    stringBuffer.append(TEXT_76);
    
 			  }
 			 
    stringBuffer.append(TEXT_77);
      
   	 	currentColNo++;
    	}
 	}
 	if(conns.size()>1){
 		for(int connNO = 1; connNO < conns.size(); connNO++){
 		  IConnection conn2 = conns.get(connNO);
 		  if((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))){
 		  	for(IMetadataColumn column:columnList){
 		  
    stringBuffer.append(TEXT_78);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
     
 		  	}
 		  }
 		}
 	}
}
		}
	}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
