package com.mindtree.pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.uistore.SearchPageUI;
import com.mindtree.utility.Logs;

public class SearchPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;
	
	public SearchPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}
	public void clickIcon() throws WebDriverHelperException {
		log = loggerUtil.createLog("SearchPage.java");
		helper.applicationWait(3000);
		log.debug("Clicking on Search icon");
		try {
			helper.clickButton(SearchPageUI.icon);
			helper.enterKey(SearchPageUI.searchbox);
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
	}
	
	public void enterText(String text) {
		log.debug("Entering Text Razor");
		try {
			helper.sendText(SearchPageUI.searchbox, text);
			helper.enterKey(SearchPageUI.searchbox);
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
	}
	public void enter() {
		log.debug("Clicking enter");
		helper.enterKey(SearchPageUI.searchbox);
	}
	public void verifyText() {
		log.debug("Veryfying text");
		try {
			String text = helper.getText(SearchPageUI.text);
			if(text.contains("Results")) {
				log.info("Text Verified");
			}
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
		
	}
}
