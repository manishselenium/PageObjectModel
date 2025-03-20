package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_pass;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_login;
	
	@FindBy(xpath ="//div[@id='content']/h2")
	WebElement success_login_txt;


	public void set_email(String email) {

		txt_email.sendKeys(email);
	}

	public void set_pass(String password) {

		txt_pass.sendKeys(password);
	}

	public void click_login() {

		btn_login.click();

	}
	
	public boolean get_successStatus() {
		
		boolean Header_Status =success_login_txt.isDisplayed();
		
		return Header_Status;
		
	}

}
