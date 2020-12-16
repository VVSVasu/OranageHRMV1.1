package com.computechis.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	public ExcelReader()   {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"\\TestData\\ExcelData.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public ExcelReader(String excelFileName)   {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(excelFileName)));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public int getRowCount(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	public int getRowCount(int sheetIndexNo) {
		return wb.getSheetAt(sheetIndexNo).getPhysicalNumberOfRows();
	}
	public static void m1() {
		
	}
	public int getColumnCount(String sheetName, int rowNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getPhysicalNumberOfCells();
	}
	public String getStringData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public double getIntegerData(String sheetName, int rowNo, int colNo) {
		return (int) wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public double getDecimalData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public boolean getBooleanData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getBooleanCellValue();
	}

}
