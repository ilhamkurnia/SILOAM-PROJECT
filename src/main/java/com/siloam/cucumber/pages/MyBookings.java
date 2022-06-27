package com.siloam.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.siloam.cucumber.driver.DriverSingleton;

public class MyBookings {

private WebDriver driver;
	
	public MyBookings() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[2]/a/i")
	private WebElement btnMenu;
	
	public void goToMenu() {
		btnMenu.click();
	}
	
	public String getTitleMyBookings() {
		return driver.getTitle();
	}
	
}
