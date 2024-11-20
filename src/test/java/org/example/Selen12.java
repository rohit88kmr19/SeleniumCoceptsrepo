package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selen12 {
    @Test
    public void testVWOLoginPossitive() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://app.vwo.com/#/login");
        WebElement emailInputbox = driver.findElement(By.id("login-username"));
        emailInputbox.sendKeys("monikarohit547@gmail.com");
        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Test@123");
        WebElement login = driver.findElement(By.id("js-login-btn"));
        login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/dashboard");
        Assert.assertEquals(driver.getTitle(), "Dashboard");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}