package org.example;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Selen04 {

    @Test
    public void testMethod()
    {
        WebDriver driver = new EdgeDriver();//Dynamic Dispatch
        WebDriver driver2 = new ChromeDriver();
        WebDriver driver3 = new FirefoxDriver();
        WebDriver driver4 = new InternetExplorerDriver();
        WebDriver driver5 = new SafariDriver();



//         SearchContext(I) (2) -> WebDriver(I)( 10) -> RemoteWebDriver(C) (15) -> ChromiumDriver(C) 25 -> EdgeDriver(C) (45)
//         SearchContext(I) -> WebDriver(I) -> RemoteWebDriver(C) -> ChromiumDriver(C) -> ChromeDriver(C)
//
//
//         SearchContext - Interface - findElement, and findElements - GGF
//         WebDriver - Interface - some incomplete functions - GF
//         RemoteWebDriver - Class- It also has some functions - F
//         ChromeDriver, FirefoxDriver, EdgeDriver, SafariDriver, InternetExplorerDriver  Class - S
//
//         Selenium - Arch - API
//         Create Session, Commands or Functions -> API Request to Browser Driver (
//         Pass the commands as API
//
//        SearchContext driver = new ChromeDriver();
//        WebDriver driver = new ChromeDriver();
  //     RemoteWebDriver driver1 = new ChromeDriver();
//         driver1 = new EdgeDriver()
//
//
//        ChromeDriver  driver = new ChromeDriver();
//
////         Scenarios
////         1. Do want to run on  Chrome or Edge?
////        ChromeDriver driver = new ChromeDriver(); ~1%
////
////         2  Do you want to run on Chrome then change to Edge ?
////         WebDriver driver = new ChromeDriver();
////         driver = new EdgeDriver(); 97% -
////
////
////         3. do you want to run on multiple browsers, aws machine, ? 2%
////         RemoteWebDriver driver (with GRID) - Advance (Last 2 Sessions)
//
////
//        SearchContext driver = new EdgeDriver();//Dynamic dispatch(run time polymorphism)
//
//        driver.findElement();
//        driver.findElements();




    }


}
