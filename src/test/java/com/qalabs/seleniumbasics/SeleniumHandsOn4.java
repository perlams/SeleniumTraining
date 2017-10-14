package com.qalabs.seleniumbasics;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn4 {
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
        myDriver.get(TestConfig.sURLHO4);

        String data= myDriver.getCurrentUrl();
        System.out.println(String.format("The current URL is %s", data, "/n"));
        Assert.assertEquals(data, "https://www.amazon.com.mx/" );


        //Declare webelement
        WebElement e = myDriver.findElement(By.id("twotabsearchtextbox"));
        e.sendKeys("Selenium");
        e.sendKeys(Keys.ENTER);

        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();

    }
}
