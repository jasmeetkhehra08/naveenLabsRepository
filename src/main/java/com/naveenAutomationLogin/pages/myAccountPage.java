package com.naveenAutomationLogin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class myAccountPage extends TestBase{

	public myAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement verifyTitletext;
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccountInfo;
	
	@FindBy(css= "i.fa.fa-check-circle")
	WebElement verifyAlertText;

	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
	WebElement subscribeOrunsubscribe;
	
	@FindBy(css= "i.fa.fa-check-circle")
	WebElement verifySubscriptionAlertText;
	
	@FindBy(css= "div.list-group a:last-of-type")
	WebElement logout;
	
	
	public newsletterSubscription subscribeOrunsubscribe() {
		subscribeOrunsubscribe.click();
		return new newsletterSubscription();
	}
	
	public AccountLogout logout() {
		logout.click();
		return new AccountLogout();
	}
	
	public String verifyTitleTxt() {
		return verifyTitletext.getText();
	}
	
	public myAccountInfo editAccountInfo() {
		editAccountInfo.click();
		return new myAccountInfo();
	}
	
	public String verifyAlertText() {
		return verifyAlertText.getText();
	}
	
	public String verifySubscriptionAlertText() {
		return verifySubscriptionAlertText.getText();
	}
	
}
