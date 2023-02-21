package pages.petstoreOctoperf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

import java.util.Map;

/** Элементы общие для системы */
public class BasePage extends AbstractPage {
   private Map<String, WebElement> elements;
    /** Доступ к элементам главного меню */


    /**
     * Получение элемента по названию
     *
     * @param elementName имя искомого элемента
     */
    public WebElement getElement(String elementName){
        return driver.findElement(By.xpath(getXpath(elementName)));
    }

    /**
     * Получение локатора элемента по названию
     *
     * @param elementName имя искомого элемента
     */
    private String getXpath(String elementName){
        String str = "";
        String substring = elementName.contains("'") ?  elementName.substring(elementName.indexOf("'") + 1, elementName.lastIndexOf("'")) : elementName;
        if(elementName.startsWith("ссылка '")){
            str = String.format(firstLink, substring);
        }
        else if(elementName.startsWith("ссылка с текстом '")){
            str = String.format(linkContainsText, substring);
        }
        else if(elementName.startsWith("поле '")){
            str = String.format(firstFieldWithText, substring);
        }
        else if(elementName.startsWith("поле с текстом '")){
            str = String.format(firstFieldContainsText, substring);
        }
        else if(elementName.startsWith("выпадающий список '")){
            str = String.format(dropDownList, substring);
        }
        else if(elementName.startsWith("чекбокс '")){
            str = String.format(checkbox, substring);
        }
        else if(elementName.equals("кнопка корзины")){
            str = cartButton;
        }
        else if(elementName.startsWith("кнопка '")){
            str = String.format(button, substring);
        }

        return str;
    }

    //ссылка %s
    private String firstLink = "//a[normalize-space()='%s']";

    //ссылка с текстом %s
    private String linkContainsText = "//a[contains(@href, '%s')]";

    //поле %s
    private String firstFieldWithText = "//input[@value='%1$s'][not(@type='checkbox')]" +
            "|//*[normalize-space()='%1$s']/following::input[not(@type='checkbox')]" +
            "|//input[@name='%1$s'][not(@type='checkbox')]";

    //поле с текстом %s
    private String firstFieldContainsText = "//*[contains(text(), '%1$s')]/following::input[not(@type='checkbox')]";

    //выпадающий список %s
    private String dropDownList = "//*[normalize-space()='%1$s']/following::select";

    //чекбокс %s
    private String checkbox = "//*[normalize-space()='%1$s']/following::input[@type='checkbox']";

    //кнопка %s
    private String button = "//input[@value='%1$s']" +
            "|//a[normalize-space()='%1$s']";

    //кнопка корзины
    private String cartButton = "//*[contains(@name,'img_cart')]/ancestor::a[contains(@href,'Cart')]";

}
