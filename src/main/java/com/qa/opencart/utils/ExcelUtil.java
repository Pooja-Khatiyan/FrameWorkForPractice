package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.opencart.constants.AppConstants;

public class ExcelUtil {

	private static Sheet sheet;
	private static Workbook book;

	public static Object[][] getTestData(String sheetName) {
		System.out.println("reading the test data from sheet : " + sheetName);
		Object data[][] = null;

		try {
			//FileInputStream ip = new FileInputStream(AppConstants.TEST_DATA_SHEET_PATH);
			FileInputStream ip = new FileInputStream(AppConstants.PRODUCT_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			if (sheet == null) {
			    throw new RuntimeException("❌ Sheet '" + sheetName + "' NOT found in Excel file: "
			            + AppConstants.PRODUCT_DATA_SHEET_PATH);
			}

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
