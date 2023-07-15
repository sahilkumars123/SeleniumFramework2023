package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.AppConstants;
import utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By email = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	//getLoginPageTitle
	//getLoginPageURL
	//isForgotPwdLinkExist
	//doLogin
	
	public String getLoginPageTitle() {
		
		 String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE_VALUE,AppConstants.MEDIUM_DEFAULT_WAIT);
		 System.out.println("title is:: "+title);
		 return title;
	}
	
	public String getLoginPageURL() {

		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.MEDIUM_DEFAULT_WAIT);
		 System.out.println("url is:: "+url);
		 return url;
	}
	public boolean isForgotPwdLinkExist() {
		
		return eleUtil.waitForElementVisible(forgotPwdLink, 10).isDisplayed();
		
	}
	public String doLogin(String username, String pwd) {
		
		eleUtil.waitForElementVisible(email, 10).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE, AppConstants.MEDIUM_DEFAULT_WAIT);
		
		
	}
	
	
	
	

}
