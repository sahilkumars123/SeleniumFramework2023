package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppConstants;
import utils.ExcelUtil;

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

    @DataProvider
    public Object[][] productSheetData(){
       return ExcelUtil.getTestData(AppConstants.PRODUCT_SHEET_NAME);
    }

        @Test(dataProvider = "productSheetData")
        public void getProductImagesCount(String searchKey, String productName, String expectedProductCount){
          searchResultsPage = accountsPage.doSearch(searchKey);
          productInfoPage = searchResultsPage.selectProduct(productName);
          double productImagesCount = productInfoPage.getProductImagesCount();
          Assert.assertEquals(productImagesCount,Double.parseDouble(expectedProductCount));
        }

        //With Hard Assert it was difficult as if first assert was failing then it was not
        //going to the below written asserts. Soft Assert will assert all the assertions then
        //only shows the result.
       @Test
        public void productInfoTest(){
            searchResultsPage = accountsPage.doSearch("macbook");
            productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
            Map<String, String> productActualData = productInfoPage.getProductMasterData();
            System.out.println(productActualData);
           softAssert.assertEquals(productActualData.get("Brand"),"Apple");
           softAssert.assertEquals(productActualData.get("Reward Points"),"800");
           softAssert.assertEquals(productActualData.get("Availability"),"In Stock");
           softAssert.assertEquals(productActualData.get("productHeader"),"MacBook Pro");
           softAssert.assertEquals(productActualData.get("price"),"$2,000.00");
           softAssert.assertAll();


        }
}
