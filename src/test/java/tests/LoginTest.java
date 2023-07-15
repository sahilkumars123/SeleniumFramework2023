package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.AppConstants;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualLoginPageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String actualLoginPageUrl = loginpage.getLoginPageURL();
		Assert.assertTrue(actualLoginPageUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Test(priority = 3)
	public void isForgotPwdLinkExistTest() {

		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@Test(priority = 4)
	public void doLogin() {
		String actualTitle = loginpage.doLogin("janautomation@gmail.com", "Selenium@12345");
		Assert.assertEquals(actualTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}

}
