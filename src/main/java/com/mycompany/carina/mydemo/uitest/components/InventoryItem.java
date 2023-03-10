package com.mycompany.carina.mydemo.uitest.components;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends AbstractUIObject {


    @FindBy(xpath = "//div[@class='inventory_item']")
    private ExtendedWebElement item;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private ExtendedWebElement addToCartButton;

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public String getItemDescription(){
        return item.getText();
    }

    public InventoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
