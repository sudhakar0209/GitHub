package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	XSSFWorkbook file;
	XSSFSheet s;
	
	public String readExcel(String path, String Sheet1, int r, int c) throws IOException {
		
		FileInputStream fin = new FileInputStream(path);
		file = new XSSFWorkbook(fin);
		s = file.getSheet(Sheet1);
//		s = file.getSheetAt(sheetNO);
		String data=s.getRow(r).getCell(c).getStringCellValue();
		file.close();
		return data;
	}
	
	public int getLastRow(String path, String Sheet1) throws IOException
	{
		FileInputStream fin = new FileInputStream(path);
		file = new XSSFWorkbook(fin);
		s = file.getSheet(Sheet1);
		int LastRow = s.getLastRowNum();
		return LastRow;
	}
	
	public static void main(String args[]) throws IOException
	{
		ExcelRead e=new ExcelRead();
		int LastRow = e.getLastRow("C:\\Users\\sudha\\OneDrive\\Desktop\\testData.xlsx", "Sheet1");
		for(int i=0; i<=LastRow; i++) {
		String username = e.readExcel("C:\\Users\\sudha\\OneDrive\\Desktop\\testData.xlsx", "Sheet1", i, 0);
		String password = e.readExcel("C:\\Users\\sudha\\OneDrive\\Desktop\\testData.xlsx", "Sheet1", i, 1);
		System.out.println("Username "+i+" "+username);
		System.out.println("Password "+i+" "+password);
		System.out.println(" ");
		}
	}

}
