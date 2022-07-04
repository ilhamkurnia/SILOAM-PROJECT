Feature: User Berhasil Memfilter Data Pasien
	Scenario: Testing Filter Data Pasien dengan status pending
		When Sales filter data pasien dengan status pending
		Then Sales berhasil memfilter data dengan status pending
		
		Scenario: Testing Filter Data Pasien dengan status complete
		When Sales filter data pasien dengan status complete
		Then Sales berhasil memfilter data dengan status complete
		
		Scenario: Testing Filter Data Dengan Search
		When Sales filter data pasien dengan search
		Then Sales berhasil memfilter data dengan search
		