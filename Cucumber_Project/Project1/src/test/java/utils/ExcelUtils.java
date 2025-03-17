package utils;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	Map<String,String> data=new HashMap<>();
	public static Workbook workbook;
	public static FileInputStream inputStream;

	Map<String,String> testData;
	
	
	
	public Map<String,String> readData(String filePath, String sheetName,int rowNumber) throws Exception{
		
		inputStream=new FileInputStream(filePath);
		
		workbook = new XSSFWorkbook(inputStream);
		
		Sheet sheet = workbook.getSheet(sheetName); // Get first sheet
        Row headerRow = sheet.getRow(0);
        
        
        for(int i=rowNumber;i<=rowNumber;i++) {
        	
        	Row row=sheet.getRow(i);
        	
        	for(int j=0;j<headerRow.getPhysicalNumberOfCells();j++) {
        		
        		Cell columnName=headerRow.getCell(j);
        //		Cell columnValue=row.getCell(j);
        		
        		String columnValue = row.getCell(j) != null ? row.getCell(j).toString() : "";
         		
        		
        		data.put(columnName.toString().trim(), columnValue);
        		
        	//	System.out.println(data.get(columnName.toString().trim()));
        	}
        	
        	
        }
        
        inputStream.close();
        workbook.close();
		return data;
	}
	
	public void updateExcel(String filePath, String sheetName, String colName, String value, int rowNumber) throws Exception {
		 
		inputStream=new FileInputStream(filePath);
		
		workbook = new XSSFWorkbook(inputStream);
		
		Sheet sheet = workbook.getSheet(sheetName); // Get first sheet
        Row headerRow = sheet.getRow(0);
        
  for(int i=rowNumber;i<=rowNumber;i++) {
        	
        	Row row=sheet.getRow(i);
        	
        	for(int j=0;j<headerRow.getPhysicalNumberOfCells();j++) {
        		
        		String columnName=headerRow.getCell(j).toString();
        				
        		if(columnName.equalsIgnoreCase(colName)) {
        			Cell cell=row.getCell(j);
        			cell.setCellValue(value);
        		}
        		
        	}
  }
  writeExel(filePath);
	inputStream.close();
	workbook.close();
	 }
	
	
	public String replaceValues(String payload) {
		
		String modifiedPayload=payload;
		
	
		modifiedPayload=modifiedPayload.replace("#inst#", data.get("instructionid"));
		modifiedPayload=modifiedPayload.replace("#endTo#", data.get("endToendId"));
		
		return modifiedPayload;
	}
	
	public void writeExel(String file) throws Exception {
		 FileOutputStream outputStream = new FileOutputStream(file);
	        workbook.write(outputStream);
	        workbook.close();
	        outputStream.close();
	}

}
