package com.qalabs.seleniumbasics;

import org.openqa.selenium.WebDriver;

public class SeleniumExercise3 {

   // public void showPageTitle (String Data){


   // }

    public static void main(String[] args) throws InterruptedException, NullPointerException {

        // Define which browser to use
        String browser = "chrome";
        String data = null;

        // Get correct driver for desire browser
        WebDriver myDriver = WebDriverFactory.getDriver(browser);

        // Get google home page
        myDriver.get("https://www.google.com.mx");
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        //Move to Facebook
        myDriver.navigate().to("https://www.facebook.com/");
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        //Move to ESPN
        myDriver.navigate().to("http://www.espn.com.mx/");
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        //Go Back first time
        myDriver.navigate().back();

        //Go Back second time
        myDriver.navigate().back();
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        //Go Forward one time
        myDriver.navigate().forward();
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        //Refresh and print
        myDriver.navigate().refresh();
        data= myDriver.getTitle();
        System.out.println(String.format("Title is %s", data, "/n"));

        // Wait some seconds
        Thread.sleep(5000);

        // Quit web driver
        myDriver.quit();

    }



}
