package com.resilinc;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {
		Set<Pojo> setPojo = new HashSet<>();
		try {
			File file = new File("C:\\Users\\Harshal-Pande\\Desktop\\Duplicate Emails\\demo.xlsx"); // creating a
																									// new file
																									// instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			while (itr.hasNext()) {
				Row row = itr.next();
				Pojo pojo = evaluateRow(row);
				if (pojo != null) {
					setPojo.add(pojo);
				}
			}

			setPojo.forEach(pojo -> {
				System.out.println(pojo.toString());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Pojo evaluateRow(Row row) {
		if (isRowEmpty(row)) {
			return null;
		}
		Pojo pojo = new Pojo();
		pojo.setProcessed(row.getCell(0) != null ? row.getCell(0).getDateCellValue().toInstant().toString() : null);
		pojo.setEvent(row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null);
		pojo.setSubject(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null);
		pojo.setFrom(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null);
		pojo.setEmail(row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null);
		pojo.setCategories(row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null);
		pojo.setUniqueArgs(row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null);
		pojo.setCompanyName(row.getCell(7) != null ? row.getCell(7).getStringCellValue() : null);
		return pojo;
	}

	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}
}

//Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
//while (cellIterator.hasNext()) {
//	Cell cell = cellIterator.next();
//	switch (cell.getCellType()) {
//	case Cell.CELL_TYPE_STRING: // field that represents string cell type
//		System.out.print(cell.getStringCellValue() + "\t\t");
//		break;
//	case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
//		if (HSSFDateUtil.isValidExcelDate(cell.getNumericCellValue())) {
//			System.out.print(cell.getDateCellValue() + "\t\t");
//		} else {
//			System.out.print(cell.getNumericCellValue() + "\t\t");
//		}
//		break;
//	default:
//	}
//}
//System.out.println("");