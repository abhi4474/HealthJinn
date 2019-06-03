package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import listeners.ConfigFileReader;

public class ExcelHandler {

	    private HashMap<String, XSSFSheet> importedSheets = new HashMap<String, XSSFSheet>();
	    private XSSFSheet selectedSheet = null;
	    private XSSFWorkbook workbook= null;
		public static ConfigFileReader obj_config = new ConfigFileReader();



	public ExcelHandler(FileInputStream excelWorkbook) throws Exception {
	    	System.out.println("Inside excel handler");
			//XSSFWorkbook workbook= null;
			try {
			   workbook = new XSSFWorkbook(excelWorkbook);
			   System.out.println("Workbook");
		   }catch (Exception e)
		   {
		   	e.printStackTrace();
		   }
	        String[] sheetNames=new String[workbook.getNumberOfSheets()] ;
            System.out.println("excelhandler"+sheetNames.length);
            XSSFSheet[] sheetData=new XSSFSheet[workbook.getNumberOfSheets()] ;
            for(int i=0;i<workbook.getNumberOfSheets();i++)
            {
                sheetNames[i]=workbook.getSheetName(i);
                sheetData[i]=workbook.getSheetAt(i);
            }

            for (int sheetNumber = 0; sheetNumber < workbook.getNumberOfSheets(); sheetNumber++) {
	            this.importedSheets.put(sheetNames[sheetNumber], sheetData[sheetNumber]);
	        }
            System.out.println("excelhandler finished  "+  sheetNames.length);
        }

	    public void selectSheet(String sheetName) throws Exception {
	        if (this.importedSheets.containsKey(sheetName)) {
	            this.selectedSheet = importedSheets.get(sheetName);
	        } else {
	            throw new Exception("Sheet with name '" + sheetName + "' doesn't exist!");
	        }
	    }

	    public String selectedSheetName() throws Exception {
	        return this.selectedSheet.getSheetName();
	    }

	   
	    public HashMap<Integer, Cell> getColumn(int columnNumber) throws Exception {
	        return getColumn(columnNumber, false);
	    }

	    
	    public HashMap<Integer, Cell> getColumn(int columnNumber, boolean skipFirstRow) throws Exception {
	        if (this.selectedSheet.equals(null)) {
	            throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
	        } else if (columnNumber > this.selectedSheet.getRow(0).getLastCellNum()) {
	            throw new Exception("There are only " + this.selectedSheet.getRow(0).getLastCellNum() + " columns in this sheet.  Unable to select column " + columnNumber + "!");
	        }
	        HashMap<Integer, Cell> selectedColumn = new HashMap<Integer, Cell>();

	        for(int i=0;i<this.selectedSheet.getRow(0).getLastCellNum();i++)
            {
                Cell currentCell=this.selectedSheet.getRow(0).getCell(i);
/*				DataFormatter df = new DataFormatter();
				String val = df.formatCellValue(currentCell);*/
                selectedColumn.put(selectedColumn.size() + 1, currentCell);
            }
/*
	        for (Cell currentCell : this.getColumn(columnNumber - 1)) {
	            selectedColumn.put(selectedColumn.size() + 1, currentCell);
	        }
*/
	        if (skipFirstRow) {
	            selectedColumn.remove(1);
	        }
	        return selectedColumn;
	    }

	    
	    public HashMap<Integer, Cell> getRow(int rowNumber) throws Exception {
	        return getRow(rowNumber, false);
	    }

	    public HashMap<Integer, Cell> getRow(int rowNumber, boolean skipFirstColumn) throws Exception {
	        if (this.selectedSheet.equals(null)) {
	            throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
	        } else if (rowNumber > this.selectedSheet.getLastRowNum()) {
	            throw new Exception("There are only " + this.selectedSheet.getLastRowNum() + " rows in this sheet.  Unable to select row " + rowNumber + "!");
	        }
	        HashMap<Integer, Cell> selectedRow = new HashMap<Integer, Cell>();
	        for (Cell currentCell : this.selectedSheet.getRow(rowNumber - 1)) {
	            selectedRow.put(selectedRow.size() + 1, currentCell);
	        }
	        if (skipFirstColumn) {
	            selectedRow.remove(1);
	            }
	        return selectedRow;
	    }
	    public Cell getCellData(int column, int row) throws Exception {
	        column--;
	        row--;
	        if (this.selectedSheet.equals(null))
	            throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
	        return this.selectedSheet.getRow(row).getCell(column);
	    }

	    public String setCellData(int column, int row , String status) throws Exception {
			String excelLocation=null;
			if (this.selectedSheet.equals(null))
				throw new Exception("No sheet selected.  You must select a sheet before trying to set data!");
			this.selectedSheet.getRow(row).createCell(column).setCellValue(status);
			excelLocation=obj_config.getExcel();
			System.out.println("located Excel at " +excelLocation);
			File location=new File(excelLocation);
			FileOutputStream FO = new FileOutputStream(location);
			workbook.write(FO);
			FO.close();
			return this.selectedSheet.getRow(row).getCell(column).getStringCellValue();
		}
	    
	    public int getRowCount()
	    {
	    	return this.selectedSheet.getLastRowNum();
	    }
	    
	    
	    public int getColumnCount()
	    {
	    	return this.selectedSheet.getRow(0).getLastCellNum();
	    }

	}
