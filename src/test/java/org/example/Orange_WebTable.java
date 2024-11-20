package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Orange_WebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList";
        driver.get(URL);
        driver.manage().window().maximize();

        //column WebTable //div[@class='oxd-table-header']/div[1]/div
        //row //div[@class='oxd-table-card']
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Hacker@4321");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        int row = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']")).size();
        int col = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card'][1]//div[@class='oxd-table-cell oxd-padding-cell']")).size();

        System.out.println("The no of rows in the table are -->" + row);
        System.out.println("The no of columns in the table are--->" + col);

        String first_part = "//div[@class='oxd-table-body']//div[@class='oxd-table-card'][";
        String second_part = "]//div[@class='oxd-table-cell oxd-padding-cell'][";
        String third_part = "]";
        for (int i = 1; i <= row; i++) {
           for (int j = 1; j <= col; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                if (data.contains("Terminated"))
                {
                    WebElement term= driver.findElement(By.cssSelector("button.oxd-icon-button.oxd-table-cell-action-space[type='button']"));
                    term.click();
                   // WebElement yes_button= driver.findElement(By.xpath("//button[contains(@class, 'oxd-button') and @type='button'][2]"));
                    //yes_button.click();
                    break;
                }
                System.out.println(data);
            }
           // System.out.println();

        }
    }}