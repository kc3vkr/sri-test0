package sri.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class DataHandlers {
	
	public static String getDataFromExcel(String filePath, String sheetName, int rowIndex, int cellIndex) {
		String data = null;
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return data;
	}
	
	public static void SetDataToExcel(String filePath, String sheetName, int rowIndex, int cellIndex, String data) {
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getDataFromProperties(String filePath, String key) {
		String data = null;
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			data = (String)p.get(key);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void setDataToProperties(String filePath, String key, String value, String comment) {
		
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			p.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			p.store(fos, comment);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
