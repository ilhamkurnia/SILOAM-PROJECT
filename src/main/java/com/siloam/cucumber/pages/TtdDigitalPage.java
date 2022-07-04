package com.siloam.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.siloam.cucumber.driver.DriverSingleton;

public class TtdDigitalPage {

private WebDriver driver;
	
	public TtdDigitalPage() {
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
	
	@FindBy(css = "#content > div.alert.alert-success.alert-dismissible.fade.show")
	private WebElement txtBerhasilInput;
	
	@FindBy(id="ktp_city")
	private WebElement selectCity;
	
	@FindBy(css="#select2-ktp_city-container")
	private WebElement selectCity1;
	
	@FindBy(id="destination_faskes")
	private WebElement selectFaskesTujuan;
	
	@FindBy(css ="#select2-destination_faskes-container")
	private WebElement selectFaskesTujuan2;
	
	@FindBy(id="reason")
	private WebElement inputAlasan;
	
	@FindBy(css="#btnEdit")
	private WebElement btnEdit;

	@FindBy(css="#btnUpdate")
	private WebElement btnSimpan;
	
	@FindBy(css="#btnCancelUpdate")
	private WebElement btnCancel;
	

	//get elemen 

	public String namaValue () {
		return inputNama.getAttribute("value");
	}
	
	public String bpjsValue () {
		return inputNoBPJS.getAttribute("value");
	}
	
	public String ktpValue () {
		return inputNoKTP.getAttribute("value");
	}
	
	public String alamatValue () {
		return inputAddress.getAttribute("value");
	}
	
	public String kotaKtpTitle () {
		return selectCity1.getAttribute("title");
	}
	
	public String faskesAwalValue () {
		return inputFaskesAwal.getAttribute("value");
	}
	
	public String faskesTujuanTitle () {
		return selectFaskesTujuan2.getAttribute("title");
	}
	
	public String alasanValue () {
		return inputAlasan.getText();
	}
	
	public boolean alasanIsDisplay () {
		return inputAlasan.isDisplayed() ;
	}
	
	
	//get fungsion
	public void editNama(String nama) {
		btnEdit.click();
		inputNama.clear();
		inputNama.sendKeys(nama);
		btnSimpan.click();
	}
	
	public void editNomerBPJS (String bpjs) {
		btnEdit.click();
		inputNoBPJS.clear();
		inputNoBPJS.sendKeys(bpjs);
		btnSimpan.click();
	}

	public void editNomerKTP (String ktp) {
		btnEdit.click();
		inputNoKTP.clear();
		inputNoKTP.sendKeys(ktp);
		btnSimpan.click();
	}
	
	public void editAlamat (String alamat) {
		btnEdit.click();
		inputAddress.clear();
		inputAddress.sendKeys(alamat);
		btnSimpan.click();
	}
	
	public void editKotaKtp (String kotaKTP) {
		btnEdit.click();
		select(selectCity).selectByVisibleText(kotaKTP);
	}
	
	public void editFaskesAwal (String faskesAwal){
		btnEdit.click();
		inputFaskesAwal.clear();
		inputFaskesAwal.sendKeys(faskesAwal);
		btnSimpan.click();
	}
	
	public void editFaskesTujuan (String faskesTujuan) {
		btnEdit.click();
		select(selectFaskesTujuan).selectByVisibleText(faskesTujuan);
	}
	
	public void editAlasan (String alasan){
		btnEdit.click();
		inputAlasan.clear();
		inputAlasan.sendKeys(alasan);
		btnSimpan.click();
	}
	
	public void simpanData () {
		btnSimpan.click();
	}

	public void cancelEditNomerBPJS (String bpjs) {
		btnEdit.click();
		inputNoBPJS.clear();
		inputNoBPJS.sendKeys(bpjs);
		btnCancel.click();
	}
	
	public static Select select (WebElement params) {
		Select select = new Select(params);
		return select;
		}
	
}
