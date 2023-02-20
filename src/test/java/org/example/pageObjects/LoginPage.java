package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    By userName = By.name("username");
    By passWord = By.name("password");
    By login = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By errorMessage = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    By forgotPasswordLink = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
    By loginPageTitle = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/h5");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void login(String strUserName, String strPassword) {

        // Fill user name
        driver.findElement(userName).sendKeys(strUserName);

        // Fill password
        driver.findElement(passWord).sendKeys(strPassword);

        // Click Login button
        driver.findElement(login).click();

    }

    // Click on Forgot Password link
    public void clickOnForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    //Get Login Page Title
    public String getLoginPageTitle() {
        return driver.findElement(loginPageTitle).getText();
    }
}