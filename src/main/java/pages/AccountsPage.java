package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AppConstants;
import utils.ElementUtil;


import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

  private WebDriver driver;

  private ElementUtil elementUtil;

    private By logoutLink = By.linkText("Logout");
    private By accHeaders = By.cssSelector("div#content h2");
    private By search = By.name("search");
    private By searchIcon = By.cssSelector("div#search button");

  public  AccountsPage(WebDriver driver){
    this.driver = driver;
    elementUtil = new ElementUtil(driver);
  }

  public String AccgetTitle(){
      return driver.getTitle();
  }

  public int getAccountHeadersCount(){
     return driver.findElements(accHeaders).size();
  }

  public List<String> getAccountHeaders(){
       List<WebElement> accHeadersList = driver.findElements(accHeaders);
       List<String> accHeaders = new ArrayList<>();
       for(WebElement e: accHeadersList){
             String accHeader = e.getText();
             accHeaders.add(accHeader);
       }
       return accHeaders;
  }

    public SearchResultsPage doSearch(String searchKey) {
        WebElement searchField = elementUtil.waitForElementVisible(search, AppConstants.MEDIUM_DEFAULT_WAIT);
        searchField.clear();
        searchField.sendKeys(searchKey);
        elementUtil.doClick(searchIcon);
        return new SearchResultsPage(driver);//TDD
    }
}
