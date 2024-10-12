package com.anhtester.common;

import com.anhtester.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(String browserName) {
        WebDriver driver = setBrowser(browserName);
//        new WebUI(driver);
        DriverManager.setDriver(driver);//Gán giá trị driver vào trong ThreadLocal
    }


    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //Khởi tạo Brower
        if (browserName.trim().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }

        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //2 hàm để maximize/minimize cửa sổ trình duyệt
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser() {
        DriverManager.quit();

    }
}