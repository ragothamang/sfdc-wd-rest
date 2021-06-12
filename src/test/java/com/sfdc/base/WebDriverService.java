package com.sfdc.base;import java.time.Duration;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface WebDriverService {


	/**
	 * This method will locate the element using any given locator
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Babu - TestLeaf
	 * @throws NoSuchElementException
	 */
	public WebElement locateElement(String locator, String locValue) ;	
	
	/**
	 * This method will locate the elements using any given locator
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author George - TestLeaf
	 */
	public List<WebElement> locateElements(String locator, String locValue) ;

	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws ElementNotVisibleException		 * 
	 */
	public void type(WebElement ele, String data) ;

	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Babu - TestLeaf
	 */
	public void click(WebElement ele);

	/**
	 * This method will get the text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Babu - TestLeaf
	 */
	public String getText(WebElement ele);

	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public void selectDropDownUsingVisibleText(WebElement ele, String value) ;

	/**
	 * This method will select the drop down using value
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value attribute to be selected from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index The index to be selected from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) ;

	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyExactTitle(String expectedTitle);
	
	/**
	 * This method will verify browser actual title with expected text using contains
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyPartialTitle(String expectedTitle);


	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifyExactText(WebElement ele, String expectedText);

	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifyPartialText(WebElement ele, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Babu - TestLeaf
	 */
	public void verifyExactAttribute(WebElement ele, String attribute, String value);

	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Babu - TestLeaf
	 */
	public void verifyPartialAttribute(WebElement ele, String attribute, String value);

	/**
	 * This method will verify if the element (Radio button, Checkbox)  is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifySelected(WebElement ele);

	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author Babu - TestLeaf
	 */
	public void verifyDisplayed(WebElement ele);

	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Babu - TestLeaf
	 */
	public void switchToWindow(int index);

	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Babu - TestLeaf
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will accept the alert opened
	 * @author Babu - TestLeaf
	 */
	public void acceptAlert();

	/**
	 * This method will dismiss the alert opened
	 * @author Babu - TestLeaf
	 */
	public void dismissAlert();

	/**
	 * This method will return the text of the alert
	 * @author Babu - TestLeaf
	 */
	public String getAlertText();

	/**
	 * This method will close the active browser
	 * @author Babu - TestLeaf
	 */
	public void closeActiveBrowser();		

	/**
	 * This method will close all the browsers
	 * @author Babu - TestLeaf
	 */
	public void closeAllBrowsers();
	
	/**
	 * This method will hover or move to particular element
	 * @author Ravi - TestLeaf
	 */
	public void HoverOnElement(WebElement ele);

	/**
	 * This method will switch the control to last opened window
	 * @author Ravi - TestLeaf
	 */
	public void switchToLastWindow();
	
	/**
	 * This method will locate list of element using xpath separately.
	 * Exception might be expected in the method, so the report status is Info
	 * @author Dinesh - Cypress BootCamp
	 */
	public int findElementSize(String locator,String locValue);
	/**
	 * This method will type the text and press Enter
	 * @author Ravi - TestLeaf
	 */
	public void typeAndReturn(WebElement ele, String data);
	/**
	 * This method will return element enable or not
	 * @author Dinesh - Cypress BootCamp
	 */
	public boolean isEnabledElement(WebElement ele);
	/**
	 * This method will select value from dropdown dynamically
	 * @author Dinesh - Cypress BootCamp
	 */
	public void selectDropDownValueDynamic(List<WebElement> ele,String strValueToBeSelect);
	/**
	 * This method will click five element in all field.
	 * return type is void
	 * @author Dinesh - Cypress BootCamp
	 */
	public void clickFirstFiveElement(List<WebElement> ele);
}


