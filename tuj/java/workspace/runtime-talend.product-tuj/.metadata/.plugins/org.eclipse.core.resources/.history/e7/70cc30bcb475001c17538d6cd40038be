package org.talend.designer.codegen.translators.loganderror;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Map;

public class TLogRowBeginJava
{
  protected static String nl;
  public static synchronized TLogRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowBeginJava result = new TLogRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "///////////////////////";
  protected final String TEXT_3 = NL + "\t        class Util_";
  protected final String TEXT_4 = " {" + NL + "" + NL + "            String[] des_top = { \".\", \".\", \"-\", \"+\" };" + NL + "" + NL + "            String[] des_head = { \"|=\", \"=|\", \"-\", \"+\" };" + NL + "" + NL + "            String[] des_bottom = { \"'\", \"'\", \"-\", \"+\" };" + NL + "" + NL + "            String name=\"\";" + NL + "" + NL + "            java.util.List<String[]> list = new java.util.ArrayList<String[]>();" + NL + "" + NL + "            int[] colLengths = new int[";
  protected final String TEXT_5 = "];" + NL + "" + NL + "            public void addRow(String[] row) {" + NL + "" + NL + "                for (int i = 0; i < ";
  protected final String TEXT_6 = "; i++) {" + NL + "                    if (row[i]!=null) {" + NL + "                      colLengths[i] = Math.max(colLengths[i], row[i].length());" + NL + "                    }" + NL + "                }" + NL + "                list.add(row);" + NL + "            }" + NL + "" + NL + "            public void setTableName(String name) {" + NL + "" + NL + "                this.name = name;" + NL + "            }" + NL + "" + NL + "            public StringBuffer format() {" + NL + "            " + NL + "            StringBuffer sb = new StringBuffer();" + NL + " ";
  protected final String TEXT_7 = " " + NL + "                " + NL + "                sb.append(print(des_top));" + NL + "" + NL + "                int totals = 0;" + NL + "                for (int i = 0; i < colLengths.length; i++) {" + NL + "                    totals = totals + colLengths[i];" + NL + "                }" + NL + "" + NL + "                // name" + NL + "                sb.append(\"|\");" + NL + "                int k = 0;" + NL + "                for (k = 0; k < (totals + ";
  protected final String TEXT_8 = " - name.length()) / 2; k++) {" + NL + "                    sb.append(' ');" + NL + "                }" + NL + "                sb.append(name);" + NL + "                for (int i = 0; i < totals + ";
  protected final String TEXT_9 = " - name.length() - k; i++) {" + NL + "                    sb.append(' ');" + NL + "                }" + NL + "                sb.append(\"|\\n\");" + NL + "" + NL + "                // head and rows" + NL + "                sb.append(print(des_head));" + NL + "                for (int i = 0; i < list.size(); i++) {" + NL + "" + NL + "                    String[] row = list.get(i);" + NL + "" + NL + "                    java.util.Formatter formatter = new java.util.Formatter(new StringBuffer());" + NL + "                    " + NL + "                    StringBuffer sbformat = new StringBuffer();                                       ";
  protected final String TEXT_10 = "      " + NL + "\t\t\t        sbformat.append(\"|%";
  protected final String TEXT_11 = "$-\");" + NL + "\t\t\t        sbformat.append(colLengths[";
  protected final String TEXT_12 = "]);" + NL + "\t\t\t        sbformat.append(\"s\");";
  protected final String TEXT_13 = "              " + NL + "                    sbformat.append(\"|\\n\");                    " + NL + "   " + NL + "                    formatter.format(sbformat.toString(), (Object[])row);\t" + NL + "                            " + NL + "                    sb.append(formatter.toString());" + NL + "                    if (i == 0)" + NL + "                        sb.append(print(des_head)); // print the head" + NL + "                }" + NL + "" + NL + "                // end" + NL + "                sb.append(print(des_bottom));" + NL + "                return sb;" + NL + "            }" + NL + "            " + NL + "" + NL + "            private StringBuffer print(String[] fillChars) {" + NL + "                StringBuffer sb = new StringBuffer();" + NL + "                //first column" + NL + "                sb.append(fillChars[0]);";
  protected final String TEXT_14 = "                " + NL + "                for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {" + NL + "                    sb.append(fillChars[2]);" + NL + "                }" + NL + "                sb.append(fillChars[3]);";
  protected final String TEXT_15 = "\t                " + NL;
  protected final String TEXT_16 = NL + "                for (int i = 0; i < colLengths[";
  protected final String TEXT_17 = "] - fillChars[3].length() + 1; i++) {" + NL + "                    sb.append(fillChars[2]);" + NL + "                }" + NL + "                sb.append(fillChars[3]);";
  protected final String TEXT_18 = NL + "                ";
  protected final String TEXT_19 = "  " + NL + "               //last column" + NL + "              for (int i = 0; i < colLengths[";
  protected final String TEXT_20 = "] - fillChars[0].length() - fillChars[1].length()+2; i++) {" + NL + "                   sb.append(fillChars[2]);" + NL + "              }";
  protected final String TEXT_21 = NL + "               //last column" + NL + "              for (int i = 0; i < colLengths[";
  protected final String TEXT_22 = "] - fillChars[1].length() + 1; i++) {" + NL + "                   sb.append(fillChars[2]);" + NL + "              }";
  protected final String TEXT_23 = "         " + NL + "                sb.append(fillChars[1]);" + NL + "                sb.append(\"\\n\");";
  protected final String TEXT_24 = "               " + NL + "                return sb;" + NL + "            }" + NL + "        }" + NL + "        Util_";
  protected final String TEXT_25 = " util_";
  protected final String TEXT_26 = " = new Util_";
  protected final String TEXT_27 = "();" + NL + "        util_";
  protected final String TEXT_28 = ".setTableName(\"";
  protected final String TEXT_29 = "\");" + NL + "        util_";
  protected final String TEXT_30 = ".addRow(new String[]{";
  protected final String TEXT_31 = "\"";
  protected final String TEXT_32 = "\",";
  protected final String TEXT_33 = "});        ";
  protected final String TEXT_34 = NL + "\t\tfinal String OUTPUT_FIELD_SEPARATOR_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";" + NL + "\t\tjava.io.PrintStream consoleOut_";
  protected final String TEXT_37 = " = null;";
  protected final String TEXT_38 = NL + "                    " + NL + "                    " + NL + "                StringBuffer sbHeader_";
  protected final String TEXT_39 = " = new StringBuffer();";
  protected final String TEXT_40 = NL + "\t\t\t\t" + NL + "\t\t\t\tsbHeader_";
  protected final String TEXT_41 = ".append(\"";
  protected final String TEXT_42 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "    \t\t\tsbHeader_";
  protected final String TEXT_44 = ".append(\"\\t\");";
  protected final String TEXT_45 = NL + "                   " + NL + "                    if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_46 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "                    }" + NL + "                    else" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_47 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "                    \tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_48 = ");" + NL + "                    }" + NL + "                    " + NL + "                    consoleOut_";
  protected final String TEXT_49 = ".println(sbHeader_";
  protected final String TEXT_50 = ".toString());" + NL + "                    consoleOut_";
  protected final String TEXT_51 = ".flush();" + NL + "                    ";
  protected final String TEXT_52 = "\t" + NL;
  protected final String TEXT_53 = NL + "\t\tint nb_line_";
  protected final String TEXT_54 = " = 0;" + NL + " " + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2    

	String cid = node.getUniqueName();
    String tablePrint = ElementParameterParser.getValue(node,"__TABLE_PRINT__");
    String printHeader = ElementParameterParser.getValue(node,"__PRINT_HEADER__");


	List<IMetadataColumn> columns = metadata.getListColumns();
	int sizeColumns = columns.size();

    stringBuffer.append(TEXT_2);
    
    if(tablePrint.equals("true")) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_6);
     if (sizeColumns > 0) { //more than one column
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_9);
    
    for ( int i = 0; i < sizeColumns; i++) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_12);
    
  }

    stringBuffer.append(TEXT_13);
     if (sizeColumns > 1) { 
    stringBuffer.append(TEXT_14);
    
   }

    stringBuffer.append(TEXT_15);
    for(int i = 0; i< sizeColumns-2;i++) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_17);
    
	}

    stringBuffer.append(TEXT_18);
     if (sizeColumns == 1) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_20);
     } else if (sizeColumns > 1){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_22);
    
  }

    stringBuffer.append(TEXT_23);
     } 
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
    for(int i=0;i< columns.size();i++){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    
	} else {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
if (printHeader.equals("true")) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
        			
    			for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    
				if(i == sizeColumns-1) break;								

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
                }   

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
	}	

    stringBuffer.append(TEXT_52);
    
  }

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
    }//2
}//1

    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}
