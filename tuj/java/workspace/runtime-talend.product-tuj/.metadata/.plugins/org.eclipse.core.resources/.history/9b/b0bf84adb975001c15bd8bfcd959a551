package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;

public class TSortInBeginJava
{
  protected static String nl;
  public static synchronized TSortInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSortInBeginJava result = new TSortInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "\tclass Comparator";
  protected final String TEXT_4 = " implements java.util.Comparator<";
  protected final String TEXT_5 = "Struct> {" + NL + "\t\tpublic Comparator";
  protected final String TEXT_6 = "() {" + NL + "\t\t}";
  protected final String TEXT_7 = NL + "\t\tpublic int compare(";
  protected final String TEXT_8 = "Struct o1, ";
  protected final String TEXT_9 = "Struct o2) {\t";
  protected final String TEXT_10 = NL + "    \t\t\tif (o1.";
  protected final String TEXT_11 = " != o2.";
  protected final String TEXT_12 = ") {" + NL + "    \t\t\t\treturn ";
  protected final String TEXT_13 = " * ((o1.";
  protected final String TEXT_14 = " > o2.";
  protected final String TEXT_15 = ")?1:-1);" + NL + "    \t\t\t} else {";
  protected final String TEXT_16 = NL + "        \t\t\tif(o1.";
  protected final String TEXT_17 = " == null && o2.";
  protected final String TEXT_18 = " != null){" + NL + "        \t\t\t\treturn ";
  protected final String TEXT_19 = " * -1;" + NL + "        \t\t\t}" + NL + "        \t\t\telse if(o1.";
  protected final String TEXT_20 = " != null && o2.";
  protected final String TEXT_21 = " == null){" + NL + "        \t\t\t\treturn ";
  protected final String TEXT_22 = " * 1;" + NL + "        \t\t\t}" + NL + "        \t\t\telse" + NL + "        \t\t\t{" + NL + "        \t\t\t\tif(o1.";
  protected final String TEXT_23 = " != null && o2.";
  protected final String TEXT_24 = " != null && o1.";
  protected final String TEXT_25 = ".compareTo(o2.";
  protected final String TEXT_26 = ")!=0)" + NL + "        \t\t\t\t{ " + NL + "        \t\t\t\t\treturn ";
  protected final String TEXT_27 = " * (o1.";
  protected final String TEXT_28 = ".compareTo(o2.";
  protected final String TEXT_29 = "));" + NL + "        " + NL + "        \t\t\t\t}" + NL + "        \t\t\t\telse" + NL + "        \t\t\t\t{";
  protected final String TEXT_30 = NL + "\t\t\t\t\tint o1";
  protected final String TEXT_31 = "int = 0, o2";
  protected final String TEXT_32 = "int = 0;" + NL + "\t\t\t\t\tif(o1.";
  protected final String TEXT_33 = " != null && o1.";
  protected final String TEXT_34 = ".length() > 0)" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\to1";
  protected final String TEXT_35 = "int = Integer.parseInt(o1.";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(o2.";
  protected final String TEXT_37 = " != null && o2.";
  protected final String TEXT_38 = ".length() > 0)" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\to2";
  protected final String TEXT_39 = "int = Integer.parseInt(o2.";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(o1";
  protected final String TEXT_41 = "int != o2";
  protected final String TEXT_42 = "int)" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_43 = " * ((o1";
  protected final String TEXT_44 = "int > o2";
  protected final String TEXT_45 = "int)?1:-1);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse" + NL + "\t\t\t\t\t{";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t\treturn 0;";
  protected final String TEXT_47 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t\t}";
  protected final String TEXT_49 = NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tjava.util.List<";
  protected final String TEXT_50 = "Struct> row_aref";
  protected final String TEXT_51 = " = (java.util.List<";
  protected final String TEXT_52 = "Struct>) globalMap.get(\"";
  protected final String TEXT_53 = "\");" + NL + "\tComparator";
  protected final String TEXT_54 = " comp";
  protected final String TEXT_55 = " = new Comparator";
  protected final String TEXT_56 = "();" + NL + "\t";
  protected final String TEXT_57 = "Struct[] rows";
  protected final String TEXT_58 = " = (";
  protected final String TEXT_59 = "Struct[]) row_aref";
  protected final String TEXT_60 = ".toArray(new ";
  protected final String TEXT_61 = "Struct[] {});" + NL + "\tjava.util.Arrays.sort(rows";
  protected final String TEXT_62 = ", comp";
  protected final String TEXT_63 = " );" + NL + "\tint nb_line_";
  protected final String TEXT_64 = " = 0;" + NL + "\t" + NL + "\tfor (int i";
  protected final String TEXT_65 = "=0; i";
  protected final String TEXT_66 = "<rows";
  protected final String TEXT_67 = ".length;i";
  protected final String TEXT_68 = "++ ) {";
  protected final String TEXT_69 = NL + "\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = rows";
  protected final String TEXT_72 = "[i";
  protected final String TEXT_73 = "].";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = NL + "\t\t// increase number of line sorted" + NL + "    \tnb_line_";
  protected final String TEXT_76 = "++;";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String rowName = null;
String origin = ElementParameterParser.getValue(node, "__ORIGIN__");

	for (INode pNode : node.getProcess().getNodesOfType("tArray")) {
		if (!pNode.getUniqueName().equals(origin + "_Array")) continue; 
		for (IConnection conn : pNode.getIncomingConnections()) {
			rowName = conn.getName();
			break;
		}
		
	}

    stringBuffer.append(TEXT_2);
    
String outRowName = "";
if ((node.getOutgoingConnections()!=null)&&(node.getOutgoingConnections().size()>0)) {
	outRowName = node.getOutgoingConnections().get(0).getName();
} else {
	outRowName = "defaultRow";
}

List<Map<String, String>> criteria = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CRITERIA__");


    stringBuffer.append(TEXT_3);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_6);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	int alphaFlag = 0;

    stringBuffer.append(TEXT_7);
    stringBuffer.append(rowName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(rowName);
    stringBuffer.append(TEXT_9);
    
	for (int i = 0 ; i < criteria.size() ; i++) {
		Map<String, String> line = criteria.get(i);
		String colname = line.get("COLNAME");	
		JavaType colJavaType = null;
		
    	String sort = line.get("SORT");
    	
    	String order = line.get("ORDER");
    	boolean asc = (order.toLowerCase().equals("asc"));
    	

		//get the Java type of that column
		boolean result = false;
		for (IMetadataColumn column : metadata.getListColumns()) {
			if (column.getLabel().compareTo(colname)==0) {
				colJavaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				result = true;
				break;
			}
		}
		if (result) {
			if (colJavaType.isPrimitive()) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append((asc)?"1":"-1");
    stringBuffer.append(TEXT_13);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_15);
    
			} else {
				if (sort.compareTo("alpha")==0) {
					alphaFlag++;

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    stringBuffer.append((asc)?"1":"-1");
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    stringBuffer.append((asc)?"1":"-1");
    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append((asc)?"1":"-1");
    stringBuffer.append(TEXT_27);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_29);
    
				} else {
					// try to convert column to int before the sort  

    stringBuffer.append(TEXT_30);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_42);
    stringBuffer.append((asc)?"1":"-1");
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_45);
    
				}
			}
		} 
		// end if result should always be true...
	}

    stringBuffer.append(TEXT_46);
    
	for(int i = 0 ; i < alphaFlag ; i++)
	{
		
    stringBuffer.append(TEXT_47);
    
	}

    
	for (int i = 0; i < criteria.size() - alphaFlag ; i++) {

    stringBuffer.append(TEXT_48);
    
	}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(rowName );
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
     
	for (IMetadataColumn column : metadata.getListColumns()) { 

    stringBuffer.append(TEXT_69);
    stringBuffer.append(outRowName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    
	}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
    }
}

    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
