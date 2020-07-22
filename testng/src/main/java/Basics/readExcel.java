package Basics;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readExcel {
public static String[][] excelData(String filename) throws IOException { 
		XSSFWorkbook book= new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheet= book.getSheetAt(0);
		int rowscount= sheet.getLastRowNum();
		XSSFRow headerRow= sheet.getRow(0);
		int celCount =  headerRow.getLastCellNum();
		String[][] array = new String[rowscount][celCount];
		for(int i=1;i<=rowscount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<celCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.println(data);
				array[i-1][j] = data;
			}
			System.out.println("****");
		}
		book.close();
		return array;
		
	}
}