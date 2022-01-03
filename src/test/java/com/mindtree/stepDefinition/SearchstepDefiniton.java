package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.pageobject.SearchPage;
import com.mindtree.utility.Logs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchstepDefiniton {
	
	PageObjectManager pageManager;
	Logs loggerUtil;
	Logger log;
	SearchPage searchpage;
	@Given("Go to gillete website1")
	public void go_to_gillete_website_1() {
	    // Write code here that turns the phrase above into concrete actions
		loggerUtil = new Logs();
		log = loggerUtil.createLog("Test2");
		pageManager = new PageObjectManager();
		searchpage = pageManager.getsearchpage();
		log.info("Website opened");
	}
	@Then("Click on search icon")
	public void click_on_search_icon() throws WebDriverHelperException {
	    // Write code here that turns the phrase above into concrete actions
	    searchpage.clickIcon();
	}

	 @Then("^Pass text as \"([^\"]*)\"$")
	public void pass_text_as_something(String Arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    searchpage.enterText(Arg1);
	}

	@Then("Verify the text Results For Razor appears at top of the search results")
	public void verify_the_text_results_for_razor_appears_at_top_of_the_search_results() {
	    // Write code here that turns the phrase above into concrete actions
	    searchpage.verifyText();
	}
}
