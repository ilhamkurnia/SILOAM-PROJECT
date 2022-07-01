package com.siloam.cucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.siloam.cucumber.driver.DriverSingleton;

public class ViewExportPage {
	private WebDriver driver;
	
	public ViewExportPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement sidebarViewExport;
	
	@FindBy(id="date1")
	private WebElement startDate;
	
	@FindBy(id="date2")
	private WebElement endDate;
	
	@FindBy(css="#content > form > div > div:nth-child(3) > div > button")
	private WebElement btnFilter;
	
	@FindBy(css="#content > div:nth-child(12) > div:nth-child(1) > form > button")
	private WebElement btnExport;
	
	public void ExportData() {
		sidebarViewExport.click();
		startDate.sendKeys("2022-06-15");
		startDate.sendKeys(Keys.RETURN);
		endDate.sendKeys("2022-07-01");
		endDate.sendKeys(Keys.RETURN);
		btnFilter.click();
		btnExport.click();
	}
	
	public static Select selectDropdown(WebElement driver) {
		 Select select = new Select(driver);
		 return select;
	}

}
