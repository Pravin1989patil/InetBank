package com.inetbank.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	
	public static void setup(String filename,String sheetname) throws IOException
	{
		fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/inetbank/testData/"+filename+".xlsx");
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		
	}
	
	public static int getRowCount(String filename, String sheetname) throws IOException
	{
		setup(filename,sheetname);
		int rowcount =sheet.getLastRowNum();
		fis.close();
		workbook.close();
		return rowcount; 
		
	}
	public static int getCellCount(String filename, String sheetname,int rownum) throws IOException 
	{
		setup(filename,sheetname);
		row=sheet.getRow(rownum);
		int colcount=row.getLastCellNum();
		fis.close();
		workbook.close();
		return colcount;
	}
	public static String getCellData(String filename, String sheetname, int rownum, int colnum) throws IOException
	{	
		setup(filename, sheetname);
		String value= sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		fis.close();
		workbook.close();
		return value;
		
	}
}
