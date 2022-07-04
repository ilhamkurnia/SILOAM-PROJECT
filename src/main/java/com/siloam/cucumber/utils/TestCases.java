package com.siloam.cucumber.utils;

public enum TestCases {

	T1("Tesing menampilkan halaman login"),
	T2("Testing Login Empty Username"),
	T3("Testing Login Empty Password"),
	T4("Testing Login Invalid Username"),
	T5("Testing Login Invalid Password"),
	T6("Testing Login User Sales Valid"),
	
	T7("Testing Menampilkan Halaman Input Data"),
	T8("Testing Mengisi nama kosong"),
	T9("Testing Mengisi valid nama"),
	T10("Testing Mengisi nomor bpjs kosong"),
	T11("Testing Mengisi valid nomor bpjs"),
	T12("Testing Mengisi nomor ktp kosong"),
	T13("Testing Mengisi valid nomor ktp"),
	T14("Testing Mengisi nomor bpjs kosong"),
	T15("Testing Mengisi valid nomor bpjs"),
	T16("Testing Mengisi alamat kosong"),
	T17("Testing Mengisi valid alamat"),
	T18("Testing Mengisi kota ktp kosong"),
	T19("Testing Mengisi valid kota ktp"),
	T20("Testing Mengisi faskes awal kosong"),
	T21("Testing Mengisi valid faskes awal"),
	T22("Testing Mengisi faskes tujuan kosong"),
	T23("Testing Mengisi valid faskes tujuan"),
	T24("Testing Mengisi alasan kosong"),
	T25("Testing Mengisi valid alasan"),
	
	T26("Testing Input Data"),
	
	T27("Testing Filter Status Pending"),
	T28("Testing Filter Status Complete"),
	T29("Testing Filter Dengan Search"),
	
	T30("Testing Logout User"),
	T31("Testing Login User Admin");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
