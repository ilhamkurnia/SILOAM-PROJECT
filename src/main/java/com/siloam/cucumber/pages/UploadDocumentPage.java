package com.siloam.cucumber.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.siloam.cucumber.driver.DriverSingleton;

public class UploadDocumentPage {
	
private static WebDriver driver;
	
	public UploadDocumentPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/a")
	private WebElement btnNew;
	
	@FindBy(xpath = "//*[@id=\"table\"]/tbody/tr[1]/td[7]/center")
	private WebElement btnView;
	
	@FindBy(css = "#content > div.row > div > ul > li:nth-child(2)")
	private WebElement txtUploadDocument;
	
	@FindBy(css= "#default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(4)")
	private WebElement txtLengkapiDokument;
	
	@FindBy (css= " #default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(4) > tr > td > div.alert.alert-success.alert-dismissable.hilang_notif > strong")
	private WebElement txtDokumentLengkap;

	@FindBy(css = "#modal_form > div > div > div.modal-header > h4")
	private WebElement txtUploadFotoHalaman;
	
	@FindBy(css = "#file")
	private WebElement inputFile;
	
	@FindBy(css = "#message")
	private WebElement txtMassageValidasiImage;
	
	@FindBy(css = "#error")
	private WebElement txtMassageValidasiImage2;
	
	@FindBy(css = "body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-text")
	private WebElement txtBerhasilUpload;
	
	@FindBy(css = "#default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > a > span")
	private WebElement btnFotoFaskesAwal;
	
	@FindBy(css = "#default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a > span")
	private WebElement btnFotoFaskesTujuan;
	
	@FindBy(css = "#default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > a > span")
	private WebElement btnFotoTTD;
	
	@FindBy(css = "#modal_form > div > div > div.modal-footer > button.btn.btn-danger.pull-left")
	private WebElement btnCancelImg;
	
	@FindBy(css = "#btnSave")
	private WebElement btnSaveImage;
	
	@FindBy(css = "#modal_form > div > div > div.modal-header > button > span")
	private WebElement btnX;
	
	@FindBy(css = "#default-tab-2 > div:nth-child(2) > div > table > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div > input[type=hidden]")
	private WebElement imgFFA; 
	
	@FindBy(xpath= "//*[@id=\"default-tab-2\"]/div[1]/div/table/tbody[2]/tr[1]/td[1]/div/input")
	private WebElement imgFFT;
	
	@FindBy(xpath = "//*[@id=\"default-tab-2\"]/div[1]/div/table/tbody[3]/tr[1]/td[1]/div/input")
	private WebElement imgFTTD;
	
	@FindBy(css = "body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-footer > div > button")
	private WebElement btnOkSaveImg;
	
	@FindBy(css = "#default-tab-2 > div:nth-child(4) > div > div")
	private WebElement btnSelanjutnya;
	
	@FindBy(className = "modal fade show\"")
	private WebElement modal;
	
	
	public void view() {
		btnNew.click();
		btnView.click();
	}
	
	
// Get Element
	public WebElement imgFFA () {
		return imgFFA;
	}
	
	public WebElement imgFFT () {
		return imgFFT;
	}
	
	public WebElement imgFTTD () {
		return imgFTTD;
	}
	
	
	
// Get Text
	public String getHalamanUpDoc () {
		return txtUploadDocument.getText();
	}
	
	public String getLengkapiDocument() {
		return txtLengkapiDokument.getText();
	}
	
	public String getDocumentLengkap() {
		return txtDokumentLengkap.getText();
	}
	
	public String getFotoHalaman() {
		bacaModal(modal);
		return txtUploadFotoHalaman.getText(); 	
	}
	
	public String getMassageValidasiImage() {
		bacaModal(modal);
		return txtMassageValidasiImage.getText();
	}
	
	public String getMassageValidasiImage2() {
		bacaModal(modal);
		return txtMassageValidasiImage2.getText();
	}
	
	public String getBerhasilUploadImg() {
		return  txtBerhasilUpload.getText();
	}
	
	
// get fiture
	public void fotoFaskesAwal() {
		btnFotoFaskesAwal.click();
	}
	
	public void fotoFaskesTujuan() {
		btnFotoFaskesTujuan.click();
	}
	
	public void fotoTTD() {
		btnFotoTTD.click();
	}
	
	public void chooseFile(String img) {
		bacaModal(modal);
		inputFile.sendKeys(img);
		tutupModal();
	}
	
	public void btnSaveImg() {
		btnSaveImage.click();
	}
	
	public void btnOK () {
		btnOkSaveImg.click();
		}
	
	public void btnCancelImg() {
		btnCancelImg.click();
	}
	
	public void btnSelanjutnya() {
		btnSelanjutnya.click();
	}
	
	public void btnX() {
		btnX.click();
	}

	
//Method
	public static void bacaModal (WebElement params) {
		try { driver.switchTo().frame(params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void tutupModal () {
		try { driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
