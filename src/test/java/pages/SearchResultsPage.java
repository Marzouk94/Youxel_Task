package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    // Locators
    private By productResults = By.cssSelector(".product-item");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDisplayed(String productName) {
        List<WebElement> productElements = driver.findElements(productResults);
        for (WebElement productElement : productElements) {
            WebElement productTitleElement = productElement.findElement(By.cssSelector(".product-title"));
            String displayedProductName = productTitleElement.getText();
            if (displayedProductName.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}
