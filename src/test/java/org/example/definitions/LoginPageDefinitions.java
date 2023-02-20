package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.HomePage;
import org.example.pageObjects.LoginPage;
import org.example.pageObjects.PageObjectManager;
import org.example.utils.TestSetUp;
import org.testng.Assert;

import java.io.IOException;

public class LoginPageDefinitions {

    TestSetUp setUp;
    public PageObjectManager pageObjectManager;
    public LoginPage loginPage;
    public HomePage homePage;


    public LoginPageDefinitions(TestSetUp setUp) throws IOException {
        this.setUp = setUp;
       // baseTest = baseTest.WebDriverManager();
        this.loginPage = setUp.pageObjectManager.getLoginPage();
        this.homePage= setUp.pageObjectManager.getHomePage();
    }

    @Given("User is on Home page")
    public void loginTest() throws IOException {
        setUp.baseTest.WebDriverManager().get("https://opensource-demo.orangehrmlive.com/");

    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {

      //  LoginPage loginPage = setUp.pageObjectManager.getLoginPage();


        // login to application
        loginPage.login(userName, passWord);

        // go the next page

    }

    @Then("User should be able to login successfully")
    public void verifyLogin() {

      //  HomePage homePage= setUp.pageObjectManager.getHomePage();
        // Verify home page
        Assert.assertTrue(homePage.getHomePageText().contains("Dashboard"));

    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {

    //    LoginPage loginPage = setUp.pageObjectManager.getLoginPage();

        // Verify home page
        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage);

    }

}