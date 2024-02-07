package Sunny;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class dataDriven {
@Test

	public void getTest() throws IOException {


		FileInputStream fis= new FileInputStream("C:\\Users\\Sunny\\demosheet.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();

		for(int i=0;i<sheets;i++) {

			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();

				Iterator<Cell> ce=firstRow.cellIterator();

				while(ce.hasNext()){
					Cell firstcell=ce.next();
					System.out.println(firstcell.getStringCellValue());


				}

			}

		}


	        fis.close();
	        workbook.close();

	}

	}




