package pages;

import org.apache.commons.collections4.SetValuedMap;
import org.apache.poi.hssf.record.BottomMarginRecord;
import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;
import applicationHandling.*;
import listeners.*;
import objectRepository.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class LoginPage extends ActionDriver {
	
    public static void loginViaOTP(String email, String expectedmsg, String fullName) throws Exception {
        /*// expliciltyWait(LoginObjects.waitForEmailTxt);
         click(LoginObjects.loginViaOtpLnk);
         InvokeAppium.test.log(LogStatus.INFO, "Click on Login via OTP button");
        // expliciltyWait(LoginObjects.emailTxt);
         type(LoginObjects.emailTxt, email);
         InvokeAppium.test.log(LogStatus.INFO, "Enter an email");
         click(LoginObjects.sendOtpLink);
         InvokeAppium.test.log(LogStatus.INFO, "Click on Send OTP button");
         //expliciltyWait(LoginObjects.visibleOtpTxt);
         allowAppPermission();
         if (expectedmsg.contains("redirection to OTP Page"))
             waitForPresenceOfElelment(LoginObjects.visibleOtpTxt);
         InvokeAppium.test.log(LogStatus.INFO, "Visibilty of OTP text");
         click(LoginObjects.otpText1);
         type(LoginObjects.otpText1, "1");
         type(LoginObjects.otpText2, "2");
         type(LoginObjects.otpText3, "3");
         type(LoginObjects.otpText4, "4");
         Thread.sleep(5000);
         try {
             if (verifyElementToBeLocated(LoginObjects.clickOkBtn)) {
         //        expliciltyWait(LoginObjects.clickOkBtn);
                 click(LoginObjects.clickOkBtn);
                 InvokeAppium.test.log(LogStatus.INFO, "Click on 'OK' button");
             }
         } catch (Exception e) {
             System.out.println("Proceed further");
             InvokeAppium.test.log(LogStatus.INFO, "Might be using same device to login so procced Further to dashboard screen");
         }
         Thread.sleep(5000);
         try{
             if (verifyElementToBeLocated(LoginObjects.healthJinnTxt)) {
                 waitForPresenceOfElelment(LoginObjects.acceptBtn);
                 click(LoginObjects.acceptBtn);
                 InvokeAppium.test.log(LogStatus.INFO, "Accept the updated Terms & conditions/Privacy Policy");
                 //expliciltyWait(LoginObjects.waitForMoreTab);
             }}catch(Exception e){
             System.out.println("Proceed further");
             InvokeAppium.test.log(LogStatus.INFO, "No update has been found; so proceed further to dashboard");}

          try{
             waitForPresenceOfElelment(LoginObjects.connectWithGF);
             verifyFunction(LoginObjects.connectWithGF);
             InvokeAppium.test.log(LogStatus.PASS,test.addScreenCapture(AppiumListeners.screenshot()));}
          catch(Exception e) {
             throw new Exception("Login Via OTP Failed"); }
           }*/
     	
    	tapAction(LoginObjects.enterPIN);
    	type(LoginObjects.enterPIN,email);
    	Thread.sleep(3000);
    	click(LoginObjects.clickSignIn);
    	//waitForPresenceOfElelment(LoginObjects.txtDashboard);
    	System.out.println("on the dashboard screen");
    	click(LoginObjects.clickApplicationForm);
 		waitForPresenceOfElelment(LoginObjects.txtLifeAssuredDetails);
 		System.out.println("on the life assured details page");
 		click(LoginObjects.enterFullName);
 		type(LoginObjects.enterFullName,fullName);
 		driver.getKeyboard();
 		driver.hideKeyboard();
 	
 		System.out.println("Entered Name");
 		Thread.sleep(3000);
 		click(LoginObjects.clickDOB);
		  Thread.sleep(5000); 
		  //driver.findElement(By.xpath("//android.widget.ListView[@index='2']")).sendKeys("Mar");
		  click(LoginObjects.setBtn); 
		  Thread.sleep(3000);
		  System.out.println("_____Life Assured Done_____");
		  click(LoginObjects.clickNextBtn); 
		  Thread.sleep(3000);
		  waitForPresenceOfElelment(LoginObjects.txtChooseProducts);
		  //scroll(LoginObjects.scrollView, "All%20Product%20Logos-18");
		  click(LoginObjects.clickProtectProduct);
		  Thread.sleep(3000);
		  click(LoginObjects.clickBtn);
		  Thread.sleep(3000);
		 System.out.println("---Let's plan your policy---");		
		 
		/*
		 * scroll(LoginObjects.scrollView, "Sum Assured");
		 * waitForPresenceOfElelment(LoginObjects.sumAssured);
		 * type(LoginObjects.sumAssured, "85000000");
		 * System.out.println("Entered SumAssured Amount");
		 */
		
 		scroll(LoginObjects.scrollView,"CALCULATE BENEFIT");
 		waitForPresenceOfElelment(LoginObjects.calculateBenefitBtn);
 		click(LoginObjects.calculateBenefitBtn);
 		waitForPresenceOfElelment(LoginObjects.txtPlanSynopsis);
 		scroll(LoginObjects.scrollView,"NEXT");
 		waitForPresenceOfElelment(LoginObjects.txtPersonalDetails);
 		
 		
 		
 		
 		
     }}


