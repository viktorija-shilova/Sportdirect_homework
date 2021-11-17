package sportdirect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoePage {
    BaseFunc baseFunc;

    final By FILTER_LIST_ITEM_GENDER = By.xpath(".//div[@class='FilterListItem AFLOR']");
    final By FILTER_LIST_ITEM_SIZE = By.xpath(".//div[@class='FilterListItem ACSIZE']");
    final By FILTER_LIST_ITEM_COLOUR = By.xpath(".//div[@class='FilterListItem ACOL']");
    private final By PRODUCT_CONTAINER = By.xpath(".//div[@id='ProductContainer'][contains(@style, 'opacity: 1')]");
    private final By SHOE_FILTERED_CONTAINER = By.id("productlistcontainer");
    private final By SHOE_FILTERED_ITEMS = By.xpath(".//li");

    public ShoePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void filterItem(String name, By locator) {
        List<WebElement> filterTitles = baseFunc.getElements(locator);
        for (WebElement we : filterTitles) {
            if (we.getText().contains(name)) {
                we.findElement(By.xpath(".//a")).click();
                break;
            }
        }
    }

    public void waitForProductLoad() {
        WebDriverWait driverWait = new WebDriverWait(baseFunc.browser, Duration.ofSeconds(10, 1000));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(PRODUCT_CONTAINER));
    }


    public ItemPage choiceItem(int item_no) {
        List<WebElement> choiceList = baseFunc.getElement(SHOE_FILTERED_CONTAINER).findElements(SHOE_FILTERED_ITEMS);
        choiceList.get(item_no).click();
        return new ItemPage(baseFunc);
    }

}
