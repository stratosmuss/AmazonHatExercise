package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar {

    private WebDriver driver;

    private By searchBar = By.xpath(".//input[@id='twotabsearchtextbox']");
    private By searchSubmit = By.xpath(".//input[@id='nav-search-submit-button']");
    private By cartBtn = By.xpath(".//div[@id='nav-cart-count-container']");

    public NavBar(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query){
        driver.findElement(searchBar).sendKeys(query);
        driver.findElement(searchSubmit).click();
    }

    public void goToCart(){
        driver.findElement(cartBtn).click();
    }
}
