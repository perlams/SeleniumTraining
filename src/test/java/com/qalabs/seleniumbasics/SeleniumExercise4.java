package com.qalabs.seleniumbasics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumExercise4 {

    public static void captureScreenshot(WebDriver driver,String screenshotName)
    {

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("C:\\Users\\Perla\\Selenium-Oracle\\"+screenshotName+".png"));

            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException, NullPointerException {

        // Define which browser to use
        String browser = "phantomjs";
        String data = null;


        // Get correct driver for desire browser
        WebDriver myDriver = WebDriverFactory.getDriver(browser);
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        myDriver.manage().window().maximize();
        myDriver.manage().window().setSize(new Dimension(1800, 1000));



        // Get Youtube home page
        myDriver.get("https://www.youtube.com/");
        captureScreenshot(myDriver, "testSS");

        //Declare webelement
        WebElement e=myDriver.findElement(By.xpath("//input[@id='search']"));


        //Check if the element is displayed and enabled
        e.isDisplayed();
        e.isEnabled();

        //Enter Search value
        String searchLabel = "Selenium";
        e.sendKeys(searchLabel);
        //e.sendKeys(Keys.ENTER);

        //Find the search button
        e= myDriver.findElement(By.id("search-icon-legacy"));

        //Click on the search button
        e.click();

        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();

    }
}
