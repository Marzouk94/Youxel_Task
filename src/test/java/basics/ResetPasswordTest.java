package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ResetPasswordTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickForgotPasswordLink();
        loginPage.enterForgotPasswordEmail("nn@nn.nn");
        loginPage.clickForgotPasswordButton();

        String successMessage = loginPage.getForgotPasswordSuccessMessage();
        if (successMessage.equals("Email with instructions has been sent to you.")) {
            System.out.println("Reset password test passed");
        } else {
            System.out.println("Reset password test failed");
        }

        driver.quit();
    }
}
