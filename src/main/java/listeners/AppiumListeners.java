package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import applicationHandling.*;
//import genericLib.OpenAndCloseBrowser;

public class AppiumListeners extends TestListenerAdapter {

        private static WebDriver driver;
        //private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

        @Override
        public void onTestFailure(ITestResult tr) {
            try {
                screenshot();
                System.out.println("Test Failed");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

        @Override
        public void onTestSkipped(ITestResult tr) {
            try {
                screenshot();
                System.out.println("Test Skipped");
            } catch (Exception e) {
                e.printStackTrace(); }
        }

        @Override
        public void onTestSuccess(ITestResult tr) {
            try {
                screenshot();
                System.out.println("Test Passed");
            } catch (Exception e) {
                e.printStackTrace(); }
        }


    public static String screenshot() throws IOException{
	    @SuppressWarnings("unused")
		String encodedBase64 = null ;
        System.out.println("Taking screenshot");
        Date date=new Date();
        SimpleDateFormat dateFormatFolder = new SimpleDateFormat("dd_MMM_yyyy");
        File ScreenshotDir = new File(System.getProperty("user.dir")+File.separator+"/Screenshots/"+dateFormatFolder.format(date));  // Defining Directory/Folder Name

        if (!ScreenshotDir.exists()){  // Checks that Directory/Folder Doesn't Exists!
            ScreenshotDir.mkdir();
        }
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
        String screenshotName=ScreenshotDir +"/"+dateFormat.format(date)+".png";
        System.out.println("screenshot loction: "+screenshotName);
        driver=InvokeAppium.getInstance();
        System.out.println(driver.getTitle());

        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenshotName));

        return screenshotName;
    }

}
