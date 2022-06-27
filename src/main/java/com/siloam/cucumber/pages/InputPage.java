package com.siloam.cucumber.pages;

import java.util.Random;

import org.openqa.selenium.By;
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
	
	
	
	public void inputForm() {
		sidebarInput.click();
		inputNama.sendKeys("ilham kurnia");
		inputNoBPJS.sendKeys(""+getRandomNumber());
		inputNoKTP.sendKeys("1232343535443534");
		inputAddress.sendKeys("JL. pepaya");
		selectDropdown(selectCity).selectByVisibleText("KABUPATEN ACEH BESAR");
		inputFaskesAwal.sendKeys("Jakarta");
		selectDropdown(selectFaskesTujuan).selectByVisibleText("Clinic Meruya || Kota Jakarta Barat");
		alasan.sendKeys("rere cantik");
		btnSubmitInput.click();	
		
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

}
