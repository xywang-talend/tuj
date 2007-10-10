package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "//create directory only if not exists" + NL + "\t\t String fileNewName_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t\t java.io.File createFile";
  protected final String TEXT_5 = " = new java.io.File(fileNewName_";
  protected final String TEXT_6 = ");" + NL + "\t\t if(!createFile";
  protected final String TEXT_7 = ".exists()){" + NL + "\t\t \t(new java.io.File(fileNewName_";
  protected final String TEXT_8 = ".substring(0,fileNewName_";
  protected final String TEXT_9 = ".lastIndexOf(\"/\")))).mkdirs();" + NL + "\t\t }";
  protected final String TEXT_10 = NL + NL + "\t\tint nb_line_";
  protected final String TEXT_11 = " = 0;" + NL + "\t\t" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_12 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_13 = ".setEncoding(";
  protected final String TEXT_14 = ");" + NL + "\t\tfinal jxl.write.WritableWorkbook writeableWorkbook";
  protected final String TEXT_15 = " = jxl.Workbook.createWorkbook(new java.io.BufferedOutputStream(new java.io.FileOutputStream(";
  protected final String TEXT_16 = "))" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t, workbookSettings_";
  protected final String TEXT_17 = ");" + NL + "        final jxl.write.WritableSheet writableSheet";
  protected final String TEXT_18 = " = writeableWorkbook";
  protected final String TEXT_19 = ".createSheet(";
  protected final String TEXT_20 = ", 0);" + NL + "" + NL + "        ";
  protected final String TEXT_21 = NL + "    \tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_24 = "));";
  protected final String TEXT_25 = NL + "\t\tif(true){" + NL + "\t\t\tthrow new Exception(\"Date pattern must be set for column ";
  protected final String TEXT_26 = " in the schema of component ";
  protected final String TEXT_27 = "!\");" + NL + "\t\t}";
  protected final String TEXT_28 = NL + "\t\twritableSheet";
  protected final String TEXT_29 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_30 = ", nb_line_";
  protected final String TEXT_31 = ", \"";
  protected final String TEXT_32 = "\"));";
  protected final String TEXT_33 = NL + "\t\tnb_line_";
  protected final String TEXT_34 = "++;";
  protected final String TEXT_35 = NL;

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
        String cid = node.getUniqueName();

        String filename = ElementParameterParser.getValueWithUIFieldKey(
            node,
            "__FILENAME__",
            "FILENAME"
        );
        
        String sheetname= ElementParameterParser.getValue(node,"__SHEETNAME__");
        
        boolean isIncludeHeader = ElementParameterParser.getValue(
            node,
            "__INCLUDEHEADER__"
        ).equals("true");
        String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");

    if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fileNewname);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_20);
    
		List<IMetadataColumn> columns = metadata.getListColumns();
    	int sizeColumns = columns.size();
    	for (int i = 0; i < sizeColumns; i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_24);
    	    		}else{
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    				}
			}
			if(isIncludeHeader){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    			}
		}
		if(isIncludeHeader){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    		}
    }
}

    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
