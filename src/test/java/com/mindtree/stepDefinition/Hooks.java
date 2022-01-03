package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;

import com.mindtree.manager.WebDriverManager;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.utility.Logs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends WebDriverManager{
	WebDriverHelper Helper;
	WebDriverManager driverManager;
	Logs loggerUtil;
	Logger log;
	
	@Before
	public void startUp() {
		loggerUtil = new Logs();
		log = loggerUtil.createLog("Hooks.class");
		log.debug("Opening driver");
		driverManager = new WebDriverManager();
		driverManager.getDriver();
		log.info("Driver opened");
		driver.get(properties.getProperty("url"));
		log.debug("Opening URL");
	}
	
	@After
	public void teardown() {
		log.info("Driver closed");
		driver.close();
	}
}
