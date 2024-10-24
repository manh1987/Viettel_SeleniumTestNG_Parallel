package com.anhtester.common;

import com.anhtester.drivers.DriverManager;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browser) {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiesHelper.getValue("browser"));
//        new WebUI(driver);
        DriverManager.setDriver(driver);//Gán giá trị driver vào trong ThreadLocal
    }


    public WebDriver setBrowser(String browser) {
        WebDriver driver = null;
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //Khởi tạo Brower
        if (browser.trim().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browser.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browser.trim().toLowerCase().equals("firefox")) {
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
    public void closeBrowser(ITestResult iTestResult) {
        //Chụp màn hình khi test case bị fail. Ngược lại ko chụp
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.takeScreenshot(iTestResult.getName());
        }
        ///Stop record video
        CaptureHelper.stopRecord();
        DriverManager.quit();

    }
}
