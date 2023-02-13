package pages;

import models.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class BirdsPage extends JPetStoreBasePage {

    private WebElement amazonParrot = driver.findElement(By.xpath("//a[contains(@href,'AV-CB-01')]"));
    private WebElement finch = driver.findElement(By.xpath("//a[contains(@href,'AV-SB-02')]"));
    private Map<String, WebElement> elements = new HashMap<>();
    public BirdsPage(){
        elements.put("amazonParrot", amazonParrot);
        elements.put("finch", finch);

    }

   public void addPetToCart(Pet pet){
        String xPath = "//a[contains(@href,'addItemToCart=&workingItemId=" + pet.getItemId() + "')]";
        driver.findElement(By.xpath(xPath)).click();

   }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }
}
