package com.sfdc.base;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.sfdc.utils.DataInputProvider;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PreAndPost extends WebDriverServiceImpl {

	public String dataSheetName;

	@BeforeSuite(groups = { "All" })
	public void beforeSuite() {
		startReport();
	}

	@BeforeClass(groups = { "All" })
	public void beforeClass() {
		Response resp = RestAssured
				.given()
				.formParam("username","ragothamanu.einsteinanalytics@gmail.com ")
				.formParam("password", "Gr@salesforce2021zMTlrHpNpyuqSBSVh371kAKT")
				.formParam("client_id","3MVG97quAmFZJfVw_SJQF310Jz7BAIkX6hmKkZ6Or5VhY1q3id4j1oapNuYR8.zp5BfBtzw_B.eMNkr2bA_DC")
				.formParam("client_secret", "118BC18DDE75F94D9645B78F7AFDF28DE4510CB75F1DB0ECE1AD5660ED4762CB")
				.formParam("grant_type","password")
				.post("https://login.salesforce.com/services/oauth2/token");
		System.out.println(resp.jsonPath().prettyPrint());
		String accesstoken = resp.jsonPath().get("access_token");
		
		RequestSpecification requestSFDC = RestAssured.given();
		requestSFDC.header("Content-Type","application/json");
		JSONObject reqJSON = new JSONObject();
		reqJSON.put("name", "rago 09062021");
		requestSFDC.body(reqJSON.toJSONString())
		.auth().oauth2(accesstoken);//.header("Authorization","Bearer"+accesstoken);
		Response responseSFDC = requestSFDC.post("https://ap17.salesforce.com/services/data/v42.0/sobjects/account");
		System.out.println(responseSFDC.getBody().asPrettyString());
		String createdAcctId = responseSFDC.jsonPath().get("id");
		System.out.println("-->   "+createdAcctId);
		
		startTestCase(testCaseName, testDescription);
	}

	@BeforeMethod(groups = { "All" })
	public void beforeMethod() {
		// for reports
		startTestModule(nodes);// each data row -> one testcase
		test.assignAuthor(authors);
		test.assignCategory(category);	 
		
		
		startApp("chrome");
	}

	@AfterMethod(groups = { "All" })
	public void afterMethod() {
//		closeAllBrowsers();
	}

	@AfterSuite(groups = { "All" })
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] getData() {
		return DataInputProvider.getSheet(dataSheetName);
	}

}
