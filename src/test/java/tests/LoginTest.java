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
		accountsPage = loginpage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
		//Assert.assertEquals(actualTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
    Assert.assertTrue(accountsPage.AccgetTitle().equals(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE));
	}

}
