package steps.web;

import elements.Header;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import models.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JPetStoreWebSteps {
    JPetStoreBasePage currentPage;
    WebDriver driver;

    @Before
    public void setup() throws IOException, InterruptedException {
        loadProperties();
        setupDriver();
    }

    @Если("Загрузить конфигурацилнные файлы")
    private void loadProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Если("Создать экземпляр драйвера")
    private void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);
    }

    @Когда("открыть {string} из {string}")
    public void openUrl(String key, String props) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(props));
        driver.get(System.getProperty(key));
    }

    @То("кликнуть на элемент {string}")
    public void clickOnElement(String element){
        currentPage.getElement(element).click();
    }

    @То("инициализация страницы {string}")
    public void pageInit(String page){
        switch (page){
            case "Main menu" : currentPage = new MainPage();
                break;
            case "new Account form" :currentPage = new newAccountForm();
                break;
            case "edit Account form" :currentPage = new editAccountForm();
                break;
            case "Birds page" : currentPage =  new BirdsPage();
                break;
            case "Dogs page" : currentPage =  new DogsPage();
                break;
            case "Cats page" : currentPage =  new CatsPage();
                break;
            case "Fish page" : currentPage =  new FishPage();
                break;
            case "Reptiles page" : currentPage =  new ReptilesPage();
                break;
            case "Cart page" : currentPage =  new CartPage();
                break;
            case "Sign In page" : currentPage =  new SignInPage();
                break;
            case "Header" : currentPage =  new Header(driver);
                break;
            case "Order form" : currentPage =  new OrderForm();
                break;
        }


}


    @Если("на странице имеется элемент {string}")
    public void isElementDisplayed(String element) {
        Assert.assertTrue(currentPage.getElement(element).isDisplayed());
    }

    @Если("на странице имеется текст {string}")
    public void isTextDisplayed(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }



    @То("ввести в поле {string} текст {string}")
    public void fillField(String element, String data){
        currentPage.getElement(element).sendKeys(data);
    }

    @То("ввести в поле {string} значение {string} из {string}")
    public void fillFieldFromProperties(String field, String key, String props) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(props));
        currentPage.getElement(field).sendKeys(System.getProperty(key));
    }

    @То("очистить поле {string}")
    public void clearField(String element){
        currentPage.getElement(element).clear();
    }

    @То("ввести в выпадающем меню {string} опцию {string}")
    public void selectOption(String element, String value){
        Select select = new Select(currentPage.getElement(element));
        select.selectByVisibleText(value);
    }

    @То("поле {string} имеет значение {string}")
    public void clearField(String field, String value){
        Assert.assertEquals( currentPage.getElement(field).getAttribute("value"), value);
    }

    @То("Добавить в корзину позицию с ID {string}")
    public void addToCart(String itemID){
        currentPage.addPetToCart(new Pet(itemID));
    }
}
