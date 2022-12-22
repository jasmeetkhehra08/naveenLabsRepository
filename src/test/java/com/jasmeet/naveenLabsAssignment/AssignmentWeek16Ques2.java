package com.jasmeet.naveenLabsAssignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssignmentWeek16Ques2 {
	WebDriver wd;
	WebDriverWait wdwait;
	SoftAssert sf;
	Actions action;
	String selenium;
	String testNG;

	@BeforeMethod
	public void setUp() {
		// basic setup to begin the selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JK\\Drivers\\Chrome Driver 108\\chromedriver.exe");
		// launch browser
		wd = new ChromeDriver();
		wdwait = new WebDriverWait(wd, Duration.ofSeconds(10));
		sf = new SoftAssert();
		// launch a page
		wd.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		action = new Actions(wd);
		wd.manage().window().maximize();
	}

	@Test
	public void Validate() {
		WebElement highlightedText = wd.findElement(By.cssSelector("div.post.hentry.uncustomized-post-template>h3"));
		sf.assertEquals(highlightedText.getText(), "How to perform mouse hover in Selenium Webdriver", "Text does not match");
		String parentWindow = wd.getWindowHandle();
		System.out.println("parent window: "+parentWindow);

		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown>button")));
		WebElement dropDownMenu = wd.findElement(By.cssSelector("div.dropdown>button"));
		action.moveToElement(dropDownMenu).perform();
		action.click();

		// selenium
		wdwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown-content>a:first-of-type")));
		wd.findElement(By.cssSelector("div.dropdown-content>a:first-of-type")).click();
		Set<String> WindowHandles = wd.getWindowHandles();
		for (String handle : WindowHandles) {
			if (!handle.equals(parentWindow)) {
				wd.switchTo().window(handle);
				selenium = handle;
				System.out.println(selenium);
				sf.assertEquals(wd.getTitle(), "Selenium Webdriver Tutorial - Selenium Tutorial for Beginners",
						"title does not match");
			}
		}

		// testNG
		wd.switchTo().window(parentWindow);
		action.moveToElement(dropDownMenu).perform();
		action.click();
		wdwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown-content>a:nth-of-type(2)")));
		wd.findElement(By.cssSelector("div.dropdown-content>a:nth-of-type(2)")).click();
				System.out.println(wd.getWindowHandle());
				sf.assertEquals(wd.getTitle(), "TestNG Tutorials for Selenium Webdriver with Real Time Examples",
						"title does not match");
		
		// appium
		wd.navigate().back();
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown>button")));
		action.moveToElement(dropDownMenu).perform();
		action.click();
		wdwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown-content>a:last-of-type")));
		wd.findElement(By.cssSelector("div.dropdown-content>a:last-of-type")).click();
		System.out.println(wd.getWindowHandle());
		sf.assertEquals(wd.getTitle(), "Complete Ultimate Appium tutorial for beginners using JAVA for Selenium",
				"title does not match");
		sf.assertAll();
	}

	@AfterTest
	public void tearDown() {
		wd.quit();
	}

}
