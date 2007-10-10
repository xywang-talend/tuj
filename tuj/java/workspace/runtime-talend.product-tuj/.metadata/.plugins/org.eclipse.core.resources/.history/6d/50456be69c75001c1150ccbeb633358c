package org.talend.designer.codegen.translators.databases.javadb;

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

public class TJavaDBInputBeginJava
{
  protected static String nl;
  public static synchronized TJavaDBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJavaDBInputBeginJava result = new TJavaDBInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tString jdbcDriver_";
  protected final String TEXT_2 = " = null;" + NL + "\t\t\tString url_";
  protected final String TEXT_3 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tjdbcDriver_";
  protected final String TEXT_5 = " = \"org.apache.derby.jdbc.EmbeddedDriver\";" + NL + "\t\t\t\turl_";
  protected final String TEXT_6 = " = \"jdbc:derby:\" + ";
  protected final String TEXT_7 = ";" + NL + "\t\t\t\t//set the root path of the database" + NL + "\t\t\t\tSystem.setProperty(\"derby.system.home\",";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "    \t\t\t\tjdbcDriver_";
  protected final String TEXT_10 = " = \"com.ibm.db2.jcc.DB2Driver\";" + NL + "    \t\t\t\turl_";
  protected final String TEXT_11 = " = \"jdbc:derby:net://\" + ";
  protected final String TEXT_12 = " + \":\" + ";
  protected final String TEXT_13 = " + \"/\" + ";
  protected final String TEXT_14 = ";" + NL + "    \t\t\t\t";
  protected final String TEXT_15 = NL + "    \t\t\t\tjdbcDriver_";
  protected final String TEXT_16 = " = \"org.apache.derby.jdbc.ClientDriver\";" + NL + "    \t\t\t\turl_";
  protected final String TEXT_17 = " = \"jdbc:derby://\" + ";
  protected final String TEXT_18 = " + \":\" + ";
  protected final String TEXT_19 = " + \"/\" + ";
  protected final String TEXT_20 = ";" + NL + "    \t\t\t\t";
  protected final String TEXT_21 = NL + "    \t\t\t";
  protected final String TEXT_22 = NL + "        \t\t\torg.apache.derby.drda.NetworkServerControl serverControl_";
  protected final String TEXT_23 = ";" + NL + "        \t\t\tserverControl_";
  protected final String TEXT_24 = " = new org.apache.derby.drda.NetworkServerControl(java.net.InetAddress.getByName(";
  protected final String TEXT_25 = "),Integer.parseInt(";
  protected final String TEXT_26 = "));" + NL + "        \t\t\t//start server" + NL + "        \t\t\tserverControl_";
  protected final String TEXT_27 = ".start(new java.io.PrintWriter(System.out,true));" + NL + "        \t\t\tboolean isServerUp_";
  protected final String TEXT_28 = " = false;" + NL + "        \t\t\tint timeOut_";
  protected final String TEXT_29 = " = 5;" + NL + "        \t\t\twhile(!isServerUp_";
  protected final String TEXT_30 = " && timeOut_";
  protected final String TEXT_31 = " > 0)" + NL + "        \t\t\t{" + NL + "        \t\t\t\ttry" + NL + "        \t\t\t\t{" + NL + "            \t\t\t\ttimeOut_";
  protected final String TEXT_32 = "--;" + NL + "            \t\t\t\t/*" + NL + "    \t\t\t\t\t\t* testing for connection to see if the network server is up and running." + NL + "    \t\t\t\t\t\t* if server is not ready yet, this method will throw an exception.\t\t" + NL + "    \t\t\t\t\t\t*/" + NL + "            \t\t\t\tserverControl_";
  protected final String TEXT_33 = ".ping();" + NL + "            \t\t\t\tisServerUp_";
  protected final String TEXT_34 = " = true;" + NL + "        \t\t\t\t}" + NL + "    \t\t\t\t\tcatch(Exception e) {" + NL + "    \t\t\t\t\t\t//Unable to obtain a connection to network server, trying again after 3000 ms." + NL + "    \t\t\t\t\t\tThread.currentThread().sleep(3000);" + NL + "    \t\t\t\t\t}    \t\t\t\t" + NL + "        \t\t\t}" + NL + "        \t\t\tif(!isServerUp_";
  protected final String TEXT_35 = ")" + NL + "        \t\t\t{" + NL + "        \t\t\t\t/*" + NL + "    \t\t\t\t\t * can not obtain a connection to network server." + NL + "    \t\t\t\t\t */ \t " + NL + "        \t\t\t\tSystem.exit(1);\t" + NL + "        \t\t\t}" + NL + "        \t\t\t//derby network server started." + NL + "    \t\t\t";
  protected final String TEXT_36 = NL + "\t\t\tClass.forName(jdbcDriver_";
  protected final String TEXT_37 = ").newInstance();" + NL + "\t\t\t" + NL + "\t\t\tjava.util.Properties properties_";
  protected final String TEXT_38 = " = new java.util.Properties();" + NL + "\t\t\t" + NL + "\t\t\tproperties_";
  protected final String TEXT_39 = ".put(\"user\",";
  protected final String TEXT_40 = ");" + NL + "\t\t\t" + NL + "\t\t\tproperties_";
  protected final String TEXT_41 = ".put(\"password\",";
  protected final String TEXT_42 = ");" + NL + "\t\t\t" + NL + "\t\t\tjava.sql.Connection conn_";
  protected final String TEXT_43 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_44 = ",properties_";
  protected final String TEXT_45 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_46 = " = conn_";
  protected final String TEXT_47 = ".createStatement();" + NL + "\t\t\t" + NL + "\t\t\tjava.sql.ResultSet rs_";
  protected final String TEXT_48 = " = stmt_";
  protected final String TEXT_49 = ".executeQuery(";
  protected final String TEXT_50 = ");" + NL + "\t\t\t" + NL + "\t\t\tjava.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_51 = " = rs_";
  protected final String TEXT_52 = ".getMetaData();" + NL + "\t\t\t" + NL + "\t\t\tint colQtyInRs_";
  protected final String TEXT_53 = " = rsmd_";
  protected final String TEXT_54 = ".getColumnCount();" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_55 = "_QUERY\",";
  protected final String TEXT_56 = ");" + NL + "" + NL + "\t\t\tint nb_line_";
  protected final String TEXT_57 = " = 0;" + NL + "\t\t\t" + NL + "\t\t  ";
  protected final String TEXT_58 = NL + "\t\t\t" + NL + "            while (rs_";
  protected final String TEXT_59 = ".next()) {" + NL + "            nb_line_";
  protected final String TEXT_60 = "++;" + NL + "            ";
  protected final String TEXT_61 = " \t" + NL + "             \t\tif(colQtyInRs_";
  protected final String TEXT_62 = "<";
  protected final String TEXT_63 = "){" + NL + "             \t\t" + NL + "             \t\t\t";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = "=";
  protected final String TEXT_66 = ";" + NL + "             \t\t\t" + NL + "             \t\t}else{" + NL + "             \t  \t  ";
  protected final String TEXT_67 = NL + "            \t\t\t  \tif(rs_";
  protected final String TEXT_68 = ".getString(";
  protected final String TEXT_69 = ")!=null&&(rs_";
  protected final String TEXT_70 = ".getString(";
  protected final String TEXT_71 = ")).length()>0){" + NL + "            \t\t\t  \t" + NL + "            \t\t\t  \t\t";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = "=rs_";
  protected final String TEXT_74 = ".getString(";
  protected final String TEXT_75 = ").charAt(0);" + NL + "            \t\t\t  \t\t" + NL + "            \t\t\t  \t}else{\t\t\t  \t" + NL + "            \t\t\t  \t    ";
  protected final String TEXT_76 = NL + "            \t\t\t  \t    " + NL + "            \t\t\t  \t   \tif((rs_";
  protected final String TEXT_77 = ".getString(";
  protected final String TEXT_78 = "))==null){" + NL + "            \t\t\t  \t   \t" + NL + "            \t\t\t  \t\t\t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = "=null;" + NL + "            \t\t\t  \t\t\t" + NL + "            \t\t\t  \t\t}else{" + NL + "            \t\t\t  \t\t" + NL + "            \t\t\t  \t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = "='\\0';" + NL + "            \t\t\t  \t\t\t" + NL + "            \t\t\t  \t\t}" + NL + "            \t\t\t  \t\t";
  protected final String TEXT_83 = NL + "            \t\t\t  \t\t" + NL + "            \t\t\t  \t\tif((rs_";
  protected final String TEXT_84 = ".getString(";
  protected final String TEXT_85 = ")).equals(\"\")){" + NL + "            \t\t\t  \t\t" + NL + "            \t\t\t  \t\t\t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = '\\0';" + NL + "            \t\t\t  \t\t\t" + NL + "            \t\t\t  \t\t}else{" + NL + "            \t\t\t  \t\t" + NL + "            \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "            \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_88 = "', value is invalid or this column should be nullable or have a default value.\");" + NL + "            \t\t\t\t\t\t\t" + NL + "            \t\t\t\t\t}" + NL + "            \t\t\t  \t\t" + NL + "            \t\t\t  \t\t";
  protected final String TEXT_89 = NL + "            \t\t\t  \t}\t\t\t" + NL + "            \t\t\t  ";
  protected final String TEXT_90 = NL + "            \t\t\t if(rs_";
  protected final String TEXT_91 = ".getTimestamp(";
  protected final String TEXT_92 = ")!=null){" + NL + "            \t\t\t \t";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = "=new java.util.Date(rs_";
  protected final String TEXT_95 = ".getTimestamp(";
  protected final String TEXT_96 = ").getTime());" + NL + "            \t\t\t }else{" + NL + "            \t\t\t \t";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " =  null;" + NL + "            \t\t\t }" + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_99 = NL + "\t\t\t         \t\t";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " = (List)rs_";
  protected final String TEXT_102 = ".getObject(";
  protected final String TEXT_103 = ");" + NL + "            \t\t\t ";
  protected final String TEXT_104 = NL + "             \t   \t\t \tif(rs_";
  protected final String TEXT_105 = ".getObject(";
  protected final String TEXT_106 = ") != null)" + NL + "             \t   \t\t \t{" + NL + "             \t\t\t \t\t";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = " = rs_";
  protected final String TEXT_109 = ".get";
  protected final String TEXT_110 = "(";
  protected final String TEXT_111 = ");" + NL + "             \t\t\t \t}" + NL + "             \t\t\t \telse" + NL + "             \t\t\t \t{" + NL + "            \t\t \t\t\t";
  protected final String TEXT_112 = NL + "            \t\t \t\t\t";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = " = null;" + NL + "            \t\t \t\t\t";
  protected final String TEXT_115 = NL + "             \t\t\t \t}" + NL + "             \t\t\t ";
  protected final String TEXT_116 = NL + "             \t\t}" + NL + "             \t\t" + NL + "               \t ";
  protected final String TEXT_117 = NL + "             \t\t   \t";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = "=";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ";" + NL + "             \t\t  ";
  protected final String TEXT_122 = NL;
  protected final String TEXT_123 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	
	String db = ElementParameterParser.getValue(node, "__DB__");
	
	String frameworkType = ElementParameterParser.getValue(node,"__FRAMEWORK_TYPE__");
	
	String dbRootPath = ElementParameterParser.getValue(node, "__DBPATH__");
		
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	
	String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			if(frameworkType.equals("EMBEDED"))
			{
				
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbRootPath);
    stringBuffer.append(TEXT_8);
    
			}
			else
			{
    			if(frameworkType.equals("JCCJDBC"))
    			{
    				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_14);
    
    			}
    			else
    			{
    				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_20);
    
    			}
    			
    stringBuffer.append(TEXT_21);
    
    			String connectionFlag = ElementParameterParser.getValue(node, "__CONNECTION_FLAG__");
    			if(connectionFlag.equals("false"))
    			{
    			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
    			}
			}
			
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			List<IMetadataColumn> columnList = metadata.getListColumns();
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
            if(conns != null && conns.size()>0){
             	IConnection conn = conns.get(0);
             	String firstConnName = conn.getName();
             	int currentColNo = 1;
             	for(IMetadataColumn column:columnList){
             	
             	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
             	String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
             	
             	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
             	
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_66);
    
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
            			  
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_75);
    if(typeToGenerate.equals("Character")){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    }else{
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    
            			  }else if(typeToGenerate.equals("Timestamp")){
            			 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_98);
    
			           	 }else if (typeToGenerate.equals("List")) {
			          	 
    stringBuffer.append(TEXT_99);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_103);
     	
            			 }else{
             	   		 
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_111);
    
            		 			if(column.isNullable())
            		 			{
            		 			
    stringBuffer.append(TEXT_112);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_114);
    
            		 			}
            		 			
    stringBuffer.append(TEXT_115);
    
             			  }
             			 
    stringBuffer.append(TEXT_116);
      
               	 	currentColNo++;
                	}
             	}
             	if(conns.size()>1){
             		for(int connNO = 1; connNO < conns.size(); connNO++){
             		  IConnection conn2 = conns.get(connNO);
             		  if((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))){
             		  	for(IMetadataColumn column:columnList){
             		  
    stringBuffer.append(TEXT_117);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_121);
     
             		  	}
             		  }
             		}
             	}
            }
            		}
            	}
            
    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    return stringBuffer.toString();
  }
}
