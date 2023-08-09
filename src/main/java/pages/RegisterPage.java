package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AppConstants;
import utils.ElementUtil;

public class RegisterPage {

    private WebDriver driver;
    private ElementUtil elementUtil;
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmpassword = By.id("input-confirm");
    private By subscribeYes = By.xpath("//label[normalize-space()='Yes']");
    private By subscribeNo = By.xpath("//label[normalize-space()='No']");
    private By privacyPolicyCheckbox = By.name("agree");

    private By agreeCheckBox = By.name("agree");
    private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

    private By successMessg = By.cssSelector("div#content h1");
    private By logoutLink = By.linkText("Logout");
    private By registerLink = By.linkText("Register");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public Boolean doRegister(String fName, String lName, String mail,String phoneNumber, String Password, String subscribe){
        elementUtil.waitForElementVisible(firstName, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(fName);
        elementUtil.doSendKeys(lastName,lName);
        elementUtil.doSendKeys(email,mail);
        elementUtil.doSendKeys(telephone,phoneNumber);
        elementUtil.doSendKeys(password,Password);
        elementUtil.doSendKeys(confirmpassword,Password);

        if(subscribe.equalsIgnoreCase("yes")){
            elementUtil.doClick(subscribeYes);
        }
        else {
            elementUtil.doClick(subscribeNo);
        }
        elementUtil.doClick(privacyPolicyCheckbox);
        elementUtil.doClick(continueButton);

       String actualSuccessMsg = elementUtil.waitForElementVisible(successMessg,AppConstants.MEDIUM_DEFAULT_WAIT).getText();
        System.out.println(actualSuccessMsg);
        if(actualSuccessMsg.contains(AppConstants.USER_RESG_SUCCESS_MESSG)){
            return true;
        }
        return false;
    }
}
