package com.jasmeet.naveenLabsAssignment;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		// basic setup to begin the selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JK\\Drivers\\Chrome Driver 108\\chromedriver.exe");
		// launch browser
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		wd.manage().window().maximize();
	}

	@Test
	public void verifyLoginTest() {
		WebElement emailInputField = wd.findElement(By.cssSelector("form div.form-group:first-of-type input"));
		WebElement passwordInputField = wd.findElement(By.cssSelector("form div.form-group:last-of-type input"));
		WebElement loginBtn = wd.findElement(By.cssSelector("input[type='submit']"));
		// send text to input field
		emailInputField.sendKeys("khehrajass@gmail.com");
		passwordInputField.sendKeys("Qwerty");
		loginBtn.click();
		String title = wd.getTitle(); // validate the title of page.
		Assert.assertEquals(title, "My Account", "Title does not match");
		System.out.println(title);
		WebElement laptopsAndNotebooks = wd.findElement(By.cssSelector("ul.nav>li:nth-of-type(2) a")); //selecting phones and PDA
		laptopsAndNotebooks.click();
		WebElement allLaptopsAndNotebooks =wd.findElement(By.cssSelector("ul.nav>li:nth-of-type(2)>div a.see-all"));
		allLaptopsAndNotebooks.click();
		String pageTitle = wd.getTitle();// validating page title
		Assert.assertEquals(pageTitle, "Laptops & Notebooks", "page title does not match");
		System.out.println(pageTitle);
		WebElement selectProduct =wd.findElement(By.cssSelector("div.product-layout:nth-of-type(4) h4 a")); //selecting product
		selectProduct.click();
		WebElement addToCart= wd.findElement(By.cssSelector("div.form-group:last-of-type button")); //adding to cart
		addToCart.click();
		WebElement shoppingCart = wd.findElement(By.cssSelector("span[id='cart-total']"));
//		String itemsInCart=shoppingCart.getText();
//		Assert.assertEquals(itemsInCart, "1 item(s) - $2,000.00", "Incorrect Quantity");
//		System.out.println(itemsInCart);
		shoppingCart.click();
		WebElement checkout = wd.findElement(By.cssSelector("p.text-right a:last-of-type")); //checkout
		checkout.click();
		//billing details
		WebElement firstName = wd.findElement(By.cssSelector("div.col-sm-10 input:first-of-type"));
		firstName.sendKeys("J");
		WebElement lastName = wd.findElement(By.cssSelector("input[name='lastname']"));
		lastName.sendKeys("K");
		WebElement address1 = wd.findElement(By.cssSelector("input[name='address_1']"));
		address1.sendKeys("108 dumfries ave");
		WebElement city = wd.findElement(By.cssSelector("input[name='city']"));
		city.sendKeys("Brampton");
		WebElement postalCode = wd.findElement(By.cssSelector("input[name='postcode']"));
		postalCode.sendKeys("L6z2x8");
		WebElement country = wd.findElement(By.cssSelector("select[name='country_id']"));
		Select sc=new Select(country);
		sc.selectByIndex(38);
		WebElement state = wd.findElement(By.cssSelector("select[name='zone_id']"));
		Select selectState = new Select(state);
		selectState.selectByIndex(609);
		WebElement continueBtn = wd.findElement(By.cssSelector("div.pull-right input"));
		continueBtn.click();
		WebElement addressRadioBtn =wd.findElement(By.cssSelector("div.radio:first-of-type input:checked"));
		addressRadioBtn.click();
		WebElement continueBtn1 = wd.findElement(By.cssSelector("div.buttons>div input"));
		continueBtn1.click();
		WebElement shippingRadioBtn =wd.findElement(By.cssSelector("div.panel.panel-default:nth-of-type(4) label input"));
		shippingRadioBtn.click();
		WebElement comment = wd.findElement(By.cssSelector("textarea[name='comment']"));
		comment.sendKeys("Please add gift receipt");
		WebElement continueBtn2 = wd.findElement(By.cssSelector("div.panel.panel-default:nth-of-type(4) div.pull-right input"));
		continueBtn2.click();
		WebElement cashOnDeliveryRadioBtn =wd.findElement(By.cssSelector("div.panel.panel-default:nth-of-type(5) label input"));//cash on delivery
		cashOnDeliveryRadioBtn.click();
		WebElement termsConditionsCheckbox =wd.findElement(By.cssSelector("div.pull-right  input[type='checkbox']"));
		termsConditionsCheckbox.click();
		WebElement continueBtn3 = wd.findElement(By.cssSelector("input#button-payment-method"));
		continueBtn3.click();
		
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

}
