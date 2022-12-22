package com.jasmeet.naveenLabsAssignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssignmentWeek16Ques3 {
	WebDriver wd;
	WebDriverWait wdwait;
	SoftAssert sf;
	String newTab1;
	String newTab2;
	String newTab3;

	@BeforeMethod
	public void setUp() {
		// basic setup to begin the selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JK\\Drivers\\Chrome Driver 108\\chromedriver.exe");
		// launch browser
		wd = new ChromeDriver();
		wdwait = new WebDriverWait(wd, Duration.ofSeconds(10));
		sf = new SoftAssert();
		// launch a page
		wd.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		wd.manage().window().maximize();
	}

	@Test
	public void validateTitles() {
		// validate title
		WebElement multiWindowTitle = wd.findElement(By.cssSelector("h3.post-title.entry-title"));
		sf.assertEquals(multiWindowTitle.getText(), "Multiple window examples", "title does not match");
		// parent tab
		String parentWindowHandle = wd.getWindowHandle();
		System.out.println("parent window handle: " + parentWindowHandle);

		wd.findElement(By.cssSelector("div.post-body.entry-content a:first-of-type")).click();

		Set<String> WindowHandles = wd.getWindowHandles();
		for (String handle : WindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				wd.switchTo().window(handle);
				newTab1 = handle;
				System.out.println("Tab 1 " + newTab1);
				sf.assertEquals(wd.getTitle(), "Google", "Title does not match");
			}
		}

		wd.switchTo().window(parentWindowHandle);
		wdwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.post-body.entry-content a:nth-of-type(2)")));
		wd.findElement(By.cssSelector("div.post-body.entry-content a:nth-of-type(2)")).click();

		Set<String> WindowHandles1 = wd.getWindowHandles();
		for (String handle : WindowHandles1) {
			if (!handle.equals(parentWindowHandle) && !handle.equals(newTab1)) {
				wd.switchTo().window(handle);
				newTab2 = handle;
				System.out.println("Tab 2 " + newTab2);
				sf.assertEquals(wd.getTitle(), "Facebook - log in or sign up", "Title does not match");
			}
		}

		wd.switchTo().window(parentWindowHandle);
		wdwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.post-body.entry-content a:nth-of-type(3)")));
		wd.findElement(By.cssSelector("div.post-body.entry-content a:nth-of-type(3)")).click();

		Set<String> WindowHandles2 = wd.getWindowHandles();
		for (String handle : WindowHandles2) {
			if (!handle.equals(parentWindowHandle) && !handle.equals(newTab1) && !handle.equals(newTab2)) {
				wd.switchTo().window(handle);
				newTab3 = handle;
				System.out.println("Tab 3 " + newTab3);
				sf.assertEquals(wd.getTitle(),
						"Yahoo | Mail, Weather, Search, News, Finance, Sports, Shopping, Entertainment, Video",
						"Title does not match");
			}
		}

		wd.switchTo().window(parentWindowHandle);
		wdwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.post-body.entry-content a:last-of-type")));
		wd.findElement(By.cssSelector("div.post-body.entry-content a:last-of-type")).click();
		System.out.println(wd.getWindowHandle());
		sf.assertEquals(wd.getTitle(), "Facebook - log in or sign up", "Title does not match");
		sf.assertAll();
	}

	@AfterTest
	public void tearDown() {
		wd.quit();
	}
}
