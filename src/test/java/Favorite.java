import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Favorites;
import pages.Item;
import pages.Main;

import java.util.concurrent.TimeUnit;

public class Favorite {
    WebDriver driver;

    @Before
    public void setup(){
        String driverPath = "src/test/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Test1_SendEmailWithSubject(){

        Main mainPage = new Main(driver);
        mainPage.openPage();
        mainPage.clickRecommendedItem();

        Item itemPage = new Item(driver);
        itemPage.addToFavorite();

        Favorites favoritesPage = new Favorites(driver);
        favoritesPage.openPage();
        favoritesPage.verifyNonEmptyFavoritesList();
    }

    @After
    public void close(){
        driver.close();
    }
}
