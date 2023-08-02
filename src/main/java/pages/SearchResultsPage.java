package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AppConstants;
import utils.ElementUtil;

public class SearchResultsPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By productsResults = By.cssSelector("div.product-layout");



    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public int getSearchResultsCount() {
        return elementUtil.waitForElementsVisible(productsResults, AppConstants.MEDIUM_DEFAULT_WAIT).size();
    }

    public ProductInfoPage selectProduct(String productName){
        elementUtil.clickElementWhenReady(By.linkText(productName), AppConstants.MEDIUM_DEFAULT_WAIT);
        return new ProductInfoPage(driver);
    }

}
