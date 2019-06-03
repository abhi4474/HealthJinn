package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import dataProvider.ReadWriteExcel;
import applicationHandling.*;
import listeners.*;
import utilities.*;
import pages.LoginPage;

public class LoginTest extends InvokeAppium{
    LoginPage loginPage_obj = new LoginPage();

/*    @Test(dataProviderClass= DataProviderLoginPage.class,dataProvider="getTableData")
    public void loginOTP (String email,String expectedmsg)
    {
        //LoginPage loginPage_obj = new LoginPage();
        loginPage_obj.loginViaOTP(email,expectedmsg);
    }*/

/*
    @Test(dataProviderClass= DataProviderLoginPage.class,dataProvider= "invalidData")
    public void invalidLoginDetails(String tcId,String tcName,String email,String expectedmsg) throws IOException {
        test=extent.startTest(tcId+" :  "+tcName);
        loginPage_obj.invalidLogin(tcId,tcName,email,expectedmsg);
        extent.endTest(test);
        extent.flush();
    }
*/

    @Test(dataProviderClass= ReadWriteExcel.class,dataProvider= "loginData")
    public void loginDataDetails(String tcId,String tcName,String email,String expectedmsg, String fullName) throws Exception {
        test=extent.startTest(tcId+" :  "+tcName);
        //loginPage_obj.otpLogin(tcId,tcName,email,expectedmsg);
       try {
           LoginPage.loginViaOTP(email,expectedmsg,fullName);
           InvokeAppium.test.log(LogStatus.PASS,"Login via OTP passed"); }
       catch (Exception e) {
           InvokeAppium.test.log(LogStatus.FAIL,"Login via OTP Failed");
          // InvokeAppium.test.log(LogStatus.FAIL,test.addScreenCapture(AppiumListeners.screenshot()));
           e.printStackTrace(); }

       String status = String.valueOf(InvokeAppium.test.getRunStatus());
       ConfigFileReader obj_config=new ConfigFileReader();
       FileInputStream fin=new FileInputStream(new File(obj_config.getExcel()));
       ExcelHandler Excel_obj = new ExcelHandler(fin);
       Excel_obj.selectSheet(obj_config.getSheetName());
       Excel_obj.setCellData(6,3,status);
       extent.endTest(test);
       extent.flush();
    }

   /* @Test
    public void loginAccountLocked(){
       // loginPage_obj.accLockedLoginLogout();
    }*/
}

