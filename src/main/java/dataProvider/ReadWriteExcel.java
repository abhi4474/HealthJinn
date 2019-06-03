package dataProvider;

import utilities.ExcelHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import listeners.ConfigFileReader;

public class ReadWriteExcel {

	public static ConfigFileReader 	obj_config = new ConfigFileReader();
	public static ExcelHandler excel;

	public static void DataProviderLoginPage_Common() throws Exception {
	    System.out.println("Inside Constructor");
		String excelLocation=null,excelSheetName=null;
		excelLocation=obj_config.getExcel();
		System.out.println("located Excel at " +excelLocation);
		excelSheetName= obj_config.getSheetName();
		System.out.println("located s heet : "+excelSheetName);
		File location=new File(excelLocation);
		System.out.println("File Located at :"+location.getAbsolutePath());
		FileInputStream fin=new FileInputStream(location);
		System.out.println("Fileinputstream Executed: "+fin.available());

		try {
			excel = new ExcelHandler(fin);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Excel"+excel);
		excel.selectSheet(obj_config.getSheetName());
		System.out.println("selected sheet name  "+  excel.selectedSheetName());

		int i,rowCount,columnCount;
		rowCount=excel.getRowCount();
		System.out.println("row count is : "+rowCount);
	}

	/*@Parameters({"excelLoc","excelSheetLogin"})
	@DataProvider
	public static Object[][] getTableData(ITestContext context) throws Exception
	{
		String excelLocation=null,excelSheetName=null;
		excelLocation=context.getSuite().getParameter("excelLoc");
    	System.out.println("located Excel at " +excelLocation);
    	excelSheetName=context.getSuite().getParameter("excelSheetLogin");
    	System.out.println("located sheet : "+excelSheetName);
		//FileInputStream f = new FileInputStream(new File(excelLocation));
    	File location=new File(excelLocation);
    	System.out.println("File Located at :"+location.getAbsolutePath());
    	FileInputStream fin=new FileInputStream(location);
		//XSSFWorkbook workbook=null;
		*//*try {
			 workbook = new XSSFWorkbook(fin);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		String[] sheetNames=new String[workbook.getNumberOfSheets()] ;
		System.out.println("excelhandler"+sheetNames.length);
		XSSFSheet[] sheetData=new XSSFSheet[workbook.getNumberOfSheets()] ;
*//*
		ExcelHandler excel=null;
		try {
			excel = new ExcelHandler(fin);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
    	System.out.println("Excel"+excel);
    	excel.selectSheet(excelSheetName);
		System.out.println("selected sheet name"+excel.selectedSheetName());

    	int i,rowCount,columnCount;
    	rowCount=excel.getRowCount();

    	System.out.println("row count is : "+rowCount);
    	
		String email;
		String expectedMsg;
    	
    	email=excel.getCellData(5, 4).getStringCellValue();		// invalid format email
    	expectedMsg=excel.getCellData(4,4).getStringCellValue();		// valid format but unregistered email
		//email[2]=excel.getCellData(4,3).getContents();		// valid format but unregistered email

    *//*	password[0]=excel.getCellData(5, 5).getContents();		// incorrect password
    	password[1]=excel.getCellData(5,7).getContents();		// correct password
    *//**//*
    	for(i=2;i<=rowCount;i++)
    		expectedMsg[i-2]=excel.getCellData(3, i).getContents();
    	*//*
    	return new Object[][]{{email,expectedMsg}};
	}*/


	@DataProvider
	public static Object[][] invalidData(ITestContext context) throws Exception {
		/*String excelLocation=null,excelSheetName=null;
		excelLocation=obj_config.getExcel();
		System.out.println("located Excel at " +excelLocation);
		excelSheetName= obj_config.getSheetName();
		System.out.println("located s heet : "+excelSheetName);
		File location=new File(excelLocation);
		System.out.println("File Located at :"+location.getAbsolutePath());
		FileInputStream fin=new FileInputStream(location);
		System.out.println("Fileinputstream Executed: "+fin.available());

		ExcelHandler excel=null;

		try {
			excel = new ExcelHandler(fin);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Excel"+excel);
		excel.selectSheet(obj_config.getSheetName());
		System.out.println("selected sheet name"+  excel.selectedSheetName());
*/
		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email;
		email = excel.getCellData(6,4).getStringCellValue();        // invalid format email
		expectedMsg = excel.getCellData(5, 4).getStringCellValue();
        tcId=excel.getCellData(1,3).getStringCellValue();
        tcName=excel.getCellData(2,3).getStringCellValue();

		return new Object[][]{{tcId,tcName,email,expectedMsg}};
	}

/*
	@Parameters({"excelLoc","excelSheetLogin"})
	@DataProvider
	public static Object[][] getValidTableData(ITestContext context) throws Exception
	{
	
		
		String excelLocation=null,excelSheetName=null;
		excelLocation=context.getCurrentXmlTest().getParameter("excelLoc");
    	System.out.println("located Excel at " +excelLocation);
    	excelSheetName=context.getCurrentXmlTest().getParameter("excelSheetLogin");
    	System.out.println("located sheet : "+excelSheetName);
    	File location=new File(excelLocation);
    	ExcelHandler excel=new ExcelHandler(location);
    	excel.selectSheet(excelSheetName);
    
    	String email[]=new String[2];
		String password[]=new String[2];
		String expectedMsg[]=new String[2];
		
		//valid but not verified email and password
		email[0]=excel.getCellData(5, 6).getStringCellValue();
		//password[0]=excel.getCellData(5, 7).getContents();
		
		//valid and verified email and password
		email[1]=excel.getCellData(5, 9).getStringCellValue().split("\n")[0];
		//password[1]=excel.getCellData(5, 9).getContents().split("\n")[1];
		
		expectedMsg[0]=excel.getCellData(4,7).getStringCellValue();
		expectedMsg[1]=excel.getCellData(4, 8).getStringCellValue();
		
		return new Object[][]{{email,password,expectedMsg}};
	
	}*/

	@DataProvider
	public static Object[][] stayActiveData(ITestContext context) throws Exception {

		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email;
		email = excel.getCellData(5,41).getStringCellValue();        // invalid format email
		expectedMsg = excel.getCellData(6, 41).getStringCellValue();
		tcId=excel.getCellData(1,41).getStringCellValue();
		tcName=excel.getCellData(2,41).getStringCellValue();
		return new Object[][]{{tcId,tcName,email,expectedMsg}};
	}

	@DataProvider
	public static Object[][] myPolicyData(ITestContext context) throws Exception {

		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email,addPolicy;
		email = excel.getCellData(5,15).getStringCellValue();        // invalid format email
		expectedMsg = excel.getCellData(6, 15).getStringCellValue();
		tcId=excel.getCellData(1,15).getStringCellValue();
		tcName=excel.getCellData(2,15).getStringCellValue();
		addPolicy=excel.getCellData(5,15).getStringCellValue().split(",")[1];
		return new Object[][]{{tcId,tcName,email,expectedMsg,addPolicy}};
	}

	@DataProvider
	public static Object[][] loginData(ITestContext context) throws Exception {

		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email,fullName;
		Cell c=excel.getCellData(5,4);

		/*if(c.getCellType()== CellType.NUMERIC)
			email= (c.getNumericCellValue()).split(",")[0];
		else
			email = c.getStringCellValue().split(",")[0];*/
		email = excel.getCellData(5,4).getStringCellValue().split(",")[0];
		expectedMsg = excel.getCellData(6, 4).getStringCellValue();
		tcId=excel.getCellData(1,4).getStringCellValue();
		tcName=excel.getCellData(2,4).getStringCellValue();
		//fullName=excel.getCellData(5,4).getStringCellValue().split(",")[1];
		fullName = c.getStringCellValue().split(",")[1];

		return new Object[][]{{tcId,tcName,email,expectedMsg,fullName}};
	}

	@DataProvider
	public static Object[][] myClaimsData(ITestContext context) throws Exception {
		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email,estAmount;
		email = excel.getCellData(5,42).getStringCellValue().split(",")[0];
		expectedMsg = excel.getCellData(6, 42).getStringCellValue();
		tcId=excel.getCellData(1,42).getStringCellValue();
		tcName=excel.getCellData(2,42).getStringCellValue();
		estAmount=excel.getCellData(5,42).getStringCellValue().split(",")[1];
		//DOT=excel.getCellData(5,4).getStringCellValue().split("  ")[2];

		return new Object[][]{{tcId,tcName,email,expectedMsg,estAmount}}; }

	@DataProvider
	public static Object[][] registrationData(ITestContext context) throws Exception {

		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email;
		email = excel.getCellData(6,4).getStringCellValue();        // invalid format email
		expectedMsg = excel.getCellData(5, 4).getStringCellValue();
		tcId=excel.getCellData(1,3).getStringCellValue();
		tcName=excel.getCellData(2,3).getStringCellValue();
		return new Object[][]{{tcId,tcName,email,expectedMsg}};
	}

	@DataProvider
	public static Object[][] moreTabData(ITestContext context) throws Exception {

		DataProviderLoginPage_Common();
		String tcId,tcName,expectedMsg,email;
		email = excel.getCellData(5,17).getStringCellValue();        // invalid format email
		expectedMsg = excel.getCellData(6, 17).getStringCellValue();
		tcId=excel.getCellData(1,17).getStringCellValue();
		tcName=excel.getCellData(2,17).getStringCellValue();
		return new Object[][]{{tcId,tcName,email,expectedMsg}};
	}
}
