package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txt_firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txt_lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement txt_telephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement check_agree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath ="//div[@id='content']/h1")
	WebElement successMsg;

	public void set_FirstName(String fname) {

		txt_firstName.sendKeys(fname);

	}

	public void set_LastName(String lname) {

		txt_lastName.sendKeys(lname);

	}

	public void set_Email(String email) {

		txt_email.sendKeys(email);

	}

	public void set_Telephone(String telNum) {

		txt_telephone.sendKeys(telNum);

	}

	public void set_password(String pass) {
		txt_password.sendKeys(pass);

	}

	public void set_confPassword(String cpass) {

		txt_confPassword.sendKeys(cpass);

	}

	public void check_agree() {

		check_agree.click();

	}

	public void click_continue() {

		btn_continue.click();

	}
	
	public String getConfirmationMsg() {
		
		try {
		
		String message_txt = successMsg.getText();
		
		return message_txt;
		}catch(Exception e) {
			
			return(e.getMessage());
		}
	}

}
