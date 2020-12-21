package com.qa.system.test.pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.system.test.helper.assertion.VerificationHelper;
import com.qa.system.test.helper.browserConfiguration.config.ObjectReader;
import com.qa.system.test.helper.logger.LoggerHelper;
import com.qa.system.test.helper.wait.WaitHelper;
import com.qa.system.test.testbase.TestBase;

public class Loginpage {
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(Loginpage.class);
	WaitHelper waithelper;
	
	@FindBy(xpath="//input[@id='user_login']") WebElement useraname;
	@FindBy(xpath="//input[@id='user_password']")WebElement password;
	@FindBy(xpath="//h2[contains(text(),'Welcome to GitLab')]") WebElement Welcomemsg;
	@FindBy(xpath="//a[contains(text(),'Sign out')]") WebElement signout;
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/ul[1]/li[8]/a[1]/*[1]")  WebElement r_button;
	@FindBy(xpath="//body/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/input[1]")WebElement Button_signIn;
public Loginpage(WebDriver driver) {
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
	
waithelper.waitForElement(Button_signIn, ObjectReader.reader.getExplicitWait());
	new TestBase().getNavigationScreen(driver);
	TestBase.logExtentReport("new login page is created");
}
public void logExtentReport(String s) {
	TestBase.test.log(Status.INFO,s);
}
//***enter username*****
	public void Ent_Username_email(String username) {
		log.info("Enter the username/emailaddress");
		logExtentReport("entering username......");
		this.useraname.sendKeys(username);
		
}
	//*****Enter Password******	
	public void Ent_password(String password) {
		log.info("Enter valid password");
		logExtentReport("entering password......"+password);
		this.password.sendKeys(password);
	}
	public void  click_ON_SigniIn () {
		log.info("Clicking on signin button.....");
		TestBase.logExtentReport("clicking in signin button....");
		//new JavaScriptHelper(driver).scrollDownVertically();
		this.Button_signIn.click();
	}
	public void loginToapplication(String username,String password) {
		Ent_Username_email(username);
		Ent_password(password);
		click_ON_SigniIn();
	
	}
	public void logout() {
		r_button.click();
		signout.click();
	}
	public boolean verifysucessfulmsg() {
		return new VerificationHelper(driver).isDisplayed(Welcomemsg);
	}
	
	
}
