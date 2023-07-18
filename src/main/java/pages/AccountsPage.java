package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

  private WebDriver driver;
  private ElementUtil elementUtil;
  private By accHeaders = By.cssSelector("#content h2");


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
}
