package pages;

import models.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class FishPage extends JPetStoreBasePage {
    private Map<String, WebElement> elements = new HashMap<>();

    private WebElement angelfish = driver.findElement(By.xpath("//a[contains(@href,'FI-SW-01')]"));
    private WebElement tigerShark = driver.findElement(By.xpath("//a[contains(@href,'FI-SW-02')]"));
    private WebElement koi = driver.findElement(By.xpath("//a[contains(@href,'FI-FW-01')]"));
    private WebElement goldfish = driver.findElement(By.xpath("//a[contains(@href,'FI-FW-02')]"));
    public FishPage(){
        elements.put("angelfish", angelfish);
        elements.put("tigerShark", tigerShark);
        elements.put("koi", koi);
        elements.put("goldfish", goldfish);

    }

    public void addPetToCart(Pet pet){
        String xPath = "//a[contains(@href,'addItemToCart=&workingItemId=" + pet.getItemId() + "')]";
        driver.findElement(By.xpath(xPath)).click();
    }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }
}
