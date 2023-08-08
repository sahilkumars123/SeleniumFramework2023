package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoTest extends BaseTest {

        @BeforeClass
        public void login(){
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

       @Test
        public void productInfoTest(){
            searchResultsPage = accountsPage.doSearch("macbook");
            productInfoPage = searchResultsPage.selectProduct("Macbook Pro");
            Map<String, String> productActualData = productInfoPage.getProductMasterData();
            System.out.println(productActualData);


        }
}
