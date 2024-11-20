package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClass2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(source).click().build().perform();
        actions.moveToElement(source).click().sendKeys("BLR").build().perform();

        WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(destination).click().sendKeys("AMD").build().perform();
    }
}