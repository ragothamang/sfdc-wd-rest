package com.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.sfdc.base.PreAndPost;

public class LoginPage extends PreAndPost{
	
	public LoginPage(EventFiringWebDriver driver, ExtentTest test) {    
        this.driver = driver;
        this.test = test;    
    }    
	public LoginPage typeUserName(String userName) {
		WebElement eleUserName = locateElement("username");
		type(eleUserName, userName);
		return this;
	}
	public LoginPage typePassword(String password) {
		WebElement elePassword = locateElement("password");
		type(elePassword, password);
		return this;
	}
//	public HomePage clickLoginButton() {
		public void clickLoginButton() {
		
		WebElement eleLogin = locateElement("Login");
		click(eleLogin);
		//return new HomePage(driver, test);
	}
}
