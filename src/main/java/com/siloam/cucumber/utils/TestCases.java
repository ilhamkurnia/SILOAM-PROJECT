package com.siloam.cucumber.utils;

import java.util.ArrayList;
import java.util.List;

public enum TestCases {
	//Login
	T1("Tesing menampilkan halaman login"),
	T2("Testing Login Empty Username"),
	T3("Testing Login Empty Password"),
	T4("Testing Login Invalid Username"),
	T5("Testing Login Invalid Password"),
	T6("Testing Login User Sales Valid"),
	
	//Input Data Negatif 
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
	
	//Input Data Positif
	T26("Testing Input Data"),
	
	//Testing Upload Document
	T27("Testing Menampilkan Halaman Upload Document"),
	T28("Testing Save Foto Faskes Awal File Kosong"),
	T29("Testing Save Foto Faskes Tujuan File Kosong"),
	T30("Testing Save Foto TTD File Kosong"),
	T31("Testing Cancel Upload Foto Faskes Awal"),
	T32("Testing Cancel Upload Foto Faskes Tujuan"),
	T33("Testing Cancel Upload Foto Faskes TTD"),
	T34("Testing Upload Document FFA File Bukan Image"),
	T35("Testing Upload Document FFT File Bukan Image"),
	T36("Testing Upload Document FTTD File Bukan Image"),
	T37("Testing Upload Foto Faskes Awal Valid"),
	T38("Testing Upload Foto Faskes Tujuan Valid"),
	T39("Testing Upload Foto TTD Valid"),
	T40("Testing Tahap Selanjutnya"),
	
	//Testing Tanda Tanggan Digital;
	T41("Testing Mengedit Form Nama Valid"),
	T42("Testing Mengedit Form Nomor BPJS"),
	T43("Testing Mengedit Form Nomor KTP"),
	T44("Testing Mengedit Form Alamat"),
	T45("Testing Mengedit Form Kota KTP menjadi Sama Dengan Faskes Tujuan"),
	T46("Testing Data Kota Ktp Sama Berhasil Disimpan"),
	T47("Testing Mengedit Form Kota KTP menjadi Berbeda Dengan Faskes Tujuan"),
	T48("Testing Data Kota Ktp Berbeda Berhasil Disimpan"),
	T49("Testing Mengedit Form Faskes Awal"),
	T50("Testing Mengedit Form Faskes Tujuan menjadi Sama Dengan Kota KTP"),
	T51("Testing Data Faskes Tujuan Sama Berhasil Disimpan"),
	T52("Testing Mengedit Form Faskes Tujuan menjadi Berbeda Dengan Kota KTP"),
	T53("Testing Data Faskes Tujuan Berbeda Berhasil Disimpan"),
	T54("Testing Mengedit Form Alasan"),
	T55("Data batal diedit"),

	//Testing Filter
	T56("Testing Filter Status Pending"),
	T57("Testing Filter Status Complete"),
	T58("Testing Filter Dengan Search"),
	
	//Testing User Admin BD
	T59("Testing Logout User"),
	T60("Testing Login User Admin");
	
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
