package com.qalabs.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class SeleniumExercise1{

        public static void main(String[] args) throws InterruptedException, NullPointerException {

            File rootPath = new File("src/test/resources/lib-thirdparty/driversforwin");
            File firefoxFilePath = new File(rootPath, "geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            WebDriver myDriver =  new FirefoxDriver();

            // Get google home page
            myDriver.get("https://www.google.com.mx");


            // Wait some seconds
            Thread.sleep(2000);


            // Quit web driver
            myDriver.quit();

        }

}
