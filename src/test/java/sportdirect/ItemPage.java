package sportdirect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemPage {
    BaseFunc baseFunc;

    private final By SIZE = By.xpath(".//li[@id='liItem']");
    private final By ADD_TO_BAG = By.id("aAddToBag");

    public ItemPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void chooseSize(String name) {
        List<WebElement> sizes = baseFunc.getElements(SIZE);
        for (WebElement we : sizes) {
            if (we.getText().replaceAll(" .+$", "").equals(name)) {
                we.findElement(By.xpath(".//a")).click();
                break;
            }
        }
    }

    public void addToCart() {
        baseFunc.getElement(ADD_TO_BAG).click();
    }
}


