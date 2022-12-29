package com.naveenAutomationLogin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class homePage extends TestBase {

	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement registerBtn;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(css = "head>title")
	WebElement verifyTitletext;

public loginAccountPage clickLoginPage() {
	myAccount.click();
	registerBtn.click();
	return new loginAccountPage();

}
public String verifyPageTitle() {
	return verifyTitletext.getText();
}
}
