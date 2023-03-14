package com.mycompany.carina.mydemo.uitest.components;
import com.mycompany.carina.mydemo.uitest.pages.LoginPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//a[.='Logout']")
    private ExtendedWebElement logoutButton;


    public BurgerMenu(WebDriver driver ) {
        super(driver);
    }

    public LoginPage logout(){
        logoutButton.click();
        return new LoginPage(driver);
    }
}
