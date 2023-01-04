package com.jasmeet.assignmentWeek18.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class shoppingCart extends TestBase {
	public shoppingCart() {
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {
		driver.getTitle();
	}

}
