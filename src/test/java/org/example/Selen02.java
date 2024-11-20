package org.example;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Selen02 {

    public static void main(String[] args) {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");
    }
}
