package com.jasmeet.assignmentWeek18.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jasmeet.assignmentWeek18.pages.HomePage;
import com.jasmeet.assignmentWeek18.pages.laptopsAndNotebooks;
import com.jasmeet.assignmentWeek18.pages.WishList;
import com.jasmeet.assignmentWeek18.pages.WishList.myWishList;
import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationLogin.pages.AccountLogout;
import com.naveenAutomationLogin.pages.homePage;
import com.naveenAutomationLogin.pages.loginAccountPage;
import com.naveenAutomationLogin.pages.myAccountPage;

public class WishListTest extends TestBase {
	SoftAssert sf;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf =new SoftAssert();
	}
	
	@Test
	public void verifyItemsInShoppingCart() {
		//login
		homePage homePage1 = new homePage();
		loginAccountPage loginAccountPage= homePage1.clickLoginPage();
		loginAccountPage.login();
		//select laptop and notebooks
		HomePage homePage = new HomePage();
		laptopsAndNotebooks laptopsAndNotebooks=homePage.selectLaptopAndNotebooks();
		laptopsAndNotebooks.verifyTitleTxt();
	sf.assertEquals(laptopsAndNotebooks.verifyTitleTxt(), "Laptops & Notebooks", "title does not match");
	laptopsAndNotebooks.dropDownMenu();
	laptopsAndNotebooks.addProducts();
	sf.assertEquals(laptopsAndNotebooks.verifyAlertText(), "Success: You have added MavBook Air to your shopping cart!", "wrong alert");
	WishList wishList=laptopsAndNotebooks.clickOnWishList();
	System.out.println(wishList.getElementFromTheTable("Product 17", myWishList.MODEL).getText());
	
	}

	
	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}



