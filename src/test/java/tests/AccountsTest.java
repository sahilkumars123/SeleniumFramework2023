package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AppConstants;

public class AccountsTest extends BaseTest {

  @BeforeClass
  public void login(){
     accountsPage =loginpage.doLogin("janautomation@gmail.com","Selenium@12345");
  }

  @Test(priority = 1)
  public void checkTitle(){
    Assert.assertTrue(accountsPage.AccgetTitle().equals(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE));
  }

  @Test(priority = 2)
  public void checkAccountsPageHeadersCount(){
     int accHeadersCount = accountsPage.getAccountHeadersCount();
    Assert.assertEquals(accHeadersCount,4);
  }

  @Test(priority = 3)
  public void checkAccountsPageHeaders(){
    Assert.assertEquals(accountsPage.getAccountHeaders(), AppConstants.EXP_ACCOUNTS_HEADERS_LIST);
  }
}
