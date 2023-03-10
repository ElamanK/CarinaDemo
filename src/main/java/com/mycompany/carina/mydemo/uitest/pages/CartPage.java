package com.mycompany.carina.mydemo.uitest.pages;
import com.mycompany.carina.mydemo.uitest.components.CartItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='title']")
    private ExtendedWebElement cartTitle;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<CartItem> items;

    public int getNumberOfItemsInCart(){
        return items.size();
    }

    public boolean isProductPresent(String productName){
        for (CartItem item : items){
            if(item.getItemTitle().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cartTitle);
    }
}
