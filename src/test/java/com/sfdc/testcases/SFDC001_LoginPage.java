package com.sfdc.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sfdc.base.PreAndPost;
import com.sfdc.pages.LoginPage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SFDC001_LoginPage extends PreAndPost {
	@BeforeTest
	public void setValues() {
		testCaseName = "SFDC001_LoginPage";
		testDescription = "Logging in to salesforce url";
		nodes = "Content";
		authors = "Rago";
		category = "Smoke";
		//dataSheetName = "SFO67_CreateContactforCampaign";
	}
	
	@Test
	public void createFollowUpEvent() throws InterruptedException  {
		
		new LoginPage(driver, test)
		.typeUserName("ragothamanu.einsteinanalytics@gmail.com")
		.typePassword("Gr@salesforce2021")
		.clickLoginButton();		
			
	}

}
