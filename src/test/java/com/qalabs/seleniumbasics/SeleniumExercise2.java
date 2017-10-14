package com.qalabs.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class SeleniumExercise2 {

    public static void main(String[] args) throws InterruptedException, NullPointerException {

        File rootPath = new File("src/test/resources/lib-thirdparty/driversforwin");
        File firefoxFilePath = new File(rootPath, "geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
        WebDriver myDriver =  new FirefoxDriver();

        // Get google home page
        myDriver.get("https://www.google.com.mx");

        String data = null;
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        data= myDriver.getCurrentUrl();
        System.out.println(String.format("The Current URL is %s", data, "/n"));

        data= myDriver.getPageSource();
        System.out.println(String.format("The page source is %s", data, "/n"));


        // Wait some seconds
        //Thread.sleep(5000);
        myDriver.wait(1000);

        // Quit web driver
        myDriver.quit();

    }


}
