package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class xpathConcepts {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.idrive360.com/enterprise/login");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//Implicitly wait

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
//        wait.until(ExpectedConditions.visibilityOfAllElements());

        //WebElement emailInputbox = driver.findElement(By.id("username"));
        WebElement username_input_css_1 = driver.findElement(By.cssSelector("input#username"));
        username_input_css_1.sendKeys("augtest_040823@idrive.com");

//        WebElement username_input_xpath = driver.findElement(By.xpath("//input[@id='username']"));
//        WebElement username_input_css_1 = driver.findElement(By.cssSelector("input#username"));
//        WebElement username_input_css_2 = driver.findElement(By.cssSelector("#username"));
//        WebElement username_input_name = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");
        WebElement button_submit = driver.findElement(By.cssSelector("div.id-frm-btnblk>button"));
        button_submit.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement errorMessage = driver.findElement(By.cssSelector("h5.id-card-title"));

        System.out.println(errorMessage.getText());
        Assert.assertEquals(errorMessage.getText(),"Your free trial has expired");


        WebElement all_P_Elements1 = driver.findElement(By.xpath("//p[contains(text(), 'and your account has been canceled.')]"));
        Assert.assertEquals(all_P_Elements1.getText(), "and your account has been canceled.");
        System.out.println(all_P_Elements1.getText());

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'and your account has been canceled.')]")));
//        System.out.println(element.getText());

       WebElement all_P_Elements = driver.findElement(By.cssSelector("div.id-card-cont p:nth-of-type(2)"));
        Assert.assertEquals(all_P_Elements.getText(), "In order to reactivate your account, upgrade your account and save 25%*.");
        System.out.println(all_P_Elements.getText());



    }
}