package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utlities.DataProviderClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC003_LoginDPTest extends BaseClass {

	@Test(dataProvider = "dp", dataProviderClass = DataProviderClass.class)
	void login(String email, String password, String result) {

		HomePage hp = new HomePage(driver);
		hp.Click_myAccount_drop();
		hp.Click_login_link();

		LoginPage lp = new LoginPage(driver);
		lp.set_email(email);
		lp.set_pass(password);
		lp.click_login();

		boolean loginStatus = lp.get_successStatus();

		// Data is valid - login success- test pass - do logout
		// login failed - test failed
		// Data is invalid - login success -test failed -do logout
		// login failed - test pass

		if (result.equalsIgnoreCase("valid")) {

			if (loginStatus == true) {

				hp.click_logout_link();
				Assert.assertTrue(true);
			} else {

				Assert.assertTrue(false);
			}

		}

		if (result.equalsIgnoreCase("invalid")) {

			if (loginStatus == true) {

				hp.click_logout_link();
				Assert.assertTrue(false);
			} else {

				Assert.assertTrue(true);
			}

		}

	}

}
