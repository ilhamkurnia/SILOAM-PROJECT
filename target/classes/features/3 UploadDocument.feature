	Feature: Testing Tanda Tangan Digital
	Scenario: Testing Menampilkan Halaman Upload Document
		When Sales berhasil masuk ke halaman upload document
		Then Menampilkan notifikasi untuk melengkapi document
			
	Scenario: Testing Save Foto Faskes Awal File Kosong
		When Sales mengakses upload foto faskes awal
		Then Masuk halaman upload foto before
		When Save file document kosong
		Then Menampilkan verifikasi select file
		
	Scenario: Testing Save Foto Faskes Tujuan File Kosong
		When Sales mengakses upload foto faskes Tujuan
		Then Masuk halaman upload foto after
		When Save file document kosong
		Then Menampilkan verifikasi select file
		
	Scenario: Testing Save Foto TTD File Kosong
		When Sales mengakses upload foto TTD
		Then Masuk halaman upload foto TTD
		When Save file document kosong
		Then Menampilkan verifikasi select file
		
	Scenario: Testing Cancel Upload Foto Faskes Awal	
		When Sales mengakses upload foto faskes awal
		Then Masuk halaman upload foto before
		When Upload document dengan jenis file dan size valid2
		And Cancel upload document 
		Then Kembali kehalaman upload document
		
	Scenario: Testing Cancel Upload Foto Faskes Tujuan	
		When Sales mengakses upload foto faskes Tujuan
		Then Masuk halaman upload foto after
		When Upload document dengan jenis file dan size valid2
		And Cancel upload document 
		Then Kembali kehalaman upload document
		
	Scenario: Testing Cancel Upload Foto TTD	
		When Sales mengakses upload foto TTD
		Then Masuk halaman upload foto TTD
		When Upload document dengan jenis file dan size valid2
		And Cancel upload document 
		Then Kembali kehalaman upload document
		
	Scenario: Testing Upload Document FFA File Bukan Image
		When Sales mengakses upload foto faskes awal
		Then Masuk halaman upload foto before
		When Upload document file bukan image
		Then Menampilkan verifikasi file tidak sesuai
		When Simpan upload document
		Then Gagal simpan file dan menampilkan verifikasi
		 
	Scenario: Testing Upload Document FFT File Bukan Image
		When Sales mengakses upload foto faskes Tujuan
		Then Masuk halaman upload foto after
		When Upload document file bukan image
		Then Menampilkan verifikasi file tidak sesuai
		When Simpan upload document
		Then Gagal simpan file dan menampilkan verifikasi
		
	Scenario: Testing Upload Document FTTD File Bukan Image
		When Sales mengakses upload foto TTD
		Then Masuk halaman upload foto TTD
		When Upload document file bukan image
		Then Menampilkan verifikasi file tidak sesuai
		When Simpan upload document
		Then Gagal simpan file dan menampilkan verifikasi
	
	Scenario: Testing Upload Foto Faskes Awal Valid
		When Sales mengakses upload foto faskes awal
		Then Masuk halaman upload foto before
		When Upload document dengan jenis file dan size valid
		And Verifikasi button ok data berhasil disimpan
		Then Foto berhasil di simpan di image FFA 
		
	Scenario: Testing Upload Foto Faskes Tujuan Valid
		When Sales mengakses upload foto faskes Tujuan
		Then Masuk halaman upload foto after
		When Upload document dengan jenis file dan size valid
		And Verifikasi button ok data berhasil disimpan
		Then Foto berhasil di simpan di image FFT

Scenario: Testing Upload Foto TTD Valid
		When Sales mengakses upload foto TTD
		Then Masuk halaman upload foto TTD
		When Upload document dengan jenis file dan size valid
		And Verifikasi button ok data berhasil disimpan
		Then Foto berhasil di simpan di image TTD
		
Scenario: Testing Tahap Selanjutnya
		When Document sudah lengkap
		Then Dapat mengakses tahap selanjutnya
