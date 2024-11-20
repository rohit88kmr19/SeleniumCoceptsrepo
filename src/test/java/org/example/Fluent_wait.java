package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

import static org.example.Utility_Helpers.*;

public class Fluent_wait {

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

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//          FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                  .withTimeout(Duration.ofSeconds(10))
//                          .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//
//        WebElement errorMsg = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.className("notification-box-description"));
//            }
//        });
        //WebElement errorMsg = checkVisibilityByFluentWait(driver,By.className("notification-box-description"));//Used Utility

        WebElement errorMsg = driver.findElement(By.className("notification-box-description"));
        //checkVisibilityOfAndTextToBePresentInElement(driver, errorMsg);//Utility Used
        checkVisibility(driver, By.className("notification-box-description"));//Utility Used
 //       WebElement errorMsg = driver.findElement(By.className("notification-box-description"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.textToBePresentInElement(errorMsg,"Your email, password, IP address or location did not match"));


        Assert.assertEquals(errorMsg.getText(), "Your email, password, IP address or location did not match");
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        System.out.println(driver.getCurrentUrl());


    }
}