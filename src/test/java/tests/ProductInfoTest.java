package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest {

        @BeforeClass
        public void productInfoTest(){
           accountsPage = loginpage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
        }

    @DataProvider
    public Object[][] productTestData(){
        return new Object[][]{
                {"macbook","MacBook Pro"},
                {"macbook","MacBook Air"},
                {"imac","iMac"},
                {"samsung","Samsung SyncMaster 941BW"},
                {"samsung","Samsung Galaxy Tab 10.1"},
        };
    }

        @Test(dataProvider = "productTestData")
        public void productHeaderTest(String searchKey, String productName){
           searchResultsPage = accountsPage.doSearch(searchKey);
           productInfoPage = searchResultsPage.selectProduct(productName);
           String actualProductValue = productInfoPage.getProductHeaderValue();
           Assert.assertEquals(actualProductValue, productName);
        }

    @DataProvider
    public Object[][] productData(){
        return new Object[][]{
                {"macbook","MacBook Pro",4},
                {"macbook","MacBook Air",4},
                {"imac","iMac",3},
                {"samsung","Samsung SyncMaster 941BW",1},
                {"samsung","Samsung Galaxy Tab 10.1",7},
        };
    }
        @Test(dataProvider = "productData")
        public void getProductImagesCount(String searchKey, String productName, int expectedProductCount){
          searchResultsPage = accountsPage.doSearch(searchKey);
          productInfoPage = searchResultsPage.selectProduct(productName);
          int productImagesCount = productInfoPage.getProductImagesCount();
          Assert.assertEquals(productImagesCount,expectedProductCount);
        }
}
