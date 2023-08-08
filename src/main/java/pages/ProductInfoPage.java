package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AppConstants;
import utils.ElementUtil;

import java.util.*;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By productHeader = By.cssSelector("div#content h1");
    private By productImages = By.xpath("//ul[@class='thumbnails']//img");
    private By quantity = By.name("quantity");
    private By addToCardBtn = By.id("button-cart");
    private By productMetaData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]/li");
    private By productPriceData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][2]/li");

    private Map<String, String> productMap;


    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
    public String getProductHeaderValue(){

        return elementUtil.doElementGetText(productHeader);
    }

    public int getProductImagesCount(){
            int actualProductImages = elementUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
            System.out.println("Total Product Images for:: "+getProductHeaderValue()+ "is:: "+actualProductImages);
            return actualProductImages;
    }

//    Brand: Apple
//    Product Code: Product 18
//    Reward Points: 800
//    Availability: In Stock
    private void getProductMetaData(){
        List<WebElement> metaData = elementUtil.waitForElementsVisible(productMetaData,AppConstants.MEDIUM_DEFAULT_WAIT);
        //Map<String,String> metaMap = new HashMap<>();
        for(WebElement e: metaData){
            String data = e.getText();
            String key = data.split(":")[0].trim();
            String value = data.split(":")[1].trim();
            productMap.put(key,value);
        }
        //return metaMap;
    }

//    $2,000.00 //0
//    Ex Tax: $2,000.00 //1
    private void getProductPriceData(){
        List<WebElement> priceData = elementUtil.waitForElementsVisible(productPriceData,AppConstants.MEDIUM_DEFAULT_WAIT);
       // Map<String,String> priceMap = new HashMap<>();

        String actPrice = priceData.get(0).getText();
        String externalTax = priceData.get(1).getText().split(":")[0].trim();
        String externalTaxValue = priceData.get(1).getText().split(":")[1].trim();
        productMap.put("price",actPrice);
        productMap.put(externalTax, externalTaxValue);
        //return priceMap;
    }

//    Brand: Apple
//    Product Code: Product 18
//    Reward Points: 800
//    Availability: In Stock
//    $2,000.00
//    Ex Tax: $2,000.00
    public Map<String, String> getProductMasterData(){
        productMap = new HashMap<String, String>();
        //productMap = new LinkedHashMap<String,String>();   --- for inserting in the order it receives the data.
        //productMap = new TreeMap<String, String>(); --- for inserting in alphabetical order.
        productMap.put("productHeader",getProductHeaderValue());
        productMap.put("productImagesCount",String.valueOf(getProductImagesCount()));
        getProductMetaData();
        getProductPriceData();

        return productMap;
    }

}
