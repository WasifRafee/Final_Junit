package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TogglePage {

	WebDriver driver;

	public TogglePage(WebDriver a) {
		this.driver = a;
	}

	// Web Elements
	@FindBy(how = How.NAME, using = "data")
	WebElement CATEGORY_NAME_ELEMENT;
	@FindBy(how = How.CSS, using = "input[type='submit'][value='Add']")
	WebElement ADD_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "input[type='submit'][value='Remove'")
	WebElement REMOVE_BUTTON_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement TOGGLE_ONE_FIRST_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[1]")
	WebElement TOGGLE_ONE_SECOND_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[2]")
	WebElement TOGGLE_ONE_THIRD_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[3]")
	WebElement TOGGLE_ONE_FOURTH_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[4]")
	WebElement TOGGLE_ONE_FIFTH_ELEMENT;
	@FindBy(how = How.NAME, using = "allbox")
	WebElement TOGGLE_ALL_ELEMENT;

	// Methods

	public void addCategory(String category) {
		CATEGORY_NAME_ELEMENT.sendKeys(category);
	}

	public void clickAddButton() {
		ADD_BUTTON_ELEMENT.click();
	}

	public void clickRemoveButton() {
		REMOVE_BUTTON_ELEMENT.click();
	}

	public void clickToggleOne() {
		TOGGLE_ONE_FIRST_ELEMENT.click();
	}

	public void clickToggleAll() {
		TOGGLE_ALL_ELEMENT.click();
	}

	public boolean checkToggleAllStatus() {

		if (TOGGLE_ONE_FIRST_ELEMENT.isSelected() && TOGGLE_ONE_SECOND_ELEMENT.isSelected()
				&& TOGGLE_ONE_THIRD_ELEMENT.isSelected() && TOGGLE_ONE_FOURTH_ELEMENT.isSelected()
				&& TOGGLE_ONE_FIFTH_ELEMENT.isSelected()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkRemovedOneStatus() {
		
		try {
		return TOGGLE_ONE_FIRST_ELEMENT.isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
		
		
	}

	public boolean checkRemovedAllStatus() {
		try {return TOGGLE_ONE_SECOND_ELEMENT.isDisplayed() && TOGGLE_ONE_THIRD_ELEMENT.isDisplayed()
				&& TOGGLE_ONE_FOURTH_ELEMENT.isDisplayed() && TOGGLE_ONE_FIFTH_ELEMENT.isDisplayed(); 
			
		} catch(org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}

}
