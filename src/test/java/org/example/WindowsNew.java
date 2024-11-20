package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WindowsNew {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement closeModal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modalMain.tcnFooter>.commonModal__close")));
        closeModal.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scroll Down");

        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

//        String dir = System.getProperty("user.dir");
//        System.out.println(dir);
        //  /Users/promode/IdeaProjects/LearningSeleniumATB7x/src/test/java/com/thetestingacademy/ex_selenium/ex_02112024_Actions_Windows_Iframe/Hello.txt
        uploadFileInput.sendKeys("D:\\Selenium_Concepts\\test.html");
        driver.findElement(By.name("submit")).click();
        System.out.println(driver.getCurrentUrl());
    }


}
