package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class WindowsHandle {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String parentWindow = driver.getWindowHandle();
        System.out.println("Paremt Window Handles-->"+parentWindow);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("WindowHandles:-->" +windowHandles);

        for (String handle:windowHandles)
        {

            if (driver.getPageSource().contains("New Window"))
            {
                driver.switchTo().window(handle);
                System.out.println("Test Case Passed");
                break;
            }
        }

    }
}
