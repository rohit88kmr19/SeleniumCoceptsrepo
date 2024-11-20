package org.example;

import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLOutput;

public class JavaScript_test1 {

    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Description("Verify the JS")
    @Test
    public void test_JS() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");
//        TakesScreenshot scrShot =((TakesScreenshot) driver);
//
//        //Call getScreenshotAs method to create image file
//
//        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//        //Move image file to new destination
//
//        File DestFile=new File("C:\Users\Asus\OneDrive\Documents");
//
//        //Copy file at destination
//
//        FileUtils.copyFile(SrcFile, DestFile);
        String url = js.executeScript("return document.URL;").toString();
        String url1= js.executeScript("return document.title;").toString();

        System.out.println(url);
        System.out.println(url1);


    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}