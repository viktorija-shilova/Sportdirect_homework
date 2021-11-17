package sportdirect;

public class Test {

    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "lv.sportsdirect.com";

    @org.junit.jupiter.api.Test
    public void SearchTest(){

        // Open Chrome browser and go to lv.sportsdirect.com
        baseFunc.goToUrl(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);

        // Type in search input field "Shoes", wait while suggest items are shows and choose "Shoes"
        ShoePage shoePage = homePage.getItemByName("Shoes");
        // Choose filter by gender --> Women
        shoePage.filterItem("Womens", shoePage.FILTER_LIST_ITEM_GENDER);
        // Wait while all women shoes are loaded on the page
        shoePage.waitForProductLoad();
        // Choose filter by color --> White
        shoePage.filterItem("White", shoePage.FILTER_LIST_ITEM_COLOUR);
        // Wait while all white shoes are loaded on the page
        shoePage.waitForProductLoad();
        // Choose filter by size --> 4.5
        shoePage.filterItem("4.5", shoePage.FILTER_LIST_ITEM_SIZE);
        // Wait while all 4.5 size shoes are loaded on the page
        shoePage.waitForProductLoad();

        // Take first item and click on it
        ItemPage itemPage = shoePage.choiceItem(0);
        // Choose size 4.5
        itemPage.chooseSize("4.5");
        // Press add to cart button
        itemPage.addToCart();

        // Type in search input field "Socks" and press Enter
        homePage.getItemByName("Socks");
        // Take third item and click on it
        ItemPage socksPage = shoePage.choiceItem(2);
        // Press add to cart button
        socksPage.addToCart();
        // Open cart page
        homePage.bagContainer();
    }
}
