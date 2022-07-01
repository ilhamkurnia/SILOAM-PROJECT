Feature: User Sales Login ke Siloam Project
	Scenario: Testing Menampilkan Halaman Login
	  Given User mengakses url
		Then User menampillkan halaman login
		
	Scenario: Testing Login Empty Username
		When User login dengan username kosong
		Then User gagal login dengan username kosong
		
		Scenario: Testing Login Empty Password
		When User login dengan password kosong
		Then User gagal login dengan password kosong
		
		Scenario: Testing Login Invalid Username
		When User login dengan invalid username
		Then User gagal login dengan invalid username
		
		Scenario: Testing Login Invalid Password
		When User login dengan invalid password
		Then User gagal login dengan invalid password
		
	Scenario: Testing Login Valid User	
		When User login dengan username dan password
		Then User berhasil login
		
		
		