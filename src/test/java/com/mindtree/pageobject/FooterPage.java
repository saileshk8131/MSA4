package com.mindtree.pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.uistore.FooterPageUI;
import com.mindtree.utility.Logs;

public class FooterPage {
	
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;
	
	public FooterPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void clickStyling() throws WebDriverHelperException {
		log = loggerUtil.createLog("FooterPage.java");
			helper.applicationWait(10000);
		
			/*helper.clickButton(FooterPageUI.click);
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}*/
	}

	public void verifyText() {
		try {
			String text = helper.getText(FooterPageUI.text);
			if(text.contains("Anchor Beard")) {
				log.info("Text Verified");
			}
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
	}
}
