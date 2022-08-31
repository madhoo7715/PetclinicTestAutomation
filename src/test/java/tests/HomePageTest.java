
package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import core.BasePageTest;



public class HomePageTest extends BasePageTest {

    @Test(priority = 0)
    public void addOwnerTest(){
        homePage.addOwner("Ranga", "Swamy", "Jersey City", "Jersey City", "12345");
        Assert.assertEquals(homePage.getOwnerFullName(), "Ranga Swamy");
    }

    @Test(priority = 1)
    public void findOwnerTest(){
        homePage.findOwner("Ranga");
        Assert.assertEquals(homePage.getOwnerFullName(), "Billa Ranga");
    }

}