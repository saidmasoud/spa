package com.mason.seor.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import com.mason.seor.persistence.R1ProgramElement;

public class R1ExcelWriter implements ItemStreamWriter<R1ProgramElement> {

	String template;
	String excelEndLocation;
	String newLocation;
	Path excelPath;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Iterator<Row> rowIterator;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	int rowCount;

	@Override
	public void write(List<? extends R1ProgramElement> items) throws Exception {

		for (R1ProgramElement r2 : items) {
			// create row
			Row row = sheet.createRow(rowCount);
			int columnCount = 0;

			// add PE
			Cell cell = row.createCell(columnCount);
			cell.setCellValue(r2.getPe());
			columnCount++;

			// add FY_Reported
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getFyReported());
			columnCount++;

			// add Organization
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getOrganization());
			columnCount++;

			// add BA
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getBa());
			columnCount++;

			// add BA_title
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getBaTitle());
			columnCount++;

			// add PE_title
			cell = row.createCell(columnCount);
			cell.setCellValue(r2.getPeTitle());
			columnCount++;
			
			// add CREATE_DTM
			cell = row.createCell(columnCount);
			cell.setCellValue(new Date().toString());
			columnCount++;

			// add FY_1996
			cell = row.createCell(columnCount);
			Double value = r2.getFy1996();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_1997
			cell = row.createCell(columnCount);
			value = r2.getFy1997();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_1998
			cell = row.createCell(columnCount);
			value = r2.getFy1998();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_1999
			cell = row.createCell(columnCount);
			value = r2.getFy1999();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2000
			cell = row.createCell(columnCount);
			value = r2.getFy2000();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2001
			cell = row.createCell(columnCount);
			value = r2.getFy2001();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2002
			cell = row.createCell(columnCount);
			value = r2.getFy2002();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2003
			cell = row.createCell(columnCount);
			value = r2.getFy2003();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2004
			cell = row.createCell(columnCount);
			value = r2.getFy2004();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2005
			cell = row.createCell(columnCount);
			value = r2.getFy2005();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2006
			cell = row.createCell(columnCount);
			value = r2.getFy2006();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2007
			cell = row.createCell(columnCount);
			value = r2.getFy2007();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2008
			cell = row.createCell(columnCount);
			value = r2.getFy2008();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2009
			cell = row.createCell(columnCount);
			value = r2.getFy2009();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2010
			cell = row.createCell(columnCount);
			value = r2.getFy2010();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2011
			cell = row.createCell(columnCount);
			value = r2.getFy2011();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2012
			cell = row.createCell(columnCount);
			value = r2.getFy2012();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2013
			cell = row.createCell(columnCount);
			value = r2.getFy2013();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2014
			cell = row.createCell(columnCount);
			value = r2.getFy2014();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2015
			cell = row.createCell(columnCount);
			value = r2.getFy2015();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2016
			cell = row.createCell(columnCount);
			value = r2.getFy2016();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			// add FY_2017
			cell = row.createCell(columnCount);
			value = r2.getFy2017();
			if (value != null) {
				cell.setCellValue(value);
			}
			columnCount++;

			rowCount++;

		}

	}

	/*
	 * Copies the Excel template to a new location and then opens
	 * the new file for writing
	 */
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		try {
			// copy template and vbs script to new location
			Files.deleteIfExists(Paths.get(excelEndLocation));
			excelPath = Files.copy(Paths.get(template), Paths.get(excelEndLocation), StandardCopyOption.COPY_ATTRIBUTES);
			newLocation = excelPath.getParent().toString() + System.getProperty("file.separator")
			+ excelPath.getFileName().toString();

			// Create Workbook instance holding reference to .xlsx file
			inputStream = new FileInputStream(new File(newLocation));
			workbook = new XSSFWorkbook(inputStream);

			// Get first/desired sheet from the workbook
			sheet = workbook.getSheetAt(0);

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
			outputStream = new FileOutputStream(newLocation);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (NullPointerException e) {
			System.out.println("NPE caught, continuing...");
		}

	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setExcelEndLocation(String endLocation) {
		this.excelEndLocation = endLocation;
	}

}