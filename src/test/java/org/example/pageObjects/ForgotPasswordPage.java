package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;

     By forgotPasswordPageTitle = By.xpath("//*[@id='app']/div[1]/div[1]/div/form/h6");
     By cancelBtn = By.xpath("//*[@id='app']/div[1]/div[1]/div/form/div[2]/button[1]");
     By resetPasswordBtn = By.xpath("//*[@id='app']/div[1]/div[1]/div/form/div[2]/button[2]");
     By userName = By.name("username");
     By resetMessage = By.xpath("//*[@id='app']/div[1]/div[1]/div/h6");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get the Title of ForgotPage
    public String getForgotPageText() {
        return driver.findElement(forgotPasswordPageTitle).getText();
    }

    // Click Cancel Button
    public void clickOnCancelBtn() {
         driver.findElement(cancelBtn).click();
    }

    // Click ResetPassword Button
    public void clickOnRestPasswordBtn() {
        driver.findElement(resetPasswordBtn).click();
    }

    // Type username in TextBox
    public void TypeOnUsernameTextBox(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    // Get Message
    public String getRestMessage() {
        return driver.findElement(resetMessage).getText();
    }
}
