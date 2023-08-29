package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Favorites {
    private final WebDriver driver;
    private final String url = "https://www.avito.ru/favorites";

    @FindBy(xpath = "//favorite-items-list")
    private WebElement favoriteItemsList;

    public Favorites(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(url);
    }

    public void verifyNonEmptyFavoritesList() {
        Assert.assertFalse(favoriteItemsList.getText().isEmpty(), "Favorites list is empty.");
    }
}
