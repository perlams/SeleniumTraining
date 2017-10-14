package com.qalabs.seleniumbasics;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn5 {

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
        myDriver.get(TestConfig.sURLHO3);

        String data= myDriver.getCurrentUrl();
        System.out.println(String.format("The current URL is %s", data, "/n"));
        Assert.assertEquals(data, "https://www.facebook.com/" );

        //Declare webElement
        WebElement email = myDriver.findElement(By.id("email"));
        email.sendKeys(TestConfig.sEmail);

        WebElement pass = myDriver.findElement(By.id("pass"));
        pass.sendKeys(TestConfig.sPass);

        WebElement loginbutton = myDriver.findElement(By.id("loginbutton"));
        loginbutton.click();


        WebElement searchbutton = myDriver.findElement(By.name("q"));
        searchbutton.sendKeys("QA Minds Lab");
        searchbutton.sendKeys(Keys.ENTER);
        WebElement option = myDriver.findElement(By.xpath("//div[text()='QA Minds Lab']"));
        option.click();
        WebElement textArea = myDriver.findElement(By.xpath("//*[@name='xhpc_message_text']"));
        textArea.sendKeys("Selenium Webdriver Perla Hands On 5");
        Thread.sleep(3000);
        WebElement postButton = myDriver.findElement(By.xpath("//button[@data-testid='react-composer-post-button']"));
        postButton.isEnabled();
        postButton.click();

        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();
    }

}
