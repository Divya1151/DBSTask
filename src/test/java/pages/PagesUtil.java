package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PagesUtil {
    WebDriver driver;

    public PagesUtil(WebDriver driver) {
        this.driver = driver;

    }
    public void navigateToMegaMenu(String link){
        WebElement megaMenu = driver.findElement(By.xpath("//div[@id = 'flpHeader']/descendant::li/a[text() = '" + link + "']"));
        megaMenu.click();
    }

    public void navigateToCreditCardMenu(String link){
        WebElement creditCardsMenu = driver.findElement(By.xpath("//div[@id = 'bodywrapper']/descendant::li/a[text() = '" + link + "']"));
        creditCardsMenu.click();
    }
}