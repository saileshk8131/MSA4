package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;

import com.mindtree.manager.PageObjectManager;
import com.mindtree.pageobject.Product;
import com.mindtree.utility.Logs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductstepDefinition {
	
	PageObjectManager pageManager;
	Logs loggerUtil;
	Logger log;
	Product productpage;
	@Given("Go to gillete website")
	public void go_to_gillete_website() {
	    // Write code here that turns the phrase above into concrete actions
		loggerUtil = new Logs();
		log = loggerUtil.createLog("Test1");
		pageManager = new PageObjectManager();
		productpage = pageManager.getHomePage();
		log.info("Website opened");
	}

	@Then("Hover on Products")
	public void hover_on_products() {
	    // Write code here that turns the phrase above into concrete actions
	    productpage.tohover();
	}

	@Then("Choose MACH3 under By Brands from the drop-down")
	public void choose_mach3_under_by_brands_from_the_drop_down() {
	    // Write code here that turns the phrase above into concrete actions
	    productpage.onClick();
	}

	@Then("Verify if the text Gillette MACH3 Turbo is displayed under out products list")
	public void verify_if_the_text_gillette_mach3_turbo_is_displayed_under_out_products_list() {
	    // Write code here that turns the phrase above into concrete actions
	    productpage.verifyText();
	}

}
