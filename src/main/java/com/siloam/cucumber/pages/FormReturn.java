package com.siloam.cucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.siloam.cucumber.driver.DriverSingleton;

public class FormReturn {
	
private WebDriver driver;
	
	public FormReturn() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a")
	private WebElement sidebarNew;
	
	@FindBy(id = "tgl")
	private WebElement tglAwal;
	
	@FindBy(id = "tgl2")
	private WebElement tglAkhir;
	
	@FindBy(id = "status")
	private WebElement status;
	
	@FindBy(id = "btn-filter")
	private WebElement btnFilter;
	
	@FindBy(id = "btn-reset")
	private WebElement btnReset;
	
	@FindBy(css = "#table > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement txtFormReturnPending;
	
	@FindBy(css = "#table > tbody > tr > td")
	private WebElement txtFormReturnComplete;
	
	
	@FindBy(css = "#table_filter > label > input")
	private WebElement search;
	
	@FindBy(id = "btnSearch")
	private WebElement btnSearch;
	
	@FindBy(css = "#table > tbody > tr > td:nth-child(7) > center > a > span")
	private WebElement btnAksi;
	
	
	@FindBy(css = "#content > ol > li.breadcrumb-item.active")
	private WebElement halamanTandaTangan;
	
	
	
	public void ReturnFormPending() {
		sidebarNew.click();
		tglAwal.sendKeys("2022-06-29");
		tglAwal.sendKeys(Keys.RETURN);
		tglAkhir.sendKeys("2022-06-30");
		tglAkhir.sendKeys(Keys.RETURN);
		selectDropdown(status).selectByValue("pending");
		btnFilter.click();
	}
	
	public void ReturnFormComplete() {
		tglAwal.sendKeys("2022-06-15");
		tglAwal.sendKeys(Keys.RETURN);
		tglAkhir.sendKeys("2022-06-27");
		tglAkhir.sendKeys(Keys.RETURN);
		selectDropdown(status).selectByValue("complete");
		btnFilter.click();
	}
	
	public void SearchData() {
		tunggu(3);
		btnReset.click();
		tunggu(3);
		search.sendKeys("samuel");
		tunggu(3);
		btnSearch.click();
		tunggu(3);
		btnAksi.click();
		
	}
	
	public static Select selectDropdown(WebElement driver) {
		 Select select = new Select(driver);
		 return select;
	}
	
	public String getTxtFormReturnPending() {
		return txtFormReturnPending.getText();
	}
	
	public String getTxtFormReturnComplete() {
		return txtFormReturnComplete.getText();
	}
	
	public String getTxtHalamanTandaTangan() {
		return halamanTandaTangan.getText();
	}
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
