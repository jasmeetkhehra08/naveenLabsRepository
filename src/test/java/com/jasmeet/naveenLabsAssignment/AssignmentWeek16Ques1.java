package com.jasmeet.naveenLabsAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssignmentWeek16Ques1 {
	WebDriver wd;
	WebDriverWait wdwait;
	SoftAssert sf;
	@BeforeMethod
	public void setUp() {
		// basic setup to begin the selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JK\\Drivers\\Chrome Driver 108\\chromedriver.exe");
		// launch browser
		wd = new ChromeDriver();
		wdwait = new WebDriverWait(wd, Duration.ofSeconds(10));
		sf = new SoftAssert();
		// launch a page
		wd.get("https://www.demoblaze.com/index.html");
		wd.manage().window().maximize();
	}

	@Test
	public void ValidatePurchaseOfItem() {

        // validate title of the page
		String title = wd.getTitle();
		sf.assertEquals(title, "STORE", "Title does not match");

        //selecting an item
		wdwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(("#tbodyid>div:first-of-type>div>div>h4>a"))));
		wd.findElement(By.cssSelector("#tbodyid>div:first-of-type>div>div>h4>a")).click();

		// validate name of item
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.name")));
		WebElement itemName = wd.findElement(By.cssSelector("h2.name"));
		sf.assertEquals(itemName.getText(), "Samsung galaxy s6", "wrong item name");

        //validate item price
		String itemPrice = wd.findElement(By.cssSelector("h3.price-container")).getText();
		sf.assertEquals(itemPrice, "$360 *includes tax", "item price is incorrect");

        // adding to cart
		wd.findElement(By.cssSelector("a.btn.btn-success.btn-lg")).click();

        //click ok on alert
		wdwait.until(ExpectedConditions.alertIsPresent());
		wd.switchTo().alert().accept();

		// click on cart button
		wd.findElement(By.cssSelector("div.navbar-collapse>ul>li:nth-of-type(4) a")).click();

		// validate name, price and total
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid td:nth-of-type(2)")));
		String name = wd.findElement(By.cssSelector("#tbodyid td:nth-of-type(2)")).getText();
		sf.assertEquals(name, "Samsung galaxy s6", "name is not correct");
		String price = wd.findElement(By.cssSelector("#tbodyid td:nth-of-type(3)")).getText();
		sf.assertEquals(price, "360", "incorrect price");
		String total = wd.findElement(By.cssSelector("div.panel-heading h3")).getText();
		sf.assertEquals(total, "360", "incorrect total");

        //place order
		wd.findElement(By.cssSelector("button.btn.btn-success")).click();

        //place order details
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal.fade.show #name")));
		wd.findElement(By.cssSelector("div.modal.fade.show #name")).sendKeys("JK");
		wd.findElement(By.cssSelector("div.modal.fade.show #country")).sendKeys("Canada");
		wd.findElement(By.cssSelector("div.modal.fade.show #city")).sendKeys("brampton");
		wd.findElement(By.cssSelector("div.modal.fade.show #card")).sendKeys("98765432100");
		wd.findElement(By.cssSelector("div.modal.fade.show #month")).sendKeys("05");
		wd.findElement(By.cssSelector("div.modal.fade.show #year")).sendKeys("2023");

		// click purchase
		wd.findElement(By.cssSelector("#orderModal div.modal-footer>button:last-of-type")).click();

		// validate thankyou message
		wdwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.sweet-alert.showSweetAlert.visible h2")));
		String thankyouMessage = wd.findElement(By.cssSelector("div.sweet-alert.showSweetAlert.visible h2")).getText();
		sf.assertEquals(thankyouMessage, "Thank you for your purchase!", "incorrect thankyou message");

		// order details
		WebElement amount = wd.findElement(By.cssSelector("div.sweet-alert.showSweetAlert.visible>p>br:first-of-type"));
		sf.assertEquals(amount.getText(), "Amount: 360 USD", "incorrect amount");
		WebElement cardNumber = wd
				.findElement(By.cssSelector("div.sweet-alert.showSweetAlert.visible>p>br:nth-of-type(2)"));
		sf.assertEquals(cardNumber.getText(), "Card Number: 98765432100", "incorrect card number");
		String verifyName = wd.findElement(By.cssSelector("div.sweet-alert.showSweetAlert.visible>p>br:nth-of-type(3)"))
				.getText();
		sf.assertEquals(verifyName, "Name: JK", "incorrect name");
		String verifyDate = wd.findElement(By.cssSelector("div.sweet-alert.showSweetAlert.visible>p>br:last-of-type"))
				.getText();
		sf.assertEquals(verifyDate, "Date: 21/11/2022", "incorrect date");

		// press ok
		wd.findElement(By.cssSelector("div.sa-confirm-button-container>button")).click();

		// validate home page
		String homePagetitle = wd.getTitle();
		sf.assertEquals(homePagetitle, "STORE", "Title does not match");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
