package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By homePageUserName = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");

    public String getHomePageText() {
        return driver.findElement(homePageUserName).getText();
    }
}