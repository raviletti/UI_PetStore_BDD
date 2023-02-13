package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class newAccountForm extends JPetStoreBasePage {


    private WebElement userId = driver.findElement(By.xpath("//input[@name='username']"));
    private WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
    private WebElement passwordRepeat = driver.findElement(By.xpath("//input[@name='repeatedPassword']"));

    private WebElement firstName = driver.findElement(By.xpath("//input[@name='account.firstName']"));
    private WebElement lastName = driver.findElement(By.xpath("//input[@name='account.lastName']"));
    private WebElement email = driver.findElement(By.xpath("//input[@name='account.email']"));
    private WebElement phone = driver.findElement(By.xpath("//input[@name='account.phone']"));
    private WebElement address1 = driver.findElement(By.xpath("//input[@name='account.address1']"));
    private WebElement address2 = driver.findElement(By.xpath("//input[@name='account.address2']"));
    private WebElement city = driver.findElement(By.xpath("//input[@name='account.city']"));
    private WebElement state = driver.findElement(By.xpath("//input[@name='account.state']"));
    private WebElement zip = driver.findElement(By.xpath("//input[@name='account.zip']"));
    private WebElement country = driver.findElement(By.xpath("//input[@name='account.country']"));

    private WebElement languagePreference = driver.findElement(By.xpath("//select[@name='account.languagePreference']"));
    private WebElement favouriteCategory = driver.findElement(By.xpath("//select[@name='account.favouriteCategoryId']"));
    private WebElement myListCheckbox = driver.findElement(By.xpath("//input[@name='account.listOption']"));
    private WebElement myBannerCheckbox = driver.findElement(By.xpath("//input[@name='account.bannerOption']"));

    private WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save Account Information']"));

     Map<String, WebElement> elements = new HashMap<String, WebElement>();

     public newAccountForm(){
         elements.put("User ID", userId);
         elements.put("Password", password);
         elements.put("Password repeat", passwordRepeat);
         elements.put("First name", firstName);
         elements.put("Last name", lastName);
         elements.put("Email", email);
         elements.put("Phone", phone);
         elements.put("Address 1", address1);
         elements.put("Address 2", address2);
         elements.put("City", city);
         elements.put("State", state);
         elements.put("Zip", zip);
         elements.put("Country", country);
         elements.put("Language Preference", languagePreference);
         elements.put("Favourite Category", favouriteCategory);
         elements.put("Enable MyList", myListCheckbox);
         elements.put("Enable MyBanner", myBannerCheckbox);
         elements.put("Save Button", saveButton);

     }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }

}
