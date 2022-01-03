package com.mindtree.manager;

import com.mindtree.pageobject.FooterPage;
import com.mindtree.pageobject.Product;
import com.mindtree.pageobject.SearchPage;

/** This class is to manage the objects of different pages
 
 *
 */
public class PageObjectManager extends WebDriverManager{
	private Product homePage;
	private SearchPage searchpage;
	private FooterPage footerpage;
	

	public Product getHomePage() {
		return(homePage==null) ? homePage = new Product():homePage;
	}
	
	public SearchPage getsearchpage() {
		
		return(searchpage==null) ? searchpage = new SearchPage():searchpage;
	}
	
	public FooterPage getfooterpage() {
		
		return(footerpage==null) ? footerpage = new FooterPage():footerpage;
	}

}
