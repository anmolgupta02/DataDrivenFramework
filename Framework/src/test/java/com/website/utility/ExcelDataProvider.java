package com.website.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelDataProvider {

	
	XSSFWorkbook wb;
	public ExcelDataProvider() throws Exception {
		
		File src = new File("/home/appventurez/eclipse-workspace/Framework/TestData/Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		//Apache POI to read the file. 
		wb = new XSSFWorkbook(fis);	
	}
	
	//Reading File and getting String Value
	public String getStringData(String SheetName, int rownum, int colnum) {
		
		
		//Different coding to incorporate numerical data into string.
		
		org.apache.poi.ss.usermodel.Cell c1 = wb.getSheet(SheetName).getRow(rownum).getCell(colnum);
		c1.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
		String data = c1.getStringCellValue();
		return data;
		
		
	}		
	
	//Reading File and getting Numeric Value.
	public double getNumericData(String SheetName, int rownum, int colnum) {
		return wb.getSheet(SheetName).getRow(rownum).getCell(colnum).getNumericCellValue();
	}
	
	public boolean isNum(String s) {
		 for (int i = 0; i < s.length(); i++) 
		        if (Character.isDigit(s.charAt(i))  
		            == false) 
		            return false; 
		  
		        return true;
	}
}


