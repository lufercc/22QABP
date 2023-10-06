package org.ui.auto.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = "#shopping_cart_container .shopping_cart_link")
    protected WebElement shoppingCart;

    protected String itemButton = "//div[contains(text(),'%s')]//ancestor::div[@class='inventory_item_description']//button[contains(@id,'add-to-cart')]";
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goShoppingCard(){
        this.shoppingCart.click();
    }

    public void addToTheCartProduct(String itemName){
        WebElement addButton = driver.findElement(By.xpath(String.format(itemButton, itemName)));
        addButton.click();
    }
}
