package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test
	void login() {

		HomePage hp = new HomePage(driver);
		hp.Click_myAccount_drop();
		hp.Click_login_link();

		LoginPage lp = new LoginPage(driver);
		lp.set_email("testmanish@test.com");
		lp.set_pass("12345");
		lp.click_login();

		Assert.assertTrue(lp.get_successStatus());
	}

}
