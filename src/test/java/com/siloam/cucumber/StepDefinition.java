package com.siloam.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.siloam.cucumber.config.AutomationFrameworkConfig;
import com.siloam.cucumber.driver.DriverSingleton;
import com.siloam.cucumber.pages.FormReturn;
import com.siloam.cucumber.pages.InputPage;
import com.siloam.cucumber.pages.LoginPage;
import com.siloam.cucumber.utils.ConfigurationProperties;
import com.siloam.cucumber.utils.Constants;
import com.siloam.cucumber.utils.TestCases;
import com.siloam.cucumber.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private InputPage inputPage;
	private FormReturn formReturn;
	//tambahan di package pages
	static ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/ReportTest.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		inputPage = new InputPage();
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
	
	
	//modul input data
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
	
//	@When("Sales filter data pasien dengan status pending")
//	public void sales_filter_data_pasien_dengan_status_pending() {
//		formReturn.ReturnFormPending();
//		extentTest.log(LogStatus.PASS, "Sales filter data pasien dengan status pending");
//	}
//	
//	@Then("Sales berhasil memfilter data dengan status pending")
//	public void sales_berhasil_memfilter_data_dengan_status_pending() {
//		assertEquals(configurationProperties.getTxtFormReturnPending(), formReturn.getTxtFormReturnPending());
//		extentTest.log(LogStatus.PASS, "Sales Berhasil filter data pasien dengan status pending");
//	}
//	
//	@When("Sales filter data pasien dengan status complete")
//	public void sales_filter_data_pasien_dengan_status_complete() {
//		formReturn.ReturnFormComplete();
//		extentTest.log(LogStatus.PASS, "Sales filter data pasien dengan status pending");
//	}
//	
//	@Then("Sales berhasil memfilter data dengan status complete")
//	public void sales_berhasil_memfilter_data_dengan_status_complete() {
//		assertEquals(configurationProperties.getTxtFormReturnComplete(), formReturn.getTxtFormReturnComplete());
//		extentTest.log(LogStatus.PASS, "Sales Berhasil filter data pasien dengan status pending");
//	}
//	
//	@When("Sales filter data pasien dengan search")
//	public void sales_filter_data_pasien_dengan_search() {
//		formReturn.SearchData();
//		extentTest.log(LogStatus.PASS, "Sales filter data pasien dengan search");
//	}
//	
//	@Then("Sales berhasil memfilter data dengan search")
//	public void sales_berhasil_memfilter_data_dengan_search() {
//		assertEquals(configurationProperties.getHalamanTandaTangan(), formReturn.getTxtHalamanTandaTangan());
//		extentTest.log(LogStatus.PASS, "Sales Berhasil filter data pasien dengan status pending");
//	}
	
	//modul logout
//	@When("User logout")
//	public void user_logout() {
//		loginPage.logout();
//		extentTest.log(LogStatus.PASS, "User logout");
//	}
//	
//	@Then("User berhasil logout")
//	public void user_berhasil_logout() {
//		tunggu(2);
//		assertEquals(configurationProperties.getHalamanLogin(), loginPage.getHalamanLogin());
//		extentTest.log(LogStatus.PASS, "User berhasil logout");
//	}
//	
//	@When("User admin login dengan username dan password")
//	public void user_admin_login_dengan_username_dan_password() {
//		loginPage.loginForm(configurationProperties.getUsernameAdmin(), configurationProperties.getPasswordAdmin());
//		extentTest.log(LogStatus.PASS, "Customer gagal login");
//	}
//	
//	@Then("User admin berhasil login")
//	public void user_admin_berhasil_login() {
//		driver.navigate().refresh();
//		tunggu(2);
//		assertEquals(configurationProperties.getTxtWelcomeAdmin(), loginPage.getTxtWelcome());
//		extentTest.log(LogStatus.PASS, "Customer berhasil login");
//	}
	
	
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
