package pages;

import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final static String URL = "http://www.amazon.com/";

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }
}
