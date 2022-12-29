package com.naveenAutomationLogin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class AccountLogout extends TestBase {

	public AccountLogout() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;
	
	public homePage logoutFromAccount() {
		continueBtn.click();
		return new homePage();
}
}
