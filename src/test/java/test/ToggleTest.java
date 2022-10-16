package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.TogglePage;
import util.BrowserFactory;
import util.ExcelRead;

public class ToggleTest {

	WebDriver driver;
	TogglePage togglePage;
	ExcelRead exlRead = new ExcelRead("testData\\CategoryData.xlsx");

	String category1 = exlRead.getCellData("Category", "Category Name", 2);
	String category2 = exlRead.getCellData("Category", "Category Name", 3);
	String category3 = exlRead.getCellData("Category", "Category Name", 4);
	String category4 = exlRead.getCellData("Category", "Category Name", 5);
	String category5 = exlRead.getCellData("Category", "Category Name", 6);

	@Before
	public void addCategory() {
		driver = BrowserFactory.init();
		 togglePage = PageFactory.initElements(driver, TogglePage.class);
		togglePage.addCategory(category1);
		togglePage.clickAddButton();
		togglePage.addCategory(category2);
		togglePage.clickAddButton();
		togglePage.addCategory(category3);
		togglePage.clickAddButton();
		togglePage.addCategory(category4);
		togglePage.clickAddButton();
		togglePage.addCategory(category5);
		togglePage.clickAddButton();
	
		
	}
	@Test
	public void toggleAllTest(){
		togglePage.clickToggleAll();
		Assert.assertTrue("All categories are not toggled!!", togglePage.checkToggleAllStatus());
	}
	@After
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}
}