package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class ReptilesPage extends JPetStoreBasePage {
    private WebElement rattlesnake = driver.findElement(By.xpath("//a[contains(@href,'RP-SN-01')]"));
    private WebElement iguana = driver.findElement(By.xpath("//a[contains(@href,'RP-LI-02')]"));
    private Map <String, WebElement> elements = new HashMap<>();
    public ReptilesPage(){
        elements.put("rattlesnake", rattlesnake);
        elements.put("iguana", iguana);
    }

    public void clickOnFishCategoryButton(WebElement webElement) {
        webElement.click();
    }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }
}
