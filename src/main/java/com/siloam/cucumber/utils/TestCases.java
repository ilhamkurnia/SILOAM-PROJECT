package com.siloam.cucumber.utils;

public enum TestCases {

	T1("Testing Login Empty Username"),
	T2("Testing Login Empty Password"),
	T3("Testing Login Invalid Username"),
	T4("Testing Login Invalid Password"),
	T5("Testing Login Valid Customer"),
	T6("Testing Input Data"),
	T7("Testing Filter Status Pending"),
	T8("Testing Filter Status Complete"),
	T9("Testing Logout User"),
	T10("Testing Login User Admin");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
