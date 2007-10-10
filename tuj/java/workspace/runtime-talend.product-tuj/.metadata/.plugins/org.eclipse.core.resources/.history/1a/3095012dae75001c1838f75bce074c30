package org.talend.designer.codegen.translators.databases.dbgeneric;

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

public class TDBInputBeginJava
{
  protected static String nl;
  public static synchronized TDBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBInputBeginJava result = new TDBInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "java.lang.Class.forName(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "String url_";
  protected final String TEXT_6 = " = \"jdbc:odbc:\"+";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "String url_";
  protected final String TEXT_9 = " = \"jdbc:odbc:\"+";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "String url_";
  protected final String TEXT_12 = " = \"jdbc:oracle:thin:@\"+";
  protected final String TEXT_13 = "+\":\"+";
  protected final String TEXT_14 = "+\":\"+";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "String url_";
  protected final String TEXT_17 = " = \"jdbc:postgresql://\"+";
  protected final String TEXT_18 = "+\":\"+";
  protected final String TEXT_19 = "+\"/\"+";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "String url_";
  protected final String TEXT_22 = " = \"jdbc:mysql://\"+";
  protected final String TEXT_23 = "+\":\"+";
  protected final String TEXT_24 = "+\"/\"+";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + NL + NL + "String dbUser_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "String dbPwd_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_31 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_32 = ",dbUser_";
  protected final String TEXT_33 = ",dbPwd_";
  protected final String TEXT_34 = ");" + NL + "" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_35 = " = conn_";
  protected final String TEXT_36 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_37 = " = stmt_";
  protected final String TEXT_38 = ".executeQuery(";
  protected final String TEXT_39 = ");" + NL + "java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_40 = " = rs_";
  protected final String TEXT_41 = ".getMetaData();" + NL + "int colQtyInRs_";
  protected final String TEXT_42 = " = rsmd_";
  protected final String TEXT_43 = ".getColumnCount();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_44 = "_QUERY\",";
  protected final String TEXT_45 = ");" + NL + NL;
  protected final String TEXT_46 = NL + "while (rs_";
  protected final String TEXT_47 = ".next()) {" + NL + "nb_line_";
  protected final String TEXT_48 = "++;" + NL;
  protected final String TEXT_49 = " \t" + NL + " \t\tif(colQtyInRs_";
  protected final String TEXT_50 = "<";
  protected final String TEXT_51 = "){" + NL + " \t\t" + NL + " \t\t\t";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ";" + NL + " \t\t\t" + NL + " \t\t}else{" + NL + " \t  \t  ";
  protected final String TEXT_55 = NL + "\t\t\t  \tString tmpString_";
  protected final String TEXT_56 = " = rs_";
  protected final String TEXT_57 = ".getString(";
  protected final String TEXT_58 = ");" + NL + "\t\t\t  \tif(tmpString_";
  protected final String TEXT_59 = " != null && tmpString_";
  protected final String TEXT_60 = ".length()>0){" + NL + "\t\t\t  \t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = tmpString_";
  protected final String TEXT_63 = ".charAt(0);" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t}else{\t\t\t  \t" + NL + "\t\t\t  \t    ";
  protected final String TEXT_64 = NL + "\t\t\t  \t    " + NL + "\t\t\t  \t   \tif((rs_";
  protected final String TEXT_65 = ".getString(";
  protected final String TEXT_66 = ")) == null){" + NL + "\t\t\t  \t   \t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = null;" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = "='\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}" + NL + "\t\t\t  \t\t";
  protected final String TEXT_71 = NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\tif((rs_";
  protected final String TEXT_72 = ".getString(";
  protected final String TEXT_73 = ")).equals(\"\")){" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = '\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\tthrow new RuntimeException(" + NL + "\t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_76 = "', value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_77 = NL + "\t\t\t  \t}\t\t\t" + NL + "\t\t\t ";
  protected final String TEXT_78 = NL + "\t\t\t java.sql.Timestamp timestamp_";
  protected final String TEXT_79 = " = rs_";
  protected final String TEXT_80 = ".getTimestamp(";
  protected final String TEXT_81 = ");" + NL + "\t\t\t if(timestamp_";
  protected final String TEXT_82 = " != null){" + NL + "\t\t\t \t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = new java.util.Date(timestamp_";
  protected final String TEXT_85 = ".getTime());" + NL + "\t\t\t }else{" + NL + "\t\t\t \t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " =  null;" + NL + "\t\t\t }" + NL + "\t\t\t ";
  protected final String TEXT_88 = NL + "         \t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = (List)rs_";
  protected final String TEXT_91 = ".getObject(";
  protected final String TEXT_92 = ");" + NL + "             " + NL + "\t\t\t ";
  protected final String TEXT_93 = NL + "\t\t\t\tObject value = rs_";
  protected final String TEXT_94 = ".getObject(";
  protected final String TEXT_95 = ");" + NL + " \t   \t\t \tif(value != null)" + NL + " \t   \t\t \t{" + NL + " \t   \t\t \t\t";
  protected final String TEXT_96 = NL + "   \t\t \t\t\t\tvalue = new ";
  protected final String TEXT_97 = "(";
  protected final String TEXT_98 = ".parse";
  protected final String TEXT_99 = "(value.toString()));" + NL + "   \t\t \t\t\t\t";
  protected final String TEXT_100 = NL + "   \t\t \t\t\t\tvalue = new ";
  protected final String TEXT_101 = "(";
  protected final String TEXT_102 = ".parse";
  protected final String TEXT_103 = "(value.toString()));" + NL + "   \t\t \t\t\t\t";
  protected final String TEXT_104 = NL + " \t\t\t \t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = (";
  protected final String TEXT_107 = ")value;" + NL + " \t\t\t \t}" + NL + " \t\t\t \telse" + NL + " \t\t\t \t{" + NL + "\t\t \t\t\t";
  protected final String TEXT_108 = NL + "\t\t \t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = null;" + NL + "\t\t \t\t\t";
  protected final String TEXT_111 = NL + " \t\t\t \t}" + NL + " \t\t\t ";
  protected final String TEXT_112 = NL + " \t\t}" + NL + " \t\t" + NL + "   \t ";
  protected final String TEXT_113 = NL + " \t\t   \t";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = "=";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = ";" + NL + " \t\t  ";
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbtypeDefinition = ElementParameterParser.getValue(node, "__TYPE__");
    String[] dbtypes = dbtypeDefinition.split(";");
    String javaDbtype   = dbtypes[0];
    String javaDbDriver   = dbtypes[1];
    
    
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
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
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_4);
    
if(javaDbtype.equals("undef")){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_7);
    
}else if(javaDbtype.equals("mssql")){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    
}else if(javaDbtype.equals("oracle")){
String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_15);
    
}else if(javaDbtype.equals("postgresql")){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_20);
    
}else if(javaDbtype.equals("mysql")){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_25);
    
}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_45);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
if(conns != null && conns.size()>0){
 	IConnection conn = conns.get(0);
 	String firstConnName = conn.getName();
 	int currentColNo = 1;
 	for(IMetadataColumn column:columnList){
 	
 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
 	String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
 	
 	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
 	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_54);
    
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
			  
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    if(typeToGenerate.equals("Character")){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    }else{
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    
			  }else if(typeToGenerate.equals("Timestamp")){
			 
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    
           	 }else if (typeToGenerate.equals("List")) {
          	 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_92);
     	
			 }else{		  
   	 		 
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_95);
    
   		 			String javaType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
   		 			if(javaType.equals("Integer"))
   		 			{
   		 				
    stringBuffer.append(TEXT_96);
    stringBuffer.append(javaType);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(javaType);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(javaType.substring(0,3));
    stringBuffer.append(TEXT_99);
    
   		 			}
   		 			else if(javaType.equals("Byte") || javaType.equals("Short") || javaType.equals("Long") || 
   		 			javaType.equals("Float") || javaType.equals("Double"))
   		 			{
   		 				
    stringBuffer.append(TEXT_100);
    stringBuffer.append(javaType);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(javaType);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(javaType);
    stringBuffer.append(TEXT_103);
    
   		 			}
 	   		 		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column.getTalendType(), true));
    stringBuffer.append(TEXT_107);
    
		 			if(column.isNullable())
		 			{
		 			
    stringBuffer.append(TEXT_108);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    
		 			}
		 			
    stringBuffer.append(TEXT_111);
    
 			  }
 			 
    stringBuffer.append(TEXT_112);
      
   	 	currentColNo++;
    	}
 	}
 	if(conns.size()>1){
 		for(int connNO = 1; connNO < conns.size(); connNO++){
 		  IConnection conn2 = conns.get(connNO);
 		  if((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))){
 		  	for(IMetadataColumn column:columnList){
 		  
    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_117);
     
 		  	}
 		  }
 		}
 	}
}
		}
	}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    return stringBuffer.toString();
  }
}
