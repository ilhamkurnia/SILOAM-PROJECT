package com.siloam.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(css = "#page-container > div > div.login-header > div.brand > b")
	private WebElement messageErrorLogin;
	
	public void loginForm(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
	
	public String getMessageErrorLogin() {
		return messageErrorLogin.getText();
	}
}
