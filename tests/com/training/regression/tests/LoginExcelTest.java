package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM LoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new LoginPOM (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	//@AfterMethod
	//public void tearDown() throws Exception {
		//driver.quit();
	//}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(
		String userName, String password,String enterCoursename,String enterCoursecode,String enterIntroductionText,String titleDescriptionIcon,
		String enterStudentUserID ,String enterStudentPassword,String searchCourseCatalog) throws InterruptedException {
		LoginPOM.enterTeacherLoginUserid(userName);
		LoginPOM.enterTeacherLoginPassword(password);
		LoginPOM.TClickOnLogin();
		LoginPOM.createACourse();
		LoginPOM.enterCoursename(enterCoursename);
		LoginPOM.clickOnAdvanceSettings();
		LoginPOM.selectCategory();
		LoginPOM.enterCategoryName("Project");
		LoginPOM.clickCategory();
		LoginPOM.enterCoursecode(enterCoursecode);
		LoginPOM.clickCreateThisCourse();
		LoginPOM.clickAddanintroduction();
		List<WebElement> enterIntroduction = driver.findElements(By.tagName("iframe"));
	    int count = enterIntroduction.size();
	    System.out.println("No of frames " + count);
		driver.switchTo().frame(0);
		LoginPOM.enterIntroductionText(enterIntroductionText);
		driver.switchTo().defaultContent();
		LoginPOM.saveIntroductionText();
		LoginPOM.clickCourseDescription();
		LoginPOM.clickDescriptionIcon();
		screenShot.captureScreenShot(userName);		
		List<WebElement> enterDescription = driver.findElements(By.tagName("iframe"));
	    int Description = enterDescription.size();
	    System.out.println("No of frames " + Description);
		driver.switchTo().frame(0);
		LoginPOM.enterIntroductionText(enterIntroductionText);
		driver.switchTo().defaultContent();
		LoginPOM.titleDescriptionIcon(titleDescriptionIcon);
		LoginPOM.saveDescriptionIcon();
		LoginPOM.clickOnProfile();
		LoginPOM.logOutTeacher();
//StudentLogin
		LoginPOM.enterStudentUserID(enterStudentUserID);
		LoginPOM.enterStudentPassword(enterStudentPassword);	
		LoginPOM.clickStudentLogin();
		LoginPOM.clickCourseCatalog();
		LoginPOM.searchCourseCatalog(searchCourseCatalog);
		LoginPOM.clickSearchCatalog();
		LoginPOM.subscribeCourse();
		LoginPOM.myCourses();
		Thread.sleep(3000);
    	LoginPOM.clickCourses();
    	Thread.sleep(3000);
    	LoginPOM.clickCourseDescription();
    	LoginPOM.clickStudentDescriptionlink();
    	LoginPOM.verifyStudentDescriptionText();
				
		
	}

}