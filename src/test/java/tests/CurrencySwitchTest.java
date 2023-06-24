package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class CurrencySwitchTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginLink();

        loginPage.login("nn@nn.nn", "112233");

        homePage.waitForDashboard();

        String targetCurrency = "Euro";
        homePage.switchCurrency(targetCurrency);

        String currentCurrency = homePage.getCurrentCurrency();
        if (currentCurrency.equalsIgnoreCase(targetCurrency)) {
            System.out.println("Currency switched to " + targetCurrency + ".");
        } else {
            System.out.println("Currency not switched to " + targetCurrency + ".");
        }

        String originalCurrency = "Dollar";
        homePage.switchCurrency(originalCurrency);

        currentCurrency = homePage.getCurrentCurrency();
        if (currentCurrency.equalsIgnoreCase(originalCurrency)) {
            System.out.println("Currency switched back to " + originalCurrency + ".");
        } else {
            System.out.println("Currency not switched back to " + originalCurrency + ".");
        }

        homePage.clickLogoutLink();

        driver.quit();
    }
}
