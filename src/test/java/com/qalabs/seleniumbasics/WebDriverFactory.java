package com.qalabs.seleniumbasics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.util.ArrayList;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser) {
        File rootPath = new File("src/test/resources/lib-thirdparty/driversforwin");
        if(browser.toLowerCase().equals("chrome")) {
            File chromeFilePath = new File(rootPath, "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());

            return new ChromeDriver(options);

        } else if (browser.toLowerCase().equals("firefox")) {
            File firefoxFilePath = new File(rootPath, "geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        } else if (browser.toLowerCase().equals("phantomjs")) {

            File file = new File(rootPath, "phantomjs.exe");

            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());
            capability.setCapability("takesScreenshot", false);
            String[] args = {"--ignore-ssl-errors=yes"};
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args);
            //capability.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0");
            //System.out.println("Capability:" +capability);

            return new PhantomJSDriver(capability);
        } else {

            return null;
        }
    }


}
