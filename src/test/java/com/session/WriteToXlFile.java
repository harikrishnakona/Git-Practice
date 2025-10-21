package com.session;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteToXlFile {
	@Test
	public void writeData() throws IOException {
		
		File file = new File("C:/Users/2440830/OneDrive - Cognizant/Desktop/TestNG/sample.xlsx");
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		String[][] dataStrings = {
				{"username","password"},
				{"admin", "admin123"},
				{"dj", "123"}
		};
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
	    Sheet sheet = workbook.createSheet("credentials");
		
	    
		for (int i = 0; i < dataStrings.length; i++ ) {
			 Row row =  sheet.createRow(i);
			 
			 for (int j = 0; j < dataStrings[i].length; j++) {
				 Cell cell = row.createCell(j);
				 cell.setCellValue(dataStrings[i][j]);
			 }
		}
		
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
	}
}

//POM -> page object model

