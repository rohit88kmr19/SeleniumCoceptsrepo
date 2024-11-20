package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsiframe {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(15000);

        driver.switchTo().frame("result");
        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));

        submit.click();

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement errorElement = driver.findElement(with(By.tagName("small")).below(element));

        String errorText = errorElement.getText();
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");

        Thread.sleep(5000);


    }
}
