package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.pageobject.FooterPage;

import com.mindtree.utility.Logs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FooterstepDefinition {
	PageObjectManager pageManager;
	Logs loggerUtil;
	Logger log;
	FooterPage footerpage;
	@Given("Go to gillete website2")
	public void go_to_gillete_website2() {
	    // Write code here that turns the phrase above into concrete actions
		loggerUtil = new Logs();
		log = loggerUtil.createLog("Test3");
		pageManager = new PageObjectManager();
		footerpage = pageManager.getfooterpage();
		log.info("Website opened");
	}

	@Given("Click on Styling under Learn in footer")
	public void click_on_styling_under_learn_in_footer() throws WebDriverHelperException {
	    // Write code here that turns the phrase above into concrete actions
	   footerpage.clickStyling();
	}

	@Then("Verify if we have the text Facial Hair Styles: The Anchor Beard under list of articles under styling")
	public void verify_if_we_have_the_text_facial_hair_styles_the_anchor_beard_under_list_of_articles_under_styling() {
	    // Write code here that turns the phrase above into concrete actions
	    footerpage.verifyText();
	}
}
