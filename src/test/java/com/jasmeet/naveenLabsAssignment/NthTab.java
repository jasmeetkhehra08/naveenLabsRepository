package com.jasmeet.naveenLabsAssignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NthTab {
	WebDriver wd;
	String childWindowHandle1;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JK\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		wd = new ChromeDriver();

		// launch a page
		wd.get("https://demoqa.com/browser-windows");
		wd.manage().window().maximize();
	}

	@Test
	public void findNthTab() {
		String parentWindowHandle = wd.getWindowHandle();
		System.out.println("parent window handle: " + parentWindowHandle);
		sleep();
		wd.findElement(By.cssSelector("#tabButton")).click();

		Set<String> WindowHandles = wd.getWindowHandles();
		for (String handle : WindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				wd.switchTo().window(handle);
				childWindowHandle1 = handle;
				System.out.println("Child window handle " + childWindowHandle1);
			}
		}
		sleep();
		wd.switchTo().window(parentWindowHandle);
		wd.findElement(By.cssSelector("#tabButton")).click();
		sleep();

		Set<String> allWindowHandles = wd.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle) && !handle.equals(childWindowHandle1)) {
				wd.switchTo().window(handle);
				System.out.println("2nd Child window handle " + handle);
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}