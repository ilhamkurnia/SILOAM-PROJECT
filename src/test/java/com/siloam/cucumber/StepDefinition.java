package com.siloam.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.siloam.cucumber.config.AutomationFrameworkConfig;
import com.siloam.cucumber.driver.DriverSingleton;
import com.siloam.cucumber.pages.FormReturn;
import com.siloam.cucumber.pages.InputPage;
import com.siloam.cucumber.pages.LoginPage;
import com.siloam.cucumber.pages.TtdDigitalPage;
import com.siloam.cucumber.pages.UploadDocumentPage;
import com.siloam.cucumber.utils.ConfigurationProperties;
import com.siloam.cucumber.utils.Constants;
import com.siloam.cucumber.utils.TestCases;
import com.siloam.cucumber.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static final Object String = null;
	private static WebDriver driver;
	private LoginPage loginPage;
	private InputPage inputPage;
	private UploadDocumentPage uploadDocument;
	private TtdDigitalPage ttdDigital;
	private FormReturn formReturn;
	
	static ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/ReportTest.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		inputPage = new InputPage();
		uploadDocument = new UploadDocumentPage();
		ttdDigital = new TtdDigitalPage();
		formReturn = new FormReturn();
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ","_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:\n"+
					extentTest.addScreenCapture(screenshotPath));
		}
	}
	
	@After
	public static void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void quitDriver() {
		tunggu(5);
		driver.quit();
	}
	
	
	
	// Modul Login
	@Given("User mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Customer mengakses url "+Constants.URL);
	}
	
	@Then("User menampillkan halaman login")
	public void user_menampillkan_halaman_login() {
		tunggu(3);
		assertEquals(configurationProperties.getHalamanLogin(), loginPage.getHalamanLogin());
		extentTest.log(LogStatus.PASS, "User berhasil menampilkan halaman login");
	}
	
	@When("User login dengan username kosong")
	public void customer_login_dengan_username_salah() {
		loginPage.loginForm(configurationProperties.getEmptyUsernamePassword(), configurationProperties.getEmptyUsernamePassword());
		extentTest.log(LogStatus.PASS, "User login dengan username kosong");
	}
	
	@Then("User gagal login dengan username kosong")
	public void customer_gagal_login_dengan_username_kosong() {
		tunggu(3);
		assertTrue(loginPage.getAlertUsername(), true);
		extentTest.log(LogStatus.PASS, "User gagal login dengan username kosong");
	}
	
	@When("User login dengan password kosong")
	public void customer_login_dengan_password_salah() {
		loginPage.loginForm(configurationProperties.getUsernameSales(), configurationProperties.getEmptyUsernamePassword());
		extentTest.log(LogStatus.PASS, "User login dengan password kosong");
	}
	
	@Then("User gagal login dengan password kosong")
	public void customer_gagal_login_dengan_password_kosong() {
		tunggu(3);
		assertTrue(loginPage.getAlertPassword(), true);
		extentTest.log(LogStatus.PASS, "User gagal login dengan password kosong");
	}
	
	
	@When("User login dengan invalid username")
	public void user_login_dengan_username_salah() {
		loginPage.loginForm(configurationProperties.getWrongUsername(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User login dengan username salah");
	}
	
	@Then("User gagal login dengan invalid username")
	public void user_gagal_login_dengan_username_salah() {
		tunggu(3);
		assertEquals(configurationProperties.getHalamanLogin(), loginPage.getHalamanLogin());
		extentTest.log(LogStatus.PASS, "Customer gagal login dengan username salah");
	}
	
	@When("User login dengan invalid password")
	public void user_login_dengan_password_salah() {
		loginPage.loginForm(configurationProperties.getUsernameSales(), configurationProperties.getWrongPassword());
		extentTest.log(LogStatus.PASS, "User login dengan password salah");
	}
	
	@Then("User gagal login dengan invalid password")
	public void customer_gagal_login_dengan_password_salah() {
		tunggu(3);
		assertEquals(configurationProperties.getHalamanLogin(), loginPage.getHalamanLogin());
		extentTest.log(LogStatus.PASS, "Customer gagal login dengan password salah");
	}
	
	@When("User login dengan username dan password")
	public void customer_login_dengan_username_password() {
		loginPage.loginForm(configurationProperties.getUsernameSales(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Customer gagal login");
	}
	
	@Then("User berhasil login")
	public void customer_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcome(), loginPage.getTxtWelcome());
		extentTest.log(LogStatus.PASS, "Customer berhasil login");
	}
	
	
	//Modul Input Data 
	@When("Sales menampilkan halaman input data")
	public void sales_menampilkan_halaman_input_data() {
		inputPage.halamanInputData();
		extentTest.log(LogStatus.PASS, "Sales menampilkan halaman input data");
	}
	@Then("Sales berhasil menampilkan halaman input data")
	public void sales_berhasil_menampilkan_halaman_input_data() {
		assertEquals(configurationProperties.getHalamanInputData(), inputPage.getHalamanInput());
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan halaman input data");
	}
	
	@When("Sales mengisi nama kosong")
	public void sales_mengisi_nama_kosong() {
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi nama kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi nama kosong")
	public void sales_berhasil_menampilkan_validasi_nama_kosong() {
		assertTrue(inputPage.getValidateNama(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan halaman input data");
	}
	
	@When("Sales mengisi valid nama")
	public void sales_mengisi_valid_nama() {
		tunggu(2);
		inputPage.ValidNama();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid nama");
	}
	
	@Then("Sales berhasil mengisi valid nama")
	public void sales_berhasil_mengisi_valid_nama() {
		assertEquals("Muhammad Ade Ilham", inputPage.getNama());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid nama");
	}
	
	@When("Sales mengisi nomor bpjs kosong")
	public void sales_mengisi_nomor_bpjs_kosong() {
		tunggu(2);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi nomor bpjs kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi nomor bpjs kosong")
	public void sales_berhasil_menampilkan_validasi_nomor_bpjs_kosong() {
		assertTrue(inputPage.getValidateNoBPJS(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi nomor bpjs kosong");
	}
	
	@When("Sales mengisi valid nomor bpjs")
	public void sales_mengisi_valid_nomor_bpjs() {
		tunggu(2);
		inputPage.ValidNoBPJS();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid nomor bpjs");
	}
	
	@Then("Sales berhasil mengisi valid nomor bpjs")
	public void sales_berhasil_mengisi_valid_nomor_bpjs() {
		assertEquals(13, inputPage.getNoBPJS());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid nama");
	}
	
	@When("Sales mengisi nomor ktp kosong")
	public void sales_mengisi_nomor_ktp_kosong() {
		tunggu(2);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi nomor ktp kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi nomor ktp kosong")
	public void sales_berhasil_menampilkan_validasi_nomor_ktp_kosong() {
		assertTrue(inputPage.getValidateNoKTP(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi nomor ktp kosong");
	}
	
	@When("Sales mengisi valid nomor ktp")
	public void sales_mengisi_valid_nomor_ktp() {
		tunggu(2);
		inputPage.ValidNoKTP();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid nomor ktp");
	}
	
	@Then("Sales berhasil mengisi valid nomor ktp")
	public void sales_berhasil_mengisi_valid_nomor_ktp() {
		assertEquals(16, inputPage.getNoKTP());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid nomor ktp");
	}
	
	@When("Sales mengisi alamat kosong")
	public void sales_mengisi_alamat_kosong() {
		tunggu(2);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi alamat kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi alamat kosong")
	public void sales_berhasil_menampilkan_validasi_alamt_kosong() {
		assertTrue(inputPage.getValidateAlamat(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi alamat kosong");
	}
	
	@When("Sales mengisi valid alamat")
	public void sales_mengisi_valid_alamat() {
		tunggu(2);
		inputPage.ValidAlamat();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid alamat");
	}
	
	@Then("Sales berhasil mengisi valid alamat")
	public void sales_berhasil_mengisi_valid_alamat() {
		assertEquals("JL. pepaya", inputPage.getAlamat());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid alamat");
	}
	
	@When("Sales mengisi kota ktp kosong")
	public void sales_mengisi_kota_ktp_kosong() {
		tunggu(2);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi kota ktp kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi kota ktp kosong")
	public void sales_berhasil_menampilkan_validasi_kota_ktp_kosong() {
		assertTrue(inputPage.getValidateKotaKTP(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi kota ktp kosong");
	}
	
	@When("Sales mengisi valid kota ktp")
	public void sales_mengisi_valid_kota_ktp() {
		tunggu(2);
		inputPage.ValidKotaKTP();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid kota ktp");
	}
	
	@Then("Sales berhasil mengisi valid kota ktp")
	public void sales_berhasil_mengisi_valid_kota_ktp() {
		assertEquals("KABUPATEN ACEH BESAR", inputPage.getKotaKTP());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid kota ktp");
	}
	
	@When("Sales mengisi faskes awal kosong")
	public void sales_mengisi_faskes_awal_kosong() {
		tunggu(2);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi faskes awal kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi faskes awal kosong")
	public void sales_berhasil_menampilkan_validasi_faskes_awal_kosong() {
		assertTrue(inputPage.getValidateFaskesAwal(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi faskes awal kosong");
	}
	
	@When("Sales mengisi valid faskes awal")
	public void sales_mengisi_valid_faskes_awal() {
		tunggu(2);
		inputPage.ValidFaskesAwal();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid faskes awal");
	}
	
	@Then("Sales berhasil mengisi valid faskes awal")
	public void sales_berhasil_mengisi_valid_faskes_awal() {
		assertEquals("Jakarta", inputPage.getFaskesAwal());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid faskes awal");
	}
	
	@When("Sales mengisi faskes tujuan kosong")
	public void sales_mengisi_faskes_tujuan_kosong() {
		tunggu(2);
		scrollDown(driver);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi faskes awal kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi faskes tujuan kosong")
	public void sales_berhasil_menampilkan_validasi_faskes_tujuan_kosong() {
		assertTrue(inputPage.getValidateFaskesTujuan(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi faskes tujuan kosong");
	}
	
	@When("Sales mengisi valid faskes tujuan")
	public void sales_mengisi_valid_faskes_tujuan() {
		tunggu(2);
		inputPage.ValidFaskesTujuan();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid faskes awal");
	}
	
	@Then("Sales berhasil mengisi valid faskes tujuan")
	public void sales_berhasil_mengisi_valid_faskes_tujuan() {
		assertEquals("1||Clinic Meruya||Kota Jakarta Barat", inputPage.getFaskesTujuan());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid faskes tujuan");
	}
	
	@When("Sales mengisi alasan kosong")
	public void sales_mengisi_alasan_kosong() {
		tunggu(2);
		scrollDown(driver);
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales mengisi alasan kosong");
	}
	
	@Then("Sales berhasil menampilkan validasi alasan kosong")
	public void sales_berhasil_menampilkan_validasi_alasan_kosong() {
		assertTrue(inputPage.getValidateAlasan(), true);
		extentTest.log(LogStatus.PASS, "Sales berhasil menampilkan validasi alasan kosong");
	}
	
	@When("Sales mengisi valid alasan")
	public void sales_mengisi_valid_alasan() {
		tunggu(2);
		inputPage.ValidAlasan();
		extentTest.log(LogStatus.PASS, "Sales mengisi valid alasan");
	}
	
	@Then("Sales berhasil mengisi valid alasan")
	public void sales_berhasil_mengisi_valid_alasan() {
		assertEquals("rere cantik", inputPage.getAlasan());
		extentTest.log(LogStatus.PASS, "Sales berhasil mengisi valid alasan");
	}
	
	@When("Sales input data pasien")
	public void sales_input_data_pasien() {
		inputPage.inputForm();
		extentTest.log(LogStatus.PASS, "Sales Input Data");
	}
	
	@Then("Sales berhasil input")
	public void sales_berhasil_input() {
		assertEquals(configurationProperties.getTxtBerhasilInput(), inputPage.getTxtBerhasilInput());
		extentTest.log(LogStatus.PASS, "Sales Berhasil Input Data");
	}
	
	
	//Modul Upload Document
	//Scenario: Testing Menampilkan Halaman Upload
	@When ("Sales berhasil masuk ke halaman upload document")
	public void sales_berhasil_masuk_kehalaman_upload_document () {
		tunggu(5);
		assertEquals(configurationProperties.getTxtUpDoc(), uploadDocument.getHalamanUpDoc());		
		extentTest.log(LogStatus.PASS, "Sales berhasil masuk ke halaman upload document");
	}
	
	@Then("Menampilkan notifikasi untuk melengkapi document")
	public void menampilkan_notifikasi_untuk_melengkapi_document () {
		assertEquals(configurationProperties.getTxtLengkapiDoc(), uploadDocument.getLengkapiDocument());
		extentTest.log(LogStatus.PASS, "Menampilkan notifikasi untuk melengkapi document");
	}
	
	//Testing Save Image File Kosong
	@When ("Save file document kosong")
	public void save_file_document_kosong () {
		uploadDocument.btnSaveImg();
		extentTest.log(LogStatus.PASS, "Save file document kosong");
	}
	
	@Then ("Menampilkan verifikasi select file")
	public void menampilkan_verifikasi_select_file () {
		assertEquals(configurationProperties.getTxtNoImage(), uploadDocument.getMassageValidasiImage());
		uploadDocument.btnX();
		extentTest.log(LogStatus.PASS, "Menampilkan verifikasi select file");
	}	
	
	// Testing Cancel Upload Foto
	@When ("Upload document dengan jenis file dan size valid2")
	public void upload_document_dengan_jenis_file_dan_size_valid2 () {
		uploadDocument.chooseFile(configurationProperties.getImageValid2());
		tunggu(5);
		assertEquals("", uploadDocument.getMassageValidasiImage());
		extentTest.log(LogStatus.PASS, "Upload document dengan jenis file dan size valid2");
	}
	
	@And ("Cancel upload document")
	public void Cancel_upload_document () {
		uploadDocument.btnCancelImg();
		extentTest.log(LogStatus.PASS, "Cancel upload document");
	}	
	
	@Then ("Kembali kehalaman upload document")
	public void kembali_kehalaman_upload_document () {
		tunggu(5);
		assertEquals(configurationProperties.getTxtUpDoc(), uploadDocument.getHalamanUpDoc());		
		extentTest.log(LogStatus.PASS, "Kembali kehalaman upload document");
	}
	
	//Testing Upload Document FFA File Bukan Image
	@When ("Upload document file bukan image")
	public void upload_document_file_bukan_image () {
		tunggu(5);
		uploadDocument.chooseFile(configurationProperties.getFileBukanImage());
		extentTest.log(LogStatus.PASS,"Upload document file bukan image");
	}
	
	@Then ("Menampilkan verifikasi file tidak sesuai")
	public void menampilkan_verifikasi_file_tidak_sesuai () {
		assertEquals(configurationProperties.getTxtImageNotValid(), uploadDocument.getMassageValidasiImage2());
		extentTest.log(LogStatus.PASS, "Menampilkan verifikasi file tidak sesuai");
	}
	
	@When ("Simpan upload document")
	public void simpan_upload_document () {
		uploadDocument.btnSaveImg();
		extentTest.log(LogStatus.PASS,"Simpan upload document");
	}
	
	@Then ("Gagal simpan file dan menampilkan verifikasi")
	public void gagal_simpan_file_dan_menampilkan_verifikasi () {
		assertEquals(configurationProperties.getTxtInvalidFile(), uploadDocument.getMassageValidasiImage());
		uploadDocument.btnX();
		extentTest.log(LogStatus.PASS, "Gagal simpan file dan menampilkan verifikasi");
	}
	
	//Testing Upload Foto Faskes Awal Valid
	@When ("Sales mengakses upload foto faskes awal")
	public void sales_mengakses_upload_foto_faskes_awal () {
		uploadDocument.fotoFaskesAwal();
		extentTest.log(LogStatus.PASS,"Sales mengakses upload foto faskes awal");
	}
	
	@Then ("Masuk halaman upload foto before")
	public void masuk_halaman_upload_foto_before () {
		tunggu(5);
		assertEquals(configurationProperties.getTxtFotoBefore(), uploadDocument.getFotoHalaman());
		extentTest.log(LogStatus.PASS, "Masuk halaman upload foto before");
	}
	
	@When ("Upload document dengan jenis file dan size valid")
	public void upload_document_dengan_jenis_file_dan_size_valid () {
		uploadDocument.chooseFile(configurationProperties.getImageValid());
		tunggu(2);
		assertEquals("", uploadDocument.getMassageValidasiImage());
		extentTest.log(LogStatus.PASS, "Upload document jenis image yang bisa disimpan");
	}
	
	@And ("Verifikasi button ok data berhasil disimpan")
	public void verifikasi_button_ok_data_berhasil_disimpan () {
		uploadDocument.btnSaveImg();
		tunggu(2);
		assertEquals(configurationProperties.getTxtBerhasilUpload(), uploadDocument.getBerhasilUploadImg());
		uploadDocument.btnOK();
		extentTest.log(LogStatus.PASS, "Verifikasi button ok data berhasil disimpan");
	}
	
	@Then ("Foto berhasil di simpan di image FFA")
	public void foto_berhasil_di_simpan_di_image_FFA() {
		tunggu(5);
		assertNotEquals("", uploadDocument.imgFFA().getAttribute("value"));
		extentTest.log(LogStatus.PASS,"Foto berhasil di simpan di image"); 
	}
		
	// Testing Upload Foto Faskes Tujuan Valid
	@When ("Sales mengakses upload foto faskes Tujuan")
	public void sales_mengakses_upload_foto_faskes_Tujuan () {
		uploadDocument.fotoFaskesTujuan();
		extentTest.log(LogStatus.PASS,"Sales mengakses upload foto faskes awal");
	}
	
	@Then ("Masuk halaman upload foto after")
	public void masuk_halaman_upload_foto_after () {
		tunggu(5);
		assertEquals(configurationProperties.getTxtFotoAfter(), uploadDocument.getFotoHalaman());
		extentTest.log(LogStatus.PASS, "Masuk halaman upload foto after");
	}
	
	@Then ("Foto berhasil di simpan di image FFT")
	public void foto_berhasil_di_simpan_di_image_FFT() {
		tunggu(5);
		assertNotEquals("", uploadDocument.imgFFT().getAttribute("value"));
		extentTest.log(LogStatus.PASS,"Foto berhasil di simpan di image FFT"); 
	}
	
	// Testing Upload Foto Faskes TTD Valid
	@When ("Sales mengakses upload foto TTD")
	public void sales_mengakses_upload_foto_TTD () {
		uploadDocument.fotoTTD();
		extentTest.log(LogStatus.PASS,"Sales mengakses upload foto TTD");
	}
		
	@Then ("Masuk halaman upload foto TTD")
	public void masuk_halaman_upload_TTD () {
	tunggu(5);
		assertEquals(configurationProperties.getTxtFotoTTD(), uploadDocument.getFotoHalaman());
		extentTest.log(LogStatus.PASS, "Masuk halaman upload foto TTD");
	}
		
	@Then ("Foto berhasil di simpan di image TTD")
	public void foto_berhasil_di_simpan_di_image_TTD() {
		tunggu(5);
		assertNotEquals("", uploadDocument.imgFTTD().getAttribute("value"));
		extentTest.log(LogStatus.PASS,"Foto berhasil di simpan di image TTD"); 
		}
		
	// Tahap Selanjutnya
	@When ("Document sudah lengkap")
	public void document_sudah_lengkap () {
		assertEquals(configurationProperties.getTxtDocumentLengkap(), uploadDocument.getDocumentLengkap());
		extentTest.log(LogStatus.PASS,"Document sudah lengkap");
		}
		
	@Then ("Dapat mengakses tahap selanjutnya")
	public void dapat_mengakses_tahap_selanjutnya () {
		uploadDocument.btnSelanjutnya();
		driver.switchTo().alert().accept();
		extentTest.log(LogStatus.PASS,"Dapat mengakses tahap selanjutnya");
		}
	
	
	//Testing Tanda Tangan Digital
	//Testing Mengedit Form Nama Valid
	@When ("Sales melakukan edit nama")
	public void sales_melakukan_edit_nama () {
		ttdDigital.editNama(configurationProperties.getNama1());
		extentTest.log(LogStatus.PASS,"Sales melakukan edit nama");
	}

	@Then ("Nama berhasil di edit")
	public void nama_berhasil_di_edit () {
		assertEquals(configurationProperties.getNama1(), ttdDigital.namaValue());
		extentTest.log(LogStatus.PASS,"Nama berhasil di edit");
		}

	//Testing Mengedit Form Nomor BPJS
	@When ("Sales melakukan edit nomor BPJS")
	public void sales_melakukan_edit_nomor_BPJS () {
		ttdDigital.editNomerBPJS(configurationProperties.getNomerBpjs1());
		extentTest.log(LogStatus.PASS,"Sales melakukan edit nomor BPJS");
	}

	@Then ("Nomer BPJS berhasil di edit")
	public void nomer_BPJS_berhasil_di_edit () {
		assertEquals(configurationProperties.getNomerBpjs1(), ttdDigital.bpjsValue());
		extentTest.log(LogStatus.PASS,"Nomer BPJS berhasil di edit");
		}
	
	//Testing Mengedit Form Nomor KTP
	@When ("Sales melakukan edit nomor KTP")
	public void sales_melakukan_edit_nomor_KTP () {
		ttdDigital.editNomerKTP(configurationProperties.getNomerktp1());
		extentTest.log(LogStatus.PASS,"Sales melakukan edit nomor KTP");
	}

	@Then ("Nomer KTP berhasil di edit")
	public void nomer_KTP_berhasil_di_edit () {
		assertEquals(configurationProperties.getNomerktp1(), ttdDigital.ktpValue());
		extentTest.log(LogStatus.PASS,"Nomer KTP berhasil di edit");
		}

	//Testing Mengedit Form Alamat
	@When ("Sales melakukan edit alamat")
	public void sales_melakukan_edit_alamat () {
		ttdDigital.editAlamat(configurationProperties.getAlamat1());
		extentTest.log(LogStatus.PASS,"Sales melakukan edit alamat");
	}

	@Then ("Alamat berhasil di edit")
	public void alamat_berhasil_di_edit () {
		assertTrue(ttdDigital.alamatValue().contains(configurationProperties.getAlamat1()));
		extentTest.log(LogStatus.PASS,"Alamat berhasil di edit");
		}
		
	//Testing Mengedit Form Kota KTP menjadi Sama Dengan Faskes Tujuan
	@When ("Sales mengedit kota ktp menjadi sama dengan faskes tujuan")
	public void sales_mengedit_kota_ktp_menjadi_sama_dengan_faskes_tujuan() {
		tunggu(5);
		ttdDigital.editKotaKtp(configurationProperties.getKotaKtp1());
		extentTest.log(LogStatus.PASS, "Sales mengedit kota ktp menjadi sama dengan faskes tujuan");
	}

	@Then ("Kolom alasan akan tertutup")
	public void kolom_alasan_akan_tertutup() {
		assertFalse(ttdDigital.alasanIsDisplay());
		extentTest.log(LogStatus.PASS, "Kolom alasan akan tertutup");
	}

	@When ("Simpan data")
	public void simpan_data() {
		ttdDigital.simpanData();
	}
	
	@Then("Kota ktp berhasil diedit menjadi sama")
	public void kota_ktp_berhasil_diedit_menjadi_sama () {
		assertTrue(ttdDigital.kotaKtpTitle().contains(configurationProperties.getKotaKtp1()));
		extentTest.log(LogStatus.PASS, "Kota ktp berhasil diedit menjadi sama");
	}
	
	//Testing Mengedit Form Kota KTP menjadi Berbeda Dengan Faskes Tujuan
	@When ("Sales mengedit kota ktp menjadi berbeda dengan faskes tujuan")
	public void sales_mengedit_kota_ktp_menjadi_berbeda_dengan_faskes_tujuan() {
		tunggu(5);
		ttdDigital.editKotaKtp(configurationProperties.getKotaKtp2());
		extentTest.log(LogStatus.PASS, "Sales mengedit kota ktp menjadi berbeda dengan faskes tujuan");
	}

	@Then ("Kolom alasan akan terbuka")
	public void kolom_alasan_akan_terbuka() {
		assertTrue(ttdDigital.alasanIsDisplay());
		extentTest.log(LogStatus.PASS, "Kolom alasan akan terbuka");
	}

	@Then("Kota ktp berhasil diedit menjadi berbeda")
	public void kota_ktp_berhasil_diedit_menjadi_berbeda () {
		assertTrue(ttdDigital.kotaKtpTitle().contains(configurationProperties.getKotaKtp2()));
		extentTest.log(LogStatus.PASS, "Kota ktp berhasil diedit menjadi berbeda");
	}
	
	//Testing Mengedit Form Faskes Awal
	@When ("Sales melakukan edit faskes awal")
	public void sales_melakukan_edit_faskes_awal() {
		ttdDigital.editFaskesAwal(configurationProperties.getFaskesAwal1());
		extentTest.log(LogStatus.PASS, "Sales melakukan edit faskes awal");
	}

	@Then ("Faskes awal berhasil di edit")
	public void faskes_awal_berhasil_di_edit() {
		assertEquals(configurationProperties.getFaskesAwal1(),ttdDigital.faskesAwalValue());
		extentTest.log(LogStatus.PASS, "Faskes awal berhasil di edit");
	}
	
	//Testing Mengedit Form Faskes Tujuan menjadi Sama Dengan Kota KTP
	@When ("Sales mengedit faskes tujuan menjadi sama dengan kota ktp")
	public void sales_mengedit_faskes_tujuan_menjadi_sama_dengan_kota_ktp() {
		ttdDigital.editFaskesTujuan(configurationProperties.getFaskesTujuan1());
		extentTest.log(LogStatus.PASS, "Sales mengedit faskes tujuan menjadi sama dengan kota ktp");
	}
	
	@Then ("Kolom alasan akan tertutup2")
	public void kolom_alasan_akan_tertutup2() {
		assertFalse(ttdDigital.alasanIsDisplay());
		extentTest.log(LogStatus.PASS, "Kolom alasan akan tertutup2");
	}

	@Then("Faskes tujuan berhasil diedit menjadi sama")
	public void faskes_tujuan_berhasil_diedit_menjadi_sama() {
		assertTrue(ttdDigital.faskesTujuanTitle().contains(configurationProperties.getFaskesTujuan1()));
		extentTest.log(LogStatus.PASS, "Faskes tujuan berhasil diedit menjadi sama");
	}
	
	
	//Testing Mengedit Form Faskes Tujuan menjadi Berbeda Dengan Kota KTP
	@When ("Sales mengedit faskes tujuan menjadi berbeda dengan kota ktp")
	public void sales_mengedit_faskes_tujuan_menjadi_berbeda_dengan_kota_ktp() {
		ttdDigital.editFaskesTujuan(configurationProperties.getFaskesTujuan2());
		extentTest.log(LogStatus.PASS, "Sales mengedit faskes tujuan menjadi berbeda dengan kota ktp");
	}
	
	@Then ("Kolom alasan akan terbuka2")
	public void kolom_alasan_akan_terbuka2() {
		tunggu(5);
		assertTrue(ttdDigital.alasanIsDisplay());
		extentTest.log(LogStatus.PASS, "Kolom alasan akan terbuka2");
	}

	@Then("Faskes tujan berhasil diedit menjadi berbeda")
	public void faskes_tujuan_berhasil_diedit_menjadi_berbeda() {
		assertTrue(ttdDigital.faskesTujuanTitle().contains(configurationProperties.getFaskesTujuan2()));
		extentTest.log(LogStatus.PASS, "Faskes tujan berhasil diedit menjadi berbeda");
	}
	
	//Testing Mengedit Form Alasan
	@When ("Sales melakukan edit alasan")
	public void sales_melakukan_edit_alasan () {
		ttdDigital.editAlasan(configurationProperties.getAlasan1());
		extentTest.log(LogStatus.PASS,"Sales melakukan edit alasan");
	}

	@Then ("Alasan berhasil di edit")
	public void alasan_berhasil_di_edit () {
		assertEquals(configurationProperties.getAlasan1(), ttdDigital.alasanValue());
		extentTest.log(LogStatus.PASS,"Alasan berhasil di edit");
		}
	
	//Testing Cancel Form Input Data
	@When ("Sales melakukan edit bpjs dan cancel data")
	public void sales_melakukan_edit_bpjs_dan_cancel_data () {
		ttdDigital.cancelEditNomerBPJS(configurationProperties.getNomerBpjs2());
		extentTest.log(LogStatus.PASS,"Sales melakukan edit bpjs dan cancel data");
	}

	@Then ("Data batal diedit")
	public void Data_batal_diedit () {
		assertNotEquals(configurationProperties.getNomerBpjs2(), ttdDigital.bpjsValue());
		extentTest.log(LogStatus.PASS,"Data batal diedit");
		}
	
	@When("Sales filter data pasien dengan status pending")
	public void sales_filter_data_pasien_dengan_status_pending() {
		formReturn.ReturnFormPending();
		extentTest.log(LogStatus.PASS, "Sales filter data pasien dengan status pending");
	}
	
	@Then("Sales berhasil memfilter data dengan status pending")
	public void sales_berhasil_memfilter_data_dengan_status_pending() {
		assertEquals(configurationProperties.getTxtFormReturnPending(), formReturn.getTxtFormReturnPending());
		extentTest.log(LogStatus.PASS, "Sales Berhasil filter data pasien dengan status pending");
	}
	
	@When("Sales filter data pasien dengan status complete")
	public void sales_filter_data_pasien_dengan_status_complete() {
		formReturn.ReturnFormComplete();
		extentTest.log(LogStatus.PASS, "Sales filter data pasien dengan status pending");
	}
	
	@Then("Sales berhasil memfilter data dengan status complete")
	public void sales_berhasil_memfilter_data_dengan_status_complete() {
		assertEquals(configurationProperties.getTxtFormReturnComplete(), formReturn.getTxtFormReturnComplete());
		extentTest.log(LogStatus.PASS, "Sales Berhasil filter data pasien dengan status pending");
	}
	
	@When("Sales filter data pasien dengan search")
	public void sales_filter_data_pasien_dengan_search() {
		formReturn.SearchData();
		extentTest.log(LogStatus.PASS, "Sales filter data pasien dengan search");
	}
	
	@Then("Sales berhasil memfilter data dengan search")
	public void sales_berhasil_memfilter_data_dengan_search() {
		assertEquals(configurationProperties.getHalamanTandaTangan(), formReturn.getTxtHalamanTandaTangan());
		extentTest.log(LogStatus.PASS, "Sales Berhasil filter data pasien dengan status pending");
	}
	
	//modul logout
	@When("User logout")
	public void user_logout() {
		loginPage.logout();
		extentTest.log(LogStatus.PASS, "User logout");
	}
	
	@Then("User berhasil logout")
	public void user_berhasil_logout() {
		tunggu(2);
		assertEquals(configurationProperties.getHalamanLogin(), loginPage.getHalamanLogin());
		extentTest.log(LogStatus.PASS, "User berhasil logout");
	}
	
	@When("User admin login dengan username dan password")
	public void user_admin_login_dengan_username_dan_password() {
		loginPage.loginForm(configurationProperties.getUsernameAdmin(), configurationProperties.getPasswordAdmin());
		extentTest.log(LogStatus.PASS, "Customer gagal login");
	}
	
	@Then("User admin berhasil login")
	public void user_admin_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcomeAdmin(), loginPage.getTxtWelcome());
		extentTest.log(LogStatus.PASS, "Customer berhasil login");
	}
	
	
	
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 300)");
	}
}


//@When ("Upload document jenis file png")
//public void upload_document_jenis_file_png () {
//	tunggu(5);
//	uploadDocument.fotoFaskesAwal();
//	uploadDocument.chooseFile(configurationProperties.getImagePng());
//	extentTest.log(LogStatus.PASS, "Upload document jenis image yang bisa disimpan");
//}
//
//@And ("Menampilkan validasi tidak sesuai")
//public void menampilkan_validasi_tidaksesuai () {
//	assertEquals(configurationProperties.getTxtImageNotValid(), uploadDocument.getValidasiFile());
//	extentTest.log(LogStatus.PASS, "Masuk halaman upload foto before");
//}
//  
//
//@Then ("Foto tidak berhasil di simpan di image ")
//public void foto_tidak_berhasil_di_simpan_di_image () {
//	uploadDocument.btnSaveImg();
//	assertEquals(configurationProperties.getTxtInvalidFile(), uploadDocument.getBerhasilUploadImg());
//	extentTest.log(LogStatus.PASS,"Foto tidak berhasil di simpan di image"); 
//	uploadDocument.btnOK();
//}

//Scenario: Testing Upload Foto Faskes Awal Jenis File tidak valid
//And Menampilkan validasi tidak sesuai
//Then Foto tidak berhasil di simpan di image 