package org.ui.auto.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css="#user-name")
    private WebElement userInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void login(String user, String password){
        this.userInput.sendKeys(user);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }
}
