package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Item {

    private final WebDriver driver;
    @FindBy(xpath = "//div[contains(@class, 'style-header-add-favorite')]/button")
    private WebElement addToFavoriteButton;

    public Item(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToFavorite() {
        addToFavoriteButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'style-header-add-favorite')]/button[@title = 'В избранном']")));
        String buttonText = addToFavoriteButton.getText();
        Assert.assertEquals(buttonText, "В избранном", "Item not added to Favorites.");
    }
}
