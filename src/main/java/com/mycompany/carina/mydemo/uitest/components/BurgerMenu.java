package com.mycompany.carina.mydemo.uitest.components;
import com.mycompany.carina.mydemo.uitest.pages.LoginPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement burgerMenuButton;

    @FindBy(xpath = "//a[.='Logout']")
    private ExtendedWebElement logoutButton;


    public BurgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPage logout(){
        burgerMenuButton.click();
        logoutButton.click();
        return new LoginPage(driver);
    }
}
