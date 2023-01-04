package com.jasmeet.assignmentWeek18.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class HomePage extends TestBase{
	Actions action = new Actions(driver);
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	WebElement category;
	
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement selectLaptopAndBooks;
	
	public laptopsAndNotebooks selectLaptopAndNotebooks() {
	action.moveToElement(category).perform();
	selectLaptopAndBooks.click();
	return new laptopsAndNotebooks();
	}
	
	
}
