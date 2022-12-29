package com.naveenAutomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationLogin.pages.homePage;
import com.naveenAutomationLogin.pages.loginAccountPage;
import com.naveenAutomationLogin.pages.myAccountInfo;
import com.naveenAutomationLogin.pages.myAccountPage;

public class ChangePhoneNumberTest extends TestBase{

		SoftAssert sf;
		@BeforeMethod
		public void setUp() {
			launchBrowser();
			sf =new SoftAssert();
		}
		
		@Test
		public void loginSuccessful() {
			homePage homePage = new homePage();
			loginAccountPage loginAccountPage= homePage.clickLoginPage();
			myAccountPage myAccountPage=loginAccountPage.login();
			sf.assertEquals(myAccountPage.verifyTitleTxt(), "My Account", "unable to login");
			myAccountInfo myAccountInfo= myAccountPage.editAccountInfo();
			myAccountInfo.updatePhoneNumber();
			sf.assertEquals(myAccountPage.verifyAlertText(), "Success: Your account has been successfully updated.", "unable to update phone number");
		}
		
		
		@AfterMethod
		public void teardown() {
			quitBrowser();
		}

	}


