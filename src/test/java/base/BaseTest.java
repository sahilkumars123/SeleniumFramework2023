package base;

import factory.DriverFactory;
import factory.OptionsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.AccountsPage;
import pages.LoginPage;

import java.util.Properties;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage loginpage;
  protected AccountsPage accountsPage;
  protected DriverFactory driverFactory;
  protected Properties properties;
  protected OptionsManager optionsManager;
	
	@BeforeTest
	public void setup() {
    System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");
    driverFactory = new DriverFactory();
    properties = driverFactory.initProperties();
    driver = driverFactory.initDriver(properties);
		loginpage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {

    driver.quit();

	}
	

}
