package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	
	public String getDataFromExcel(String Sheet,int row,int column) throws EncryptedDocumentException, IOException
	{
	
		FileInputStream fis=  new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb  =   WorkbookFactory.create(fis);
		String data = wb.getSheet(Sheet).getRow(row).getCell(column).getStringCellValue();
		wb.close();
	   	return data;
	   	
	}

	
	public int getRowCount(String Sheet) throws EncryptedDocumentException, IOException
	{
	    FileInputStream fis=  new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb  =   WorkbookFactory.create(fis);
		int  rowCount = wb.getSheet(Sheet).getLastRowNum();
		wb.close();
	    return rowCount;
	
	}
	
	public void setDataIntoExcel(String sheet,int row,int column,String data) throws EncryptedDocumentException, IOException
	{
		  FileInputStream fis=  new FileInputStream("./testdata/testScriptdata.xlsx");
		  Workbook wb  = WorkbookFactory.create(fis);
          wb.getSheet(sheet).getRow(row).getCell(column).setCellValue(data);
          
          FileOutputStream fos =  new FileOutputStream("./testdata/testScriptdata.xlsx");
          wb.write(fos);
          wb.close();
		 
		
	    
	}

}
