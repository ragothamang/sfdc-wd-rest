package com.sfdc.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sfdc.base.PreAndPost;
import com.sfdc.pages.LoginPage;

public class SFDC002_AccountPage extends PreAndPost {
	@BeforeTest
	public void setValues() {
		testCaseName = "SFDC002_AccountPage";
		testDescription = "Navigating to account page";
		nodes = "Account";
		authors = "Rago";
		category = "Smoke";
		//dataSheetName = "SFO67_CreateContactforCampaign";
	}
	
	@Test
	public void createFollowUpEvent2() throws InterruptedException  {
		
		new LoginPage(driver, test)
		.typeUserName("ragothamanu.einsteinanalytics@gmail.com")
		.typePassword("Gr@salesforce2021")
		.clickLoginButton();		
			
	}
}
