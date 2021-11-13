package com.test.lakshmanan.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.test.lakshmanan.selenium.enums.Browser;

public class DriverFactory {

    public static WebDriver getWebDriver(Browser browser){

        WebDriver driver = null;
        switch(browser){

            case CHROME:
                WebDriverManager.chromedriver().setup(); // method to get the webdriver dynamically
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--silent");
//                options.addArguments("--incognito");
                options.setCapability("applicationCacheEnabled",false);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup(); // method to get the webdriver dynamically
                ChromeOptions chOptions = new ChromeOptions();
                chOptions.addArguments("--headless");
                chOptions.addArguments("--incognito");
                chOptions.addArguments("--window-size=1920,1080");
                chOptions.setCapability("applicationCacheEnabled",false);
                driver = new ChromeDriver(chOptions);
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                driver = null;
        }

        return driver;
    }
}
