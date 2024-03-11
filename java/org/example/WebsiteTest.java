package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.example.GenricMethods.takeSreenShort;

public class WebsiteTest {
    public static void main(String[] args) {
        // Set website URL
        String url = "https://www.google.com";

        // Define browsers to test
        Map<String, String> drivers = new HashMap<>();
        drivers.put("Chrome", "");
        drivers.put("Firefox", "");
        drivers.put("Edge", "");

        // Define resolutions to test
        Map<String, String> resolutions = new HashMap<>();
        resolutions.put("Desktop", "1920x1080");
        resolutions.put("Tablet", "1024x768");
        resolutions.put("Mobile", "360x640");

        try {
            for (Map.Entry<String, String> browserEntry : drivers.entrySet()) {

                String browserName = browserEntry.getKey();
                File browserFolder = new File(browserName);
                browserFolder.mkdir(); // Create a folder for the browser

                for (Map.Entry<String, String> resolutionEntry : resolutions.entrySet()) {
                    WebDriver driver;
                    switch (browserEntry.getKey()) {
                        case "Chrome":
                            driver = new ChromeDriver();
                            break;
                        case "Firefox":
                            driver = new FirefoxDriver();
                            break;
                        case "Edge":
                            driver = new EdgeDriver();
                            break;
                        default:
                            driver = new ChromeDriver();

                    }
                    String resolutionName = resolutionEntry.getKey();
                    String resolution = resolutionEntry.getValue();
                    File resolutionFolder = new File(browserName + "/" + resolutionName);
                    resolutionFolder.mkdir(); // Create a folder for the resolution

                    // Set window size
                    String[] dimensions = resolution.split("x");
                    int width = Integer.parseInt(dimensions[0]);
                    int height = Integer.parseInt(dimensions[1]);
                    driver.manage().window().setSize(new Dimension(width, height));

                    // Open website
                    driver.get(url);


                    //Recording method calling here
                    //Which is in genricMethod


                    //Test script should be write here
                    driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("MS Dhoni");
                    Thread.sleep(3000);



                    // Take screenshot Method calling
                    takeSreenShort(driver,browserName,resolutionName);


                    // Quit the driver
                    driver.quit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
