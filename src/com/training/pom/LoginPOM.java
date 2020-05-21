package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPOM {
	WebDriver driver;
	public LoginPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
//######################################################################################
//TC - ELTD_064 - WebElements
//To verify whether application allows teacher to create a course with objective description 
//& topics, student to get register for the course take the test & admin to report
//######################################################################################
	
	@FindBy(id ="login")
	private WebElement enterTeacherUserID; 
	
	@FindBy(id ="password")
	private WebElement enterTeacherPassword; 
	
	@FindBy(id ="form-login_submitAuth")
	private WebElement TclickLogin;
	
	@FindBy(xpath ="//a[contains(text(),'Create a course')]")
	private WebElement createACourse; 
	
	@FindBy(id ="title")
	private WebElement enterCoursename;
	
	@FindBy(id ="advanced_params")
	private WebElement clickOnAdvanceSettings;
	
	@FindBy(xpath ="//*[@id=\"advanced_params_options\"]/div[1]/div[1]/div/button/div/div/div")
	private WebElement selectCategory;
		
	@FindBy(xpath ="//*[@id=\"advanced_params_options\"]/div[1]/div[1]/div/div/div[1]/input")
	private WebElement enterCategoryName;
	
	@FindBy(xpath ="//span[contains(text(),'Projects')]")
	private WebElement clickCategory;
		
	@FindBy(id ="add_course_wanted_code")
	private WebElement enterCoursecode;
		
	@FindBy(xpath="//button[@name = 'submit']")
	private WebElement clickCreateThisCourse;
	
	@FindBy(xpath="//*[@id=\"course_tools\"]/div[1]/div/div[1]/a/em")
	private WebElement clickAddanintroduction;
		
	@FindBy(xpath="//body[@contenteditable = 'true']")
	private WebElement enterIntroductionText;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveIntroductionText;
		
	@FindBy(xpath ="//img[@title ='Course description']")
	private WebElement clickCourseDescription;
		
	@FindBy(xpath ="//img[@title ='Description']")
	private WebElement clickDescriptionIcon;
	
	@FindBy(xpath ="//button[@name='submit']")
	private WebElement saveDescriptionIcon;
	
	@FindBy(id ="course_description_title")
	private WebElement titleDescriptionIcon;
	
	@FindBy(xpath="(//img[@class ='img-circle'])[1]")
	private WebElement clickOnProfile;
	
	@FindBy(id ="logout_button")
	private WebElement logOutTeacher;
	
	
	
//Student Login
	
	@FindBy(id ="login")
	private WebElement enterStudentUserID; 
	
	@FindBy(id ="password")
	private WebElement enterStudentPassword; 
	
	@FindBy(id ="form-login_submitAuth")
	private WebElement clickStudentLogin;
	
	@FindBy(xpath ="//a[contains(text(),'Course catalog')]")
	private WebElement clickCourseCatalog;
			
	@FindBy(xpath ="//input[@name='search_term']")
	private WebElement searchCourseCatalog;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement clickSearchCatalog;
	
	@FindBy(xpath ="//a[@title='Subscribe']")
	private WebElement subscribeCourse;	
	
	@FindBy(xpath ="//a[@title='My courses']")
	private WebElement myCourses;	
	
	@FindBy(xpath ="//a[contains(text(),'Seleniumbatchabc23')]")
	private WebElement clickCourses;
	
	@FindBy(xpath ="//a[contains(text(),'Description')]")
	private WebElement clickStudentDescriptionlink;
	
	@FindBy(xpath ="//p[contains(text(),'This is a Selenium Course')]")
	private WebElement verifyStudentDescriptionText;
	
	
	
	
	
//######################################################################################
//TC - ELTD_064 - Methods
//To verify whether application allows teacher to create a course with objective description 
//& topics, student to get register for the course take the test & admin to report
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

	public void createACourse() {
		this.createACourse.click();		
	}	
	
	public void enterCoursename(String enterCoursename) {
		this.enterCoursename.sendKeys(enterCoursename);	
	}	
	
	public void clickOnAdvanceSettings() {
		this.clickOnAdvanceSettings.click();		
	}	
	
	
	public void selectCategory() {
	this.selectCategory.click();
	}		
	

	public void enterCategoryName(String enterCategoryName) {
	this.enterCategoryName.sendKeys(enterCategoryName);
	}
	
	public void clickCategory() {
	this.clickCategory.click();
	}	
	
	public void enterCoursecode(String enterCoursecode) {
	this.enterCoursecode.sendKeys(enterCoursecode);
	}	
	
	public void clickCreateThisCourse() {
		this.clickCreateThisCourse.click();
	}
	
	public void clickAddanintroduction() {
		this.clickAddanintroduction.click();
	}	
	
	public void enterIntroductionText(String enterIntroductionText) {
        this.enterIntroductionText.sendKeys(enterIntroductionText);
	}
	
	public void saveIntroductionText() {
		this.saveIntroductionText.click();	
	}
	
			
	public void clickCourseDescription() {
		this.clickCourseDescription.click();	
	}
	
	public void clickDescriptionIcon() {
		this.clickDescriptionIcon.click();	
	}
	
	public void titleDescriptionIcon(String titleDescriptionIcon) {
		this.titleDescriptionIcon.sendKeys(titleDescriptionIcon);
	}
	

	public void saveDescriptionIcon() {
		this.saveDescriptionIcon.click();	
	}
	
	public void clickOnProfile() {
		this.clickOnProfile.click();	
	}
	
	public void logOutTeacher() {
		this.logOutTeacher.click();	
	}
		
	
//Student Login
	
	public void enterStudentUserID(String enterStudentUserID) {
		this.enterStudentUserID.sendKeys(enterStudentUserID);		
	}	
	public void enterStudentPassword(String enterStudentPassword) {
		this.enterStudentPassword.sendKeys(enterStudentPassword);		
	}	
	public void clickStudentLogin() {
		this.clickStudentLogin.click();		
	}	
		
   public void clickCourseCatalog() {
	  this.clickCourseCatalog.click();		
    }	
   
   public void searchCourseCatalog(String searchCourseCatalog) {
	  this.searchCourseCatalog.sendKeys(searchCourseCatalog);	  
    }	

   public void clickSearchCatalog() {
	  this.clickSearchCatalog.click();		
	}	
   
   public void subscribeCourse() {
	  this.subscribeCourse.click();		
	}	
	   
   public void myCourses() {
	  this.myCourses.click();		
	}	
   
   public void clickCourses() {
	 this.clickCourses.click();	
	 //driver.findElement(By.xpath("//a[contains(text(),'"+enterCoursename+"')]")).click();
	 }	
   
   public void clickStudentDescriptionlink() {
	  this.clickStudentDescriptionlink.click();		
	}	
   
    
   public void verifyStudentDescriptionText() {
	   String actualMessage =this.verifyStudentDescriptionText.getText();
	   String expectedMessage = "This is a Selenium Course";
	    Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println(actualMessage);	
	   
	}	

   
   
   
}