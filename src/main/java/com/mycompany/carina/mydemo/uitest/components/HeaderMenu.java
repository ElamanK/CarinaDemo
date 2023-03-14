package com.mycompany.carina.mydemo.uitest.components;
import com.mycompany.carina.mydemo.uitest.pages.CartPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage openCart(){
        cartButton.click();
        return new CartPage(getDriver());
    }

    public BurgerMenu getBurgerMenu(){
        burgerMenu.click();
        return new BurgerMenu(getDriver());
    }
}
