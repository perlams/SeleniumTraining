package com.qalabs.seleniumbasics;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn3 {

    public static void main(String[] args) throws InterruptedException, NullPointerException {
        // Define which browser to use
        String browser = "chrome";


        // Get correct driver for desire browser
        WebDriver myDriver = WebDriverFactory.getDriver(browser);
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        myDriver.manage().window().maximize();
        myDriver.manage().window().setSize(new Dimension(1800, 1000));


        // Get Facebook home page
        myDriver.get(TestConfig.sURLHO3);

        String data= myDriver.getCurrentUrl();
        System.out.println(String.format("The current URL is %s", data, "/n"));
        Assert.assertEquals(data, "https://www.facebook.com/" );


        //Declare webElement
        WebElement e = myDriver.findElement(By.id("email"));
        e.sendKeys(TestConfig.sEmail);
        e = myDriver.findElement(By.id("pass"));
        e.sendKeys(TestConfig.sPass);
        e = myDriver.findElement(By.id("loginbutton"));
        e.click();

        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();

    }
}
