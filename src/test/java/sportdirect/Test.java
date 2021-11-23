package sportdirect;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Test {

    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "lv.sportsdirect.com";
    private final By WOMENS_CHECKED_FILTER = By.xpath(".//div[@data-productname='Womens']/a/span");
    private final By COLOUR_CHECKED_FILTER = By.xpath(".//div[@data-productname='White']/a/span");
    private final By SIZE_CHECKED_FILTER = By.xpath(".//div[@data-productname='4.5']/a/span");
    private final By BAG_QUANTITY = By.xpath(".//span[@id='bagQuantity']");

    @org.junit.jupiter.api.Test
    public void SearchTest(){

        // Home page
        baseFunc.goToUrl(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);

        //Shoe page
        ShoePage shoePage = homePage.getItemByName("Shoes");

        shoePage.filterItem("Womens", shoePage.FILTER_LIST_ITEM_GENDER);
        String woman_filter_expected = baseFunc.browser.findElement(WOMENS_CHECKED_FILTER).getAttribute("aria-checked");
        Assertions.assertEquals(woman_filter_expected, "true");
        System.out.println("AssertEquals Women Filter Passed\n");
        
        shoePage.waitForProductLoad();

        shoePage.filterItem("White", shoePage.FILTER_LIST_ITEM_COLOUR);
        String colour_filter_expected = baseFunc.browser.findElement(COLOUR_CHECKED_FILTER).getAttribute("aria-checked");
        Assertions.assertEquals(colour_filter_expected, "true");
        System.out.println("AssertEquals Colour Filter Passed\n");

        shoePage.waitForProductLoad();

        shoePage.filterItem("4.5", shoePage.FILTER_LIST_ITEM_SIZE);
        String size_filter_expected = baseFunc.browser.findElement(SIZE_CHECKED_FILTER).getAttribute("aria-checked");
        Assertions.assertEquals(size_filter_expected, "true");
        System.out.println("AssertEquals Size Filter Passed\n");

        shoePage.waitForProductLoad();

        // Item page
        ItemPage itemPage = shoePage.choiceItem(0);
        itemPage.chooseSize("4.5");
        baseFunc.closeBanner();
        itemPage.addToCart();
        itemPage.waitForCartLoad();

        String cartItems = baseFunc.browser.findElement(BAG_QUANTITY).getText();
        Assertions.assertEquals(cartItems, "1");
        System.out.println("Item 1 adding to cart Passed\n");

        homePage.getItemByName("Socks");
        ItemPage socksPage = shoePage.choiceItem(2);
        baseFunc.closeBanner();

        socksPage.addToCart();
        itemPage.waitForCartLoad();

        String cartItems2 = baseFunc.browser.findElement(BAG_QUANTITY).getText();
        Assertions.assertEquals(cartItems2, "2");
        System.out.println("Item 2 adding to cart Passed\n");

        // Cart page
        homePage.bagContainer();
        baseFunc.browser.close();
    }

}
