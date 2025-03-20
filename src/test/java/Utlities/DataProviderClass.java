package Utlities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	@DataProvider(name = "dp")
	public String[][] loginDp() throws IOException {

		String path = ".\\testData\\LoginData.xlsx";

		ExcelUtility eu = new ExcelUtility(path);
		int rowCount = eu.get_rowCount("Sheet1");
		int cellCount = eu.get_cellCount("Sheet1", 1);

		String data[][] = new String[rowCount][cellCount];

		for (int r = 1; r <= rowCount; r++) {

			for (int c = 0; c < cellCount; c++) {

				data[r - 1][c] = eu.get_cellData("Sheet1", r, c);
			}

		}

		return data;

	}

}
