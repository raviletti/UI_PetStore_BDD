package steps.web;

import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebSteps {
    BasePage basePage;
    BasePage initializedPage;
    WebDriver driver;

    /**
     * Подготовка драйвера и конфига
     *
     */
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

    /**
     * Открытие url из конфига
     *
     * @param key имя значения из конфига
     * @param props имя  конфига
     */
    @Когда("перейти по адресу {string} из конфига {string}")
    public void openUrl(String key, String props) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(props));
        driver.get(System.getProperty(key));
    }

    @То("инициализация страницы {string}")
    public void pageInit(String page) {
        if (page.equals("BasePage")){
            basePage = new BasePage();
        }
       else initializedPage = basePage.init(page);
    }


    /**
     * Нажатие по выбранному элементу
     *
     * @param elementName наименование элемента
     */
    @То("кликнуть на элемент {string}")
    public void clickOnElement(String elementName){
       basePage.getElement(elementName).click();
    }

    /**
     * Проверка наличия элемента на странице
     *
     * @param elementName наименование элемента
     */
    @Если("на странице имеется элемент {string}")
    public void isElementDisplayed(String elementName) {
        Assert.assertTrue(basePage.getElement(elementName).isDisplayed());
    }

    /**
     * Проверка наличия текста на странице
     *
     * @param text искомый текст
     */
    @Если("на странице имеется текст {string}")
    public void isTextDisplayed(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }


    /**
     * Ввод в поле значения
     *
     * @param fieldName поле для ввода
     * @param value вводимое значение
     */
    @То("ввести в поле {string} значение {string}")
    public void fillField(String fieldName, String value){
        basePage.getElement(fieldName).sendKeys(value);
    }

    /**
     * Ввод в поле значения из конфига
     *
     * @param fieldName поле для ввода
     * @param key значение из конфига
     * @param props имя конфиг файла
     */
    @То("ввести в поле {string} значение {string} из конфига {string}")
    public void fillFieldFromProperties(String fieldName, String key, String props) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(props));
        basePage.getElement(fieldName).sendKeys(System.getProperty(key));
    }

    /**
     * Очистить поле
     *
     * @param fieldName поле для ввода
     */
    @То("очистить поле {string}")
    public void clearField(String fieldName){
        basePage.getElement(fieldName).clear();
    }

    /**
     * Выбор значения в выпадающем списке
     *
     * @param dropdown выпадающий список
     * @param value значение
     */
    @То("в выпадающем списке {string} выбрать опцию {string}")
    public void selectOption(String dropdown, String value){
        Select select = new Select(basePage.getElement(dropdown));
        select.selectByVisibleText(value);
    }

    /**
     * Установка чекбокса
     *
     * @param action действие
     * @param elementName элемент с чекбоксом
     */
    @То("^(активировать|деактивировать) чекбокс на элементе \"([^\"]*)\"$")
    public void activateCheckbox(String action, String elementName){
        WebElement webElement = basePage.getElement(elementName);
        webElement.click();
        if (action.equals("активировать") && !webElement.isSelected()){
            webElement.click();
        }
        else if(action.equals("деактивировать") && webElement.isSelected()){
            webElement.click();
        }
    }

    /**
     * Проверка значения в поле
     *
     * @param fieldName поле
     * @param value значение
     */
    @То("поле {string} имеет значение {string}")
    public void clearField(String fieldName, String value){
        Assert.assertEquals( basePage.getElement(fieldName).getAttribute("value"), value);
    }

}
