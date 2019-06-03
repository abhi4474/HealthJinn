package applicationHandling;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.List;
import objectRepository.LoginObjects;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ActionDriver extends InvokeAppium{
        //protected AndroidDriver driver;

        /*public ActionDrivers(AndroidDriver driver) {
            this.driver=driver;
        }*/
     /*   public static WebDriverWait wait;
        public static AndroidDriver driver;*/
	    public static WebDriverWait wait;
	
	    public static void waitForPresenceOfElelment(By loc){
			 WebDriverWait wait= new WebDriverWait(driver,3000);
			  wait.until(ExpectedConditions.presenceOfElementLocated(loc));}
	    
	    public static void tapAction(By loc) {	
	    	MobileElement view = driver.findElement(loc);
	    	driver.tap(1, view, 3);
	    }
	
	    
	/*
	 * public void swipeInListTillExpectedTextAndTap(List<MobileElement> list,
	 * String expectedText, int time) { int i = 1; while
	 * (!driver.getPageSource().contains(expectedText)) {
	 * swipeInListFromLastToFirst(list); i++; if (i == time) break; }
	 * tap(driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""
	 * + expectedText + "\")")); }
	 * 
	 * public void swipeInListFromLastToFirst(List<MobileElement> listID) { int
	 * items = listID.size(); org.openqa.selenium.Point centerOfFirstElement =
	 * listID.get(0).getCenter(); org.openqa.selenium.Point centerOfLastElement =
	 * listID.get(items - 1).getCenter(); new
	 * TouchAction(driver)<>(driver).longPress(point(centerOfLastElement.x,
	 * centerOfLastElement.y)) .moveTo(point(centerOfFirstElement.x,
	 * centerOfFirstElement.y)).release().perform(); }
	 */
	    
	    public static void touchAction(int xPoint, int yPoint) {
	    	//get screen size
	    	Dimension size = driver.manage().window().getSize();
	    	//calculate center point of height
	    	int point_to_tap1 = (int) (size.getHeight() * 0.5);
	    	//calculate center point of width
	    	int point_to_tap2 = (int) (size.getWidth() * 0.5);
	    	System.out.printf(size+ "/"+ point_to_tap1+ "/"+point_to_tap2);

	    	TouchAction touchAction=new TouchAction(driver);
	    	touchAction.tap(xPoint, yPoint).perform();
	    	
	    	//action.press(startX, startY).moveTo((endX - startX), (endY-startY)).release().perform();

	    }
	    
	    public static void testScroll() {
	    	List<MobileElement> datePickerBox = driver.findElements(By.xpath("//*[@class='android.widget.EditText']"));

	    	WebElement month = datePickerBox.get(0);
	    	WebElement day = datePickerBox.get(1);
	    	WebElement year = datePickerBox.get(2);

	    	month.click();
	    	month.sendKeys("Feb");

	    	day.click();
	    	day.sendKeys("22");

	    	year.click();
	    	year.sendKeys("2000"); }
	    
	    	
	
	    
	    public static boolean bottomTopswipe() {  	    	  
	    	try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            HashMap<String, String> scrollObject = new HashMap<String, String>();
	            scrollObject.put("direction", "up");
	            js.executeScript("mobile: scroll", scrollObject);
	            System.out.println("Swipe up was Successfully done.");
	          }
	             catch (Exception e) 
	              {
	                  System.out.println("swipe up was not successfull");
	              }   
	          return false;   
	    	 }
	    
	    public static void waitForElementToBeClickable(By loc)
	    {
	        WebDriverWait wait= new WebDriverWait(driver,3000);
	        wait.until(ExpectedConditions.elementToBeClickable(loc));
	    }
	
	    public static void click(By loc) {
	        //System.out.println(loc);
	        waitForPresenceOfElelment(loc);
	        waitForElementToBeClickable(loc);
	        WebElement element = driver.findElement(loc);
	        element.click();
	    }
	
	    public static void type(By loc,String str) {
	        waitForPresenceOfElelment(loc);
	        WebElement element = driver.findElement(loc);
	        element.sendKeys(str);}
	
	    public static String readOTP() throws Exception {
	        //driver.startActivity("com.android.mms", "com.android.mms.ui.ConversationList");
	                driver.openNotifications();
	                try {
	                    String otp = driver.findElementByXPath("//*[contains(@text,'is')]").getText().split("code:")[0];
	                    return otp;
	                }catch (NoSuchElementException e){
	                    throw new java.lang.Exception("Notification not found");}
	    }
	
		    
	    /*public static void expliciltyWait(By loc){
	        wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	    }
	
	    public static void openEmail() throws EmailException {
	
	        Email email = new SimpleEmail();
	        email.setHostName("smtp.googlemail.com");
	        email.setSmtpPort(465);
	        email.setAuthenticator(new DefaultAuthenticator("username", "password"));
	        email.setSSLOnConnect(true);
	        email.setFrom("user@gmail.com");
	        email.setSubject("TestMail");
	        email.setMsg("This is a test mail ... :-)");
	        email.addTo("foo@bar.com");
	        email.send();
	    }*/
	
	    public static void verifyFunction(By loc) throws Exception {
	        try{
	        WebElement element = driver.findElement(loc);
	        element.isDisplayed();}
	        catch(Exception e) {
	            throw new Exception("Element is not present"); } }
	
	
	    public void waitForPageLoad() {
	        wait = new WebDriverWait(driver, 40);
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver webDriver) {
	                        return null;}
	                    public Boolean apply(AndroidDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"); }};
	        wait.until(pageLoadCondition);}
	
		/*
		 * public static void uploadFromCamera() throws InterruptedException {
		 * //click(MyClaimsObject.loc);
		 * waitForPresenceOfElelment(MyClaimsObject.clickCamera);
		 * click(MyClaimsObject.clickCamera);
		 * waitForPresenceOfElelment(MyClaimsObject.clickDoneBtn);
		 * click(MyClaimsObject.clickCaptureBtn); Thread.sleep(10000);
		 * click(MyClaimsObject.clickDoneBtn);
		 * waitForPresenceOfElelment(MyClaimsObject.clickUploadBtn1);
		 * click(MyClaimsObject.clickUploadBtn1);
		 * waitForPresenceOfElelment(MyClaimsObject.pleaseTxt);
		 * click(MyClaimsObject.confirmBtn); //
		 * expliciltyWait(MyClaimsObject.clickSubmitBtn); }
		 */
	
	    public static void scroll(By loc, String val) {
	        WebElement list = driver.findElement(loc);
	        try{
	        list.findElement(MobileBy
	                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
	                        + "new UiSelector().text(\" val \"));"));}
	        catch(Exception e){
	            e.printStackTrace();
	            System.out.println("Cannot scroll further");
	        }}
	
	    public static List<MobileElement> listMySection(By loc) {
	        waitForPresenceOfElelment(loc);
	        List<MobileElement> elements = driver.findElements(loc);
	        return elements;
	    }
	
	    public static void clickFromList(By loc, int index)
	    {
	        List<MobileElement> elements = driver.findElements(loc);
	        elements.get(index).click();
	    }
	
	    public static boolean verifyElementToBeLocated(By Loc)
	    {
	        WebElement element = driver.findElement(Loc);
	        element.isDisplayed();
	        return true;
	    }
	
	    public static String getText(By loc)
	    {
	        WebElement element = driver.findElement(loc);
	        return element.getText();
	    }
	
	    public static void getAttribute(By loc, String str)
	    {
	        WebElement element = driver.findElement(loc);
	        element.getAttribute(str);
	    }
	
	    public static void clearTextboxField(By loc)
	    {
	        WebElement element = driver.findElement(loc);
	        element.clear();
	    }
	
	    public void dropDown(By loc,String text){
	        List<MobileElement> list= driver.findElements(loc);
	        for(int i=0; i<list.size();i++){
	            WebElement values = list.get(i);
	            if(values.getAttribute("text").equalsIgnoreCase(text))
	                values.click();
	        }
	    }
	
	    public static void allowAppPermission() {
	        while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size() > 0) {
	            driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();}
	    }
}
