package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class OrderForm extends JPetStoreBasePage {

    private By continueButton = By.xpath("//input[@name='newOrder']");
    private By confirmButton = By.xpath("//a[contains(@href,'newOrder')]");
    private By thanks = By.xpath("//li[contains(text(),'Thank you')]");

    private Map<String, WebElement> elements = new HashMap<>();
    private Map<String, By> byes = new HashMap<>();

    public OrderForm(){
        byes.put("Continue Button", continueButton);
        byes.put("Confirm Button", confirmButton);
        byes.put("Thanks Text", thanks);

    }

    public WebElement getElement(String elementName){
        WebElement result = elements.get(elementName);
        if(result == null){
            return driver.findElement(byes.get(elementName));
        }
        else return result;
    }
//    public WebElement getFromBy(String byName){
//        return driver.findElement(byes.get(byName));
//    }
//
//    public boolean elementIsAppear(String elementName){
//        return getFromBy(elementName).isDisplayed();
//    }
}
