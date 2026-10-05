package com.automation.steps;

import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        loginPage.open();
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        if (!username.isEmpty()) {
            loginPage.enterUsername(username);
        }
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        if (!password.isEmpty()) {
            loginPage.enterPassword(password);
        }
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
        Assertions.assertTrue(
                inventoryPage.isInventoryPageDisplayed(),
                "Inventory page should be displayed after successful login"
        );
    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {
        Assertions.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface"),
                "Login error message should be displayed"
        );
    }
}