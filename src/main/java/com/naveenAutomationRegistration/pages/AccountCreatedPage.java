package com.naveenAutomationRegistration.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class AccountCreatedPage extends TestBase {

	public AccountCreatedPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[id='content'] h1")
	WebElement verifyText;
	

	public String accountCreatedTxt() {
		return verifyText.getText();
	}
}
