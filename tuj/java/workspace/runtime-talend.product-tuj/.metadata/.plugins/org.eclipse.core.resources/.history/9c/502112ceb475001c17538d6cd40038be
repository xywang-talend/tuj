package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Map;
import java.util.List;

public class TWebServiceInputBeginJava
{
  protected static String nl;
  public static synchronized TWebServiceInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceInputBeginJava result = new TWebServiceInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/////////////////////////////////// " + NL + "        " + NL + "        Object[] params_";
  protected final String TEXT_3 = " = new Object[] {";
  protected final String TEXT_4 = NL + "        ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = ",      ";
  protected final String TEXT_8 = NL + "        ";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = "      " + NL + "        };  " + NL + "        " + NL + " \t\torg.talend.DynamicInvoker.main(params_";
  protected final String TEXT_11 = ");" + NL + " \t\tjava.util.Map result = org.talend.DynamicInvoker.getResult();" + NL + "        " + NL + "        String[] results_";
  protected final String TEXT_12 = " = null;" + NL + "\t    int nb_line_";
  protected final String TEXT_13 = " = 0;" + NL + "\t" + NL + "        for (Object key : result.keySet()) {" + NL + "        " + NL + "           results_";
  protected final String TEXT_14 = " = new String[";
  protected final String TEXT_15 = "];" + NL + "            " + NL + "           Object value = result.get(key);" + NL + "           if (value instanceof Object[]){" + NL + "                Object[] objArr_";
  protected final String TEXT_16 = " = (Object[])value;" + NL + "                int len_";
  protected final String TEXT_17 = " = Math.min(objArr_";
  protected final String TEXT_18 = ".length, results_";
  protected final String TEXT_19 = ".length);" + NL + "                int k_";
  protected final String TEXT_20 = " = 0;" + NL + "                for (int i_";
  protected final String TEXT_21 = " = 0; i_";
  protected final String TEXT_22 = " < len_";
  protected final String TEXT_23 = "; i_";
  protected final String TEXT_24 = "++ ) {" + NL + "                    results_";
  protected final String TEXT_25 = "[k_";
  protected final String TEXT_26 = "] = String.valueOf(objArr_";
  protected final String TEXT_27 = "[k_";
  protected final String TEXT_28 = "]);" + NL + "                }" + NL + "                " + NL + "          } else if (value instanceof java.util.List) {" + NL + "                java.util.List list_";
  protected final String TEXT_29 = " = (java.util.List)value;" + NL + "                int len_";
  protected final String TEXT_30 = " = Math.min(list_";
  protected final String TEXT_31 = ".size(), results_";
  protected final String TEXT_32 = ".length);" + NL + "                int k_";
  protected final String TEXT_33 = " = 0;" + NL + "                for (java.util.Iterator iter_";
  protected final String TEXT_34 = " = list_";
  protected final String TEXT_35 = ".iterator(); iter_";
  protected final String TEXT_36 = ".hasNext() && k_";
  protected final String TEXT_37 = " < len_";
  protected final String TEXT_38 = "; k_";
  protected final String TEXT_39 = "++) {" + NL + "                    results_";
  protected final String TEXT_40 = "[k_";
  protected final String TEXT_41 = "] = String.valueOf(iter_";
  protected final String TEXT_42 = ".next());" + NL + "                }" + NL + "                                " + NL + "            } else if (value instanceof java.util.Map) {                " + NL + "\t\t\t\tjava.util.Map map_";
  protected final String TEXT_43 = " = (java.util.Map)value;" + NL + "                java.util.Collection values_";
  protected final String TEXT_44 = " = map_";
  protected final String TEXT_45 = ".values();" + NL + "                int len_";
  protected final String TEXT_46 = " = Math.min(values_";
  protected final String TEXT_47 = ".size(), results_";
  protected final String TEXT_48 = ".length);" + NL + "                int k_";
  protected final String TEXT_49 = " = 0;" + NL + "                for (java.util.Iterator iter_";
  protected final String TEXT_50 = " = values_";
  protected final String TEXT_51 = ".iterator(); iter_";
  protected final String TEXT_52 = ".hasNext() && k_";
  protected final String TEXT_53 = " < len_";
  protected final String TEXT_54 = "; k_";
  protected final String TEXT_55 = "++) {" + NL + "                    results_";
  protected final String TEXT_56 = "[k_";
  protected final String TEXT_57 = "] = String.valueOf(iter_";
  protected final String TEXT_58 = ".next());" + NL + "                }" + NL + "" + NL + "            } else if (value instanceof org.w3c.dom.Element) {" + NL + "                results_";
  protected final String TEXT_59 = "[0] = org.apache.axis.utils.XMLUtils.ElementToString((org.w3c.dom.Element)value);" + NL + "                " + NL + "            }else if (value instanceof org.apache.axis.types.Schema){" + NL + "                org.apache.axis.types.Schema schema_";
  protected final String TEXT_60 = " = (org.apache.axis.types.Schema) value;" + NL + "                org.apache.axis.message.MessageElement[] _any_";
  protected final String TEXT_61 = " = schema_";
  protected final String TEXT_62 = ".get_any();" + NL + "                for (int s_";
  protected final String TEXT_63 = " = 0; s_";
  protected final String TEXT_64 = " < _any_";
  protected final String TEXT_65 = ".length; s_";
  protected final String TEXT_66 = "++) {" + NL + "                    results_";
  protected final String TEXT_67 = "[s_";
  protected final String TEXT_68 = "] = _any_";
  protected final String TEXT_69 = "[s_";
  protected final String TEXT_70 = "].toString();" + NL + "                }\t" + NL + "                " + NL + "            } else {" + NL + "\t\t\t    results_";
  protected final String TEXT_71 = "[0] = String.valueOf(value);" + NL + "            }" + NL + "\t" + NL + "           nb_line_";
  protected final String TEXT_72 = "++;" + NL + "\t       " + NL + "// for output";
  protected final String TEXT_73 = NL + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_75 = " < results_";
  protected final String TEXT_76 = ".length && results_";
  protected final String TEXT_77 = "[";
  protected final String TEXT_78 = "]!=null){\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = results_";
  protected final String TEXT_82 = "[";
  protected final String TEXT_83 = "];";
  protected final String TEXT_84 = NL + "\t\t\t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_87 = "[";
  protected final String TEXT_88 = "], ";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\t\t\t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = results_";
  protected final String TEXT_93 = "[";
  protected final String TEXT_94 = "].getBytes();" + NL + "\t";
  protected final String TEXT_95 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " = ParserUtils.parseTo_";
  protected final String TEXT_98 = "(results_";
  protected final String TEXT_99 = "[";
  protected final String TEXT_100 = "]);";
  protected final String TEXT_101 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "      \t\t\t";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_110 = NL + "///////////////////////////////////       ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
     
        List<IMetadataColumn> listColumns = metadata.getListColumns(); 
        
        List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENDPOINT__") );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node,"__METHOD__") );
    stringBuffer.append(TEXT_7);
    
        for (int i = 0; i < params.size(); i++) {
            Map<String, String> line = params.get(i);

    stringBuffer.append(TEXT_8);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_9);
    
        }

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(listColumns.size() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_73);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_78);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_83);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_89);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_94);
    
					} else  { //other

    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_100);
    
					}

    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_104);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_110);
    
  }
}  
 
    return stringBuffer.toString();
  }
}
