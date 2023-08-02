package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchResultsPage;
import utils.AppConstants;

public class AccountsTest extends BaseTest {

  @BeforeClass
  public void login(){
     accountsPage =loginpage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
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

  @DataProvider
  public Object[][] getSearchKey(){
    return new Object[][]{
            {"macbook",3},
            {"imac",1},
            {"samsung",2}
    };
  }

  @Test(priority = 4, dataProvider = "getSearchKey")
  public void searchTest(String searchKey, int expectedProductCount){

    SearchResultsPage searchPage = accountsPage.doSearch(searchKey);
    int actualResultsCount = searchPage.getSearchResultsCount();
    Assert.assertEquals(actualResultsCount,expectedProductCount);
  }


}
