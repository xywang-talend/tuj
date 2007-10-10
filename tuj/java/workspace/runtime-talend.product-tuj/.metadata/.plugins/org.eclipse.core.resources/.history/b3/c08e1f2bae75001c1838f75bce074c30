package org.talend.designer.codegen.translators.databases.dbjdbc;

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

public class TJDBCInputBeginJava
{
  protected static String nl;
  public static synchronized TJDBCInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCInputBeginJava result = new TJDBCInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t" + NL + "\tjava.lang.Class.forName(";
  protected final String TEXT_4 = ");" + NL + "\tString connectionString_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_7 = " =" + NL + "\t\tjava.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");" + NL + "\t" + NL + "\tjava.sql.Statement statement_";
  protected final String TEXT_11 = " = connection_";
  protected final String TEXT_12 = ".createStatement();" + NL + "\tjava.sql.ResultSet resultSet_";
  protected final String TEXT_13 = " = statement_";
  protected final String TEXT_14 = ".executeQuery(";
  protected final String TEXT_15 = ");" + NL + "\tjava.sql.ResultSetMetaData resultSetMetadata_";
  protected final String TEXT_16 = " = resultSet_";
  protected final String TEXT_17 = ".getMetaData();" + NL + "\tint columnsCount_";
  protected final String TEXT_18 = " = resultSetMetadata_";
  protected final String TEXT_19 = ".getColumnCount();" + NL + "\tString tmpString_";
  protected final String TEXT_20 = " = null;" + NL + "\tjava.sql.Date tmpDate_";
  protected final String TEXT_21 = " = null;" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_22 = "_QUERY\", ";
  protected final String TEXT_23 = ");" + NL + "\t" + NL + "\twhile (resultSet_";
  protected final String TEXT_24 = ".next()) {" + NL + "\t\tnb_line_";
  protected final String TEXT_25 = "++;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_26 = NL + " \t\t\t\t\tif (columnsCount_";
  protected final String TEXT_27 = " < ";
  protected final String TEXT_28 = ") {" + NL + "\t\t\t \t\t\t";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";" + NL + " \t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\ttmpString_";
  protected final String TEXT_33 = " = resultSet_";
  protected final String TEXT_34 = ".getString(";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t  \t\t\tif (tmpString_";
  protected final String TEXT_36 = " != null && tmpString_";
  protected final String TEXT_37 = ".length() > 0) {" + NL + "\t\t\t\t  \t\t\t\t";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = " = tmpString_";
  protected final String TEXT_40 = ".charAt(0);" + NL + "\t\t\t\t\t  \t\t}" + NL + "\t\t\t\t\t\t \t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\ttmpDate_";
  protected final String TEXT_42 = " = resultSet_";
  protected final String TEXT_43 = ".getDate(";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t\t\t\tif (tmpDate_";
  protected final String TEXT_45 = " != null) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = new java.util.Date(tmpDate_";
  protected final String TEXT_48 = ".getTime());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_49 = NL + "\t\t\t         \t\t";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " = (List)resultSet_";
  protected final String TEXT_52 = ".getObject(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t\t \t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = resultSet_";
  protected final String TEXT_57 = ".get";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\tif (resultSet_";
  protected final String TEXT_61 = ".wasNull()) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " = null;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t   \t \t}" + NL + "\t\t\t   \t \t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ";" + NL + "\t\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String driverJar = ElementParameterParser.getValue(node, "__DRIVER_JAR__");
String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
String jdbcUrl = ElementParameterParser.getValue(node, "__URL__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
String dbquery = ElementParameterParser.getValue(node, "__QUERY__");
dbquery = dbquery.replaceAll("\n"," ");
dbquery = dbquery.replaceAll("\r"," ");

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if ((metadatas != null) && (metadatas.size() > 0)) {
	metadata = metadatas.get(0);
}

if (metadata != null) {
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(jdbcUrl);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
		List<? extends IConnection> outConnections = node.getOutgoingSortedConnections();
		List<IMetadataColumn> columnList = metadata.getListColumns();
		
		if (outConnections != null && outConnections.size() > 0) {
		 	IConnection firstOutConnection = outConnections.get(0);
		 	int currentColumn = 1;
		
		 	for (IMetadataColumn column : columnList) {
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			 	String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
				
				if (firstOutConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(currentColumn);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_31);
    
						String method;
						if (typeToGenerate.equals("byte[]")) {
							method = "Bytes";
						} else if (typeToGenerate.equals("Integer")) {
							method = "Int";
						} else {
							method = typeToGenerate.substring(0,1).toUpperCase() + typeToGenerate.substring(1);
						}
						
			  			if (typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
							
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(currentColumn);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
						} else if (typeToGenerate.equals("java.util.Date")) {
							
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(currentColumn);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			           		 }else if (typeToGenerate.equals("List")) {
			          	    
    stringBuffer.append(TEXT_49);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(currentColumn);
    stringBuffer.append(TEXT_53);
    
				 		} else {
			   	 			
    stringBuffer.append(TEXT_54);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(currentColumn);
    stringBuffer.append(TEXT_59);
    
						}
						
						if (column.isNullable()) {
							
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    
						}
			   	 		
			   	 		
    stringBuffer.append(TEXT_64);
    
			   	 	currentColumn++;
				}
			}
			
			for (int i = 1; i < outConnections.size(); i++) {
				IConnection outConnection = outConnections.get(i);
				if ((outConnection.getName().compareTo(firstOutConnection.getName()) != 0) &&
					(outConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
					for (IMetadataColumn column : columnList) {
						
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outConnection.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    
					}
				}
			}
		}
}

    return stringBuffer.toString();
  }
}
