package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class SignInPage extends JPetStoreBasePage {

    private WebElement usernameBar = driver.findElement(By.xpath("//input[@name='username']"));
    private WebElement passwordBar = driver.findElement(By.xpath("//input[@name='password']"));
    private WebElement loginButton = driver.findElement(By.xpath("//input[@name='signon']"));
    private WebElement registerButton = driver.findElement(By.xpath("//a[contains(@href,'newAccountForm')]"));
    private Map<String, WebElement> elements = new HashMap<>();
    public SignInPage(){
        elements.put("Username Bar", usernameBar);
        elements.put("Password Bar", passwordBar);
        elements.put("Login Button", loginButton);
        elements.put("Register Now!", registerButton);
    }

    public void login(String username, String password){
        usernameBar.sendKeys(username);
        passwordBar.sendKeys(password);
        loginButton.click();
    }
    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }
}
