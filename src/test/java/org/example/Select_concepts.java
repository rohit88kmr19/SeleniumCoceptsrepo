package org.example;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Select_concepts {
        public static void main(String[] args) {


            EdgeDriver driver = new EdgeDriver();
//            driver.get("https://the-internet.herokuapp.com/dropdown");
//            System.out.println(driver.getTitle());
//            driver.manage().window().maximize();
//
//            WebElement element_select = driver.findElement(By.id("dropdown"));
//            Select select = new Select(element_select);
////        select.selectByVisibleText("Option 2");
//            select.selectByIndex(2);

            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            System.out.println(driver.getTitle());
            driver.manage().window().maximize();

//           WebElement element= driver.findElement(By.xpath("//button[@onClick='jsAlert()']"));
//           element.click();
//           Alert alert = driver.switchTo().alert();
//           alert.accept();
            WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
            elementConfirm.click();
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            
            Alert alert1 = driver.switchTo().alert();
            alert1.dismiss();
//            WebElement elementPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
//            elementPrompt.click();
//            Alert alert2 = driver.switchTo().alert();
//            alert2.sendKeys("Rohit");
//            alert2.accept();
            String result= driver.findElement(By.id("result")).getText();

            System.out.println(result);
            Assert.assertEquals(result, "You entered: Rohit");



        }
    }