package org.talend.designer.codegen.translators.file.input;

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

public class TFileInputLDIFBeginJava
{
  protected static String nl;
  public static synchronized TFileInputLDIFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputLDIFBeginJava result = new TFileInputLDIFBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "///////////////////////////////////" + NL + "        netscape.ldap.util.LDIF ldif_";
  protected final String TEXT_2 = " = new netscape.ldap.util.LDIF(";
  protected final String TEXT_3 = ");" + NL + "" + NL + "        String[] filters_";
  protected final String TEXT_4 = " = new String[] {         ";
  protected final String TEXT_5 = " " + NL + "\t\t\"";
  protected final String TEXT_6 = "\",";
  protected final String TEXT_7 = "        " + NL + "        };" + NL + "        String[] results_";
  protected final String TEXT_8 = " = null;" + NL + "        int nb_line_";
  protected final String TEXT_9 = " = 0;" + NL + "        " + NL + "        ///////////////////////////////////" + NL + "" + NL + "        for (netscape.ldap.util.LDIFRecord record_";
  protected final String TEXT_10 = " = ldif_";
  protected final String TEXT_11 = ".nextRecord(); record_";
  protected final String TEXT_12 = " != null; record_";
  protected final String TEXT_13 = " = ldif_";
  protected final String TEXT_14 = ".nextRecord()) {" + NL + "" + NL + "            results_";
  protected final String TEXT_15 = " = new String[";
  protected final String TEXT_16 = "];" + NL + "            " + NL + "            netscape.ldap.util.LDIFContent content_";
  protected final String TEXT_17 = " = record_";
  protected final String TEXT_18 = ".getContent();" + NL + "\t\t\t" + NL + "            switch (content_";
  protected final String TEXT_19 = ".getType()) {" + NL + "            " + NL + "            case netscape.ldap.util.LDIFContent.ATTRIBUTE_CONTENT:" + NL + "            " + NL + "                netscape.ldap.util.LDIFAttributeContent attrContent_";
  protected final String TEXT_20 = " = (netscape.ldap.util.LDIFAttributeContent) content_";
  protected final String TEXT_21 = ";" + NL + "                netscape.ldap.LDAPAttribute[] attributes_";
  protected final String TEXT_22 = " = attrContent_";
  protected final String TEXT_23 = ".getAttributes();" + NL + "                " + NL + "                for (int i_";
  protected final String TEXT_24 = " = 0; i_";
  protected final String TEXT_25 = " < filters_";
  protected final String TEXT_26 = ".length; i_";
  protected final String TEXT_27 = "++) {" + NL + "                " + NL + "                    for (int j_";
  protected final String TEXT_28 = " = 0; j_";
  protected final String TEXT_29 = " < attributes_";
  protected final String TEXT_30 = ".length; j_";
  protected final String TEXT_31 = "++) {" + NL + "                    " + NL + "                        netscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_32 = " = attributes_";
  protected final String TEXT_33 = "[j_";
  protected final String TEXT_34 = "];" + NL + "                        " + NL + "                        if (filters_";
  protected final String TEXT_35 = "[i_";
  protected final String TEXT_36 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_37 = ".getName())) {" + NL + "                        " + NL + "                            java.util.Enumeration values_";
  protected final String TEXT_38 = " = attribute_";
  protected final String TEXT_39 = ".getStringValues();" + NL + "                            " + NL + "                            while (values_";
  protected final String TEXT_40 = ".hasMoreElements()) {" + NL + "                                String value_";
  protected final String TEXT_41 = " = (String) values_";
  protected final String TEXT_42 = ".nextElement();" + NL + "                                results_";
  protected final String TEXT_43 = "[i_";
  protected final String TEXT_44 = "] = results_";
  protected final String TEXT_45 = "[i_";
  protected final String TEXT_46 = "] == null ? value_";
  protected final String TEXT_47 = " : results_";
  protected final String TEXT_48 = "[i_";
  protected final String TEXT_49 = "] + \",\" + value_";
  protected final String TEXT_50 = ";" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                }" + NL + "                " + NL + "                break;" + NL + "" + NL + "            case netscape.ldap.util.LDIFContent.ADD_CONTENT:" + NL + "                // LDIFAddContent addContent = (LDIFAddContent) content;" + NL + "                break;" + NL + "                " + NL + "            case netscape.ldap.util.LDIFContent.MODIFICATION_CONTENT:" + NL + "                // LDIFModifyContent modifyContent = (LDIFModifyContent) content;" + NL + "                break;" + NL + "                " + NL + "            case netscape.ldap.util.LDIFContent.DELETE_CONTENT:" + NL + "                // LDIFDeleteContent deleteContent = (LDIFDeleteContent) content;" + NL + "                break;" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_51 = "++;" + NL + "            " + NL + "            " + NL + "// for output";
  protected final String TEXT_52 = NL + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_54 = " < results_";
  protected final String TEXT_55 = ".length && results_";
  protected final String TEXT_56 = "[";
  protected final String TEXT_57 = "]!=null ){\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = results_";
  protected final String TEXT_61 = "[";
  protected final String TEXT_62 = "];";
  protected final String TEXT_63 = NL + "\t\t\t\t\t";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_66 = "[";
  protected final String TEXT_67 = "], ";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\t\t\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = results_";
  protected final String TEXT_72 = "[";
  protected final String TEXT_73 = "].getBytes();" + NL + "\t";
  protected final String TEXT_74 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ParserUtils.parseTo_";
  protected final String TEXT_77 = "(results_";
  protected final String TEXT_78 = "[";
  protected final String TEXT_79 = "]);";
  protected final String TEXT_80 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "      \t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_89 = NL + "///////////////////////////////////        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");       
        List<IMetadataColumn> listColumns = metadata.getListColumns();         

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
        for (IMetadataColumn column: listColumns) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    
        }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(listColumns.size() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_52);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_57);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_62);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_63);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_68);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_69);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_73);
    
					} else  { //other

    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_79);
    
					}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_83);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_89);
    
  }
}  
 
    return stringBuffer.toString();
  }
}
