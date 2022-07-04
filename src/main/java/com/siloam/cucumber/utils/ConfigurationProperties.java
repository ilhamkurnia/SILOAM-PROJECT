package com.siloam.cucumber.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

// Login
	@Value("${browser}")
	private String browser;
	
	@Value("${emptyUsernamePassword}")
	private String emptyUsernamePassword;
	
	@Value("${usernameSales}")
	private String usernameSales;
	
	@Value("${usernameAdmin}")
	private String usernameAdmin;
	
	@Value("${password}")
	private String password;
	
	@Value("${passwordAdmin}")
	private String passwordAdmin;
	
	@Value("${wrongUsername}")
	private String wrongUsername;
	
	@Value("${wrongPassword}")
	private String wrongPassword;
	
	@Value("${txtWelcome}")
	private String txtWelcome;
	
	@Value("${txtWelcomeAdmin}")
	private String txtWelcomeAdmin;
	
	@Value("${halamanLogin}")
	private String halamanLogin;
	
	@Value("${halamanInputData}")
	private String halamanInputData;
	
	@Value("${halamanTandaTanganDigital}")
	private String halamanTandaTangan;
	
	@Value("${txtBerhasilInput}")
	private String txtBerhasilInput;
	
	@Value("${txtFormReturnPending}")
	private String txtFormReturnPending;
	
	@Value("${txtFormReturnComplete}")
	private String txtFormReturnComplete;
	
	
// Upload Document
	@Value("${txtUpDoc}")
	private String txtUpDoc;
	
	@Value("${txtLengkapiDoc}")
	private String txtLengkapiDoc;
	
	@Value("${txtFotoBefore}")
	private String txtFotoBefore;
	
	@Value("${txtFotoAfter}")
	private String txtFotoAfter;
	
	@Value("${txtFotoTTD}")
	private String txtFotoTTD;
	
	@Value("${txtNoImage}")
	private String txtNoImage;
	
	@Value("${txtImageNotValid}")
	private String txtImageNotValid;
	
	@Value("${txtDocumentLengkap}")
	private String txtDocumentLengkap;
	
	@Value("${imageValid}")
	private String imageValid;
	
	@Value("${txtBerhasilUpload}")
	private String txtBerhasilUpload;
	
	@Value("${imagePng}")
	private String imagePng;
	
	@Value("${imageValid2}")
	private String imageValid2;
	
	@Value("${fileBukanImage}")
	private String fileBukanImage;
	
	@Value("${txtInvalidFile}")
	private String txtInvalidFile;
	
	@Value("${txtImageNotValid2}")
	private String txtImageNotValid2;
	
	
	//tanda tangan digital edit input
	@Value("${nama1}")
	private String nama1;
	
	@Value("${nomerBpjs1}")
	private String nomerBpjs1;
	
	@Value("${nomerBpjs2}")
	private String nomerBpjs2;
	
	@Value("${nomerktp1}")
	private String nomerktp1;
	
	@Value("${alamat1}")
	private String alamat1;
	
	@Value("${kotaKtp1}")
	private String kotaKtp1;
	
	@Value("${kotaKtp2}")
	private String kotaKtp2;
	
	@Value("${faskesAwal1}")
	private String faskesAwal1;

	@Value("${faskesTujuan1}")
	private String faskesTujuan1;

	@Value("${faskesTujuan2}")
	private String faskesTujuan2;
	
	@Value("${alasan1}")
	private String alasan1;
	
	
//Login
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmptyUsernamePassword() {
		return emptyUsernamePassword;
	}

	public void setEmptyUsernamePassword(String emptyUsernamePassword) {
		this.emptyUsernamePassword = emptyUsernamePassword;
	}

	public String getUsernameSales() {
		return usernameSales;
	}

	public void setUsernameSales(String usernameSales) {
		this.usernameSales = usernameSales;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getUsernameAdmin() {
		return usernameAdmin;
	}

	public void setUsernameAdmin(String usernameAdmin) {
		this.usernameAdmin = usernameAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
	

	public String getHalamanLogin() {
		return halamanLogin;
	}

	public void setHalamanLogin(String halamanLogin) {
		this.halamanLogin = halamanLogin;
	}

	public String getHalamanInputData() {
		return halamanInputData;
	}

	public void setHalamanInputData(String halamanInputData) {
		this.halamanInputData = halamanInputData;
	}

	public String getHalamanTandaTangan() {
		return halamanTandaTangan;
	}

	public void setHalamanTandaTangan(String halamanTandaTangan) {
		this.halamanTandaTangan = halamanTandaTangan;
	}

	public String getTxtWelcome() {
		return txtWelcome;
	}

	public void setTxtWelcome(String txtWelcome) {
		this.txtWelcome = txtWelcome;
	}

	public String getTxtWelcomeAdmin() {
		return txtWelcomeAdmin;
	}

	public void setTxtWelcomeAdmin(String txtWelcomeAdmin) {
		this.txtWelcomeAdmin = txtWelcomeAdmin;
	}

	public String getWrongUsername() {
		return wrongUsername;
	}

	public void setWrongUsername(String wrongUsername) {
		this.wrongUsername = wrongUsername;
	}

	public String getWrongPassword() {
		return wrongPassword;
	}

	public void setWrongPassword(String wrongPassword) {
		this.wrongPassword = wrongPassword;
	}

	public String getTxtBerhasilInput() {
		return txtBerhasilInput;
	}

	public void setTxtBerhasilInput(String txtBerhasilInput) {
		this.txtBerhasilInput = txtBerhasilInput;
	}

	public String getTxtFormReturnPending() {
		return txtFormReturnPending;
	}

	public void setTxtFormReturnPending(String txtFormReturnPending) {
		this.txtFormReturnPending = txtFormReturnPending;
	}

	public String getTxtFormReturnComplete() {
		return txtFormReturnComplete;
	}

	public void setTxtFormReturnComplete(String txtFormReturnComplete) {
		this.txtFormReturnComplete = txtFormReturnComplete;
	}
	
	
	
	
// Upload Document 
	public String getTxtUpDoc() {
		return txtUpDoc;
	}

	public void setTxtUpDoc(String txtUpDoc) {
		this.txtUpDoc = txtUpDoc;
	}

	public String getTxtLengkapiDoc() {
		return txtLengkapiDoc;
	}

	public void setTxtLengkapiDoc(String txtLengkapiDoc) {
		this.txtLengkapiDoc = txtLengkapiDoc;
	}

	public String getTxtFotoBefore() {
		return txtFotoBefore;
	}

	public void setTxtFotoBefore(String txtFotoBefore) {
		this.txtFotoBefore = txtFotoBefore;
	}

	public String getTxtFotoAfter() {
		return txtFotoAfter;
	}

	public void setTxtFotoAfter(String txtFotoAfter) {
		this.txtFotoAfter = txtFotoAfter;
	}

	public String getTxtFotoTTD() {
		return txtFotoTTD;
	}

	public void setTxtFotoTTD(String txtFotoTTD) {
		this.txtFotoTTD = txtFotoTTD;
	}

	public String getTxtNoImage() {
		return txtNoImage;
	}

	public void setTxtNoImage(String txtNoImage) {
		this.txtNoImage = txtNoImage;
	}

	public String getTxtImageNotValid() {
		return txtImageNotValid;
	}

	public void setTxtImageNotValid(String txtImageNotValid) {
		this.txtImageNotValid = txtImageNotValid;
	}

	public String getTxtDocumentLengkap() {
		return txtDocumentLengkap;
	}

	public void setTxtDocumentLengkap(String txtDocumentLengkap) {
		this.txtDocumentLengkap = txtDocumentLengkap;
	}

	public String getImageValid() {
		return imageValid;
	}

	public void setImageValid(String imageValid) {
		this.imageValid = imageValid;
	}

	public String getTxtInvalidFile() {
		return txtInvalidFile;
	}

	public void setTxtInvalidFile(String txtInvalidFile) {
		this.txtInvalidFile = txtInvalidFile;
	}

	public String getTxtBerhasilUpload() {
		return txtBerhasilUpload;
	}

	public void setTxtBerhasilUpload(String txtBerhasilUpload) {
		this.txtBerhasilUpload = txtBerhasilUpload;
	}

	public String getImagePng() {
		return imagePng;
	}

	public void setImagePng(String imagePng) {
		this.imagePng = imagePng;
	}

	public String getImageValid2() {
		return imageValid2;
	}

	public void setImageValid2(String imageValid2) {
		this.imageValid2 = imageValid2;
	}

	public String getFileBukanImage() {
		return fileBukanImage;
	}

	public void setFileBukanImage(String fileBukanImage) {
		this.fileBukanImage = fileBukanImage;
	}

	public String getTxtImageNotValid2() {
		return txtImageNotValid2;
	}

	public void setTxtImageNotValid2(String txtImageNotValid2) {
		this.txtImageNotValid2 = txtImageNotValid2;
	}

	
	
	//ttd digital (edit input data)
	public String getNama1() {
		return nama1;
	}

	public void setNama1(String nama1) {
		this.nama1 = nama1;
	}

	public String getNomerBpjs1() {
		return nomerBpjs1;
	}

	public void setNomerBpjs1(String nomerBpjs1) {
		this.nomerBpjs1 = nomerBpjs1;
	}

	public String getNomerBpjs2() {
		return nomerBpjs2;
	}

	public void setNomerBpjs2(String nomerBpjs2) {
		this.nomerBpjs2 = nomerBpjs2;
	}

	public String getNomerktp1() {
		return nomerktp1;
	}

	public void setNomerktp1(String nomerktp1) {
		this.nomerktp1 = nomerktp1;
	}

	public String getAlamat1() {
		return alamat1;
	}

	public void setAlamat1(String alamat1) {
		this.alamat1 = alamat1;
	}

	public String getKotaKtp1() {
		return kotaKtp1;
	}

	public void setKotaKtp1(String kotaKtp1) {
		this.kotaKtp1 = kotaKtp1;
	}

	public String getKotaKtp2() {
		return kotaKtp2;
	}

	public void setKotaKtp2(String kotaKtp2) {
		this.kotaKtp2 = kotaKtp2;
	}

	public String getFaskesAwal1() {
		return faskesAwal1;
	}

	public void setFaskesAwal1(String faskesAwal1) {
		this.faskesAwal1 = faskesAwal1;
	}

	public String getFaskesTujuan1() {
		return faskesTujuan1;
	}

	public void setFaskesTujuan1(String faskesTujuan1) {
		this.faskesTujuan1 = faskesTujuan1;
	}

	public String getFaskesTujuan2() {
		return faskesTujuan2;
	}

	public void setFaskesTujuan2(String faskesTujuan2) {
		this.faskesTujuan2 = faskesTujuan2;
	}

	public String getAlasan1() {
		return alasan1;
	}

	public void setAlasan1(String alasan1) {
		this.alasan1 = alasan1;
	}


	
	
		
}