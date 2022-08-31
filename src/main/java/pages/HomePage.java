package pages;

import core.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class HomePage extends Page {

    @FindBy(css = "ul[class='nav navbar-nav me-auto'] > li > a")
    protected List<WebElement> L1NavigationLinks;

    @FindBy(css = "#search-owner-form > a")
    protected WebElement addOwnerOption;
    @FindBy(id = "firstName")
    protected WebElement firstNameTextField;
    @FindBy(id = "lastName")
    protected WebElement lastNameTextField;
    @FindBy(id = "address")
    protected WebElement addressTextField;
    @FindBy(id = "city")
    protected WebElement cityTextField;
    @FindBy(id = "telephone")
    protected WebElement telephoneTextField;
    @FindBy(css = "button[class='btn btn-primary']")
    protected WebElement addOwnserButton;


    @FindBy(css = "#search-owner-form > div:nth-child(2) > div > button")
    protected WebElement findOwnerOption;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addOwner(String fn, String ln, String address, String city, String telephone) {
        L1NavigationLinks.get(1).click();
        addOwnerOption.click();

        firstNameTextField.sendKeys(fn);
        lastNameTextField.sendKeys(ln);
        addressTextField.sendKeys(address);
        cityTextField.sendKeys(city);
        telephoneTextField.sendKeys(telephone);
        addOwnserButton.click();
    }

    public void findOwner(String ln) {
        L1NavigationLinks.get(1).click();
        lastNameTextField.sendKeys(ln);

        findOwnerOption.click();
    }

    public String getOwnerFullName() {
        WebElement fullName = driver.findElement(By.cssSelector("table[class='table table-striped'] > tbody > tr:first-child > td > b"));
        return fullName.getText();
    }
}