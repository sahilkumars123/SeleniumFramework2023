package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 */
public class DriverFactory {

   WebDriver driver;
   Properties properties;
   OptionsManager optionsManager;

  /**
   * This is use to intialize the driver
   * @return it returns the driver
   */
  public WebDriver initDriver(Properties properties){
    String browserName = properties.getProperty("browser");
    System.out.println("browser name is:: "+browserName);
    optionsManager = new OptionsManager(properties);


    switch (browserName.toLowerCase()){

      case "chrome":
        driver = new ChromeDriver(optionsManager.getChromeOptions());
        break;
      case "firefox":
        driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
        break;
      case "edge":
        driver = new EdgeDriver(optionsManager.getEdgeOptions());
        break;
      case "safari":
        driver = new SafariDriver();
        break;
      default:
        System.out.println("please enter correct browser name:: "+browserName);
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get(properties.getProperty("url"));
    return driver;
  }

  /**
   * This method is used to intialize the properties
   * @return This method will return the Properties object
   */
  public Properties initProperties(){

    properties = new Properties();
  try {
    FileInputStream ip = new FileInputStream("./src/resources/config.properties");
    properties.load(ip);
  } catch (FileNotFoundException e) {
    throw new RuntimeException(e);
  } catch (IOException e) {
    throw new RuntimeException(e);
  }
  return properties;
}

}
