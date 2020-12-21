package com.qa.system.test.testScripts;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.system.test.helper.assertion.AssertionHelper;
import com.qa.system.test.helper.browserConfiguration.config.ObjectReader;
import com.qa.system.test.helper.logger.LoggerHelper;
import com.qa.system.test.helper.wait.WaitHelper;
import com.qa.system.test.pageObject.Loginpage;
import com.qa.system.test.testbase.TestBase;

public class LoginTestwithDatadrivenApproach extends TestBase{
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginTestwithDatadrivenApproach.class);
	WaitHelper waithelper;
	Loginpage login;
	@DataProvider(name="testData")
	public Object[][]testData(){
		Object[][]data=getExcelData("testData.xlsx", "loginData");
		return data;
	}

	
	@Test(dataProvider ="testData" )
	
	public void LoginTest(String userName,String password,String runMode) {
		getApplicationUrl(ObjectReader.reader.getUrl());
		login=new Loginpage(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("Runmode for this set of data is marked n");
		}
		try {
			login.loginToapplication(userName, password);
		boolean status=login.verifysucessfulmsg();
		AssertionHelper.updateTestStatus(status);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		login.logout();
	}
}
