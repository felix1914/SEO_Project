package com.samplepro.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_utils {

	

    
    static Excel_Reader reader;

    
    public static  ArrayList<Object[]> getDataFromexcel() {
  
        
        ArrayList<Object[]> myData=new ArrayList<Object[]>();
        try {
        	 
        	
        	
        	reader=new Excel_Reader("C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
            String INDEX = reader.getCellData("Sheet1", "INDEX", rowNum);
            String PageURL = reader.getCellData("Sheet1", "PageURL", rowNum);
            
            String Title = reader.getCellData("Sheet1", "Title", rowNum).toLowerCase().trim();
            if(Title.length()==0) {
            	Title = "No excel data found";
            }
            String Description = reader.getCellData("Sheet1", "Description", rowNum).toLowerCase().trim();
            if(Description.length()==0) {
            	Description = "No excel data found";
            }
            String keywords = reader.getCellData("Sheet1", "keywords", rowNum).toLowerCase().trim();
            		
    
            if(keywords.length()==0) {
            	keywords =  "No excel data found";    	
            }
            String H1Tags = reader.getCellData("Sheet1", "H1Tags", rowNum).toLowerCase().trim();
           
            if(H1Tags.length()==0) {
            	H1Tags = "No excel data found";
            }  
            
             
            Object ob[]= {INDEX,PageURL,Title,Description,keywords,H1Tags};
            		
            myData.add(ob);
           
        }
        return myData;
   
    }
    
//Title validation
    public static void writeinexcel2(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(6);
        if (value=="FAIL"||value=="INVALID URL") {
        	   XSSFCellStyle my_style = wb.createCellStyle();
               XSSFFont my_font=wb.createFont();
               my_font.setColor(XSSFFont.COLOR_RED);
               my_style.setFont(my_font);
               c.setCellValue(value);
                c.setCellStyle(my_style);

		}
        else {
			 c.setCellValue(value);
		}
       
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }

    //Description validation
    public static void writeinexcel3(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(7);
        if (value=="FAIL") {
     	   XSSFCellStyle my_style = wb.createCellStyle();
            XSSFFont my_font=wb.createFont();
            my_font.setColor(XSSFFont.COLOR_RED);
            my_style.setFont(my_font);
            c.setCellValue(value);
             c.setCellStyle(my_style);

		}else {
			 c.setCellValue(value);
		}
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }
    //keywords validation
    public static void writeinexcel4(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(8);
        if (value=="FAIL"||value=="INVALID URL") {
      	   XSSFCellStyle my_style = wb.createCellStyle();
             XSSFFont my_font=wb.createFont();
             my_font.setColor(XSSFFont.COLOR_RED);
             my_style.setFont(my_font);
             c.setCellValue(value);
              c.setCellStyle(my_style);

 		}else {
 			 c.setCellValue(value);
 		}
       
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }
    //title,description,title
    public static void writeinexcel5(String value, int INDEX) throws Exception {
    	 Thread.sleep(2000);
         File fis = new File(
                 "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
         FileInputStream excelloc = new FileInputStream(fis);
 		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
 		XSSFSheet s = wb.getSheetAt(0);
 		XSSFRow row = s.getRow(INDEX);

 		XSSFCell c = row.createCell(9);
 		if (value.length() > 0) {
 			XSSFCellStyle my_style = wb.createCellStyle();
 			XSSFFont my_font = wb.createFont();
 			my_font.setColor(XSSFFont.COLOR_RED);
 			my_style.setFont(my_font);
 			c.setCellValue(value);
 			c.setCellStyle(my_style);

  		}else {
  			 c.setCellValue(value);
  		}
        
         FileOutputStream out = new FileOutputStream(fis);
         wb.write(out);
         out.close();
     }
    public static void writeinexcel6(String value, int INDEX) throws Exception {
    	Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
       
        FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);

		XSSFCell c = row.createCell(10);
		if (value.length() > 0) {
			XSSFCellStyle my_style = wb.createCellStyle();
			XSSFFont my_font = wb.createFont();
			my_font.setColor(XSSFFont.COLOR_RED);
			my_style.setFont(my_font);
			c.setCellValue(value);
			c.setCellStyle(my_style);

 		}else {
 			 c.setCellValue(value);
 		}
       
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }
    public static void writeinexcel7(String value, int INDEX) throws Exception {
    	Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
       
        FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);

		XSSFCell c = row.createCell(11);
		if (value.length() > 0) {
			XSSFCellStyle my_style = wb.createCellStyle();
			XSSFFont my_font = wb.createFont();
			my_font.setColor(XSSFFont.COLOR_RED);
			my_style.setFont(my_font);
			c.setCellValue(value);
			c.setCellStyle(my_style);

 		}else {
 			 c.setCellValue(value);
 		}
       
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }

    public static void writeinexcel9(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(12);
        int H1parseInt = Integer.parseInt(value);
        if (H1parseInt >1) {
     	   XSSFCellStyle my_style = wb.createCellStyle();
            XSSFFont my_font=wb.createFont();
            my_font.setColor(XSSFFont.COLOR_RED);
            my_style.setFont(my_font);
            c.setCellValue(value);
            c.setCellStyle(my_style);
            

		}else {
			c.setCellValue(value);
		}
        
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }

    public static void writeinexcel8(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(13);
        
        if (value=="PASS") {
        	c.setCellValue(value);
        	  

   		}else {
   		 XSSFCellStyle my_style = wb.createCellStyle();
         XSSFFont my_font=wb.createFont();
         my_font.setColor(XSSFFont.COLOR_RED);
         my_style.setFont(my_font);
         c.setCellValue(value);
          c.setCellStyle(my_style);
   			 
   		}
         
          FileOutputStream out = new FileOutputStream(fis);
          wb.write(out);
          out.close();
      }
    public static void writeinexcel10(String value, int INDEX) throws Exception {
    	 Thread.sleep(2000);
         File fis = new File(
                 "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
         FileInputStream excelloc = new FileInputStream(fis);
         XSSFWorkbook wb = new XSSFWorkbook(excelloc);
         XSSFSheet s = wb.getSheetAt(0);
         XSSFRow row = s.getRow(INDEX);
         XSSFCell c = row.createCell(14);
         if (value=="FAIL"||value=="INVALID URL") {
       	   XSSFCellStyle my_style = wb.createCellStyle();
              XSSFFont my_font=wb.createFont();
              my_font.setColor(XSSFFont.COLOR_RED);
              my_style.setFont(my_font);
              c.setCellValue(value);
               c.setCellStyle(my_style);

  		}else {
  			 c.setCellValue(value);
  		}
        
         FileOutputStream out = new FileOutputStream(fis);
         wb.write(out);
         out.close();
     }
    public static void writeinexcel11(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(15);
        c.setCellValue(value);
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }
    public static void writeinexcel12(int  respCode, int INDEX) throws Exception {
    	 Thread.sleep(2000);
         File fis = new File(
                 "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
         FileInputStream excelloc = new FileInputStream(fis);
         XSSFWorkbook wb = new XSSFWorkbook(excelloc);
         XSSFSheet s = wb.getSheetAt(0);
         XSSFRow row = s.getRow(INDEX);
         XSSFCell c = row.createCell(16);
       //  int responsecode = Integer.parseInt(respCode);
         if (respCode >200) {
      	   XSSFCellStyle my_style = wb.createCellStyle();
             XSSFFont my_font=wb.createFont();
             my_font.setColor(XSSFFont.COLOR_RED);
             my_style.setFont(my_font);
             c.setCellValue(respCode);
             c.setCellStyle(my_style);
             

 		}else {
 			 c.setCellValue(respCode);
 		}
         
         FileOutputStream out = new FileOutputStream(fis);
         wb.write(out);
         out.close();
     }

   
    //time stamp
    public static void writeinexcel13(String value, int INDEX) throws Exception {
        Thread.sleep(2000);
        File fis = new File(
                "C:\\Users\\j416\\eclipse-workspace\\project\\Excel\\Book1.xlsx");
        FileInputStream excelloc = new FileInputStream(fis);
        XSSFWorkbook wb = new XSSFWorkbook(excelloc);
        XSSFSheet s = wb.getSheetAt(0);
        XSSFRow row = s.getRow(INDEX);
        XSSFCell c = row.createCell(17);
        c.setCellValue(value);
        FileOutputStream out = new FileOutputStream(fis);
        wb.write(out);
        out.close();
    }
    

}
