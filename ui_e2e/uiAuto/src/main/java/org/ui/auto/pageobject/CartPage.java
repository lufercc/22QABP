package org.ui.auto.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    @FindBy(css = "#first-name")
    WebElement firstNameInput;

    @FindBy(css = "#last-name")
    WebElement lastNameInput;

    @FindBy(css = "#postal-code")
    WebElement postalCodeInput;

    @FindBy(css = "#continue")
    WebElement continueButton;

    @FindBy(css = "#finish")
    WebElement finish;

    @FindBy(css = ".complete-header")
    WebElement orderCompleteMessage;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void fillFormToCart(String firstName, String lastName, String zipCode){
        checkoutButton.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(zipCode);
        continueButton.click();
        finish.click();
    }

    public String getOrderCompleteMessage(){
        return orderCompleteMessage.getText();
    }
}
