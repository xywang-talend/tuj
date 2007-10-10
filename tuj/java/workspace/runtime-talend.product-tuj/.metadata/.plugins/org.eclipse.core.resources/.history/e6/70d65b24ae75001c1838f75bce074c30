package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TSalesforceInputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceInputBeginJava result = new TSalesforceInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "////////////////////////////" + NL + "        " + NL + "        int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "        org.talend.salesforce.SforceManagement sforceManagement_";
  protected final String TEXT_4 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "        " + NL + "        sforceManagement_";
  protected final String TEXT_5 = ".login(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");" + NL + "        " + NL + "        StringBuffer sb_";
  protected final String TEXT_9 = " = new StringBuffer();" + NL + "        sb_";
  protected final String TEXT_10 = ".append(\"SELECT \");" + NL + "        sb_";
  protected final String TEXT_11 = ".append(\"";
  protected final String TEXT_12 = "\");" + NL + "        sb_";
  protected final String TEXT_13 = ".append(\" From \");" + NL + "        sb_";
  protected final String TEXT_14 = ".append(\"";
  protected final String TEXT_15 = "\");";
  protected final String TEXT_16 = NL + "           sb_";
  protected final String TEXT_17 = ".append(\" WHERE \");" + NL + "           sb_";
  protected final String TEXT_18 = ".append(";
  protected final String TEXT_19 = ");        ";
  protected final String TEXT_20 = "         " + NL + "" + NL + "  \t\tjava.util.List<com.sforce.soap.partner.sobject.SObject> list_";
  protected final String TEXT_21 = " = sforceManagement_";
  protected final String TEXT_22 = ".query(sb_";
  protected final String TEXT_23 = ".toString());" + NL + "  \t\t" + NL + "\t\tfor (com.sforce.soap.partner.sobject.SObject object_";
  protected final String TEXT_24 = " : list_";
  protected final String TEXT_25 = ") {" + NL + "            org.apache.axis.message.MessageElement[] _any_";
  protected final String TEXT_26 = " = object_";
  protected final String TEXT_27 = ".get_any();" + NL + "            nb_line_";
  protected final String TEXT_28 = "++;" + NL + "                " + NL + "//////////       " + NL;
  protected final String TEXT_29 = NL + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_31 = " < _any_";
  protected final String TEXT_32 = ".length && _any_";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "].getValue()!=null){" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " = _any_";
  protected final String TEXT_38 = "[";
  protected final String TEXT_39 = "].getValue();";
  protected final String TEXT_40 = NL + "\t\t\t\t\t";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " = ParserUtils.parseTo_Date(_any_";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "].getValue(), ";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t\t\t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = _any_";
  protected final String TEXT_49 = "[";
  protected final String TEXT_50 = "].getValue().getBytes();" + NL + "\t";
  protected final String TEXT_51 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = ParserUtils.parseTo_";
  protected final String TEXT_54 = "(_any_";
  protected final String TEXT_55 = "[";
  protected final String TEXT_56 = "].getValue());";
  protected final String TEXT_57 = NL + NL + NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "      \t\t\t";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_66 = " " + NL + "////////////////////////////";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    

	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	
	String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");

	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");
	
	String condition = ElementParameterParser.getValue(node, "__CONDITION__");

    stringBuffer.append(TEXT_1);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
    //get the select fields from schema
    List<IMetadataColumn> columnsFields=metadata.getListColumns();
    StringBuffer sb = new StringBuffer();
    for (int i=0;i < columnsFields.size();i++) {//4
		IMetadataColumn column=columnsFields.get(i);
		sb.append(column.getLabel());
		if (i == columnsFields.size()-1) break;
		sb.append(",");
	}	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sb.toString() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_15);
    
        if(condition!=null && condition.trim().length()!=0)     {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_19);
    
        }

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_29);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_34);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_39);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_45);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_50);
    
					} else  { //other

    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_56);
    
					}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_60);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_66);
    
  }
}

    return stringBuffer.toString();
  }
}
