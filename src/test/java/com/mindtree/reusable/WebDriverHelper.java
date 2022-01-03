package com.mindtree.reusable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.manager.WebDriverManager;

/** This is a reusable helper class for performing all the driver functionalities

 *@since 29/12/2021
 */
public class WebDriverHelper extends WebDriverManager {

	/** Sending text to element
	 * @param element
	 * @param text
	 * @throws WebDriverHelperException
	 */
	public void sendText(By element, String text) throws WebDriverHelperException {
		try {
			driver.findElement(element).sendKeys(text);
		} catch (ElementNotInteractableException exception) {
			throw new WebDriverHelperException(exception);
		}
	}

	/** Getting text from a webelement
	 * @param element
	 * @return text
	 * @throws WebDriverHelperException
	 */
	public String getText(By element) throws WebDriverHelperException {
		String text = null;
		try {
			text = driver.findElement(element).getText();
		} catch (ElementNotInteractableException exception) {
			throw new WebDriverHelperException(exception);
		}
		return text;
	}

	/** to click on a webelement
	 * @param element
	 * @throws WebDriverHelperException
	 */
	public void clickButton(By element) throws WebDriverHelperException {
		
			driver.findElement(element).click();
		
	}

	/** Switch window
	 * @param index
	 */
	public void switchHandles(int index) {
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(index));
	}

	/** Hover on a webelement
	 * @param element
	 */
	public void hover(By element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element)).perform();
	}

	/** Wait for page loading
	 * @param time
	 * @throws WebDriverHelperException
	 */
	public void pageLoad(int time) throws WebDriverHelperException {
		try {
			driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		} catch (TimeoutException exception) {
			throw new WebDriverHelperException(exception);
		}
	}

	/** clear text of an input field
	 * @param element
	 */
	public void clearText(By element) {
		driver.findElement(element).clear();
	}

	/** Perform click through action class
	 * @param element
	 * @throws WebDriverHelperException
	 */
	public void actionClick(By element) throws WebDriverHelperException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element));
		actions.click(driver.findElement(element)).build().perform();
	}

	/** Check if webelement is present or not
	 * @param element
	 * @return boolean value
	 */
	public boolean elementDisplayed(By element) {
		return driver.findElement(element).isDisplayed();
	}

	/** Explicit wait for visibility of webelement
	 * @param time
	 * @param element
	 * @throws WebDriverHelperException
	 */
	public void explicitWaitForVisibility(int time, By element) throws WebDriverHelperException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		} catch (TimeoutException exception) {
			throw new WebDriverHelperException(exception);
		}
	}

	/** Explicit wait for invisibility of element
	 * @param element
	 * @param time
	 */
	public void explicitWaitForInvisibility(By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	
	/** Implicit wait
	 * @param time
	 */
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/** To click on enter
	 * @param element
	 */
	public void enterKey(By element) {
		WebElement we=driver.findElement(element);
		we.sendKeys(Keys.ENTER);
	}
	/** Make the application wait
	 * @param time
	 * @throws WebDriverHelperException
	 */
	public void applicationWait(int time) throws WebDriverHelperException {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new WebDriverHelperException(e);
		}
	}
}
