import model.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.HashMap;

public class AmazonHatExerciseTest {

    private final static String HATS_FOR_MEN = "hats for men";
    private final static String HATS_FOR_WOMEN = "hats for women";

    private WebDriver driver;

    private HashMap<String, Product> products = new HashMap<>();

    private LandingPage landingPage;
    private SearchResults searchResults;
    private NavBar navBar;
    private ProductPage productPage;
    private Cart cart;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver);
        navBar = new NavBar(driver);
        searchResults = new SearchResults(driver);
        productPage = new ProductPage(driver);
        cart = new Cart(driver);
    }

    @Test
    public void amazonHatExerciseTest() throws InterruptedException {
        landingPage.openPage();

        int qty = 2;
        navBar.searchFor(HATS_FOR_MEN);
        searchResults.openFirstResult();
        productPage.ensureSizeSelected();
        products.put(HATS_FOR_MEN, new Product(productPage.getProductName(), productPage.getPrice(), qty));
        productPage.setQty(qty);
        productPage.addToCart();
        navBar.goToCart();
        assertCorrectSubtotal(cart.getSubTotal());

        qty = 1;
        navBar.searchFor(HATS_FOR_WOMEN);
        searchResults.openFirstResult();
        productPage.ensureSizeSelected();
        products.put(HATS_FOR_WOMEN, new Product(productPage.getProductName(), productPage.getPrice(), qty));
        productPage.addToCart();
        navBar.goToCart();
        assertCorrectSubtotal(cart.getSubTotal());

        cart.setQty(products.get(HATS_FOR_MEN).getName(), 1);
        assertCorrectSubtotal(cart.getSubTotal());
    }

    private void assertCorrectSubtotal(double actual) {
        double expected = products.values().stream().mapToDouble(product -> product.getPrice() * product.getQty()).sum();
        double expectedRounded = Double.parseDouble(String.format("%.2f", expected));
        Assert.assertEquals("Failed to assert correct Subtotal", expectedRounded, actual, 0.0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
