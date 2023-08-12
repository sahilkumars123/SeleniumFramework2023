package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppConstants;
import utils.ExcelUtil;

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

    @DataProvider
    public Object[][] getUserRegSheetData(){
       return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
    }

    @Test(dataProvider = "getUserRegSheetData")
    public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe){
        Assert.assertTrue(registerPage.doRegister(firstName,lastName,getRandomEmailId(),telephone,password, subscribe));
    }
}
