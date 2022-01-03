package com.mindtree.pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.uistore.ProductUI;
import com.mindtree.utility.Logs;

public class Product {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;
	
	public Product() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}
	
	public void tohover() {
		log = loggerUtil.createLog("Product.java");
		log.debug("Mouse Hover to Products");
		helper.hover(ProductUI.products);
	}
	public void onClick() {
		log.debug("Clicking on MACH3");
		try {
			helper.clickButton(ProductUI.mach3);
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
	}
	public void verifyText() {
		log.debug("Veryfying text");
		try {
			String text = helper.getText(ProductUI.text);
			if(text.contains("Gillette MACH3 Turbo")) {
				log.info("Text Verified");
			}
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
		
	}
}
