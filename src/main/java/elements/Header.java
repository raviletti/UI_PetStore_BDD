package elements;

import io.cucumber.java.ru.Если;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.JPetStoreBasePage;

import java.util.HashMap;
import java.util.Map;

/** Главное меню (блок элементов) */
public class Header extends JPetStoreBasePage {
    Map<String, WebElement> elements = new HashMap<>();

    @FindBy(xpath = "//img[@name='img_cart']")
    private WebElement cartButton;
    @FindBy(xpath = "//a[contains(@href,'signonForm')]")
    private WebElement signInButton;
    @FindBy(xpath = "//a[contains(@href,'signoff')]")
    private WebElement signOutButton;
    @FindBy(xpath = "//a[contains(@href,'editAccount')]")
    private WebElement myAccount;
    @FindBy(xpath = "//div[@id='QuickLinks']//a[contains(@href,'FISH')]")
    private WebElement fishLink;
    @FindBy(xpath = "//div[@id='QuickLinks']//a[contains(@href,'DOGS')]")
    private WebElement dogLink;
    @FindBy(xpath = "//div[@id='QuickLinks']//a[contains(@href,'REPTILES')]")
    private WebElement reptileLink;
    @FindBy(xpath = "//div[@id='QuickLinks']//a[contains(@href,'CATS')]")
    private WebElement catLink;
    @FindBy(xpath = "//div[@id='QuickLinks']//a[contains(@href,'BIRDS')]")
    private WebElement birdLink;



    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elements.put("Cart Button", cartButton);
        elements.put("Sign In", signInButton);
        elements.put("Sign Out", signOutButton);
        elements.put("My Account", myAccount);
        elements.put("Fish Link", fishLink);
        elements.put("Dog Link", dogLink);
        elements.put("Reptile Link", reptileLink);
        elements.put("Cat Link", catLink);
        elements.put("Bird Link", birdLink);
    }

    @Если("Нажать кнопку \"Cart\"")
    public void clickOnCartButton() {
        cartButton.click();
    }

    public WebElement getElement(String elementName){
        return elements.get(elementName);
    }


}
