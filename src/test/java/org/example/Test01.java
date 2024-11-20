package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {
    public static void main(String[] args) {

        ChromeDriver chromeDriver=new ChromeDriver();
        chromeDriver.get("https://app.vwo.com");
    }
}
