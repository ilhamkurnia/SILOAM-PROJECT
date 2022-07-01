package com.siloam.cucumber.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

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
	
	
	
	
	
	
	
}
