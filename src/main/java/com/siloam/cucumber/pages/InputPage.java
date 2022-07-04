package com.siloam.cucumber.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.siloam.cucumber.driver.DriverSingleton;

public class InputPage {
	
private WebDriver driver;
	
	public InputPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement sidebarInput;
	
	@FindBy(css = "#content > ol > li.breadcrumb-item.active")
	private WebElement halamanInputData ;
	
	@FindBy(id = "name")
	private WebElement inputNama;
	
	@FindBy(id = "no_bpjs")
	private WebElement inputNoBPJS;
	
	@FindBy(id = "no_ktp")
	private WebElement inputNoKTP;
	
	@FindBy(id = "address")
	private WebElement inputAddress;
	
	@FindBy(id = "origin_faskes")
	private WebElement inputFaskesAwal;
	
	@FindBy(css = "#default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > a > span")
	private WebElement txtBerhasilInput;
	
	@FindBy(id="ktp_city")
	private WebElement selectCity;
	
	@FindBy(id="destination_faskes")
	private WebElement selectFaskesTujuan;
	
	@FindBy(id="reason")
	private WebElement alasan;
	
	@FindBy(css="#default-tab-1 > form > div.form-group.row.m-b-0 > div > button")
	private WebElement btnSubmitInput;
	
	public void halamanInputData() {
		sidebarInput.click();
		btnSubmitInput.click();	
	}
	
	public void ValidNama() {
		inputNama.sendKeys("Muhammad Ade Ilham");
	}
	
	public void ValidNoBPJS() {
		inputNoBPJS.sendKeys(""+getRandomNumber());
	}
	
	public void ValidNoKTP() {
		inputNoKTP.sendKeys("1232343535443534");
	}
	
	public void ValidAlamat() {
		inputAddress.sendKeys("JL. pepaya");
	}
	
	public void ValidKotaKTP() {
		selectDropdown(selectCity).selectByVisibleText("KABUPATEN ACEH BESAR");
	}
	
	public void ValidFaskesAwal() {
		inputFaskesAwal.sendKeys("Jakarta");
	}
	
	public void ValidFaskesTujuan() {
		selectDropdown(selectFaskesTujuan).selectByVisibleText("Clinic Meruya || Kota Jakarta Barat");
	}
	
	public void ValidAlasan() {
		alasan.sendKeys("rere cantik");
	}
	
	public void inputForm() {
		btnSubmitInput.click();	
	}
	
	public String getValidateNama() {
		return inputNama.getAttribute("required");
	}
	
	public String getNama() {
		return inputNama.getAttribute("value");
	}
	
	public String getValidateNoBPJS() {
		return inputNoBPJS.getAttribute("required");
	}
	
	public int getNoBPJS() {
		String typedValue = inputNoBPJS.getAttribute("value");
		int size = typedValue.length();
		return size;
	}
	
	public String getValidateNoKTP() {
		return inputNoKTP.getAttribute("required");
	}
	
	public int getNoKTP() {
		String typedValue = inputNoKTP.getAttribute("value");
		int size = typedValue.length();
		return size;
	}
	
	public String getValidateAlamat() {
		return inputAddress.getAttribute("required");
	}
	
	public String getAlamat() {
		return inputAddress.getAttribute("value");
	}
	
	public String getValidateKotaKTP() {
		return selectCity.getAttribute("required");
	}
	
	public String getKotaKTP() {
		return selectCity.getAttribute("value");
	}
	
	public String getValidateFaskesAwal() {
		return inputFaskesAwal.getAttribute("required");
	}
	
	public String getFaskesAwal() {
		return inputFaskesAwal.getAttribute("value");
	}
	
	public String getValidateFaskesTujuan() {
		return selectFaskesTujuan.getAttribute("required");
	}
	
	public String getFaskesTujuan() {
		return selectFaskesTujuan.getAttribute("value");
	}
	
	public String getValidateAlasan() {
		return alasan.getAttribute("required");
	}
	
	public String getAlasan() {
		return alasan.getAttribute("value");
	}
	
	
	
	public String getHalamanInput() {
		return halamanInputData.getText();
	}
	
	public String getValidateNama() {
		return inputNama.getAttribute("required");
	}
	
	public String getNama() {
		return inputNama.getAttribute("value");
	}
	
	public String getValidateNoBPJS() {
		return inputNoBPJS.getAttribute("required");
	}
	
	public int getNoBPJS() {
		String typedValue = inputNoBPJS.getAttribute("value");
		int size = typedValue.length();
		return size;
	}
	
	public String getValidateNoKTP() {
		return inputNoKTP.getAttribute("required");
	}
	
	public int getNoKTP() {
		String typedValue = inputNoKTP.getAttribute("value");
		int size = typedValue.length();
		return size;
	}
	
	public String getValidateAlamat() {
		return inputAddress.getAttribute("required");
	}
	
	public String getAlamat() {
		return inputAddress.getAttribute("value");
	}
	
	public String getValidateKotaKTP() {
		return selectCity.getAttribute("required");
	}
	
	public String getKotaKTP() {
		return selectCity.getAttribute("value");
	}
	
	public String getValidateFaskesAwal() {
		return inputFaskesAwal.getAttribute("required");
	}
	
	public String getFaskesAwal() {
		return inputFaskesAwal.getAttribute("value");
	}
	
	public String getValidateFaskesTujuan() {
		return selectFaskesTujuan.getAttribute("required");
	}
	
	public String getFaskesTujuan() {
		return selectFaskesTujuan.getAttribute("value");
	}
	
	public String getValidateAlasan() {
		return alasan.getAttribute("required");
	}
	
	public String getAlasan() {
		return alasan.getAttribute("value");
	}
	
	
	
	public String getHalamanInput() {
		return halamanInputData.getText();
	}
	
	public String getTxtBerhasilInput() {
		return txtBerhasilInput.getText();
	}
	
	public static Select selectDropdown(WebElement driver) {
		 Select select = new Select(driver);
		 return select;
	}
	
	public long getRandomNumber(){
        // create instance of Random class
        Random rand = new Random();
        // Generate and return Random number with decimal
        long first14 = (rand.nextLong() % 10000000000000000L) + 520000000000000000L;
        return rand.nextLong();
    }
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 300)");
	}

}