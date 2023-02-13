package pages;

import io.cucumber.java.ru.Если;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/** Страница с описанием товара */
public class MainPage extends JPetStoreBasePage {

    // todo: проинициализировать элементы через driver.findElement

    private WebElement fish = driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href,'FISH')]"));
    private WebElement dogs = driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href,'DOGS')]"));
    private WebElement cats = driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href,'CATS')]"));
    private WebElement reptiles = driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href,'REPTILES')]"));
    private WebElement birds = driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href,'BIRDS')]"));
    private Map<String, WebElement> elements = new HashMap<>();
    public MainPage(){
        elements.put("Fish", fish);
        elements.put("Dogs", dogs);
        elements.put("Cats", cats);
        elements.put("Reptiles", reptiles);
        elements.put("Birds", birds);

    }


    @Если("Перейти в выбранный раздел")
    public void clickOnCategoryButton(WebElement webElement) {
        webElement.click();
    }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }

    //todo: switch case на переход в разделы по строковому названию
}
