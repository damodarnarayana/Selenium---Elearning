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
import com.training.pom.LoginPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM2 LoginPOM2;
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
		LoginPOM2 = new LoginPOM2(driver); 
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
	
		screenShot.captureScreenShot("Third");
		
		Thread.sleep(6000);
	
	}
	
	@Test(priority =2)
	public void validForgetPassword() throws InterruptedException {
		LoginPOM2.clickForgottn(); 
		LoginPOM2.lostPwd("damodarnarayana@gmail.com");
		LoginPOM2.submitForgottn();
		LoginPOM2.ForgetPasswordMessage();
		screenShot.captureScreenShot("First");
		Thread.sleep(5000);	
	}
	
	@Test(priority =0)
	public void  validTeacherSignUp() throws InterruptedException {	 
		LoginPOM2.RegisterNewUserLinkClick();
		LoginPOM2.RegisterEnterFirstName("Damodar");
		LoginPOM2.RegisterEnterLastName("Manala");
		LoginPOM2.RegisterEnterEmail("damodarnarayana@gmail.com");
		LoginPOM2.RegisterUserName("damodarnarayana1");
		LoginPOM2.RegisterPassword1("Damodar@1981");
		LoginPOM2.RegisterPassword2("Damodar@1981");
		LoginPOM2.RegisterPhone("8043007042");
		LoginPOM2.RegisterSlectLanguage("english");
		Thread.sleep(5000);
		LoginPOM2.RegisterRole();
		Thread.sleep(5000);
		LoginPOM2.RegisterSubmit();
		screenShot.captureScreenShot("Second");
	}

}