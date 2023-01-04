package com.jasmeet.assignmentWeek18.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class laptopsAndNotebooks extends TestBase {

	public laptopsAndNotebooks() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Laptops & Notebooks']")
	WebElement verifyTitletext;

	@FindBy(xpath = "#input-sort")
	WebElement dropDownMenu;

	@FindBy(xpath = "//option[text()='Rating (Highest)']")
	WebElement highToLow;

	@FindBy(css = "div.col-sm-9>div:nth-of-type(4)>div:first-of-type>div>div:last-of-type>div.button-group>button:first-of-type")
	WebElement product1;

	@FindBy(css = "div.col-sm-9>div:nth-of-type(4)>div:nth-of-type(2)>div>div:last-of-type>div.button-group>button:first-of-type")
	WebElement product2;

	@FindBy(css = "div.col-sm-9>div:nth-of-type(4)>div:nth-of-type(2)>div>div:last-of-type>div.button-group>button:first-of-type")
	WebElement product3;

	@FindBy(css = "div.alert>a:last-of-type")
	WebElement clickOnShoppingCart;

	public String verifyTitleTxt() {
		return verifyTitletext.getText();
	}

	@FindBy(xpath = "div.alert")
	WebElement verifyAlertText;

	public void dropDownMenu() {
		dropDownMenu.click();
		highToLow.click();
	}

	public void addProducts() {
		product1.click();
		product2.click();
		product3.click();
	}

	public String verifyAlertText() {
		return verifyAlertText.getText();
	}

	public shoppingCart clickOnShoppingCart() {
		clickOnShoppingCart.click();
		return new shoppingCart();
	}
}
