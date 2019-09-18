package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class doli_bar_FWUtil1 {
	
	public static  String getXLData(String path,String sheet,int row,int cell)
	{
		String v="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	public static void setXLdata(String path,String sheet,int row,int cell,int value)
	{
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			w.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
			w.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Method Overloading
	public static void setXLdata(String path,String sheet,int row,int cell,String value)
	{
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			w.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
			w.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//method-4
	public static int getXLRowCount(String path,String sheet)
	{
		int count=0;
		try {
		Workbook w = WorkbookFactory.create(new FileInputStream(path));
		count=w.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public static void getPhoto(WebDriver driver,String path) {
		try {
		TakesScreenshot t = (TakesScreenshot)driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		File desFile = new File(path);
		FileUtils.copyFile(srcFile,desFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

