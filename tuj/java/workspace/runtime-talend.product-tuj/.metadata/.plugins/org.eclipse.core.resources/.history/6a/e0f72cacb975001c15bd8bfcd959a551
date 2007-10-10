package org.talend.designer.codegen.translators.databases;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.database.EDatabaseTypeName;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.TypesManager;
import org.talend.core.model.metadata.Dbms;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TCreateTableMainJava
{
  protected static String nl;
  public static synchronized TCreateTableMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCreateTableMainJava result = new TCreateTableMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "try{" + NL + NL + NL + NL + NL + NL + NL;
  protected final String TEXT_3 = "\t\t" + NL + "\t\tboolean isLackDBType = ";
  protected final String TEXT_4 = ";" + NL + "\t\tif(isLackDBType)" + NL + "\t\t{" + NL + "\t\t \tthrow new Exception(\"To create a table, the DB Type in the schema must be set\");" + NL + "\t\t}";
  protected final String TEXT_5 = NL + "\t\tString url";
  protected final String TEXT_6 = "=null;" + NL + "\t\tjava.sql.Connection con";
  protected final String TEXT_7 = "=null;" + NL + "\t\tjava.sql.Statement stmt";
  protected final String TEXT_8 = "=null;" + NL + "\t\tString sql";
  protected final String TEXT_9 = "=null;";
  protected final String TEXT_10 = NL + "\t\tClass.forName(\"";
  protected final String TEXT_11 = "\");" + NL + "\t\tcon";
  protected final String TEXT_12 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\t\tcon";
  protected final String TEXT_15 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = NL + "\t\tcon";
  protected final String TEXT_18 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_19 = "\");\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\tClass.forName(\"";
  protected final String TEXT_21 = "\");" + NL + "\t\turl";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL + "\t\tcon";
  protected final String TEXT_24 = " = java.sql.DriverManager.getConnection(url";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\turl";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL + "\t\t\tSystem.setProperty(\"derby.system.home\",";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "       \t\torg.apache.derby.drda.NetworkServerControl serverControl_";
  protected final String TEXT_32 = ";" + NL + "        \tserverControl_";
  protected final String TEXT_33 = " = new org.apache.derby.drda.NetworkServerControl(java.net.InetAddress.getByName(";
  protected final String TEXT_34 = "),Integer.parseInt(";
  protected final String TEXT_35 = "));" + NL + "\t\t\tserverControl_";
  protected final String TEXT_36 = ".start(new java.io.PrintWriter(System.out,true));" + NL + "        \tboolean isServerUp_";
  protected final String TEXT_37 = " = false;" + NL + "        \tint timeOut_";
  protected final String TEXT_38 = " = 5;" + NL + "        \twhile(!isServerUp_";
  protected final String TEXT_39 = " && timeOut_";
  protected final String TEXT_40 = " > 0)" + NL + "        \t{\ttry" + NL + "        \t\t{\ttimeOut_";
  protected final String TEXT_41 = "--;" + NL + "            \t\tserverControl_";
  protected final String TEXT_42 = ".ping();" + NL + "            \t\tisServerUp_";
  protected final String TEXT_43 = " = true;" + NL + "        \t\t}catch(Exception e) {" + NL + "    \t\t\t\tThread.currentThread().sleep(3000);" + NL + "    \t\t\t}    \t\t\t\t" + NL + "        \t}" + NL + "        \tif(!isServerUp_";
  protected final String TEXT_44 = ")" + NL + "        \t{\tSystem.exit(1);\t}";
  protected final String TEXT_45 = NL + "\t\tjava.util.Properties properties";
  protected final String TEXT_46 = "=new java.util.Properties();" + NL + "\t\tClass.forName(\"";
  protected final String TEXT_47 = "\");" + NL + "\t\tproperties";
  protected final String TEXT_48 = ".put(\"user\",";
  protected final String TEXT_49 = ");" + NL + "\t\tproperties";
  protected final String TEXT_50 = ".put(\"password\",";
  protected final String TEXT_51 = ");" + NL + "\t\tcon";
  protected final String TEXT_52 = "=java.sql.DriverManager.getConnection(url";
  protected final String TEXT_53 = ",properties";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\tClass.forName(\"";
  protected final String TEXT_56 = "\");" + NL + "\t\turl";
  protected final String TEXT_57 = "=";
  protected final String TEXT_58 = ";" + NL + "\t\tcon";
  protected final String TEXT_59 = "=java.sql.DriverManager.getConnection(url";
  protected final String TEXT_60 = ",";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + NL + "\t\tstmt";
  protected final String TEXT_64 = " = con";
  protected final String TEXT_65 = ".createStatement();" + NL + "\t" + NL + " ";
  protected final String TEXT_66 = "//drop and then create" + NL + "\t\ttry{" + NL + "\t\t\tstmt";
  protected final String TEXT_67 = ".execute(\"drop table \"+\"";
  protected final String TEXT_68 = "\");\t" + NL + "\t\t}catch(Exception e){\t" + NL + "\t\t}\t\t" + NL + "\t\tsql";
  protected final String TEXT_69 = "=\"";
  protected final String TEXT_70 = "\";" + NL + "\t\tstmt";
  protected final String TEXT_71 = ".execute(sql";
  protected final String TEXT_72 = ");\t";
  protected final String TEXT_73 = "\t\t" + NL + "        java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_74 = " = con";
  protected final String TEXT_75 = ".getMetaData();" + NL + "        java.sql.ResultSet rs_";
  protected final String TEXT_76 = " = dbMetaData_";
  protected final String TEXT_77 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "        boolean flag_";
  protected final String TEXT_78 = " = false;" + NL + "        while(rs_";
  protected final String TEXT_79 = ".next())" + NL + "        {" + NL + "        \tString table_";
  protected final String TEXT_80 = " = rs_";
  protected final String TEXT_81 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\tif(table_";
  protected final String TEXT_82 = ".equalsIgnoreCase(";
  protected final String TEXT_83 = "))" + NL + "\t\t\t{" + NL + "\t\t\t\tflag_";
  protected final String TEXT_84 = " = true;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "        }" + NL + "        rs_";
  protected final String TEXT_85 = ".close();" + NL + "        if(!flag_";
  protected final String TEXT_86 = ")" + NL + "        {" + NL + "           sql";
  protected final String TEXT_87 = "=\"";
  protected final String TEXT_88 = "\";" + NL + "           globalMap.put(\"";
  protected final String TEXT_89 = "_QUERY\",sql";
  protected final String TEXT_90 = ");" + NL + "           stmt";
  protected final String TEXT_91 = ".execute(sql";
  protected final String TEXT_92 = ");         \t" + NL + "        }  \t\t\t\t";
  protected final String TEXT_93 = "// just create" + NL + "\t\tsql";
  protected final String TEXT_94 = "=\"";
  protected final String TEXT_95 = "\";" + NL + "\t\tstmt";
  protected final String TEXT_96 = ".execute(sql";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\t\tjava.sql.Statement stmtClose";
  protected final String TEXT_99 = "=con";
  protected final String TEXT_100 = ".createStatement();" + NL + "\t\tstmtClose";
  protected final String TEXT_101 = ".execute(\"SHUTDOWN\");";
  protected final String TEXT_102 = NL;
  protected final String TEXT_103 = NL + "\t\tcon";
  protected final String TEXT_104 = ".close();" + NL + "\t\t";
  protected final String TEXT_105 = NL + "\t\t\tcon";
  protected final String TEXT_106 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + NL + "}catch(Exception e){" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_108 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\tthrow new TalendException(this, e);" + NL + "\t}" + NL + "" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();	
	String cid = node.getUniqueName();
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");
	String host = ElementParameterParser.getValue(node,"__HOST__");
	String port = ElementParameterParser.getValue(node,"__PORT__");
	String dbname = ElementParameterParser.getValue(node,"__DBNAME__");
	String user = ElementParameterParser.getValue(node,"__USER__");
	String pass = ElementParameterParser.getValue(node,"__PASS__");
	String frameworkType=ElementParameterParser.getValue(node,"__JAVADBFRAME__");
	final String dbmsId= ElementParameterParser.getValue(node,"__MAPPING__");
	Dbms dbms=MetadataTalendType.getDbms(dbmsId);
	
	List<IMetadataColumn> columnList = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	if(metadatas != null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}

//inner class
class Transfer{
	public String dbDriver(INode node){
		String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");
		if(dbType.equals("MSSQL")){
			return "net.sourceforge.jtds.jdbc.Driver";
		}else if(dbType.equals("MySQL")){
			return "org.gjt.mm.mysql.Driver";
		}else if(dbType.equals("Oracle")){
			return "oracle.jdbc.driver.OracleDriver";
		}else if(dbType.equals("Postgre")){
			return "org.postgresql.Driver";
		}else if(dbType.equals("Access")){
			return "sun.jdbc.odbc.JdbcOdbcDriver";
		}else if(dbType.equals("DB2")){
			return "com.ibm.db2.jcc.DB2Driver";
		}else if(dbType.equals("Firebird")){
			return "org.firebirdsql.jdbc.FBDriver";
		}else if(dbType.equals("Informix")){
			return "com.informix.jdbc.IfxDriver";
		}else if(dbType.equals("Ingres")){
			return "com.ingres.jdbc.IngresDriver";
		}else if(dbType.equals("JavaDB")){
			String frameworkType=ElementParameterParser.getValue(node,"__JAVADBFRAME__");
			if(frameworkType.equals("Embeded")){
				return "org.apache.derby.jdbc.EmbeddedDriver";
			}else if(frameworkType.equals("JCCJDBC")){
				return "com.ibm.db2.jcc.DB2Driver";
			}else if(frameworkType.equals("DERBYCLIENT")){
				return "org.apache.derby.jdbc.ClientDriver";
			}
		}else if(dbType.equals("SQLite")){
			return "org.sqlite.JDBC";
		}else if(dbType.equals("Sybase")){
			return "com.sybase.jdbc3.jdbc.SybDriver";
		}else if(dbType.equals("ODBC")){
			return "sun.jdbc.odbc.JdbcOdbcDriver";
		}else if(dbType.equals("HSQLdb")){
			return "org.hsqldb.jdbcDriver";
		}else if(dbType.equals("Interbase")){
			return "interbase.interclient.Driver";
		}
		return null;
	}
	
	
	public String url(INode node){	
		//String tableName = ElementParameterParser.getValue(node,"__TABLE__");
		String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");
		String host = ElementParameterParser.getValue(node,"__HOST__");
		String port = ElementParameterParser.getValue(node,"__PORT__");
		String dbname = ElementParameterParser.getValue(node,"__DBNAME__");
		String user = ElementParameterParser.getValue(node,"__USER__");
		String pass = ElementParameterParser.getValue(node,"__PASS__");
		String oraType = ElementParameterParser.getValue(node,"__ORACLETYPE__");

		if(dbType.equals("MSSQL")){
			return "\"jdbc:jtds:sqlserver://\"+"+host+"+\":\"+"+port+"+\"//\"+"+dbname;
		}else if(dbType.equals("MySQL")){
			return "\"jdbc:mysql://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname+ "+\"?noDatetimeStringSync=true\"";
		}else if(dbType.equals("Oracle")){//depends on SID/Service
					if(oraType.equals("Oracle SID")){
						return "\"jdbc:oracle:thin:@\"+"+host+"+\":\"+" + port + "+\":\"+" + dbname;
					}else{
						return "\"dbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\"+" + host + "+\")(port=\"+" + port + "+\"))(connect_data=(service_name=\"+" + dbname +"+\")))\"";			
					}
		}else if(dbType.equals("Postgre")){
			return "\"jdbc:postgresql://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(dbType.equals("Access")){
		String accessDbname = ElementParameterParser.getValue(node,"__ACCESSDBNAME__");
			return "\"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=\"+"+accessDbname;
		}else if(dbType.equals("DB2")){
			return "\"jdbc:db2://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(dbType.equals("Firebird")){			
			String firebirdDB=ElementParameterParser.getValue(node,"__FIREBIRDDBNAME__");
			return "\"jdbc:firebirdsql:\"+"+host+"+\":\"+"+firebirdDB;
		}else if(dbType.equals("Informix")){
			String server=ElementParameterParser.getValue(node,"__INFORMIXSERVER__");			
			return "\"jdbc:informix-sqli://\"+"+host+ "+\":\"+"+port+"+\"/\"+"+dbname+"+\":informixserver=\"+"+server;
		}else if(dbType.equals("Ingres")){
			return "\"jdbc:ingres://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(dbType.equals("JavaDB")){
			String frameworkType=ElementParameterParser.getValue(node,"__JAVADBFRAME__");
			if(frameworkType.equals("Embeded")){
				return "\"jdbc:derby:\"+" + dbname;
			}else if(frameworkType.equals("JCCJDBC")){
				return "\"+jdbc:derby:net://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
			}else if(frameworkType.equals("DERBYCLIENT")){
				return "\"+jdbc:derby://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
			}
		}else if(dbType.equals("SQLite")){		
			String sqliteDB=ElementParameterParser.getValue(node,"__SQLITEDBNAME__");
			return "\"jdbc:sqlite:/\"+" +sqliteDB.toLowerCase();
		}else if(dbType.equals("Sybase")){
			return "\"jdbc:sybase:Tds:\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(dbType.equals("ODBC")){
			return "\"jdbc:odbc:\" + " + dbname;
		}else if(dbType.equals("HSQLdb")){
			String runningMode=ElementParameterParser.getValue(node,"__HSQLMODE__");
			String tls=ElementParameterParser.getValue(node,"__TLS__");
			String dbalias=ElementParameterParser.getValue(node,"__HSQLDATABASEALIAS__");
			if(runningMode.equals("SERVER")){
				if(tls.equals("true")){
					return "\"jdbc:hsqldb:hsqls://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}else{
					return "\"jdbc:hsqldb:hsql://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}
			}else if(runningMode.equals("WEBSERVER")){
				if(tls.equals("true")){
					return "\"jdbc:hsqldb:https://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}else{
					return  "\"jdbc:hsqldb:http://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}
			}else if(runningMode.equals("PROCESS")){
				String dbpath=ElementParameterParser.getValue(node,"__HSQLDATABASEPATH__");
				String hdbname=ElementParameterParser.getValue(node,"__HSQLDATABASE__");
				return "\"jdbc:hsqldb:file:\"+" + dbpath + "+\"/\"+" + hdbname + "+\";ifexists=true\"";
			}
		}else if(dbType.equals("Interbase")){
			return "\"jdbc:interbase://\"+"+host+"+\"/\"+"+dbname;
		}
		return null;
	}
	
	public String protectChar(String dbType, String tableName){
		if(dbType.equals("DB2")||dbType.equals("Ingres")||dbType.equals("MSSQL")||dbType.equals("Oracle")||dbType.equals("Postgre")||dbType.equals("SQLite")||dbType.equals("Firebird")||dbType.equals("JavaDB")||dbType.equals("HSQLdb")||dbType.equals("Interbase")||dbType.equals("Informix")){
			return "\\\"\"+"+tableName+"+\"\\\"";
		}else if(dbType.equals("Access")){
			return "[\"+"+tableName+"+\"]";
		}else if(dbType.equals("MySQL")){
			return "`\"+"+tableName+"+\"`";
		}else if(dbType.equals("Sybase")){
			return "\"+"+tableName+"+\"";
		}
		return "\"+"+tableName+"+\"";
	}
	
	
	public String sql(String dbType,String tableName,INode node){
	String sql="";
	//table name (special postgres schema)
	if(dbType.equals("Postgre")){
		String schema = ElementParameterParser.getValue(node,"__SCHEMA_POSTGRES__");
		sql="create table \\\"\"+"+schema+"+\"\\\"."+protectChar(dbType, tableName)+" (";
	}else{
		sql="create table "+protectChar(dbType, tableName)+" (";
	}
	
		List<IMetadataTable> metadatas = node.getMetadataList();
		List PKey=new ArrayList();	
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);
			if (metadata!=null) {
				List<IMetadataColumn> columnList = metadata.getListColumns();
				int colNum=1;									
			 	for(IMetadataColumn column:columnList){	
			 	//column name
			 	   if(dbType.equals("MySQL")){
			 			sql=sql+"`"+column.getOriginalDbColumnName()+"` ";
			 		}else{
			 			sql=sql+"\\\""+column.getOriginalDbColumnName()+"\\\" ";
			 		}
			 	//primary key
					if(column.isKey()==true){PKey.add(column.getOriginalDbColumnName());}
			 	//column type
				 		sql=sql+column.getType();
			 	//column DataDefine
			 	
			 	MappingTypeRetriever mtr=MetadataTalendType.getMappingTypeRetriever(dbmsId);		 	
			 
			 
			 
			 	
					if(column.getLength()==null) {column.setLength(0);};
					if(column.getPrecision()==null) {column.setPrecision(0);};
			 		if(column.getLength()!=0&&column.getPrecision()==0){     //only Length
			 				if(!mtr.isLengthIgnored(dbmsId,column.getType()))	//and Length is not ignored
			 					sql=sql+"("+column.getLength()+")";		 				
			 		}else if(column.getLength()!=0&&column.getLength()!=0){		//Length and Precision not null
			 				if(mtr.isPrecisionIgnored(dbmsId,column.getType())&&!mtr.isLengthIgnored(dbmsId,column.getType()))
			 					sql=sql+"("+column.getLength()+")";				//only Precision is ignored
			 				else if(!mtr.isPrecisionIgnored(dbmsId,column.getType())&&!mtr.isLengthIgnored(dbmsId,column.getType())){
			 					// Precision and Length are not ignored	
			 					if(mtr.isPreBeforeLength(dbmsId,column.getType()))
								 	sql=sql+"("+column.getPrecision()+","+column.getLength()+")"; 
								else
								 	sql=sql+"("+column.getLength()+","+column.getPrecision()+")"; 				
			 				}
			 				else
			 					sql=sql;					 				 			
			 		}		 	
			 		sql=sql+" ";
			 	//default_value
					sql=sql+fillValue(column.getDefault(),column.getTalendType());
			 	//nullable
			 		if(column.isNullable()==false){
			 			sql=sql+"not null ";
			 		}
			 	//if_there_should_be_a ','
			 		colNum=colNum+1;
			 		if(!((colNum>columnList.size())&&(PKey.isEmpty()))){sql=sql+",";}
			 	}
			 	//primary key
				 	if(!(PKey.isEmpty())){
					 	sql=sql+" primary key (";
					 	for(int i=0;i<PKey.size();i++){
					 	
						 	if(dbType.equals("MySQL")){
				 				sql=sql+"`"+(String)PKey.get(i)+"` ";
					 		}else{
					 			sql=sql+"\\\""+(String)PKey.get(i)+"\\\" ";
					 		}
					 		if(i<PKey.size()-1){sql=sql+",";}
					 	}
					 	sql=sql+")";
				 	}
		 	}
	 	}		
		sql=sql+")";
		return sql;
	}
	
    public boolean isLackDBType(INode node) {

        List<IMetadataTable> metadatas = node.getMetadataList();
        List PKey = new ArrayList();
        if ((metadatas != null) && (metadatas.size() > 0)) {
            IMetadataTable metadata = metadatas.get(0);
            if (metadata != null) {
                List<IMetadataColumn> columnList = metadata.getListColumns();
                for (IMetadataColumn column : columnList) {
                    if (column.getType() == null || column.getType().trim().length() == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }	
    
    
    public String fillValue(String value, String colType) {
		if(value==null || value.equals("\"\"")){
	  		return " ";
	  	}else if((value.startsWith("\"")||value.startsWith("'") )&& (value.endsWith("\"")||value.endsWith("'"))){
			return "default '"+value.substring(1,value.length()-1)+"' ";
	   	}else if(value.equalsIgnoreCase("null")){
	   		return "default null ";
	   	}else if(value.equals("")){
	   		return " ";
		}else{
			return "default "+value+" ";
		}
	}
    
    
}
       Transfer tr=new Transfer();

    stringBuffer.append(TEXT_2);
     
  if (tr.isLackDBType(node)){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(tr.isLackDBType(node) );
    stringBuffer.append(TEXT_4);
    
  }

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__EXISTINGCONNECTION__");
	String oraType = ElementParameterParser.getValue(node,"__ORACLETYPE__");
	if((dbType.equals("MySQL"))&&(useExistingConn.equals("true")))
	{
		String connection = ElementParameterParser.getValue(node,"__CONNECTION_MYSQL__");
		String conn = "conn_" + connection;

    stringBuffer.append(TEXT_10);
    stringBuffer.append(tr.dbDriver(node));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_13);
    		
	}else if((dbType.equals("Oracle"))&&(useExistingConn.equals("true"))){
		
		String connection = ElementParameterParser.getValue(node,"__CONNECTION_ORACLE__");
		String conn = "conn_" + connection;

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_16);
    
	}else if((dbType.equals("Postgre"))&&(useExistingConn.equals("true"))){
		String connection = ElementParameterParser.getValue(node,"__CONNECTION_POSTGRE__");
		String conn = "conn_" + connection;

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_19);
      }else if((dbType.equals("Access"))||(dbType.equals("SQLite"))){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(tr.dbDriver(node));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(tr.url(node));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    	}else if(dbType.equals("JavaDB")){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tr.url(node));
    stringBuffer.append(TEXT_28);
    		if(frameworkType.equals("Embeded")){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ElementParameterParser.getValue(node,"__DBPATH__"));
    stringBuffer.append(TEXT_30);
    		}else{
		String connectionFlag = ElementParameterParser.getValue(node, "__JAVADBNETSERVER__");
    	if(connectionFlag.equals("false")){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
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
    			}
		}
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(tr.dbDriver(node));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    	}else{
    stringBuffer.append(TEXT_55);
    stringBuffer.append(tr.dbDriver(node));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(tr.url(node));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_62);
    	} 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    //  special action / Main action
	String specialAction=ElementParameterParser.getValue(node,"__SPECIALACTION__");
	if(specialAction.equals("DropAndCreate")){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(tr.protectChar(dbType, tableName));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(tr.sql(dbType,tableName,node));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    	}else if(specialAction.equals("CreateOnly")){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(tr.sql(dbType,tableName,node));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    }else{
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(tr.sql(dbType,tableName,node));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    }
//close
	if(dbType.equals("HSQLdb")){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    	}
    stringBuffer.append(TEXT_102);
    
	if(!dbType.equals("MySQL") && !dbType.equals("Oracle") && !dbType.equals("Postgre"))
	{
		
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    			
	}
	else
	{
		if(!useExistingConn.equals("true"))
		{
			
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
		}
	}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    return stringBuffer.toString();
  }
}
