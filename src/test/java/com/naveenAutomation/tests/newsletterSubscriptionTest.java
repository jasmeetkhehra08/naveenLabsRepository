package com.naveenAutomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationLogin.pages.homePage;
import com.naveenAutomationLogin.pages.loginAccountPage;
import com.naveenAutomationLogin.pages.myAccountPage;
import com.naveenAutomationLogin.pages.newsletterSubscription;

public class newsletterSubscriptionTest extends TestBase {

	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
	}

	@Test
	public void loginSuccessful() {
		homePage homePage = new homePage();
		loginAccountPage loginAccountPage = homePage.clickLoginPage();
		myAccountPage myAccountPage = loginAccountPage.login();
		sf.assertEquals(myAccountPage.verifyTitleTxt(), "My Account", "unable to login");
		newsletterSubscription newsletterSubscription = myAccountPage.subscribeOrunsubscribe();
		newsletterSubscription.updateSubscription();
		myAccountPage.verifySubscriptionAlertText();
		sf.assertEquals(myAccountPage.verifySubscriptionAlertText(),
				" Success: Your newsletter subscription has been successfully updated!",
				"unable to update subscription");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
