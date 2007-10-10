package org.talend.designer.codegen.translators.databases.informix;

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

public class TInformixInputBeginJava
{
  protected static String nl;
  public static synchronized TInformixInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInformixInputBeginJava result = new TInformixInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "java.lang.Class.forName(\"com.informix.jdbc.IfxDriver\");" + NL + "" + NL + "String url_";
  protected final String TEXT_4 = " = \"jdbc:informix-sqli://\" + ";
  protected final String TEXT_5 = " + \":\" + ";
  protected final String TEXT_6 = " + \"/\" + ";
  protected final String TEXT_7 = " + \":informixserver=\" + ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "String dbUser_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "String dbPwd_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_13 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_14 = ",dbUser_";
  protected final String TEXT_15 = ",dbPwd_";
  protected final String TEXT_16 = ");" + NL + "" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_17 = " = conn_";
  protected final String TEXT_18 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_19 = " = stmt_";
  protected final String TEXT_20 = ".executeQuery(";
  protected final String TEXT_21 = ");" + NL + "java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_22 = " = rs_";
  protected final String TEXT_23 = ".getMetaData();" + NL + "int colQtyInRs_";
  protected final String TEXT_24 = " = rsmd_";
  protected final String TEXT_25 = ".getColumnCount();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_26 = "_QUERY\",";
  protected final String TEXT_27 = ");" + NL + NL;
  protected final String TEXT_28 = NL + "while (rs_";
  protected final String TEXT_29 = ".next()) {" + NL + "nb_line_";
  protected final String TEXT_30 = "++;" + NL;
  protected final String TEXT_31 = " \t" + NL + " \t\tif(colQtyInRs_";
  protected final String TEXT_32 = "<";
  protected final String TEXT_33 = "){" + NL + " \t\t" + NL + " \t\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = "=";
  protected final String TEXT_36 = ";" + NL + " \t\t\t" + NL + " \t\t}else{" + NL + " \t  \t  ";
  protected final String TEXT_37 = NL + "\t\t\t  \tif(rs_";
  protected final String TEXT_38 = ".getString(";
  protected final String TEXT_39 = ")!=null&&(rs_";
  protected final String TEXT_40 = ".getString(";
  protected final String TEXT_41 = ")).length()>0){" + NL + "\t\t\t  \t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = "=rs_";
  protected final String TEXT_44 = ".getString(";
  protected final String TEXT_45 = ").charAt(0);" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t}else{\t\t\t  \t" + NL + "\t\t\t  \t    ";
  protected final String TEXT_46 = NL + "\t\t\t  \t    " + NL + "\t\t\t  \t   \tif((rs_";
  protected final String TEXT_47 = ".getString(";
  protected final String TEXT_48 = "))==null){" + NL + "\t\t\t  \t   \t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = "=null;" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "='\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}" + NL + "\t\t\t  \t\t";
  protected final String TEXT_53 = NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\tif((rs_";
  protected final String TEXT_54 = ".getString(";
  protected final String TEXT_55 = ")).equals(\"\")){" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = '\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\tthrow new RuntimeException(" + NL + "\t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_58 = "', value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_59 = NL + "\t\t\t  \t}\t\t\t" + NL + "\t\t\t  ";
  protected final String TEXT_60 = NL + "\t\t\t if(rs_";
  protected final String TEXT_61 = ".getTimestamp(";
  protected final String TEXT_62 = ")!=null){" + NL + "\t\t\t \t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = "=new java.util.Date(rs_";
  protected final String TEXT_65 = ".getTimestamp(";
  protected final String TEXT_66 = ").getTime());" + NL + "\t\t\t }else{" + NL + "\t\t\t \t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " =  null;" + NL + "\t\t\t }" + NL + "\t\t\t ";
  protected final String TEXT_69 = NL + "         \t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = (List)rs_";
  protected final String TEXT_72 = ".getObject(";
  protected final String TEXT_73 = ");" + NL + "\t\t\t ";
  protected final String TEXT_74 = NL + " \t   \t\t \tif(rs_";
  protected final String TEXT_75 = ".getObject(";
  protected final String TEXT_76 = ") != null)" + NL + " \t   \t\t \t{" + NL + " \t\t\t \t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = rs_";
  protected final String TEXT_79 = ".get";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = ");" + NL + " \t\t\t \t}" + NL + " \t\t\t \telse" + NL + " \t\t\t \t{" + NL + "\t\t \t\t\t";
  protected final String TEXT_82 = NL + "\t\t \t\t\t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = null;" + NL + "\t\t \t\t\t";
  protected final String TEXT_85 = NL + " \t\t\t \t}" + NL + " \t\t\t ";
  protected final String TEXT_86 = NL + " \t\t}" + NL + " \t\t" + NL + "   \t ";
  protected final String TEXT_87 = NL + " \t\t   \t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = "=";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ";" + NL + " \t\t  ";
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbserver = ElementParameterParser.getValue(node, "__DBSERVER__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding= ElementParameterParser.getValue(node, "__ENCODING__");
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       dbquery = dbquery.replaceAll("\n"," ");
    		dbquery = dbquery.replaceAll("\r"," ");
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbserver);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbpwd);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_27);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
if(conns != null && conns.size()>0){
 	IConnection conn = conns.get(0);
 	String firstConnName = conn.getName();
 	int currentColNo = 1;
 	for(IMetadataColumn column:columnList){
 	
 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
 	String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
 	
 	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
 	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_36);
    
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
			  
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_45);
    if(typeToGenerate.equals("Character")){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    }else{
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    
			  }else if(typeToGenerate.equals("Timestamp")){
			 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    
           	 }else if (typeToGenerate.equals("List")) {
          	 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_73);
     	
			 }else{		  
 	   	 	 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_81);
    
		 			if(column.isNullable())
		 			{
		 			
    stringBuffer.append(TEXT_82);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    
		 			}
		 			
    stringBuffer.append(TEXT_85);
    
 			  }
 			 
    stringBuffer.append(TEXT_86);
      
   	 	currentColNo++;
    	}
 	}
 	if(conns.size()>1){
 		for(int connNO = 1; connNO < conns.size(); connNO++){
 		  IConnection conn2 = conns.get(connNO);
 		  if((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))){
 		  	for(IMetadataColumn column:columnList){
 		  
    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
     
 		  	}
 		  }
 		}
 	}
}
		}
	}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    return stringBuffer.toString();
  }
}
