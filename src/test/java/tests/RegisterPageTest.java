package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void regSetup(){
        registerPage = loginpage.navigateToRegisterLink();
    }

    @Test
    public void userRegisterTest(){
        Assert.assertTrue(registerPage.doRegister("Naveen","Testing","naveen@test.com","9876778285","naveen@123","yes"));
    }
}
