package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class CartPage extends JPetStoreBasePage {

    private WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[contains(@href,'newOrderForm')]"));
    private WebElement updateCart = driver.findElement(By.xpath("//input[@name='updateCartQuantities']"));

    private Map<String, WebElement> elements = new HashMap<>();
    public CartPage(){
        elements.put("Proceed To Checkout", proceedToCheckoutButton);
        elements.put("updateCart", updateCart);

    }

    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }

}
