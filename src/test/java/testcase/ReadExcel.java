package testcase;

import java.io.File;

import utilities.ExcelReader;

public class ReadExcel {

	public static void main(String[] args) {
		
		ExcelReader reader = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		String sheetName = "AddCustomerTest";
		
		String data = reader.getCellData(sheetName, "firstname", 5);
		System.out.println("Cell data: "+data);
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("Total rows are: "+rowCount);
		
		if(!reader.isSheetExist("PoiSheet")) {
			reader.addSheet("PoiSheet");
		}
		
		reader.setCellData(sheetName, "firstname", 6, "Mayank");
		System.out.println(reader.getCellData(sheetName, "firstname", 6));
		
		System.out.println(reader.getColumnCount(sheetName));
		
		
	}
	
}
