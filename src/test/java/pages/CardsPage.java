package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CardsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    PagesUtil pagesUtil;


    @FindBy(css = "div[class = 'compare-div mTop-16 checkbox']")
    List<WebElement> creditCardsList;

    @FindBy(id = "cardCompareBtn")
    WebElement compareButton;


    public CardsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        pagesUtil = new PagesUtil(driver);
    }

    public void navigateToCreditCards(){
        pagesUtil.navigateToCreditCardMenu("Credit Cards");
    }

    public void selectCardsToCompare(int noOfCards){
        for(WebElement card : creditCardsList.subList(0, noOfCards)) {
            ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,250)");
            card.click();
        }
    }

    public void clickToCompare(){
        compareButton.click();
    }

}
