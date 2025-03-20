package Utlities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream file;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;

	String path = ".\\testData\\LoginData.xlsx";

	public ExcelUtility(String path) {

		this.path = path;
	}

	public int get_rowCount(String sheet) throws IOException {

		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		file.close();

		return rowCount;
	}

	public int get_cellCount(String sheet, int rowNum) throws IOException {
		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet("Sheet1");
		int cellCount = ws.getRow(rowNum).getLastCellNum();
		wb.close();
		file.close();

		return cellCount;

	}

	public String get_cellData(String sheet, int rowNum, int cellNum) throws IOException {

		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);

		DataFormatter data = new DataFormatter();
        String cellData = data.formatCellValue(cell);

		return cellData;

	}

}
