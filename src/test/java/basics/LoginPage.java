package basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//button[contains(text(), 'Log in')]");
    private By forgotPasswordLink = By.linkText("Forgot password?");
    private By forgotPasswordEmailField = By.id("Email");
    private By forgotPasswordButton = By.xpath("//input[@value='Reset password']");
    private By forgotPasswordSuccessMessage = By.cssSelector(".result");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }


    public void login(String email, String password) {
        WebElement emailFieldElement = driver.findElement(emailField);
        WebElement passwordFieldElement = driver.findElement(passwordField);
        WebElement loginButtonElement = driver.findElement(loginButton);

        emailFieldElement.sendKeys(email);
        passwordFieldElement.sendKeys(password);
        loginButtonElement.click();
    }

    public void clickForgotPasswordLink() {
        WebElement forgotPasswordLinkElement = driver.findElement(forgotPasswordLink);
        forgotPasswordLinkElement.click();
    }

    public void enterForgotPasswordEmail(String email) {
        WebElement forgotPasswordEmailFieldElement = driver.findElement(forgotPasswordEmailField);
        forgotPasswordEmailFieldElement.sendKeys(email);
    }

    public void clickForgotPasswordButton() {
        WebElement forgotPasswordButtonElement = driver.findElement(forgotPasswordButton);
        forgotPasswordButtonElement.click();
    }

    public String getForgotPasswordSuccessMessage() {
        WebElement successMessageElement = driver.findElement(forgotPasswordSuccessMessage);
        return successMessageElement.getText();
    }
}
