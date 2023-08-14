package factory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
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
   public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

  /**
   * This is use to intialize the driver
   * @return it returns the driver
   */
  public WebDriver initDriver(Properties properties){
    String browserName = properties.getProperty("browser"); // if we need to read it from Properties file.
    //String browserName = System.getProperty("browser"); //If we need to read it from Environment variables file.
    System.out.println("browser name is:: "+browserName);
    optionsManager = new OptionsManager(properties);


    switch (browserName.toLowerCase()){

      case "chrome":
        //driver = new ChromeDriver(optionsManager.getChromeOptions());
        threadLocal.set(new ChromeDriver(optionsManager.getChromeOptions()));
        break;
      case "firefox":
        //driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
        threadLocal.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
        break;
      case "edge":
        //driver = new EdgeDriver(optionsManager.getEdgeOptions());
        threadLocal.set(new EdgeDriver(optionsManager.getEdgeOptions()));
        break;
      case "safari":
        threadLocal.set(new SafariDriver());
        //driver = new SafariDriver();
        break;
      default:
        System.out.println("please enter correct browser name:: "+browserName);
    }

    getDriver().manage().window().maximize();
    getDriver().manage().deleteAllCookies();
    getDriver().get(properties.getProperty("url"));
    return getDriver();
  }

  public static WebDriver getDriver(){

    return threadLocal.get();
  }

  /**
   * This method is used to intialize the properties
   * @return This method will return the Properties object
   */
  public Properties initProperties(){

//mvn clean install -Denv="qa"

    FileInputStream ip = null;
    properties = new Properties();

    String envName = System.getProperty("env");

    try {
      if (envName == null) {
        System.out.println("no env is given ...hence running it on QA env");
        ip = new FileInputStream("./src/resources/qa.config.properties");
      } else {
        System.out.println("environment name is:: "+envName);
        switch (envName.toLowerCase().trim()) {
          case "qa":
            ip = new FileInputStream("./src/resources/qa.config.properties");
            break;
          case "dev":
            ip = new FileInputStream("./src/resources/dev.config.properties");
            break;
          case "stage":
            ip = new FileInputStream("./src/resources/stage.config.properties");
            break;
          case "uat":
            ip = new FileInputStream("./src/resources/uat.config.properties");
            break;
          case "prod":
            ip = new FileInputStream("./src/resources/prod.config.properties");
            break;
          default:
            System.out.println("Please pass the correct envName:: " + envName);
            break;
        }
      }
    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }
    try {
      properties.load(ip);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return properties;
}

/**
 * take Screenshot
 */
  public static String getScreenshot(String methodName){

   File srcFile =  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
   String path =  System.getProperty("user.dir")+"/screenshot/"+methodName+"_"+System.currentTimeMillis()+".png";
   File destination = new File(path);
    try {
      FileHandler.copy(srcFile,destination);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return path;
  }
}
