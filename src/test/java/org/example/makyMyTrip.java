package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class makyMyTrip {

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
        //driver.findElement(By.cssSelector(".modalMain.tcnFooter>.commonModal__close")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();

        WebElement fromCitySel = driver.findElement(By.xpath("//p[contains(text(), 'Mumbai, India')]"));
        fromCitySel.click();
        WebElement toCity = driver.findElement(By.id("toCity"));
        toCity.click();
        WebElement toCitySel = driver.findElement(By.xpath("//p[contains(text(), 'Bangkok, Thailand')]"));
        toCitySel.click();

        WebElement departureCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='departure']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", departureCalendar);
        wait.until(ExpectedConditions.elementToBeClickable(departureCalendar)); // Ensure it's clickable
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureCalendar); // Use JS click

        // Navigate to the desired month (if required)
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='Next Month']")));

        WebElement nextMonthButton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        nextMonthButton.click(); // Example: If you need to move to November


        String dateXpath = "//div[@aria-label='Tue Nov 05 2024']";
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(dateXpath)
        ));
        dateElement.click();

        System.out.println("Date Selected Successfully Departure!!!");

        WebElement departureCalendarReturn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-cy='returnArea']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", departureCalendarReturn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureCalendarReturn); // Use JS click


        // Navigate to the desired month (if required)
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='Next Month']")));

        WebElement nextMonthButtonReturn = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        nextMonthButtonReturn.click(); // Example: If you need to move to November

        String returnDateXpath = "//div[contains(@aria-label, 'Jan 10 2024')]"; // Adjust as necessary
        WebElement returnDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(returnDateXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", returnDateElement);

         System.out.println("Date Selected Successfully for return");

//        WebDriverWait searchFlightWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement searchFlight = searchFlightWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cy='submit']")));
//        searchFlight.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement submitButton = driver.findElement(By.xpath("//p[@data-cy='submit']/a"));
        submitButton.click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
//        submitButton.click();

    }
    }





//return
//        Select select = new Select(dropdown);
//        //        select.selectByVisibleText("Option 2");
//        select.selectByIndex(2);

