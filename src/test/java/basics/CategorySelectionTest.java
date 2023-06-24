package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CategorySelectionTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginLink();

        loginPage.login("nn@nn.nn", "112233");

        homePage.waitForDashboard();

        String selectedCategory = homePage.selectCategory();

        if (selectedCategory != null) {
            System.out.println("Selected Category: " + selectedCategory);
        } else {
            System.out.println("Failed to select a category.");
        }

        homePage.clickLogoutLink();

        driver.quit();
    }
}
