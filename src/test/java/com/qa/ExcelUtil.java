package com.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static Object[][] excelDataProvider() {
		try {
			FileInputStream fis = new FileInputStream("../ReadExcelFile/src/test/resources/TestData/DataSheet.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			// System.out.println(row);
			System.out.println(cell);

			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++)
			{
				for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++)
				{
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			} 
			return data;

		} catch (FileNotFoundException e) {
			System.out.println("Excel file in not found on specified path in given location");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Excel File could not able to load properly");
			e.printStackTrace();
		}
		return null;
		
	}
	
}
