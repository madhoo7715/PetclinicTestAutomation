package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.ConfigReader;


public class BasePageTest {
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;
    protected HomePage homePage;


    @BeforeSuite
    public void testPlanSetup(ITestContext context) {
        ConfigReader.initializeProperties();
    }

    @BeforeClass
    public void setUpDriver(){
        driverSetUp();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass
    public void closeDriver(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Close Driver: Interrupted Exception Found!!");
        }
        driver.close();
    }

    public void driverSetUp(){
        String browser = System.getProperty("browser");
        String headless = System.getProperty("headless");
        String maximize = System.getProperty("maximize");

        if(browser.equalsIgnoreCase("CHROME")){
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();

            if(headless.equalsIgnoreCase("TRUE")) {
                chromeOptions.addArguments("--headless");
            }
            if(maximize.equalsIgnoreCase("TRUE")) {
                chromeOptions.addArguments("start-maximized");
            }
            driver = new ChromeDriver(chromeOptions);

        } else {
            System.out.println("The driver is not supported.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigReader.getPetClinicProperty("baseURL"));
    }
}
