package listeners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class ConfigFileReader{

    private static Properties properties;
    private final String propertyFilePath = System.getProperty("user.dir") + File.separator + "config.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            System.out.println("file path: " + propertyFilePath);
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

/*    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }*/

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else
            throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("URL");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

/*    public String getBrowser() {
        // TODO Auto-generated method stub
        String Browser = properties.getProperty("BrowserName");
        if (Browser != null) return Browser;
        else
            throw new RuntimeException("Browser not specified in the Configuration.properties file.");
    }*/

    public String getExcel() {
        // TODO Auto-generated method stub
        String Excel = properties.getProperty("Path");
        System.out.println(Excel);
        if (Excel != null) return Excel;
        else
            throw new RuntimeException("Excel not specified in the Configuration.properties file.");
    }

    public String getSheetName()
    {
        String Sheet = properties.getProperty("SheetName");
        System.out.println(Sheet);
        if(Sheet != null) return Sheet;
        else
            throw new RuntimeException("Sheet not specified in the Configuration.properties file. ");
    }
    public String getPropertyFilePath() {
        // TODO Auto-generated method stub
        String ReportPath = properties.getProperty("ExtentReportPath");
        if (ReportPath != null) return ReportPath;
        else
            throw new RuntimeException("ReportPath not specified in the Configuration.properties file.");
    }

    public  String getAutomationName()
    {
        String automationName = properties.getProperty("AutomationName");
        if(automationName != null) return automationName;
        else
            throw new RuntimeException("AutomationName not specified in the Configuration.properties file.");
    }

    public  String getAppPackage()
    {
        String appPackage = properties.getProperty("AppPackage");
        if(appPackage != null) return appPackage;
        else
            throw new RuntimeException("AppPackage not specified in the Configuration.properties file.");
    }

    public  String getAppActivity()
    {
        String appActivity = properties.getProperty("AppActivity");
        if(appActivity != null) return appActivity;
        else
            throw new RuntimeException("AppActivity not specified in the Configuration.properties file.");
    }

   /* public String EncryptPass(int row)  {
        // TODO Auto-generated method stub
        String Pass = properties.getProperty("Password");

        String encryptedPassword = EncryptPassword.generateSecurePassword(Pass, EncryptPassword.getSalt(30));

        Cell cell = sheet.getRow(row).getCell(4);
        cell.setCellValue(encryptedPassword);

        Cell cell1 = sheet.getRow(row).getCell(8);
        cell1.setCellValue(encryptedPassword);

for(Row row : sheet)
			{
				for (Cell cell : row)
				{
					if(cell.equals(cell.getStringCellValue().contains("PASS")))
					{
						int r=cell.getRowIndex();
						int c = cell.getColumnIndex();
						cell = sheet.getRow(r).getCell(c+1);
						cell.setCellValue(Pass);
					}
				}

        FileOutputStream outFile;
        try {
            outFile = new FileOutputStream(new File("C:\\Users\\so.maggo\\workspace\\Partner_Portal_final\\Partner_Portal\\Partner_Portal.xlsx"));
            workBook.write(outFile);
            outFile.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        if(Pass != null) return Pass;
        else throw new RuntimeException("Password not specified in the Configuration.properties file.");
    }

}




{
	try {

        FileInputStream file = new FileInputStream(new File("C:\\test.xls"));

        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Cell cell = null;

        //Update the value of cell
        cell = sheet.getRow(1).getCell(2);
        cell.setCellValue(cell.getNumericCellValue() * 2);
        cell = sheet.getRow(2).getCell(2);
        cell.setCellValue(cell.getNumericCellValue() * 2);
        Row row = sheet.getRow(0);
        row.createCell(3).setCellValue("Value 2");

        file.close();

        FileOutputStream outFile =new FileOutputStream(new File("C:\\update.xls"));
        workbook.write(outFile);
        outFile.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}

*/
}



