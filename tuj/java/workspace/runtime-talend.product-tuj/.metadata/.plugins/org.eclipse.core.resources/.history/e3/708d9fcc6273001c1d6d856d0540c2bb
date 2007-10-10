package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedBeginJava result = new TFileInputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_2 = " = new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_3 = ",";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = ",";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = ",";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = ");" + NL + "while (fid_";
  protected final String TEXT_12 = ".nextRecord()) {";
  protected final String TEXT_13 = "String temp_";
  protected final String TEXT_14 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = fid_";
  protected final String TEXT_18 = ".get(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = "temp_";
  protected final String TEXT_21 = " = fid_";
  protected final String TEXT_22 = ".get(";
  protected final String TEXT_23 = ");" + NL + "if(temp_";
  protected final String TEXT_24 = ".length() > 0) {";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = temp_";
  protected final String TEXT_27 = ".getBytes();";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = ParserUtils.parseTo_";
  protected final String TEXT_34 = "(temp_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = "} else {\t\t\t\t\t\t";
  protected final String TEXT_37 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_38 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = "}";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ";    \t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		String filename = ElementParameterParser.getValue(node,"__FILENAME__");
    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	if(header.equals("")){
    		header="0";
    	}
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
		if(limit.equals("")){
			limit = "-1";
		}
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	if(footer.equals("")){
    		footer="0";
    	}
    	String random = "-1";
    	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
    	if(ran.equals("true")){
    		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
    		if(random.equals("")){
    			random="0";
    		}
    	}
    	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    	
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean noStringTypeExist = false;
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					}else{
						noStringTypeExist = true;
						break;
					}
				}
				if(noStringTypeExist){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
				}
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

					
    
if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_19);
    
}else{ 

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
					}else if(javaType == JavaTypesManager.DATE) { 

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_31);
    
					} else { 

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
					}

    stringBuffer.append(TEXT_36);
    
					String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
					if(defaultValue == null) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_38);
    
					} else {

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_41);
    
					}

    stringBuffer.append(TEXT_42);
    
}

    
				}
			}
		}
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	 for (IMetadataColumn column: metadata.getListColumns()) {
			    	 
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    
				 	}
				}
			}
		}
		}
	}
}

    return stringBuffer.toString();
  }
}
