package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Excel {
	
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public static void captureScreenShot(WebDriver ldriver,int n){
		File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
					try {
						;
			
		FileUtils.copyFile(src, new File("D://selenium//"+n+"//"+System.currentTimeMillis()+".png"));
		}
		catch(Exception e)
					{
			System.out.println(e);
					}
					

		}	
			
			
			
			
			public static String getData(int r , int c) throws IOException
			 {
				
				File file=new File("D:\\Screenshots\\JIRA.xlsx");
				FileInputStream fis=new FileInputStream(file);
				 wb=new XSSFWorkbook(fis);
				 sheet=wb.getSheetAt(0);
				Row row=sheet.getRow(r);
				Cell cell=row.getCell(c);
				
				 
				
				String value=cell.getStringCellValue();
				
				return value;
			
				
			 }
			
			
			
		public static String getExcelData(String sheetname,String col_name,int i) 
		{
			String res=null;
			try {
			DataFormatter formatter=new DataFormatter();
			File file=new File("D:\\Screenshots\\JIRA.xlsx");
			FileInputStream fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet(sheetname);
			
			
				Row r=sheet.getRow(0);
				int maxCell = r.getLastCellNum();
				
				
				for(int y=0;y<=maxCell;y++)
				{
					String value=formatter.formatCellValue(sheet.getRow(0).getCell(y));
					if(value.equalsIgnoreCase(col_name))
					{
						res=formatter.formatCellValue(sheet.getRow(i).getCell(y));
						
					}
					
				}
				

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			
			
			return res;
			
		}
			
			
			
			
			
			
			public static int getRowCount() throws Exception {
				File file=new File("D:\\Screenshots\\JIRA.xlsx");
				FileInputStream fis=new FileInputStream(file);
				 wb=new XSSFWorkbook(fis);
				 sheet=wb.getSheetAt(0);
				 int rc=sheet.getLastRowNum();
				 
				 return rc;
				 
				
				
				
			}
			
		
			public static void writeData(int r , int c,String value) throws IOException, Exception, InvalidFormatException
			 {
				
				File file=new File("D:\\Screenshots\\JIRA.xlsx");
				FileInputStream fis=new FileInputStream(file);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sheet = wb.getSheetAt(0);
				Row row=sheet.getRow(r);
				Cell cell=row.createCell(c);
				cell.setCellValue(value);
				FileOutputStream fos=new FileOutputStream(file);
				//fos.flush();
				
				wb.write(fos);
				
				fos.close();
				
			
				
				
				
			 }
			
}	
		
	 
	
