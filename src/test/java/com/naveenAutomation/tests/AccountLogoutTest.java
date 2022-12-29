package com.naveenAutomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationLogin.pages.AccountLogout;
import com.naveenAutomationLogin.pages.homePage;
import com.naveenAutomationLogin.pages.loginAccountPage;
import com.naveenAutomationLogin.pages.myAccountPage;
import com.naveenAutomationRegistration.pages.AccountCreatedPage;
import com.naveenAutomationRegistration.pages.YourStorePage;
import com.naveenAutomationRegistration.pages.registerAccountPage;

public class AccountLogoutTest extends TestBase {

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
		AccountLogout accountLogout=myAccountPage.logout();
		accountLogout.logoutFromAccount();
		sf.assertEquals(homePage.verifyPageTitle(), "Your Store", "unable to logout");
	
	}

	
	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}

