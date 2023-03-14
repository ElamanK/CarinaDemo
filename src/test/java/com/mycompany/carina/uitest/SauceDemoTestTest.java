package com.mycompany.carina.uitest;
import com.mycompany.carina.mydemo.uitest.pages.CartPage;
import com.mycompany.carina.mydemo.uitest.pages.HomePage;
import com.mycompany.carina.mydemo.uitest.pages.LoginPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTestTest extends AbstractSauceDemoTest {

    @Test
    public void loginTest()  {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("user"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
    }


    @Test
    public void testCartBadgeNumber(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        HomePage homePage = loginUtils.loginAsStandardUser();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        homePage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(homePage.getNumberOfItemsFromCartBadge(),1, "Cart badge number is different");
    }

    @Test
    public void testAddToCartButton(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        HomePage homePage = loginUtils.login(R.TESTDATA.get("user"), R.TESTDATA.get("password"));
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        homePage.addProductToCart(R.TESTDATA.get("Sauce Labs Backpack"));
        CartPage cartPage = homePage.getHeaderMenu().openCart();
        Assert.assertTrue(cartPage.isPageOpened(),"Cart page is not opened");
        Assert.assertEquals(cartPage.getNumberOfItemsInCart(),1,"Number of items is different");
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"),"Product is not present");
        }


    @Test
    public void logout() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        HomePage homePage = loginUtils.login(R.TESTDATA.get("user"),R.TESTDATA.get("password"));
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        homePage.getHeaderMenu().getBurgerMenu().logout();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened after logout");
    }


}
