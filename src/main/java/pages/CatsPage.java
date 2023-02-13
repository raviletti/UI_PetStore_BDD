package pages;

import models.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class CatsPage extends JPetStoreBasePage {

    private WebElement manx = driver.findElement(By.xpath("//a[contains(@href,'FL-DSH-01')]"));
    private WebElement persian = driver.findElement(By.xpath("//a[contains(@href,'FL-DLH-02')]"));
    private Map<String, WebElement> elements = new HashMap<>();
    public CatsPage(){
        elements.put("Manx", manx);
        elements.put("Persian", persian);

    }

    public void addPetToCart(Pet pet){
        String xPath = "//a[contains(@href,'addItemToCart=&workingItemId=" + pet.getItemId() + "')]";
        driver.findElement(By.xpath(xPath)).click();
    }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }
}
