package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.AccountsPage;
import pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage loginpage;
  protected AccountsPage accountsPage;
  protected DriverFactory driverFactory;
	
	@BeforeTest
	public void setup() {
    System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");
    driverFactory = new DriverFactory();
    driver = driverFactory.initDriver("chrome");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginpage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {

    driver.quit();

	}
	

}
