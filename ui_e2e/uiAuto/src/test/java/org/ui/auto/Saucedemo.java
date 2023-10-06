package org.ui.auto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.ui.auto.pageobject.CartPage;
import org.ui.auto.pageobject.HomePage;
import org.ui.auto.pageobject.LoginPage;

public class Saucedemo {
    protected WebDriver driver;

    @Test
    public void sauceDemoTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.addToTheCartProduct("Sauce Labs Backpack");
        homePage.addToTheCartProduct("Sauce Labs Fleece Jacket");
        homePage.addToTheCartProduct("Sauce Labs Bike Light");
        homePage.goShoppingCard();

        CartPage cartPage = new CartPage(driver);
        cartPage.fillFormToCart("First Name", "Last Name", "0000" );
        String doneMessage = cartPage.getOrderCompleteMessage();
        assert doneMessage.equalsIgnoreCase("Thank you for your order!");
        driver.quit();
    }
}
