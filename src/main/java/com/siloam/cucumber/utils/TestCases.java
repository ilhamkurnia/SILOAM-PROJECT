package com.siloam.cucumber.utils;

public enum TestCases {

	T1("Testing Login Invalid Customer"),
	T2("Testing Login Valid Customer"),
	T3("Testing Input Data");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
