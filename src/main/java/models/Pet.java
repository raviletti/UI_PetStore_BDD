package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Pet {
    private String itemId;
    private String productId;
    private String Description;
    private String price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Pet(String itemId) {
        this.itemId = itemId;
    }

}
