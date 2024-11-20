package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class eBay {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.ebay.com/");

        WebElement search = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        search.sendKeys("apple");

        WebElement serch_click = driver.findElement(By.cssSelector("input[id=\"gh-btn\"]"));
        serch_click.click();

        List<WebElement> title_Items = driver.findElements(By.cssSelector(".s-item__title"));
        List<WebElement> items_Price = driver.findElements(By.cssSelector(".s-item__price"));

        int size = Math.min(title_Items.size(), items_Price.size());

        double minPrice = Double.MAX_VALUE;  // Initialize with the largest possible value
        double maxPrice = Double.MIN_VALUE;  // Initialize with the smallest possible value
        String minPriceTitle = "";
        String maxPriceTitle = "";

        for (int i = 0; i < size; i++) {
//            System.out.println("Title:" +title_Items.get(i).getText()+"||" + "Price" +items_Price.get(i).getText());
//            System.out.println();
            try {
                // Extract title and price text
                String title = title_Items.get(i).getText();
                String priceText = items_Price.get(i).getText()
                        .replaceAll("[^0-9.]", "") // Keep only numbers and dots
                        .trim();

                // Convert the cleaned price to double
                double price = Double.parseDouble(priceText);

                // Print the current item details
                System.out.println("Title: " + title + " || Price: $" + price);

                // Find the minimum price
                if (price < minPrice) {
                    minPrice = price;
                    minPriceTitle = title;
                }

                // Find the maximum price
                if (price > maxPrice) {
                    maxPrice = price;
                    maxPriceTitle = title;
                }

            } catch (NumberFormatException e) {
                // Handle invalid or non-numeric price values
                System.out.println("Skipping invalid price: " + items_Price.get(i).getText());
            }
        }
        // Print the min and max prices with their titles after the loop
        System.out.println("\nMinimum Price: $" + minPrice + " || Title: " + minPriceTitle);
        System.out.println("Maximum Price: $" + maxPrice + " || Title: " + maxPriceTitle);


    }
}