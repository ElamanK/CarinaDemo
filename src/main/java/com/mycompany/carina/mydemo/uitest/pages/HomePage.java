package com.mycompany.carina.mydemo.uitest.pages;
import com.mycompany.carina.mydemo.uitest.components.BurgerMenu;
import com.mycompany.carina.mydemo.uitest.components.InventoryItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private BurgerMenu burgerMenu;

    @FindBy(css = ".title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private ExtendedWebElement shoppingCartBadge;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<InventoryItem> items;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }


    public BurgerMenu getBurgerMenu(){
        return burgerMenu;
    }
    //move to component
    public CartPage openCart(){
        cartButton.click();
        return new CartPage(getDriver());
    }



    public int getNumberOfItemsFromCartBadge(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }


    public void addProductToCart(String productName){
        for (InventoryItem item : items) {
            if (item.getItemDescription().toLowerCase().contains(productName.toLowerCase())) {
                item.clickAddToCart();
                break;
            }
        }
    }




}
