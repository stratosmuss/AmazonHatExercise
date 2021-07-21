package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Cart {

    private WebDriver driver;

    private By priceBox = By.xpath(".//span[@id='sc-subtotal-amount-buybox']");

    private String productQtyDropdownLocFormat = ".//div[contains(@class,'a-fixed-left-grid-col')" +
            "and count(.//span[contains(text(),'%s')]) >0 ][1]//select[@name='quantity']";

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public double getSubTotal() {
        String priceBoxText = driver.findElement(priceBox).getText();
        return Double.parseDouble(priceBoxText.replace("$", ""));
    }

    public void setQty(String productName, int qty) {
        By qtyDropdown = By.xpath(String.format(productQtyDropdownLocFormat, productName.split("'")[0]));
        new Select(driver.findElement(qtyDropdown)).selectByVisibleText(String.valueOf(qty));
    }
}
