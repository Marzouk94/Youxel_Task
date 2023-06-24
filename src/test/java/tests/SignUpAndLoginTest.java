package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.time.Duration;


public class SignUpAndLoginTest {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = homePage.clickRegisterLink();


        registrationPage.register(First_Name, "NN", "nn@nn.nn", "112233", "112233");

        homePage.clickLoginLink();

        loginPage.enterEmail("nn@nn.nn");
        loginPage.enterPassword("112233");
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.titleContains("Dashboard"));

        driver.quit();

    }

}


