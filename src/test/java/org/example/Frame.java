package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.List;
import java.util.Set;

public class Frame {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Parent--->"+mainWindowHandle);
        List<WebElement> list_heatmaps= driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmaps.get(1)).click().build().perform();
        Thread.sleep(13000);
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All Window Handles:--->"+allHandles);
        for (String handle:allHandles)
        {
            if (!handle.equals(mainWindowHandle))
            {
                driver.switchTo().window(handle);
                System.out.println("Child Window Title-->"+driver.getTitle());
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickMap = driver.findElement(By.cssSelector("[data-qa=\"liqokuxuba\"]"));
                clickMap.click();
            }
        }
            driver.switchTo().window(mainWindowHandle);




    }
}
