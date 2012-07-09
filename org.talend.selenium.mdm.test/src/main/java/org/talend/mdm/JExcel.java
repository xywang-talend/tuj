package org.talend.mdm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;

/**
 * Operate the excel.
 * @author zpbai
 */
public class JExcel {
	private static Workbook wb;
	private InputStream is;
	
	public Workbook getWorkbook(String filePath){
		try {
			if(wb == null){
				is = new FileInputStream(new File(filePath));
				wb = Workbook.getWorkbook(is);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb;
	}
	
	public void closeWorkBook(){
		try {
			is.close();
			is = null;
			wb.close();
			wb = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Sheet getSheet(int num) {
		return wb.getSheet(num);
	}
	
	public Sheet getSheet(String name) {
		return wb.getSheet(name);
	}
	
	public Sheet[] getSheets() {
		return wb.getSheets();
	}
	
	public String getSheetName(Sheet sheet){
		return sheet.getName();
	}
	
	public int getSheetColumns(Sheet sheet){
		return sheet.getColumns();
	}
	
	public int getSheetgetRows(Sheet sheet){
		return sheet.getRows();
	}
}
