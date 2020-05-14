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
import com.training.pom.LoginPOMMedium;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTestsMedium {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOMMedium LoginPOMMedium;
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
		LoginPOMMedium = new LoginPOMMedium(driver); 
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
	

   @Test (priority =4)//TO verify whether application allows teacher to review, rate & send email about the test
	public void ELTC_036() throws InterruptedException {
		LoginPOMMedium.enterTeacherLoginUserid("damodarnarayanat");
		LoginPOMMedium.enterTeacherLoginPassword("Damodar@t");
	   	LoginPOMMedium.TClickOnLogin();
	   	LoginPOMMedium.TClickOnCouse();
	   	LoginPOMMedium.TClickTest36();
	   	LoginPOMMedium.TClickOnResultsFeedback();
	  	LoginPOMMedium.TclickOnClickGradeActivity();
	  	LoginPOMMedium.TclickOnClickSendemail();
	  	Thread.sleep(3000);
	  	LoginPOMMedium.TclickOnCorrectTest();	  			   	
		Thread.sleep(6000);		
		LoginPOMMedium.TMessageSent();	
		screenShot.captureScreenShot("ELTC_036");
	   }
	
	@Test (priority =5)//TO verify whether application allows teacher to Report & send mail to student about the test submitted
	public void ELTC_037() throws InterruptedException {
		LoginPOMMedium.enterTeacherLoginUserid("damodarnarayanat");
		LoginPOMMedium.enterTeacherLoginPassword("Damodar@t");
	   	LoginPOMMedium.TClickOnLogin();
	   	LoginPOMMedium.TClickOnReportingLink();
	   	LoginPOMMedium.TClickOnSearchUser("student_damodar");
	   	LoginPOMMedium.TClickOnSearchSubmit();
	   	LoginPOMMedium.TClickOnStudentDetails();
	   	LoginPOMMedium.TClickOnCourseDetails();
	   	LoginPOMMedium.TClickOnTest();
	   	LoginPOMMedium.TclickOnClickSendemail();
	  	Thread.sleep(3000);
	  	LoginPOMMedium.TclickOnCorrectTest();	  			   	
		Thread.sleep(6000);			
		LoginPOMMedium.TMessageSent();
		screenShot.captureScreenShot("ELTC_037");
		
	   }
	
	  @Test (priority =6)//TO verify whether application allows teacher to generate report based on the student
	  public void ELTC_039() throws InterruptedException {
		LoginPOMMedium.enterTeacherLoginUserid("damodarnarayanat");
		LoginPOMMedium.enterTeacherLoginPassword("Damodar@t");
		LoginPOMMedium.TClickOnLogin();
		LoginPOMMedium.TClickOnReportingLink();
		LoginPOMMedium.TClickOnfollowedStudents();
	   	LoginPOMMedium.TClickOnStudentDetails();
	   	LoginPOMMedium.TClickOnCourseDetails();
		LoginPOMMedium.TClickOnTest();
	   	LoginPOMMedium.TclickOnClickSendemail();
	  	Thread.sleep(3000);
	  	LoginPOMMedium.TclickOnCorrectTest();	  			   	
		Thread.sleep(6000);			
		LoginPOMMedium.TMessageSent();
		screenShot.captureScreenShot("ELTC_039");		
	   }
}