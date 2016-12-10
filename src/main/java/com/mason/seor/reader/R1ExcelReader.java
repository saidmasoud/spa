package com.mason.seor.reader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

import com.mason.seor.model.r1.ProgramElement;

public class R1ExcelReader implements ItemStreamReader<ProgramElement> {

	String fileLocation;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Iterator<Row> rowIterator;

	@Override
	public ProgramElement read() throws Exception {

		ProgramElement element = new ProgramElement();
		try {
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// this is for the rows that may be headers,
				// empty rows, etc.
				if (!isValidRow(row)) {
					return new ProgramElement();
				}

				element.setOrganization(row.getCell(2).getStringCellValue());
				element.setBa(Integer.valueOf(row.getCell(4).getStringCellValue()));
				element.setBaTitle(row.getCell(5).getStringCellValue());
				element.setPe(row.getCell(6).getStringCellValue());
				element.setPeTitle(row.getCell(7).getStringCellValue());
				element.setTwoYearsPriorAmount(row.getCell(9).getNumericCellValue());
				element.setPrevYearPriorAmount(row.getCell(10).getNumericCellValue());
				element.setCurrentYearAmount(row.getCell(11).getNumericCellValue());
				return element;
			}
		} catch (NullPointerException e) {
			// System.out.println("Found blank value, continuing....");
			return element;
		} catch (NumberFormatException e) {
			System.out.println("Caught row with bad format, continuing...");
			return new ProgramElement();
		}

		return null;
	}

	public boolean isValidRow(Row row) {

		String checkPe = row.getCell(6).getStringCellValue();
		if (checkPe.trim().matches("^[0-9]{7}")) {
			System.out.println("Invalid row detected!!! Value: " + checkPe);
			return false;
		}
		return true;

	}

	@SuppressWarnings("resource")
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		System.out.println("Opening " + fileLocation);
		try {
			
			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(fileLocation);

			// Get first/desired sheet from the workbook
			sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			rowIterator = sheet.iterator();
			// skip first row which contains headers
			rowIterator.next();
		} catch (IOException e) {
			throw new ItemStreamException(
					"IOException occured while trying to open workbook: " + e.getLocalizedMessage());
		}

	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		// do nothing

	}

	@Override
	public void close() throws ItemStreamException {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NPE caught, continuing...");
		}

	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
