package com.qa.system.test.testScripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.system.test.helper.assertion.AssertionHelper;
import com.qa.system.test.helper.assertion.VerificationHelper;
import com.qa.system.test.helper.browserConfiguration.config.ObjectReader;
import com.qa.system.test.helper.logger.LoggerHelper;
import com.qa.system.test.helper.wait.WaitHelper;
import com.qa.system.test.pageObject.Loginpage;
import com.qa.system.test.testbase.TestBase;

public class LoginTest  extends TestBase{
 WebDriver driver;
 

private final Logger log=LoggerHelper.getLogger(LoginTest.class);
@Test(description = "login Test with valid Credintial")
public void TestLoginToapplication() throws InterruptedException   {
	
	
	 
	getApplicationUrl(ObjectReader.reader.getUrl());
	  
	  log.info("url is calling"); 
	  Thread.sleep(6000);
	  
	 
		  try { 
			  Loginpage loginpage = new Loginpage(driver);
				loginpage.Ent_Username_email(ObjectReader.reader.getUserName());
				loginpage.Ent_password(ObjectReader.reader.getPassword());
				loginpage.click_ON_SigniIn();
			 
		
		  boolean status=loginpage.verifysucessfulmsg();
		  
		  AssertionHelper.updateTestStatus(status);
		  
		  
		  } catch (NullPointerException e) {
		  
		  }
		 
	  
		
	  
	  
	  
	  
	 
	
	 
}
}
