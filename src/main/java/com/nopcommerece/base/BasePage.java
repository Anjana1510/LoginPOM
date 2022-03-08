package com.nopcommerece.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;
    public WebDriver initializeDriver(String browserName) {
        if (browserName.equals("chrome")) {
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\jalpe\\IdeaProjects\\untitled\\" +
                    "LoginP\\LoginPOM\\src\\test\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {System.out.println("Invalid browser");
        }
        driver.manage().window().maximize();
        return driver;
    }
    public Properties initializeProperties(){prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\jalpe\\IdeaProjects\\untitled\\LoginP\\LoginPOM\\" +
                    "src\\test\\resources\\TestData\\Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
