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

public class ProjectCreationpage {
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(ProjectCreationpage.class);
	WaitHelper waithelper;
	@FindBy(xpath="//p[contains(text(),'Projects are where you store your code, access iss')]") WebElement create_a_Project;
	@FindBy(xpath="//h3[contains(text(),'Create blank project')]")WebElement create_A_Blankproject;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]") WebElement enter_projectName;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[3]/div[2]/input[1]")WebElement project_slug;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/a[1]")WebElement create_a_group;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[3]/textarea[1]")WebElement project_description;
	@FindBy(xpath="//body/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[9]/input[1]")WebElement clickon_registerButton;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[4]/div[1]/input[1]")WebElement btn_private;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[4]/div[1]/input[1]")WebElement btn_public;
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/input[3]")WebElement create_project_btn;
	
	
public ProjectCreationpage(WebDriver driver) {
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
public void clickonnewproject() {
	
	this.create_a_Project.click();;
	
}					
public void clickonA_blankproject() {
	
	this.create_A_Blankproject.click();
	
}		
public void Enter_projectname(String value1) {
	
	this.enter_projectName.sendKeys(value1);
	
}
public void Enter_project_sludge(String value2) {
	
	this.project_slug.sendKeys(value2);
	
}		

public void clickon_private_button() {
	
	this.btn_private.click();
	
}		

public void clickon_public_button() {
	
	this.btn_public.click();
	
}		

public void clickon_createProjectButton() {
	
	this.create_project_btn.click();
	
}		







}
