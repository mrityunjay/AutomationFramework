package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.MainClass;

public class UtilityFunction extends MainClass{
	
	public static String getCellData(int i, int j) {
		Workbook book = null;
		try {
			FileInputStream file=new FileInputStream(properties.getProperty("datafilepath"));
			book=WorkbookFactory.create(file);
			Sheet sheet=book.getSheet("Sheet1");
			String data=sheet.getRow(i).getCell(j).toString();
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				book.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "";
	}
	
	public static String[][] getExcelData(){
		Workbook book = null;
		try {
			FileInputStream file=new FileInputStream(properties.getProperty("datafilepath"));
			book=WorkbookFactory.create(file);
			Sheet sheet=book.getSheet("Sheet1");
			
			int totalRow=sheet.getLastRowNum();
			int lastColNumber=sheet.getRow(0).getLastCellNum();
			
			String[][] data=new String[totalRow][lastColNumber];
			
			for(int i=0;i<totalRow;i++) {
				for(int j=0;j<lastColNumber;j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				book.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
