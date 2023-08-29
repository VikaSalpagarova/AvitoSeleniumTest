package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Main {

    private final WebDriver driver;
    private final String url = "https://www.avito.ru/";

    @FindBy(xpath = "//div[@data-marker='bx-recommendations-block-item']/div[1]/div[2]//a[@itemprop='url']")
    private WebElement recommendedItem;

    public Main(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(url);
    }

    public void clickRecommendedItem() {
        driver.get(recommendedItem.getAttribute("href"));
    }
}