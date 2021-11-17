package sportdirect;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage {
    BaseFunc baseFunc;

    private final By SEARCH = By.id("txtSearch");
    private final By CART = By.id("bagQuantityContainer");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public ShoePage getItemByName(String name) {
        WebElement input = baseFunc.getElement(SEARCH);
        input.click();
        input.sendKeys(name + Keys.ENTER);
                return new ShoePage(baseFunc);
            }

    public CartPage bagContainer() {
        WebElement cart = baseFunc.getElement(CART);
        cart.click();
        return new CartPage(baseFunc);
    }
}
