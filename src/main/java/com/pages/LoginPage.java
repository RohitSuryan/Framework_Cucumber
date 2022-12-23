package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//	1. By Locators: 
	private By login = By.linkText("Login");
	private By emailId = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//div[text()='Login']");
	private By forgotPwdLink = By.xpath("//a[contains(text(),'Forgot your password?')]");
	
	
	//	2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//	3.  page actions: features(behavior) of the page the form of methods:
	
	public void clickOnLogin() {
		driver.findElement(login).click();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
	}

	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(login).click();
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
	}

	
	
}
