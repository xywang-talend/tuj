package org.talend.designer.codegen.translators.databases.hsqldb;

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

public class THSQLDbInputBeginJava
{
  protected static String nl;
  public static synchronized THSQLDbInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THSQLDbInputBeginJava result = new THSQLDbInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "String url_";
  protected final String TEXT_4 = " = null;" + NL;
  protected final String TEXT_5 = NL + "\t\turl_";
  protected final String TEXT_6 = " = \"jdbc:hsqldb:hsqls://\" + ";
  protected final String TEXT_7 = " + \":\" + ";
  protected final String TEXT_8 = " + \"/\" + ";
  protected final String TEXT_9 = ";" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\turl_";
  protected final String TEXT_11 = " = \"jdbc:hsqldb:hsql://\" + ";
  protected final String TEXT_12 = " + \":\" + ";
  protected final String TEXT_13 = " + \"/\" + ";
  protected final String TEXT_14 = ";" + NL + "\t";
  protected final String TEXT_15 = NL + "\t\turl_";
  protected final String TEXT_16 = " = \"jdbc:hsqldb:https://\" + ";
  protected final String TEXT_17 = " + \":\" + ";
  protected final String TEXT_18 = " + \"/\" + ";
  protected final String TEXT_19 = ";" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\turl_";
  protected final String TEXT_21 = " = \"jdbc:hsqldb:http://\" + ";
  protected final String TEXT_22 = " + \":\" + ";
  protected final String TEXT_23 = " + \"/\" + ";
  protected final String TEXT_24 = ";" + NL + "\t";
  protected final String TEXT_25 = NL + "\turl_";
  protected final String TEXT_26 = " = \"jdbc:hsqldb:file:\" + ";
  protected final String TEXT_27 = " + \"/\" + ";
  protected final String TEXT_28 = " + \";ifexists=true\";" + NL + "\t";
  protected final String TEXT_29 = NL + "java.lang.Class.forName(\"org.hsqldb.jdbcDriver\");" + NL + "" + NL + "String dbUser_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";" + NL + "String dbPwd_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_34 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_35 = ",dbUser_";
  protected final String TEXT_36 = ",dbPwd_";
  protected final String TEXT_37 = ");" + NL + "" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_38 = " = conn_";
  protected final String TEXT_39 = ".createStatement();" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_40 = " = stmt_";
  protected final String TEXT_41 = ".executeQuery(";
  protected final String TEXT_42 = ");" + NL + "java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_43 = " = rs_";
  protected final String TEXT_44 = ".getMetaData();" + NL + "int colQtyInRs_";
  protected final String TEXT_45 = " = rsmd_";
  protected final String TEXT_46 = ".getColumnCount();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_47 = "_QUERY\",";
  protected final String TEXT_48 = ");" + NL + NL;
  protected final String TEXT_49 = NL + "while (rs_";
  protected final String TEXT_50 = ".next()) {" + NL + "nb_line_";
  protected final String TEXT_51 = "++;" + NL;
  protected final String TEXT_52 = " \t" + NL + " \t\tif(colQtyInRs_";
  protected final String TEXT_53 = "<";
  protected final String TEXT_54 = "){" + NL + " \t\t" + NL + " \t\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = "=";
  protected final String TEXT_57 = ";" + NL + " \t\t\t" + NL + " \t\t}else{" + NL + " \t  \t  ";
  protected final String TEXT_58 = NL + "\t\t\t  \tif(rs_";
  protected final String TEXT_59 = ".getString(";
  protected final String TEXT_60 = ")!=null&&(rs_";
  protected final String TEXT_61 = ".getString(";
  protected final String TEXT_62 = ")).length()>0){" + NL + "\t\t\t  \t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = "=rs_";
  protected final String TEXT_65 = ".getString(";
  protected final String TEXT_66 = ").charAt(0);" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t}else{\t\t\t  \t" + NL + "\t\t\t  \t    ";
  protected final String TEXT_67 = NL + "\t\t\t  \t    " + NL + "\t\t\t  \t   \tif((rs_";
  protected final String TEXT_68 = ".getString(";
  protected final String TEXT_69 = "))==null){" + NL + "\t\t\t  \t   \t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = "=null;" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = "='\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}" + NL + "\t\t\t  \t\t";
  protected final String TEXT_74 = NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\tif((rs_";
  protected final String TEXT_75 = ".getString(";
  protected final String TEXT_76 = ")).equals(\"\")){" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = '\\0';" + NL + "\t\t\t  \t\t\t" + NL + "\t\t\t  \t\t}else{" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t\tthrow new RuntimeException(" + NL + "\t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_79 = "', value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t  \t\t" + NL + "\t\t\t  \t\t";
  protected final String TEXT_80 = NL + "\t\t\t  \t}\t\t\t" + NL + "\t\t\t  ";
  protected final String TEXT_81 = NL + "\t\t\t if(rs_";
  protected final String TEXT_82 = ".getTimestamp(";
  protected final String TEXT_83 = ")!=null){" + NL + "\t\t\t \t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = "=new java.util.Date(rs_";
  protected final String TEXT_86 = ".getTimestamp(";
  protected final String TEXT_87 = ").getTime());" + NL + "\t\t\t }else{" + NL + "\t\t\t \t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " =  null;" + NL + "\t\t\t }" + NL + "\t\t\t ";
  protected final String TEXT_90 = NL + "         \t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = (List)rs_";
  protected final String TEXT_93 = ".getObject(";
  protected final String TEXT_94 = ");" + NL + "\t\t\t ";
  protected final String TEXT_95 = NL + " \t   \t\t \tif(rs_";
  protected final String TEXT_96 = ".getObject(";
  protected final String TEXT_97 = ") != null)" + NL + " \t   \t\t \t{" + NL + " \t\t\t \t\t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = rs_";
  protected final String TEXT_100 = ".get";
  protected final String TEXT_101 = "(";
  protected final String TEXT_102 = ");" + NL + " \t\t\t \t}" + NL + " \t\t\t \telse" + NL + " \t\t\t \t{" + NL + "\t\t \t\t\t";
  protected final String TEXT_103 = NL + "\t\t \t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = null;" + NL + "\t\t \t\t\t";
  protected final String TEXT_106 = NL + " \t\t\t \t}" + NL + " \t\t\t ";
  protected final String TEXT_107 = NL + " \t\t}" + NL + " \t\t" + NL + "   \t ";
  protected final String TEXT_108 = NL + " \t\t   \t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = "=";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ";" + NL + " \t\t  ";
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbalias = ElementParameterParser.getValue(node, "__DATABASE_ALIAS__");
	String dbpath = ElementParameterParser.getValue(node, "__DBPATH__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
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
    
String runningMode = ElementParameterParser.getValue(node, "__RUNNING_MODE__");
String tls = ElementParameterParser.getValue(node, "__TLS__");
if(runningMode.equals("HSQLDB_SERVER"))
{
	if(tls.equals("true"))
	{
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbalias);
    stringBuffer.append(TEXT_9);
    
	}
	else
	{
	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbalias);
    stringBuffer.append(TEXT_14);
    
	}
}
else if(runningMode.equals("HSQLDB_WEBSERVER"))
{
	if(tls.equals("true"))
	{
	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbalias);
    stringBuffer.append(TEXT_19);
    
	}
	else
	{
	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbalias);
    stringBuffer.append(TEXT_24);
    
	}
}
else if(runningMode.equals("HSQLDB_INPROGRESS_PERSISTENT"))
{
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbpath);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_28);
    
}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_48);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
if(conns != null && conns.size()>0){
 	IConnection conn = conns.get(0);
 	String firstConnName = conn.getName();
 	int currentColNo = 1;
 	for(IMetadataColumn column:columnList){
 	
 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
 	String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
 	
 	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
 	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_57);
    
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
			  
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(currentColNo);
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
    if(typeToGenerate.equals("Character")){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
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
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    
			  }else if(typeToGenerate.equals("Timestamp")){
			 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    
           	 }else if (typeToGenerate.equals("List")) {
          	 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_94);
     	
			 }else{		  
 	   	 	 
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_102);
    
		 			if(column.isNullable())
		 			{
		 			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    
		 			}
		 			
    stringBuffer.append(TEXT_106);
    
 			  }
 			 
    stringBuffer.append(TEXT_107);
      
   	 	currentColNo++;
    	}
 	}
 	if(conns.size()>1){
 		for(int connNO = 1; connNO < conns.size(); connNO++){
 		  IConnection conn2 = conns.get(connNO);
 		  if((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))){
 		  	for(IMetadataColumn column:columnList){
 		  
    stringBuffer.append(TEXT_108);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_112);
     
 		  	}
 		  }
 		}
 	}
}
		}
	}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    return stringBuffer.toString();
  }
}
