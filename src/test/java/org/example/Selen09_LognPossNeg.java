package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selen09_LognPossNeg {
    @Description("Verify that with invalid email and password, error message is shown on the app.vwo login page")
    @Test(priority = 1)
    public void testVWOLoginNegative() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://app.vwo.com/#/login");
        WebElement emailInputbox = driver.findElement(By.id("login-username"));
        emailInputbox.sendKeys("7x@wingify.com");
        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Test123");
        WebElement login = driver.findElement(By.id("js-login-btn"));
        login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
  }


        WebElement errorMsg = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(errorMsg.getText(), "Your email, password, IP address or location did not match");
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        System.out.println(errorMsg.getText());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        System.out.println(driver.getCurrentUrl());
    }
    @Description("Verify that with valid email and password, dashboard page is shown after login into the app")
    @Test(priority = 2)
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

       // Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/dashboard");
        Assert.assertEquals(driver.getTitle(), "Test Test");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}