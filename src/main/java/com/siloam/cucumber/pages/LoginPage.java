package com.siloam.cucumber.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.siloam.cucumber.driver.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#page-container > div > div.login-content > form > div:nth-child(1) > input")
	private WebElement inputEmail;
	
	@FindBy(css = "#page-container > div > div.login-content > form > div:nth-child(2) > input")
	private WebElement inputPassword;
	
	@FindBy(css = "#page-container > div > div.login-content > form > div.login-buttons > button")
	private WebElement btnLogin;
	
	@FindBy(css = "#header > ul > li > a > span")
	private WebElement txtWelcome;
	
	@FindBy(css = "#header > ul > li > a")
	private WebElement ddLogout;
	
	@FindBy(xpath = "//*[@id=\"header\"]/ul/li/div")
	private WebElement btnLogout;
	
	
	
	@FindBy(css = "#page-container > div > div.login-header > div.brand > b")
	private WebElement halamanLogin;
	
	public void loginForm(String email, String password) {
		inputEmail.clear();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
        
	}
	
	public void loginAdminForm(String email, String password) {
		inputEmail.clear();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
        
	}
	
	public void logout() {
		ddLogout.click();
		btnLogout.click();
        
	}
	
	public String getAlertUsername() {
		
		return inputEmail.getAttribute("required");
	}
	
	public String getAlertPassword() {
		return inputPassword.getAttribute("required");
	}
	
//	public boolean isAlertPresent(){
//	    boolean foundAlert = false;
//	    WebDriverWait wait = new WebDriverWait(driver, 0 /*timeout in seconds*/);
//	    try {
//	        wait.until(ExpectedConditions.alertIsPresent());
//	        foundAlert = true;
//	    } catch (TimeoutException eTO) {
//	        foundAlert = false;
//	    }
//	    return foundAlert;
//	}
	
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
	
	public String getHalamanLogin() {
		return halamanLogin.getText();
	}
}
