package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

  private ChromeOptions co;
  private FirefoxOptions fo;
  private EdgeOptions eo;

  private Properties properties;


  public OptionsManager(Properties properties)
  {
      this.properties = properties;
  }

  public ChromeOptions getChromeOptions(){
    co = new ChromeOptions();
    if(Boolean.parseBoolean(properties.getProperty("headless"))){
          co.addArguments("--headless=new");
    }
    if(Boolean.parseBoolean(properties.getProperty("incognito"))){
      co.addArguments("--incognito");
    }
    return co;
  }

  public FirefoxOptions getFirefoxOptions(){
    fo = new FirefoxOptions();
    if(Boolean.parseBoolean(properties.getProperty("headless"))){
      fo.addArguments("--headless=new");
    }
    if(Boolean.parseBoolean(properties.getProperty("incognito"))){
      fo.addArguments("--incognito");
    }
    return fo;
  }

  public EdgeOptions getEdgeOptions(){
    eo = new EdgeOptions();
    if(Boolean.parseBoolean(properties.getProperty("headless"))){
      eo.addArguments("--headless=new");
    }
    if(Boolean.parseBoolean(properties.getProperty("incognito"))){
      eo.addArguments("--incognito");
    }
    return eo;
  }
}
