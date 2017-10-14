package com.qalabs.seleniumbasics;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn2 {

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
        String browser = "chrome";


        // Get correct driver for desire browser
        WebDriver myDriver = WebDriverFactory.getDriver(browser);
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        myDriver.manage().window().maximize();
        myDriver.manage().window().setSize(new Dimension(1800, 1000));


        // Get Youtube home page
        myDriver.get("https://www.google.com/");

        String data= myDriver.getCurrentUrl();
        System.out.println(String.format("The current URL is %s", data, "/n"));
        Assert.assertEquals(data, "https://www.google.com/" );
        captureScreenshot(myDriver, "testSSHandsOn");

        //Declare webelement
        WebElement e = myDriver.findElement(By.id("lst-ib"));


        //Check if the element is displayed and enabled
        e.isDisplayed();
        e.isEnabled();

        //Enter Search value
        String searchLabel = "Selenium";
        e.sendKeys(searchLabel);
        e.sendKeys(Keys.ENTER);


        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();
    }
}
