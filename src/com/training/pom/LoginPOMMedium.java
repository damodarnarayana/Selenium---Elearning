package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPOMMedium {
	public LoginPOMMedium(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
//######################################################################################
//TC - ELTC_036 - WebElements
//TO verify whether application allows teacher to review, rate & send email about the test
//######################################################################################
	
	@FindBy(id ="login")
	private WebElement enterTeacherUserID; 
	
	@FindBy(id ="password")
	private WebElement enterTeacherPassword; 
	
	@FindBy(id ="form-login_submitAuth")
	private WebElement TclickLogin;
	
	@FindBy(xpath ="//*[@id=\"page\"]/div/div[2]/div/div/div[2]/h4/a")
	private WebElement clickCourse; 
	
	@FindBy(xpath ="//img[@title = \"Tests\"]")
	private WebElement clickTests1; 
	
	@FindBy(xpath ="html/body/main/section/div/div[4]/table/tbody/tr/td[3]/a[3]")
	private WebElement clickResultsFeedback;	
	
	@FindBy(xpath ="//*[@id=\"202\"]/td[12]/div/a[1]/img")
	private WebElement clickGradeActivity; 
	
	@FindBy(xpath="//input[@name = \"send_notification\"]")
	private WebElement clickSendemail; 
	
	@FindBy(id="form-email_submit")
	private WebElement clickcorrectTest; 
	
//######################################################################################
//TC - ELTC_037 - WebElements
//TO verify whether application allows teacher to Report & send mail to student about the test submitted
//######################################################################################
	@FindBy(xpath="//a[contains(text(),\"Followed students\")]")
	private WebElement followedStudents; 	
//######################################################################################
//TC - ELTC_039 - WebElements
//TO verify whether application allows teacher to generate report based on the student
//######################################################################################	
	
	@FindBy(xpath="//a[@title = 'Reporting']")
	private WebElement clickReportinglink; 
	
	@FindBy(id="search_user_keyword")
	private WebElement searchUser; 
	
	@FindBy(id="search_user_submit")
	private WebElement clickSearchSubmit;	
	
	@FindBy(id="details_student_damodar")
	private WebElement clickStudentDetails;
	
	@FindBy(xpath="//img[@title = 'Details']")
	private WebElement clickCoursetDetails;
	
	@FindBy(xpath="//img[@title = \"Test\"]")
	private WebElement clickTest2;
	
	@FindBy(xpath = "//div[@class=\"alert alert-info\"]")
	private WebElement messageSent;

//######################################################################################
//TC - ELTC_036 - Methods
//TO verify whether application allows teacher to review, rate & send email about the test
//######################################################################################
	
	public void enterTeacherLoginUserid(String enterTeacherUserID) {
		this.enterTeacherUserID.sendKeys(enterTeacherUserID);		
	}
	
	public void enterTeacherLoginPassword(String enterTeacherPassword) {
		this.enterTeacherPassword.sendKeys(enterTeacherPassword);		
	}
	
	public void TClickOnLogin() {
		this.TclickLogin.click();		
	}
	
	public void TClickOnCouse() {
		this.clickCourse.click();		
	}
	
	public void TClickTest36() {
		this.clickTests1.click();		
	}	
	
	public void TClickOnResultsFeedback() {
		this.clickResultsFeedback.click();		
	}	
	
	public void TclickOnClickGradeActivity() {
		this.clickGradeActivity.click();		
	}	
	
	public void TclickOnClickSendemail() {
		this.clickSendemail.click();		
	}	
	
	public void TclickOnCorrectTest() {
		this.clickcorrectTest.click();
	}	
	
//######################################################################################
//TC - ELTC_037 - Methods
//TO verify whether application allows teacher to Report & send mail to student about the test submitted
//######################################################################################
		
	public void TClickOnfollowedStudents() {
		this.followedStudents.click();		
	}	
//######################################################################################
//TC - ELTC_039 - Methods
//TO verify whether application allows teacher to generate report based on the student
//######################################################################################	
		
	public void TClickOnReportingLink() {
		this.clickReportinglink.click();		
	}	
	
	public void TClickOnSearchUser(String searchUser) {
		this.searchUser.clear();
		this.searchUser.sendKeys(searchUser);
	}	
	
	public void TClickOnSearchSubmit() {
		this.clickSearchSubmit.click();		
	}	
	
	public void TClickOnStudentDetails() {
		this.clickStudentDetails.click();		
	}	
	
	public void TClickOnCourseDetails() {
		this.clickCoursetDetails.click();		
	}	
	
	public void TClickOnTest() {
		this.clickTest2.click();		
	}	
	
	public void TMessageSent() {
		String actualMessage = this.messageSent.getText();
		String expectedMessage = "Message Sent";
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println(actualMessage);		
	}	
	
	
}