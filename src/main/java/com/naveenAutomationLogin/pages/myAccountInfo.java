package com.naveenAutomationLogin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class myAccountInfo extends TestBase{

	public myAccountInfo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[type='tel']")
	WebElement updatePhoneNumber;
	
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;
	
		public myAccountPage updatePhoneNumber() {
			updatePhoneNumber.click();
			updatePhoneNumber.clear();
			updatePhoneNumber.sendKeys("7894561230");
			continueBtn.click();
			return new myAccountPage();
	}
}
