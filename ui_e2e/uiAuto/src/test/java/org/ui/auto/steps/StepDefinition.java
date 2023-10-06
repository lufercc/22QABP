package org.ui.auto.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.ui.auto.pageobject.CartPage;
import org.ui.auto.pageobject.HomePage;
import org.ui.auto.pageobject.LoginPage;

import java.util.List;

public class StepDefinition {
    WebDriver driver;
    LoginPage login;
    HomePage homePage;
    CartPage cartPage;

    public StepDefinition(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @Given("I open SauceDemo page")
    public void iOpenSauceDemoPage() {
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
    }

    @And("I login with {string} with password {string}")
    public void iLoginWithWithPassword(String usr, String pwd) {
        login.login("standard_user", "secret_sauce");
    }

    @And("I go to the cart")
    public void iGoToTheCart() {
        homePage.goShoppingCard();
    }

    @And("I complete my buy with {string} as First Name, {string} as Last Name and {string} as zip code")
    public void iCompleteMyBuyWithAsFirstNameAsLastNameAndAsZipCode(String fName, String lName, String zipCode) {
        cartPage.fillFormToCart(fName, lName, zipCode );
    }
    @When("I add the follow items to the card")
    public void iAddTheFollowItemsToTheCard(List<String> items) {
        for (String item: items) {
            homePage.addToTheCartProduct(item);
        }
    }
    @Then("I verify the {string} is displayed at the end of the buy")
    public void iVerifyTheIsDisplayedAtTheEndOfTheBuy(String expectMessage) {
        String doneMessage = cartPage.getOrderCompleteMessage();
        Assert.assertEquals("The Message not coincide", expectMessage, doneMessage);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
