package com.siloam.cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.siloam.cucumber.config.AutomationFrameworkConfig;
import com.siloam.cucumber.driver.DriverSingleton;
import com.siloam.cucumber.pages.LoginPage;
import com.siloam.cucumber.pages.MyBookings;
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
	private MyBookings myBookings;
	//tambahan di package pages
	static ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/ReportTest.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		myBookings = new MyBookings();
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
	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Customer mengakses url "+Constants.URL);
	}
	
	@When("Customer login dengan username dan password salah")
	public void customer_login_dengan_username_password_Salah() {
		loginPage.loginForm(configurationProperties.getEmail(), configurationProperties.getWrongPassword());
		extentTest.log(LogStatus.PASS, "Customer login dengan username dan password salah");
	}
	
	@Then("Customer gagal login")
	public void customer_gagal_login() {
		tunggu(3);
		assertEquals(configurationProperties.getMessageErrorLogin(), loginPage.getMessageErrorLogin());
		extentTest.log(LogStatus.PASS, "Customer gagal login");
	}
	
	@When("Customer login dengan username dan password")
	public void customer_login_dengan_username_password() {
		loginPage.loginForm(configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Customer gagal login");
	}
	
	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcome(), loginPage.getTxtWelcome());
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
}
