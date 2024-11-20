package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seln05 {

    @Test
    public void testVWOLoginPageTitle() {
        EdgeOptions edgeOptions = new EdgeOptions();
        //ChromeOptions chromeOptions = new ChromeOptions();
        // FirefoxOptions firefoxOptions = new FirefoxOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
//        driver.manage().window().maximize();
//        driver.manage().window().minimize();

        System.out.println(driver.getPageSource());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
        driver.quit();


    }
}