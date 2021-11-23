package sportdirect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ItemPage {
    BaseFunc baseFunc;

    private final By SIZE = By.xpath(".//li[@id='liItem']");
    private final By ADD_TO_BAG = By.id("aAddToBag");
    private final By BANNER = By.xpath(".//div[@class='closingIcon']");
    private final By BAG_CONTAINER = By.xpath(".//div[@id='divBagItems'][contains(@style, 'display: block')]");

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

    public void waitForCartLoad() {
        WebDriverWait driverWait = new WebDriverWait(baseFunc.browser, Duration.ofSeconds(10, 1000));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(BAG_CONTAINER));
    }
}


