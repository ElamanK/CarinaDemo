package com.mycompany.carina.mydemo.uitest.components;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='cart_item']")
    private ExtendedWebElement item;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private ExtendedWebElement itemTitle;

    public String getItemTitle(){
        return itemTitle.getText();
    }

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
