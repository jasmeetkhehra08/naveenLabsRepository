package com.jasmeet.assignmentWeek18.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class WishList extends TestBase {
	public WishList() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	@FindBy(css = "table[class='table table-bordered table-hover'] tbody>tr:last-of-type>td:last-of-type>a")
	WebElement removeProduct;
	
	@FindBy(css = "div.alert")
	WebElement successBanner;
	
	public void removeProduct() {
		removeProduct.click();
	}
	
	public void successBanner() {
		successBanner.getText();
	}

	public WebElement getElementFromTheTable(String productName, myWishList column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String orderIdText = cells.get(1).getText();
			if (orderIdText.equals(productName)) {
				return cells.get(columnIndex);
			}
		}
		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(myWishList column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}
		}
		System.out.println("Column does not exist");
		return -1;
	}

	public enum myWishList {
		IMAGE("image"), PRODUCT_NAME("product name"), MODEL("model"), STOCK("stock"), UNIT_PRICE("unit price"),
		ACTION("action");

		String name;

		private myWishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
