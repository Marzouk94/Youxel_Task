package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.xpath("//button[@id='register-button']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameField);
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameField);
        lastNameElement.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordField);
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }

    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegisterButton();
    }
}
