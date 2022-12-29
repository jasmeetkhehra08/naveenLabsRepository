package com.naveenAutomationRegistration.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class YourStorePage extends TestBase{

	public YourStorePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerBtn;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;

public registerAccountPage clickRegisterPage() {
	myAccount.click();
	registerBtn.click();
	return new registerAccountPage();
}


}