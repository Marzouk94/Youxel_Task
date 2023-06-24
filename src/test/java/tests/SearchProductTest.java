package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;

public class SearchProductTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginLink();

        loginPage.login("nn@nn.nn", "112233");

        homePage.waitForDashboard();

        String productName = "Apple iCam";
        homePage.searchProduct(productName);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        boolean isProductFound = searchResultsPage.isProductDisplayed(productName);
        if (isProductFound) {
            System.out.println("Product found in search results.");
        } else {
            System.out.println("Product not found in search results.");
        }

        // Logout
        homePage.clickLogoutLink();

        // Close the browser
        driver.quit();
    }
}
