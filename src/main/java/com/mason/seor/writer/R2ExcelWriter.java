package com.mason.seor.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import com.mason.seor.persistence.R2ProgramElement;

public class R2ExcelWriter implements ItemStreamWriter<R2ProgramElement> {

	String vbsEndLocation;
	String vbsScript;
	String excelLocation;
	Path vbsPath;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Iterator<Row> rowIterator;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	int rowCount;

	@Override
	public void write(List<? extends R2ProgramElement> items) throws Exception {
		
		// this will set the cell type as "Number" for the FY_* columns
		XSSFDataFormat format = workbook.createDataFormat();
		XSSFCellStyle style = workbook.createCellStyle();
		style.setDataFormat(format.getFormat("0.00"));

		for (R2ProgramElement r2 : items) {
			// create row
			Row row = sheet.createRow(rowCount);
			int columnCount = 0;

			// add PE
			Cell cell = row.createCell(columnCount);
			cell.setCellValue(r2.getPe());
			columnCount++;

			// add PE_Title
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getPeTitle());
			columnCount++;

			// add Budget_Year
			cell = row.createCell(columnCount);
			cell.setCellValue(/*"PB_"+*/r2.getBudgetYear());
			columnCount++;
			
			// add Budget_Cycle
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getBudgetCycle());
			columnCount++;
			
			// add Submission_Date
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getSubmissionDate());
			columnCount++;
			
			// add Service_Agency_Name
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getServiceAgencyName());
			columnCount++;
			
			// add Appropriation_Code
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getAppropriationCode());
			columnCount++;
			
			// add Appropriation_Name
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getAppropriationName());
			columnCount++;

			// add BA
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getBa());
			columnCount++;
			
			// add BA_Title
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getBaTitle());
			columnCount++;
			
			// add CREATE_DTM
			cell = row.createCell(columnCount);
			cell.setCellValue(new Date().toString());
			columnCount++;

			// add FY_2010
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			Double value = r2.getFy2010();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2011
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2011();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2012
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2012();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2013
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2013();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2014
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2014();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2015
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2015();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2016
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2016();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2017
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2017();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;
			
			// add FY_2018
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2018();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;
			
			// add FY_2019
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2019();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;
			
			// add FY_2020
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2020();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;
			
			// add FY_2021
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2021();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;
			
			// add FY_2022
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2022();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;
			
			// add FY_2023
			cell = row.createCell(columnCount);
			cell.setCellStyle(style);
			value = r2.getFy2023();
			if (value == null || value==0) {
				cell.setCellValue("");
			} else{
				cell.setCellValue(value);
			}
			columnCount++;

			rowCount++;

		}

	}

	/*
	 * Copies the VBS template to a new location and then opens
	 * the existing Excel file for writing
	 */
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		try {
			// copy VBS script to new location
			/*Files.deleteIfExists(Paths.get(vbsEndLocation));
			Path vbsPath = Files.copy(Paths.get(vbsScript), Paths.get(vbsEndLocation), StandardCopyOption.COPY_ATTRIBUTES);
			vbsScript = vbsPath.getParent().toString() + System.getProperty("file.separator")
			+ vbsPath.getFileName().toString();*/
			
			//replace excel location template in script
			Charset charset = StandardCharsets.UTF_8;
			String content = new String(Files.readAllBytes(vbsPath));
			content = content.replaceAll("<excel_file_path>", excelLocation.replace("\\", "/"));
			Files.write(vbsPath, content.getBytes(charset));
			
			// Create Workbook instance holding reference to .xlsm file
			inputStream = new FileInputStream(new File(excelLocation));
			workbook = new XSSFWorkbook(inputStream);

			// Get second/desired sheet from the workbook
			sheet = workbook.getSheetAt(1);

			// Iterate through each rows one by one
			rowIterator = sheet.iterator();
			// we're going to start at row 2 since the first row contains the
			// headers
			rowCount = 1;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		// Do nothing
	}

	/*
	 * (non-Javadoc) Write changes to then close the workbook file, and then
	 * execute the VBS script to call the macros within the Excel template
	 */
	@Override
	public void close() throws ItemStreamException {
		try {
			inputStream.close();
			outputStream = new FileOutputStream(excelLocation);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
			// call VBS
			//String cmd = "wscript " + vbsScript;
			//Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (NullPointerException e) {
			System.out.println("NPE caught, continuing...");
		}

	}

	public void setExcelLocation(String excelLocation) {
		this.excelLocation = excelLocation;
	}

	public void setVbsEndLocation(String vbsEndLocation) {
		this.vbsEndLocation = vbsEndLocation;
	}

	public void setVbsScript(String vbsScript) {
		this.vbsScript = vbsScript;
	}

}