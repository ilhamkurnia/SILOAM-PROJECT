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
	
	@Value("${email}")
	private String email;
	
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
	
	@Value("${messageErrorLogin}")
	private String messageErrorLogin;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMessageErrorLogin() {
		return messageErrorLogin;
	}

	public void setMessageErrorLogin(String messageErrorLogin) {
		this.messageErrorLogin = messageErrorLogin;
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
