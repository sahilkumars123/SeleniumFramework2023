package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage loginpage;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginpage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
