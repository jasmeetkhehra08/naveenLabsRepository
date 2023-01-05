package com.jasmeet.assignmentWeek18.tests;

import org.openqa.selenium.WebElement;
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
		sf = new SoftAssert();
	}

	@Test
	public void verifyItemsInShoppingCart() {
		// login
		homePage homePage1 = new homePage();
		loginAccountPage loginAccountPage = homePage1.clickLoginPage();
		loginAccountPage.login();
		// select laptop and notebooks
		HomePage homePage = new HomePage();
		laptopsAndNotebooks laptopsAndNotebooks = homePage.selectLaptopAndNotebooks();
		laptopsAndNotebooks.verifyTitleTxt();
		sf.assertEquals(laptopsAndNotebooks.verifyTitleTxt(), "Laptops & Notebooks", "title does not match");
		laptopsAndNotebooks.dropDownMenu();
		laptopsAndNotebooks.addProducts();
		sf.assertEquals(laptopsAndNotebooks.verifyAlertText(),
				"Success: You have added MavBook Air to your shopping cart!", "wrong alert");
		WishList wishList = laptopsAndNotebooks.clickOnWishList();
		sf.assertEquals(wishList.verifyTitle(), "My wish list", "wrong title");

		WebElement product1Name = wishList.getElementFromTheTable("MacBook Air", myWishList.PRODUCT_NAME);
sf.assertEquals(product1Name, "MacBook Air", "wrong product name");
		WebElement product1Price = wishList.getElementFromTheTable("MacBook Air", myWishList.UNIT_PRICE);
		sf.assertEquals(product1Price, "MacBook Air", "wrong product price");

		WebElement product2Name = wishList.getElementFromTheTable("MacBook Pro", myWishList.PRODUCT_NAME);
		sf.assertEquals(product2Name, "MacBook Pro", "wrong product name");
		WebElement product2Price = wishList.getElementFromTheTable("MacBook Pro", myWishList.UNIT_PRICE);
		sf.assertEquals(product2Price, "MacBook Pro", "wrong product price");
		
		WebElement product3Name = wishList.getElementFromTheTable("Sony VAIO", myWishList.PRODUCT_NAME);
		sf.assertEquals(product3Name, "Sony VAIO", "wrong product name");
		WebElement product3Price = wishList.getElementFromTheTable("Sony VAIO", myWishList.UNIT_PRICE);
		sf.assertEquals(product3Price, "Sony VAIO", "wrong product price");
		
		//remove last item
		wishList.removeProduct();
		wishList.successBanner();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
