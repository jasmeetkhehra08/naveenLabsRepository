package com.naveenAutomationLogin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationRegistration.pages.AccountCreatedPage;

public class loginAccountPage extends TestBase {

	public loginAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	private void enterEmail() {
		email.sendKeys("khehrajass@gmail.com");
	}

	private void enterPassword() {
		password.sendKeys("Qwerty");
	}

	public myAccountPage login() {
		enterEmail();
		enterPassword();
		loginBtn.click();
		return new myAccountPage();
	}
}
