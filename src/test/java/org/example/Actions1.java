package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstname"));
        // Keyboards - > keyDown -> Shift -> send key -> key Up

        Actions actions  = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstName,"the testing academy")
                .keyUp(Keys.SHIFT).build().perform();

        Thread.sleep(13000);
        driver.quit();
    }
}
