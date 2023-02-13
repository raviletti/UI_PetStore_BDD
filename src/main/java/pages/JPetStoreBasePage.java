package pages;

import elements.Header;
import models.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

/** Элементы общие для системы */
public class JPetStoreBasePage extends AbstractPage {
   private Map<String, WebElement> elements;
    /** Доступ к элементам главного меню */

    public WebElement getElement(String elementName){
        return null;
    }


    public void addPetToCart(Pet pet){
        String xPath = "//a[contains(@href,'addItemToCart=&workingItemId=" + pet.getItemId() + "')]";
        driver.findElement(By.xpath(xPath)).click();
    }
}
