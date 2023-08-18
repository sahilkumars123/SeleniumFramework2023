package base;

import factory.DriverFactory;
import factory.OptionsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.Properties;

public class BaseTest {
	
	WebDriver driver;

    protected LoginPage loginpage;
  protected AccountsPage accountsPage;
  protected SearchResultsPage searchResultsPage;
  protected ProductInfoPage productInfoPage;
  protected DriverFactory driverFactory;
  protected Properties properties;
  protected OptionsManager optionsManager;
  protected SoftAssert softAssert;
  protected RegisterPage registerPage;
	
	@BeforeTest
	public void setup() {
    //System.setProperty("webdriver.chrome.driver", "D://Softwares//chromedriver_win32 (2)//chromedriver.exe");
    driverFactory = new DriverFactory();
    properties = driverFactory.initProperties();
    driver = driverFactory.initDriver(properties);
    loginpage = new LoginPage(driver);
    softAssert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {

    driver.quit();

	}
	

}
