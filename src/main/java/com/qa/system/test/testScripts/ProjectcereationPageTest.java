package com.qa.system.test.testScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.system.test.helper.assertion.AssertionHelper;
import com.qa.system.test.helper.assertion.VerificationHelper;
import com.qa.system.test.helper.browserConfiguration.config.ObjectReader;
import com.qa.system.test.helper.logger.LoggerHelper;
import com.qa.system.test.pageObject.ProjectCreationpage;
import com.qa.system.test.pageObject.Registrationpage;
import com.qa.system.test.testbase.TestBase;

public class ProjectcereationPageTest extends TestBase {
	
		 WebDriver driver;
		 AssertionHelper AssertionHelper;
		 VerificationHelper VerificationHelper;

		private final Logger log=LoggerHelper.getLogger(ProjectcereationPageTest.class);
		@Test
		public void TestLoginToapplication() throws InterruptedException {
			
			getApplicationUrl(ObjectReader.reader.getUrl());
			ProjectCreationpage projectcreation = new ProjectCreationpage(driver);
			boolean status=VerificationHelper.isDisplayed(driver.findElement(By.xpath("//p[contains(text(),'Projects are where you store your code, access iss')]")));
			if(status=true) {
				projectcreation.clickonnewproject();
				projectcreation.clickonA_blankproject();
				projectcreation.Enter_projectname("selenium");
				projectcreation.Enter_project_sludge("SeleniumwithJava");
				projectcreation.clickon_private_button();
				projectcreation.clickon_createProjectButton();
			}
			else {
				log.info("project creation failed");
			}
}}
