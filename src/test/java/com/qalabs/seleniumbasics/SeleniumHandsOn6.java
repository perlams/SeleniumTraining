package com.qalabs.seleniumbasics;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn6 {

    public static void main(String[] args) throws InterruptedException, NullPointerException {
        // Define which browser to use
        String browser = "firefox";


        // Get correct driver for desire browser
        WebDriver myDriver = WebDriverFactory.getDriver(browser);
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        myDriver.manage().window().maximize();
        myDriver.manage().window().setSize(new Dimension(1800, 1000));


        // Get Facebook home page
        myDriver.get(TestConfig.sURLHO6);

        String data= myDriver.getCurrentUrl();
        System.out.println(String.format("The current URL is %s", data, "/n"));
        Assert.assertEquals(data, "https://www.wikipedia.com/" );

        //Declare webElement
        WebElement loginbutton = myDriver.findElement(By.id("loginbutton"));
        loginbutton.click();


        WebElement searchbutton = myDriver.findElement(By.name("q"));
        searchbutton.sendKeys("QA Minds");
        //e.click(By.xpath("//div[text()='QA Minds Lab']"));
        searchbutton.sendKeys(Keys.ENTER);

        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();
    }
}
