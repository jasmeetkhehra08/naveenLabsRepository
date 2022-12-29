package com.naveenAutomationRegistration.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenAutomation.Base.TestBase;

public class registerAccountPage extends TestBase {

	public registerAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='firstname']")
	WebElement firstName;

	@FindBy(css = "input[name='lastname']")
	WebElement lastName;

	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "input[name='telephone']")
	WebElement telephone;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(css = "input[name='confirm']")
	WebElement confirmPassword;

	@FindBy(css = "input[type='checkbox']")
	WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;

	private void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	private void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	private void enterEmail(String enterEmail) {
		email.sendKeys(enterEmail);
	}

	private void enterPhoneNumber(String phone) {
		telephone.sendKeys(phone);
	}

	private void enterPassword(String pswrd) {
		password.sendKeys(pswrd);
	}

	private void enterConfirmPwd(String cPswrd) {
		confirmPassword.sendKeys(cPswrd);
	}

	private void clickPrivacyPolicy() {
		privacyPolicyCheckBox.click();
	}

	public AccountCreatedPage register(String fname, String lname, String enterEmail, String phone, String pswrd, String cpswrd) {
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(enterEmail);
		enterPhoneNumber(phone);
		enterPassword(pswrd);
		enterConfirmPwd(cpswrd);
		clickPrivacyPolicy();
		continueBtn.click();
		return new AccountCreatedPage();
	}

}
