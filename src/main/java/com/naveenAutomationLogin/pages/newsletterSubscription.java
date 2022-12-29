package com.naveenAutomationLogin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class newsletterSubscription extends TestBase{

	public newsletterSubscription() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[value='1']")
	WebElement yesRadioButton;
	
	@FindBy(css="input[type='submit']")
	WebElement continueBtn;
	
	public myAccountPage updateSubscription() {
		yesRadioButton.click();
		continueBtn.click();
		return new myAccountPage();
}
}
