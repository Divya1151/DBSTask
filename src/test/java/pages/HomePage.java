package pages;


import org.openqa.selenium.WebDriver;

/**
 * This is a Home page and here we are navigating to Cards option
 */

public class HomePage {
    WebDriver driver;
    PagesUtil pagesUtil;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        pagesUtil = new PagesUtil(driver);
    }

    public void navigateToCards(String link) {
        pagesUtil.navigateToMegaMenu(link);


    }

}
