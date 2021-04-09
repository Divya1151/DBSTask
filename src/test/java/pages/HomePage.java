package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
