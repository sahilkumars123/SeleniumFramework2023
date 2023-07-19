package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

  private WebDriver driver;

  public WebDriver initDriver(String browserName){

    System.out.println("browser name is:: "+browserName);

    switch (browserName.toLowerCase()){

      case "chrome":
        driver = new ChromeDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      case "safari":
        driver = new SafariDriver();
        break;
      default:
        System.out.println("please enter correct browser name:: "+browserName);
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    return driver;
  }




}
