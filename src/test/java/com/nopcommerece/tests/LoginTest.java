package com.nopcommerece.tests;

import com.nopcommerece.base.BasePage;
import com.nopcommerece.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest {
    BasePage basePage;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initializeProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initializeDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
    }
    @Test
    public void clickLogin(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password") );
    }
    @Test
    public void tearDown(){
        driver.quit();
    }
}
