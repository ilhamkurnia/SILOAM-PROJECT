package com.siloam.cucumber.utils;

public enum TestCases {

	T1("Tesing menampilkan halaman login"),
	T2("Testing Login Empty Username"),
	T3("Testing Login Empty Password"),
	T4("Testing Login Invalid Username"),
	T5("Testing Login Invalid Password"),
	T6("Testing Login User Sales Valid"),
	
	T7("Testing Menampilkan Halaman Input Data"),
	T8("Testing Input Data"),
	
	T9("Testing Filter Status Pending"),
	T10("Testing Filter Status Complete"),
	T11("Testing Filter Dengan Search"),
	
	T12("Testing Logout User"),
	T13("Testing Login User Admin");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
