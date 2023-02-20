package org.example.utils;

import org.openqa.selenium.WebElement;
import org.example.pageObjects.PageObjectManager;

import java.io.IOException;


public class TestSetUp {


    public WebElement errorMessage;
    public WebElement homePageUserName;
    public PageObjectManager pageObjectManager;
    public BaseTest baseTest;

    public TestSetUp() throws IOException {

        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());

    }
}
