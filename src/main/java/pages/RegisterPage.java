package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class RegisterPage {

    private WebDriver driver;
    private ElementUtil elementUtil;
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By email = By.name("email");
    private By phone = By.name("telephone");
    private By password = By.name("password");
    private By confirmPassword = By.name("confirm");
    private By privacyPolicyCheckbox = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public void doRegister(String fName, String lName, String mail,String phoneNumber, String Password, String ConfirmPassword){
        elementUtil.doSendKeys(firstName,fName);
        elementUtil.doSendKeys(lastName,lName);
        elementUtil.doSendKeys(email,mail);
        elementUtil.doSendKeys(phone,phoneNumber);
        elementUtil.doSendKeys(password,Password);
        elementUtil.doSendKeys(confirmPassword,ConfirmPassword);
        elementUtil.doClick(privacyPolicyCheckbox);
        elementUtil.doClick(continueButton);
    }





}
