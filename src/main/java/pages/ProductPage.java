package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    private WebDriver driver;

    private By sizeDropdown = By.xpath("//select[@name='dropdown_selected_size_name']");
    private By qtyDropdown = By.xpath("//select[@name='quantity']");
    private By addToCartBtn = By.xpath("//input[@id='add-to-cart-button']");
    private By priceBlock = By.xpath(".//span[@id='priceblock_ourprice']");
    private By nameBlock = By.xpath(".//span[@id='productTitle']");

    private String dropdownOptionLocFormat = "//a[contains(@class,'a-dropdown-link') and contains(text(),'%s')]";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setQty(int qty) {
        String qtyAsString = String.valueOf(qty);
        By optionLoc = By.xpath(String.format(dropdownOptionLocFormat, qtyAsString));

        new Select(driver.findElement(qtyDropdown)).selectByIndex(qty - 1);
        driver.findElement(optionLoc).click();
    }

    public void ensureSizeSelected() throws InterruptedException {
        if (!driver.findElements(sizeDropdown).isEmpty()){
            Select select = new Select(driver.findElement(sizeDropdown));
            select.selectByIndex(1);
            Thread.sleep(2000); //allow price to refresh
        }
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public double getPrice() {
        String priceBoxText = driver.findElement(priceBlock).getText();
        return Double.parseDouble(priceBoxText.replace("$", ""));
    }

    public String getProductName(){
        return driver.findElement(nameBlock).getText();
    }
}