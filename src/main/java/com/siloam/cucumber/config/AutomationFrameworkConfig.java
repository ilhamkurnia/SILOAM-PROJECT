package com.siloam.cucumber.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.siloam.cucumber")
public class AutomationFrameworkConfig {
	
	public AutomationFrameworkConfig() {
		
	}

}
