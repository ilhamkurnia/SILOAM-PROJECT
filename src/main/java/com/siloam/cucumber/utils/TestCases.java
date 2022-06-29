package com.siloam.cucumber.utils;

public enum TestCases {

	T1("Testing Login Empty Username"),
	T2("Testing Login Empty Password"),
	T3("Testing Login Invalid Username"),
	T4("Testing Login Invalid Password"),
	T5("Testing Login Valid Customer"),
	T6("Testing Input Data");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
