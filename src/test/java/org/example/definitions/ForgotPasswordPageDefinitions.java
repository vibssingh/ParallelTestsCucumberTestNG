package org.example.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.ForgotPasswordPage;
import org.example.pageObjects.LoginPage;
import org.example.pageObjects.PageObjectManager;
import org.example.utils.TestSetUp;
import org.testng.Assert;

public class ForgotPasswordPageDefinitions {

    TestSetUp setUp;
    PageObjectManager pageObjectManager;
    public LoginPage loginPage;
    public  ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordPageDefinitions(TestSetUp setUp) {
        this.setUp = setUp;
        this.loginPage = setUp.pageObjectManager.getLoginPage();
        this.forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
    }

    @When("User clicks on Forgot your password? link")
    public void forgotPasswordLink() {

      //  LoginPage loginPage = setUp.pageObjectManager.getLoginPage();
        loginPage.clickOnForgotPasswordLink();

    }

    @Then("User should be able to navigate to Reset Password page")
    public void verifyForgotPasswordPage() {

      //  ForgotPasswordPage forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getForgotPageText(),"Reset Password");

    }

    @Then("User clicks on Cancel button to go back to Login Page")
    public void verifyCancelBtn() {

      //  ForgotPasswordPage forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
        forgotPasswordPage.clickOnCancelBtn();
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login");

    }

    @Then("User clicks on Reset Password button and provide username as {string}")
    public void verifyResetPasswordBtn(String username) {

        //  ForgotPasswordPage forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
        forgotPasswordPage.TypeOnUsernameTextBox(username);
        forgotPasswordPage.clickOnRestPasswordBtn();

    }

    @Then("Verify the message {string}")
    public void verifyMessage(String message) {

        //  ForgotPasswordPage forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getRestMessage(),message);

    }
}
