package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {

    private WebDriver driver;

    private By firstResultImage = By.xpath("//div[@data-component-type='s-search-result' " +
            "and count(.//span[contains(text(),'Ships to')])>0 " +
            "and count(.//*[contains(@class,'a-price')])>0 ][1]");

    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstResult() {
        driver.findElement(firstResultImage).click();
    }
}
