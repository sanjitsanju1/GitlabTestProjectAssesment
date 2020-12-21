package com.qa.system.test.testScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.system.test.helper.assertion.AssertionHelper;
import com.qa.system.test.helper.assertion.VerificationHelper;
import com.qa.system.test.helper.browserConfiguration.config.ObjectReader;
import com.qa.system.test.helper.logger.LoggerHelper;
import com.qa.system.test.pageObject.Registrationpage;
import com.qa.system.test.testbase.TestBase;

public class RegistrationpageTest extends TestBase {
	
		 WebDriver driver;
		 AssertionHelper AssertionHelper;
		 VerificationHelper VerificationHelper;

		private final Logger log=LoggerHelper.getLogger(RegistrationpageTest.class);
		@Test
		public void TestLoginToapplication() throws InterruptedException {
			
			getApplicationUrl(ObjectReader.reader.getUrl());
			Thread.sleep(6000);
			try { 
				Registrationpage Registrationpage = new Registrationpage(driver);
			boolean status=VerificationHelper.isDisplayed(driver.findElement(By.xpath("//a[contains(text(),'Register now')]")));
			if(status=true) {
			Registrationpage.Enter_Firstname("sanjit ");
			Thread.sleep(1000);
			Registrationpage.Enter_lastname("sahoo");
			Registrationpage.Enter_username("sajnassn@12");
			Thread.sleep(1000);
			Registrationpage.Enter_email("sanjitsahii@gmail.com");
			Registrationpage.Enter_password("phpjavaselenium12");
			Thread.sleep(1000);
			Registrationpage.click_RegisterBitton();
			}
			else 
			{
				log.info("registation is not complete");
			}
			
				
			} catch (Exception e) {
				
			}
			
		}
		
	}		

