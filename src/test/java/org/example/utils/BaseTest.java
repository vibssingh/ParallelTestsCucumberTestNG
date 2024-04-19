package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public final static int TIMEOUT = 10;

    public WebDriver WebDriverManager () throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url= prop.getProperty("QAUrl");

        if (driver == null) {
            if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
            } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                driver = new EdgeDriver(options);
            } else {
                System.out.println("No Browser is provided");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            driver.manage().window().maximize();
            driver.get(url);

        }
        return driver;
    }
}
