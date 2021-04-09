package testcases;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CardsPage;
import pages.CreditCardComparisonPage;
import pages.HomePage;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareCreditCardTestCases extends BaseClass {


    @Parameters("noOfCardsToCompare")
    @Test
    public void verifyDataOnComparison(int noOfCardsToCompare){
        HomePage home = new HomePage(driver);
        home.navigateToCards("Cards");
        CardsPage cards = new CardsPage(driver);
        cards.navigateToCreditCards();
        cards.selectCardsToCompare(noOfCardsToCompare);
        cards.clickToCompare();
        Gson gson = new Gson();
        CreditCardComparisonPage compare = new CreditCardComparisonPage(driver);
        try {
            Reader reader = Files.newBufferedReader(Paths.get("comparisonCreditCardExpectedResult.json"));
            List<String> cardsToCompare = compare.getComparisonCardNames(noOfCardsToCompare);
            List<Map<String, String>> actualResult = compare.getActualResult(noOfCardsToCompare);
            JsonObject jsonExpectedResult = new Gson().fromJson(reader, JsonObject.class);
            for (int i = 0; i < 2; i++) {
                Map<String, String> mapExpectedResult = gson.fromJson(
                        jsonExpectedResult.get(cardsToCompare.get(i)), new TypeToken<HashMap<String, String>>() {
                        }.getType());
                Assert.assertEquals(actualResult.get(i), mapExpectedResult);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
