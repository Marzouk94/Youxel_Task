package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;

    // Locators
    private By loginLink = By.linkText("Log in");
    private By registerLink = By.linkText("Register");
    private By logoutLink = By.linkText("Log out");
    private By dashboard = By.xpath("//div[@class='topic-block-title']");
    private By searchBox = By.name("q");
    private By currencyDropdown = By.id("customerCurrency");
    private By categoryList = By.xpath("//ul[@class='top-menu notmobile']/li/a");
    private By subCategoryList = By.xpath("//ul[@class='top-menu notmobile']/li/div/div/ul/li/a");
    private By categoryMenu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(), 'Computers')]");
    private By subCategoryMenu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(), 'Notebooks')]");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLoginLink() {
        WebElement loginLinkElement = driver.findElement(loginLink);
        loginLinkElement.click();

        return new LoginPage(driver);
    }

    public RegistrationPage clickRegisterLink() {
        WebElement registerLinkElement = driver.findElement(registerLink);
        registerLinkElement.click();

        return new RegistrationPage(driver);
    }

    public void clickLogoutLink() {
        WebElement logoutLinkElement = driver.findElement(logoutLink);
        logoutLinkElement.click();
    }

    public void waitForDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
    }

    public void searchProduct(String productName) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.sendKeys(productName);
        searchBoxElement.submit();
    }

    public void switchCurrency(String currency) {
        Select currencyDropdownElement = new Select(driver.findElement(currencyDropdown));
        currencyDropdownElement.selectByVisibleText(currency);
    }

    public String selectCategory() {
        WebElement categoryElement = driver.findElement(categoryMenu);
        categoryElement.click();
        WebElement subCategoryElement = driver.findElement(subCategoryMenu);
        if (subCategoryElement.isDisplayed()) {
            subCategoryElement.click();
            return subCategoryElement.getText();
        }

        return null;
    }
    public String getCurrentCurrency() {
        WebElement currencyElement = driver.findElement(currencyDropdown);
        Select currencySelect = new Select(currencyElement);
        WebElement selectedCurrencyOption = currencySelect.getFirstSelectedOption();
        return selectedCurrencyOption.getText();
    }


}
