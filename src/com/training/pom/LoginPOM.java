package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPOM {
	public LoginPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//######################################################################################
//  Applicaiton Login with Valid UserID and Password
//######################################################################################
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	
//######################################################################################
//  Forget Password Test Case
//######################################################################################
		
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/main/auth/lostPassword.php']")
	private WebElement forgetPassword; 
	
	@FindBy(id="lost_password_user")
	private WebElement lostpwdtestbox;	
	
	@FindBy(id="lost_password_submit")
	private WebElement lostpwsubmit;
	
	@FindBy(xpath  = "//div[@class='alert alert-info']")
	private WebElement forgetAleartMessage;
	
//######################################################################################
//  //  User Registering the Application as New User - Role - Teacher
//######################################################################################
	
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/main/auth/inscription.php']")
	private WebElement RegisterNewUserClick; 
	@FindBy(id="registration_firstname")
	private WebElement enterRegisterFirstName;	
	
	@FindBy(id = "registration_lastname")
	private WebElement enterRegisterLastName;
	
	@FindBy(id = "registration_email")
	private WebElement enterRegisterEmail;
	
	@FindBy(id = "username")
	private WebElement enterUserName;
	
	@FindBy(id = "pass1")
	private WebElement enterPassword1;
	
	@FindBy(id = "pass2")
	private WebElement enterPassword2;
	
	@FindBy(id = "registration_phone")
	private WebElement enterPhone;
	
	@FindBy(xpath = "//select[@id = 'registration_language']")
	private WebElement dropDownLanguage;
		
	@FindBy(xpath = "//p[contains(text(),'Teach courses')]")
	private WebElement RegistrationRole;
		
	@FindBy(id = "registration_submit")
	private WebElement RegistratioSubmit;
	//p[contains(text(),'An e-mail has been sent to remind you of your logi')]
	
	@FindBy(xpath = "//p[contains(text(),'An e-mail has been sent to remind you of your logi')]")
	private WebElement RegistratioMessage;
		
	
//######################################################################################
//  Applicaiton Login with Valid UserID and Password
//######################################################################################
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 		
	}
	
	
//######################################################################################
//  Forget Password Test Case
//######################################################################################
	
	public void clickForgottn() {
		this.forgetPassword.click(); 		
	}
	
	public void lostPwd(String lostpwd) {
		this.lostpwdtestbox.sendKeys(lostpwd); 
	}
	
	public void submitForgottn() {
		this.lostpwsubmit.click(); 	
		
	}
	
	public void ForgetPasswordMessage() {
	String actualMessage = 	this.forgetAleartMessage.getText();
	String expectedMessage = "This platform was unable to send the email. Please contact Admin User for more information.";
	Assert.assertEquals(actualMessage, expectedMessage);
	System.out.println();			
	}
//######################################################################################
//  User Registering the Application as New User - Role - Teacher
//######################################################################################
	public void RegisterNewUserLinkClick() {
		this.RegisterNewUserClick.click(); 
		 
	}
	
	public void RegisterEnterFirstName(String enterRegisterFirstName) {
		this.enterRegisterFirstName.clear();
		this.enterRegisterFirstName.sendKeys(enterRegisterFirstName);
		
	}
		
	public void RegisterEnterLastName(String enterRegisterLastName) {
		this.enterRegisterLastName.clear();
		this.enterRegisterLastName.sendKeys(enterRegisterLastName);
		
	}
	public void RegisterEnterEmail(String enterRegisterEmail) {
		this.enterRegisterEmail.clear();
		this.enterRegisterEmail.sendKeys(enterRegisterEmail);			
				
	}	
		
	public void RegisterUserName(String enterUserName) {
		this.enterUserName.clear();
		this.enterUserName.sendKeys(enterUserName);
				
	}	
	
	public void RegisterPassword1(String enterPassword1) {
		this.enterPassword1.clear();
		this.enterPassword1.sendKeys(enterPassword1);
				
	}	
	
	public void RegisterPassword2(String enterPassword2) {
		this.enterPassword2.clear();
		this.enterPassword2.sendKeys(enterPassword2);
				
	}	
		
	public void RegisterPhone(String enterPhone) {
		this.enterPhone.clear();
		this.enterPhone.sendKeys(enterPhone);
				
	}	
	
	public void RegisterSlectLanguage(String selectLanguage) {
		WebElement dropDownWindow = this.dropDownLanguage;
		Select sel = new Select(dropDownWindow); 
		sel.selectByValue(selectLanguage);
	}
	
	public void RegisterRole() {
		this.RegistrationRole.click();
	}
		
	public void RegisterSubmit() {
		this.RegistratioSubmit.click();
				
	}	
	
	public void RegisterMessage(String RegistratioMessage) {
		
		String actualNewRegistrationMessage = this.RegistratioMessage.getText();
		String expectNewRegistrationMessage = "An e-mail has been sent to remind you of your login and password.";
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualNewRegistrationMessage, expectNewRegistrationMessage);
		System.out.println("Next Step");
		softassert.assertAll();
		
		
		
	}

	
}
