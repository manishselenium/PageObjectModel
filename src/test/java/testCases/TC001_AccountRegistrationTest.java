package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	void verify_account_registration() {

		HomePage hp = new HomePage(driver);
		hp.Click_myAccount_drop();
		hp.Click_register_link();

		RegisterPage rp = new RegisterPage(driver);
		rp.set_FirstName("test");
		rp.set_LastName("user");
		rp.set_Email(randomNum() + randomAlpha() + "@test.com");
		rp.set_Telephone("9876545678");
		rp.set_password("Test@123");
		rp.set_confPassword("Test@123");
		rp.check_agree();
		rp.click_continue();

		String actualMsg = rp.getConfirmationMsg();

		Assert.assertEquals(actualMsg, "Your Account Has Been Created!");

	}

}
