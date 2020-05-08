package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test (priority =1)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("damodarnarayana1");
		loginPOM.sendPassword("Damodar@1981");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Third");
		
		Thread.sleep(6000);
	
	}
	
	@Test(priority =2)
	public void validForgetPassword() throws InterruptedException {
		loginPOM.clickForgottn(); 
		loginPOM.lostPwd("damodarnarayana@gmail.com");
		loginPOM.submitForgottn();
		loginPOM.ForgetPasswordMessage();
		screenShot.captureScreenShot("First");
		Thread.sleep(5000);	
	}
	
	@Test(priority =0)
	public void  validTeacherSignUp() throws InterruptedException {	 
		loginPOM.RegisterNewUserLinkClick();
		loginPOM.RegisterEnterFirstName("Damodar");
		loginPOM.RegisterEnterLastName("Manala");
		loginPOM.RegisterEnterEmail("damodarnarayana@gmail.com");
		loginPOM.RegisterUserName("damodarnarayana1");
		loginPOM.RegisterPassword1("Damodar@1981");
		loginPOM.RegisterPassword2("Damodar@1981");
		loginPOM.RegisterPhone("8043007042");
		loginPOM.RegisterSlectLanguage("english");
		Thread.sleep(5000);
		loginPOM.RegisterRole();
		Thread.sleep(5000);
		loginPOM.RegisterSubmit();
		screenShot.captureScreenShot("Second");
	}

}