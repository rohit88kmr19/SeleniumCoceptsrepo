package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTable {

    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Description("Verify the WebTable")
    @Test
    public void test_JS() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();

        ////table[@id='customers']/tbody/tr
        ////table[@id='customers']/tbody/tr[2]/td

        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        System.out.println("The no of rows in the table are -->"+row);
        System.out.println("The no of columns in the table are--->"+col);


        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i=2; i<=row;i++)
        {
            for (int j=1;j<=col;j++)
            {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
               // System.out.println(data);
                if (data.contains("Helen Bennett"))
                {
                    String country_path= dynamic_xpath+"/following-sibling::td";
                    String country_company= dynamic_xpath+"/preceding-sibling::td";
                    String country_text= driver.findElement(By.xpath(country_path)).getText();
                    String company_text= driver.findElement(By.xpath(country_company)).getText();
                    System.out.println("---------------------");
                    System.out.println("helen Bennett is in - " +country_text);
                    System.out.println("helen Bennett is Company - " +company_text);
                }
            }
        }




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