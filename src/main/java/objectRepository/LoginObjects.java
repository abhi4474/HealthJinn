package objectRepository;

import org.openqa.selenium.By;

public class LoginObjects {
	
	public static By enterPIN=By.xpath("//*[@class='android.widget.EditText']");
	public static By clickSignIn=By.xpath("//*[@class='android.widget.Button'][@text='Sign In']");
	public static By txtDashboard=By.xpath("//*[@class='android.view.View'][@text='Dashboard']");
	public static By clickApplicationForm=By.xpath("//*[@class='android.widget.Image'][@text='Icon-E-App']");
	public static By txtLifeAssuredDetails=By.xpath("//*[@class='android.view.View'][@text='Life Assured Details']");
	public static By clickCameraIcon=By.xpath("//*[@class='android.widget.Image'][@text='Ico-Camera']");
	public static By clickCameraBtn=By.id("com.android.camera:id/v9_shutter_button_internal");
	public static By doneCameraBtn=By.id("com.android.camera:id/inten_done_apply");
	public static By enterFullName=By.xpath("//*[@class='android.widget.EditText']");
	public static By clickDOB=By.xpath("//*[@class='android.view.View'][@text='Date of Birth']");
	public static By setBtn=By.xpath("//*[@class='android.widget.Button'][@text='Set']");
	public static By cancelBtn=By.xpath("//*[@class='android.widget.Button'][@text='Cancel']");
	public static By selectYear=By.xpath("//*[@class='android.widget.ListView'][@text='Year']");
	public static By selectMonth=By.xpath("//*[@class='android.widget.ListView'][@text='Month']");
	public static By selectDay=By.xpath("//*[@class='android.widget.ListView'][@text='Day']");
	public static By clickToggleNO=By.xpath("//*[@class='android.view.View'][@text='No']");
	public static By clickToggleYes=By.xpath("//*[@class='android.view.View'][@text='Yes']");
	public static By clickNextBtn=By.xpath("//*[@class='android.widget.Button'][@text='NEXT']");
	public static By txtChooseProducts=By.xpath("//*[@class='android.view.View'][@text='Choose from wide range of products']");
	public static By scrollView=By.xpath("//*[@class='android.view.View']");
	public static By txtPlanYourPolicy=By.xpath("//*[@class='android.widget.Button'][@text='Let's Plan Your Policy']");
	public static By clickProtectProduct=By.xpath("//*[@class='android.widget.Image'][@text='All%20Product%20Logos-21']");
	public static By selectYear1=By.xpath("//*[@class='android.widget.ListView'][@text='Day']");
	public static By sumAssured=By.xpath("//*[@class='android.widget.EditText'][@text='25,00,000']");
	public static By txtPremiumPaid=By.xpath("//*[@class='android.widget.View'][@text='Premium Payment Mode");
	public static By clickHalfYearly=By.xpath("//*[@class='android.view.View'][@text='Half Yearly']");
	public static By calculateBenefitBtn=By.xpath("//*[@class='android.widget.Button'][@text='CALCULATE BENEFIT']");
	public static By nxtBtn=By.xpath("//*[@class='android.widget.Button'][@text='NEXT']");
	public static By txtYourPlanSynopsis=By.xpath("//*[@class='android.view.View'][@text='YOUR PLAN SYNOPSIS']");
	public static By txtPersonalDetails=By.xpath("//*[@class='android.view.View'][@text=''Personal Details]");
	public static By clickSelect=By.xpath("//*[@class='android.view.View'][@text='Select']");
	public static By txtFatherName=By.xpath("//*[@class='android.widget.EditText']");
	public static By txtMotherName=By.id("_label-23");
	public static By clickBtn=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button\r\n" + "");
	public static By txtPlanSynopsis=By.xpath("//*[@class='android.view.View][@text='YOUR PLAN SYNOPSIS']");
	
	
	
	public static By popUpNtwrkissue=By.xpath("//*[@class='android.view.View'][@text='Network Issue !']");
	public static By okBtn=By.xpath("//*[@class='android.widget.Button'][@text='OK']");
	
	
	
	
	
	
	
	
	
	
	
	/* HealthJinn */
    public static By clickCancelBtn=By.id("com.google.android.gms:id/cancel");
    public static By enterMobileNumber=By.id("com.freecharge.android:id/username");
    public static By clickContinueBtn=By.id("com.freecharge.android:id/submit");
    public static By submitBtn=By.xpath("//*[@text='SUBMIT']");


    //public static By clickSignIn= By.id("com.phonepe.app:id/tv_already_have_account_sign_in");
    public static By clickForgot= By.id("com.phonepe.app:id/tv_verifyuser_forgot");
    public static By clickContinue=By.id("com.phonepe.app:id/confirm");
    public static By resetText=By.id("com.phonepe.app:id/tv_forget_password_dialog_title");
    public static By clickShowTxt=By.id("com.phonepe.app:id/tv_new_password_show");
    public static By waitForNotification=By.xpath("//*[contains(@text,'is your PhonePe password reset code.')]");


    public static By getStartedTxt=By.id("com.ubercab.uberlite:id/ub__lite_get_started_button");
    public static By visibleTxt=By.xpath("//*[@class='android.view.View' and @text='Enter your phone number(required)']");
    public static By typeMobileNo=By.xpath("//*[@class='android.webkit.WebView'][@class='android.view.View' and @id='answerForm'][@class='android.widget.EditText'and @id='mobile']");
    public static By waitForEmailTxt=By.id("com.amhi.healthjinn:id/email");
    public static By resendTxt=By.id("resend");
    public static By clickNextBtn1=By.xpath("//*[@class='android.view.View'][@class='android.widget.Button'and @text='Next']");
    public static By smsOtp=By.id("smsOTP");
   // public static By nextBtn=By.id("com.amhi.healthjinn:id/btnNext");
    public static By loginViaOtpLnk=By.xpath("//*[@text='Login using OTP']");
    public static By emailTxt=By.xpath("//*[@text='Phone Number / Email Id']");
    public static By enterEmail=By.id("com.amhi.healthjinn:id/email");
    public static By enterpassword=By.id("com.amhi.healthjinn:id/password");
    public static By clickLoginBtn=By.id("com.amhi.healthjinn:id/login");
    public static By sendOtpLink=By.xpath("//*[@text='SEND OTP']");
    public static By visibleOtpTxt=By.id("com.amhi.healthjinn:id/otp_desc");
    public static By otpText1=(By.id("com.amhi.healthjinn:id/text_1"));
    public static By otpText2=(By.id("com.amhi.healthjinn:id/text_2"));
    public static By otpText3=(By.id("com.amhi.healthjinn:id/text_3"));
    public static By otpText4=(By.id("com.amhi.healthjinn:id/text_4"));
    public static By clickOkBtn=By.id("com.amhi.healthjinn:id/btnRight");
    public static By clickOtpLogin=By.xpath("//*[@text='OTP LOGIN']");
    public static By waitForMoreTab=By.id("com.amhi.healthjinn:id/more");
    public static By verbiageIncorrectPwd=By.id("com.amhi.healthjinn:id/msg");
    public static By clickMyAccount=By.xpath("//*[@text='My Account']");
    public static By clickLogOut=By.id("com.amhi.healthjinn:id/logout");
    public static By waitMyAccount=By.xpath("//*[@text='My Account']");
    public static By visibleMsg=By.id("com.amhi.healthjinn:id/msg");
    public static By errorTxt=By.xpath("//*[@text='Please fill valid details to proceed.']");
    public static By acceptBtn=By.xpath("//*[@class='android.widget.TextView'][@text='ACCEPT']");
    public static By healthJinnTxt=By.xpath("//*[@text='HealthJinn']");
    public static By connectWithGF=By.id("com.amhi.healthjinn:id/connectWithGF");
}
