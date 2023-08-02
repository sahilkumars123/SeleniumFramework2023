package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AppConstants;
import utils.ElementUtil;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By productHeader = By.cssSelector("div#content h1");
    private By productImages = By.xpath("//ul[@class='thumbnails']//img");
    private By quantity = By.name("quantity");
    private By addToCardBtn = By.id("button-cart");

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
    public String getProductHeaderValue(){
          return elementUtil.doElementGetText(productHeader);
    }

    public int getProductImagesCount(){
            int actualProductImages = elementUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
            System.out.printf("Total Product Images for:: "+getProductHeaderValue()+ "is:: "+actualProductImages);
            return actualProductImages;
    }










}
