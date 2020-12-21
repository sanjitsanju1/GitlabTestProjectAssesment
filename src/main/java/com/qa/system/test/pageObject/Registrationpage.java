package com.qa.system.test.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.system.test.helper.browserConfiguration.config.ObjectReader;
import com.qa.system.test.helper.logger.LoggerHelper;
import com.qa.system.test.helper.wait.WaitHelper;
import com.qa.system.test.testbase.TestBase;

public class Registrationpage {
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(Registrationpage.class);
	WaitHelper waithelper;
	@FindBy(xpath="//a[contains(text(),'Register now')]") WebElement register;
	@FindBy(xpath="//input[@id='new_user_first_name']")WebElement ent_firstName;
	@FindBy(xpath="//input[@id='new_user_last_name']") WebElement ent_lastName;
	@FindBy(xpath="//input[@id='new_user_username']")WebElement ent_username;
	@FindBy(xpath="//input[@id='new_user_email']")WebElement ent_Email;
	@FindBy(xpath="//input[@id='new_user_password']")WebElement ent_password;
	@FindBy(xpath="//body/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[9]/input[1]")WebElement clickon_registerButton;
	
public Registrationpage(WebDriver driver) {
	this.driver=driver;
	waithelper=new WaitHelper(driver);
	PageFactory.initElements(driver, this);
	waithelper.waitForElement(clickon_registerButton, ObjectReader.reader.getExplicitWait());
	new TestBase().getNavigationScreen(driver);
	TestBase.logExtentReport("new Registarion page is created");
}
public void logExtentReport(String s) {
	TestBase.test.log(Status.INFO,s);
}
public void Enter_Firstname(String firstname)
{
	log.info("Entering the first name");
	logExtentReport("Entering the first name......"+firstname);
	this.ent_firstName.sendKeys(firstname);
}
public void Enter_lastname(String lastname)
{
	log.info("Entering the last name");
	logExtentReport("Entering the last name......"+lastname);
	this.ent_lastName.sendKeys(lastname);
}
public void Enter_username(String username)
{
	log.info("Entering the valid username");
	logExtentReport("Entering the valid username......"+username);
	this.ent_username.sendKeys(username);
}
public void Enter_password(String password)
{
	log.info("Entering the valid password");
	logExtentReport("Entering the valid password......"+password);
	this.ent_password.sendKeys(password);
}
public void Enter_email(String email)
{
	log.info("Entering the valid email id");
	logExtentReport("Entering the valid email id......"+email);
	this.ent_Email.sendKeys(email);
}
public void click_RegisterBitton()
{
	this.clickon_registerButton.click();
}
}
