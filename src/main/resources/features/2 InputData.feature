Feature: User Input Data
		Scenario: Testing Menampilkan Halaman Input Data
	  When Sales menampilkan halaman input data
		Then Sales berhasil menampilkan halaman input data
		
		Scenario: Testing menampilkan validasi jika nama kosong
	  When Sales mengisi nama kosong
		Then Sales berhasil menampilkan validasi nama kosong
		
		Scenario: Testing mengisi valid nama
	  When Sales mengisi valid nama 
		Then Sales berhasil mengisi valid nama
		
		Scenario: Testing menampilkan validasi jika nomor bpjs kosong
	  When Sales mengisi nomor bpjs kosong
		Then Sales berhasil menampilkan validasi nomor bpjs kosong
		
		Scenario: Testing mengisi valid nomor bpjs
	  When Sales mengisi valid nomor bpjs
		Then Sales berhasil mengisi valid nomor bpjs
		
		Scenario: Testing menampilkan validasi jika nomor ktp kosong
	  When Sales mengisi nomor ktp kosong
		Then Sales berhasil menampilkan validasi nomor ktp kosong
		
		Scenario: Testing mengisi valid nomor ktp
	  When Sales mengisi valid nomor ktp
		Then Sales berhasil mengisi valid nomor ktp
		
		Scenario: Testing menampilkan validasi jika alamat kosong
	  When Sales mengisi alamat kosong
		Then Sales berhasil menampilkan validasi alamat kosong
		
		Scenario: Testing mengisi valid alamat
	  When Sales mengisi valid alamat
		Then Sales berhasil mengisi valid alamat
		
		Scenario: Testing menampilkan validasi jika kota ktp kosong
	  When Sales mengisi kota ktp kosong
		Then Sales berhasil menampilkan validasi kota ktp kosong
		
		Scenario: Testing mengisi valid kota ktp
	  When Sales mengisi valid kota ktp
		Then Sales berhasil mengisi valid kota ktp
		
		Scenario: Testing menampilkan validasi jika faskes awal kosong
	  When Sales mengisi faskes awal kosong
		Then Sales berhasil menampilkan validasi faskes awal kosong
		
		Scenario: Testing mengisi valid faskes awal
	  When Sales mengisi valid faskes awal
		Then Sales berhasil mengisi valid faskes awal
		
		Scenario: Testing menampilkan validasi jika faskes tujuan kosong
	  When Sales mengisi faskes tujuan kosong
		Then Sales berhasil menampilkan validasi faskes tujuan kosong
		
		Scenario: Testing mengisi valid faskes tujuan
	  When Sales mengisi valid faskes tujuan
		Then Sales berhasil mengisi valid faskes tujuan
		
		Scenario: Testing menampilkan validasi jika alasan kosong
	  When Sales mengisi alasan kosong
		Then Sales berhasil menampilkan validasi alasan kosong
		
		Scenario: Testing mengisi valid alasan
	  When Sales mengisi valid alasan
		Then Sales berhasil mengisi valid alasan
		
		Scenario: Testing input data pasien
		When Sales input data pasien
		Then Sales berhasil input