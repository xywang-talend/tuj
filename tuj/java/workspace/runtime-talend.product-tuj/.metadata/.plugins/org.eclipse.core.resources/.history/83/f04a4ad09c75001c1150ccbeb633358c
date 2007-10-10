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

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_3 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_4 = ".setEncoding(";
  protected final String TEXT_5 = ");" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_6 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(new java.io.FileInputStream(" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_7 = ")), workbookSettings_";
  protected final String TEXT_8 = ");" + NL + "        final jxl.Sheet sheet_";
  protected final String TEXT_9 = "  = workbook_";
  protected final String TEXT_10 = ".getSheet(";
  protected final String TEXT_11 = ");" + NL + "        if(sheet_";
  protected final String TEXT_12 = " == null){" + NL + "        \tthrow new Exception(\"Sheet \\\"\"+";
  protected final String TEXT_13 = "+\"\\\" not exist!\");" + NL + "        }" + NL + "        int nb_line_";
  protected final String TEXT_14 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "0";
  protected final String TEXT_17 = ";" + NL + "        int end_line_";
  protected final String TEXT_18 = " = sheet_";
  protected final String TEXT_19 = ".getRows()- ";
  protected final String TEXT_20 = "0";
  protected final String TEXT_21 = ";" + NL + "        int limit_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = "-1";
  protected final String TEXT_24 = ";" + NL + "        int start_column_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = "0";
  protected final String TEXT_27 = "-1";
  protected final String TEXT_28 = ";" + NL + "        int end_column_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = "sheet_";
  protected final String TEXT_31 = ".getColumns()";
  protected final String TEXT_32 = ";" + NL + "" + NL + "        jxl.Cell[] row_";
  protected final String TEXT_33 = " = null;" + NL + "        " + NL + "        for(int i_";
  protected final String TEXT_34 = " = begin_line_";
  protected final String TEXT_35 = "; i_";
  protected final String TEXT_36 = " < end_line_";
  protected final String TEXT_37 = "; i_";
  protected final String TEXT_38 = "++){" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_39 = " != -1 && nb_line_";
  protected final String TEXT_40 = " >= limit_";
  protected final String TEXT_41 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "                " + NL + "        \trow_";
  protected final String TEXT_42 = " = sheet_";
  protected final String TEXT_43 = ".getRow(i_";
  protected final String TEXT_44 = ");     " + NL + "        ";
  protected final String TEXT_45 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_46 = " = new String[";
  protected final String TEXT_47 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_48 = " = end_column_";
  protected final String TEXT_49 = " >\trow_";
  protected final String TEXT_50 = ".length ? row_";
  protected final String TEXT_51 = ".length : end_column_";
  protected final String TEXT_52 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_53 = ";i++){\t\t\t\t\t\t\t" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_54 = " < actual_end_column_";
  protected final String TEXT_55 = "){" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_56 = "[i] = row_";
  protected final String TEXT_57 = "[i + start_column_";
  protected final String TEXT_58 = "].getContents();" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_59 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}";
  protected final String TEXT_60 = "\t\t\t\t\t" + NL + "\t\t\tif(temp_row_";
  protected final String TEXT_61 = "[";
  protected final String TEXT_62 = "].length() > 0) {";
  protected final String TEXT_63 = NL + "\t\t\t";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " = temp_row_";
  protected final String TEXT_66 = "[";
  protected final String TEXT_67 = "];";
  protected final String TEXT_68 = "\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_69 = "<actual_end_column_";
  protected final String TEXT_70 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = ((jxl.DateCell)row_";
  protected final String TEXT_73 = "[";
  protected final String TEXT_74 = " + start_column_";
  protected final String TEXT_75 = "]).getDate();" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\tthrow new Exception(\"The cell format is not Date in row \"+(nb_line_";
  protected final String TEXT_76 = "+1)+\" column \"+(";
  protected final String TEXT_77 = " + start_column_";
  protected final String TEXT_78 = "+1));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_79 = NL + "\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = ParserUtils.parseTo_";
  protected final String TEXT_82 = "(temp_row_";
  protected final String TEXT_83 = "[";
  protected final String TEXT_84 = "]);";
  protected final String TEXT_85 = "\t\t\t\t\t" + NL + "\t\t\t}else {";
  protected final String TEXT_86 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_87 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_88 = NL + "\t\t\t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = NL + "\t\t}";
  protected final String TEXT_93 = NL + "      \t";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node,"__FILENAME__"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, "__SHEETNAME__"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, "__SHEETNAME__"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_15);
    if(header.trim().equals("")){
    stringBuffer.append(TEXT_16);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_19);
    if(footer.trim().equals("")){
    stringBuffer.append(TEXT_20);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    if(limit.trim().equals("")){
    stringBuffer.append(TEXT_23);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    if(firstColumn.trim().equals("")){
    stringBuffer.append(TEXT_26);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    if(lastColumn.trim().equals("")){
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    }else{
    stringBuffer.append(lastColumn);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_44);
    
//begin
//
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
//
//end
    stringBuffer.append(TEXT_45);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_62);
    
//start
//
						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_63);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_67);
    		
//start
//
						} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_68);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_85);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_86);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_87);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_88);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_91);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_92);
    
//start
//
					}
				}
			}
			if (conns.size()>1) {
				for (int i=1;i<conns.size();i++) {
					IConnection connection = conns.get(i);
					if ((connection.getName().compareTo(firstConnName)!=0)&&(connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    		for (IMetadataColumn column: metadata.getListColumns()) {
//
//end
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connection.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    
//start
//
						}
					}
				}
			}
		}
	}
}
//
//end
    return stringBuffer.toString();
  }
}
