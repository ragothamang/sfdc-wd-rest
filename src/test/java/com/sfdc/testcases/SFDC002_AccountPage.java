package com.sfdc.testcases;

import org.testng.annotations.BeforeTest;

import com.sfdc.base.PreAndPost;

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
}
