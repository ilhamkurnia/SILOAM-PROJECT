Feature: Testing Tanda Tangan Digital
	Scenario: Testing Mengedit Form Nama Valid
		When Sales melakukan edit nama
		Then Nama berhasil di edit
	
	Scenario: Testing Mengedit Form Nomor BPJS
		When Sales melakukan edit nomor BPJS
		Then Nomer BPJS berhasil di edit
		
	Scenario: Testing Mengedit Form Nomor KTP
		When Sales melakukan edit nomor KTP
		Then Nomer KTP berhasil di edit
		
	Scenario: Testing Mengedit Form Alamat
		When Sales melakukan edit alamat
		Then Alamat berhasil di edit
		
	Scenario: Testing Mengedit Form Kota KTP menjadi Sama Dengan Faskes Tujuan
		When Sales mengedit kota ktp menjadi sama dengan faskes tujuan
		Then Kolom alasan akan tertutup
	
	Scenario: Testing Data Kota Ktp Sama Berhasil Disimpan
		When Simpan data
		Then Kota ktp berhasil diedit menjadi sama
		
	Scenario: Testing Mengedit Form Kota KTP menjadi Berbeda Dengan Faskes Tujuan
		When Sales mengedit kota ktp menjadi berbeda dengan faskes tujuan
		Then Kolom alasan akan terbuka
	
	Scenario: Testing Data Kota Ktp Berbeda Berhasil Disimpan
		When Simpan data
		Then Kota ktp berhasil diedit menjadi berbeda
		
	Scenario: Testing Mengedit Form Faskes Awal
		When Sales melakukan edit faskes awal
		Then Faskes awal berhasil di edit
		
	Scenario: Testing Mengedit Form Faskes Tujuan menjadi Sama Dengan Kota KTP
		When Sales mengedit faskes tujuan menjadi sama dengan kota ktp
		Then Kolom alasan akan tertutup2
		
	Scenario: Testing Data Faskes Tujuan Sama Berhasil Disimpan
		When Simpan data
		Then Faskes tujuan berhasil diedit menjadi sama
		
	Scenario: Testing Mengedit Form Faskes Tujuan menjadi Berbeda Dengan Kota KTP
		When Sales mengedit faskes tujuan menjadi berbeda dengan kota ktp
		Then Kolom alasan akan terbuka2
		
	Scenario: Testing Data Faskes Tujuan Berbeda Berhasil Disimpan
		When Simpan data
		Then Faskes tujan berhasil diedit menjadi berbeda
		
	Scenario: Testing Mengedit Form Alasan
		When Sales melakukan edit alasan
		Then Alasan berhasil di edit
		
	Scenario: Testing Cancel Form Input Data
		When Sales melakukan edit bpjs dan cancel data
		Then Data batal diedit
		
	