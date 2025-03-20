package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	// locator

	@FindBy(xpath = "//ul[@class='list-inline']/li[2]/a")
	WebElement myAccount_drop;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register_link;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement login_link;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout_link;

	// Action
	public void Click_myAccount_drop() {
		myAccount_drop.click();

	}

	public void Click_register_link() {

		register_link.click();
	}

	public void Click_login_link() {

		login_link.click();
	}

	public void click_logout_link() {
		
		logout_link.click();

	}

}
