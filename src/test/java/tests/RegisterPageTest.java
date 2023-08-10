package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void regSetup(){
        registerPage = loginpage.navigateToRegisterLink();
    }

    public String getRandomEmailId(){
        return  "OpenCartAuto"+System.currentTimeMillis()+"@open.com";
    }

    @DataProvider
    public Object[][] getUserRegData(){
        return new Object[][]{
                {"pooja","agarwal","9099912345","pooja@123","yes"},
                {"shubham","gupta","9876778283","sahil@123","yes"}
        };
    }

    @Test(dataProvider = "getUserRegData")
    public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe){
        Assert.assertTrue(registerPage.doRegister("Naveen","Testing",getRandomEmailId(),"9876778285","naveen@123","yes"));
    }
}
