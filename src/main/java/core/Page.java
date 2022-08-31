package core;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;
    protected WebDriverWait wdWait;
    protected Actions mkbActions;

    public Page(WebDriver driver){
        this.driver = driver;
        jsExecutor = (JavascriptExecutor) driver;
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mkbActions = new Actions(driver);
    }

    public void waitForElementToBeClickable(String cssSelector) {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    public boolean isElementPresent(String cssSelector){
        try {
            driver.findElement(By.cssSelector(cssSelector));
        } catch(org.openqa.selenium.NoSuchElementException exception){
            System.out.println("No Such Element Exception got caught!");
            return false;
        }
        return true;
    }

    public void copyPasteRobot(){
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(1000);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);

        } catch (AWTException e) {
            System.out.println("AWT exception!!!");
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception!!!");
        }
    }

    public void moveToAndClickElement(WebElement elm) {
        mkbActions.moveToElement(elm).click().build().perform();
    }

    public void scrollToElement(WebElement elm){
        mkbActions.scrollToElement(elm).build().perform();
    }

    public void scrollDownPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mkbActions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

}
