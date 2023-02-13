package pages;

import models.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class DogsPage extends JPetStoreBasePage {

    private WebElement bulldog = driver.findElement(By.xpath("//a[contains(@href,'K9-BD-01')]"));
    private WebElement poodle = driver.findElement(By.xpath("//a[contains(@href,'K9-PO-02')]"));
    private WebElement dalmation = driver.findElement(By.xpath("//a[contains(@href,'K9-DL-01')]"));
    private WebElement goldenRetriever = driver.findElement(By.xpath("//a[contains(@href,'K9-RT-01')]"));
    private WebElement labradorRetriever = driver.findElement(By.xpath("//a[contains(@href,'K9-RT-02')]"));
    private WebElement chihuahua = driver.findElement(By.xpath("//a[contains(@href,'K9-CW-01')]"));

    private Map<String, WebElement> elements = new HashMap<>();
    public DogsPage(){
        elements.put("bulldog", bulldog);
        elements.put("poodle", poodle);
        elements.put("dalmation", dalmation);
        elements.put("goldenRetriever", goldenRetriever);
        elements.put("labradorRetriever", labradorRetriever);
        elements.put("chihuahua", chihuahua);
    }

    public void addPetToCart(Pet pet){
        String xPath = "//a[contains(@href,'addItemToCart=&workingItemId=" + pet.getItemId() + "')]";
        driver.findElement(By.xpath(xPath)).click();
    }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }
}
