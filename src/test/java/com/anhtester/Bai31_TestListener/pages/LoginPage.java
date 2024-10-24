package com.anhtester.Bai31_TestListener.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    private String url = "https://crm.anhtester.com/admin/authentication";


    //Khai báo tất cả các object (element) trên page này
    //Thuộc kiểu đối tượng By(thuộc của selenium)

    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");
    By menuDashboard = By.xpath(" //ul[@id='side-menu']//span[normalize-space()='Dashboard']");

    //Xây dựng các hàm xử lý trên chính page này
    private void setInputEmail(String email) {

        WebUI.setText(inputEmail, email);
        LogUtils.info("Set email value: " + email);
    }

    private void setInputPassword(String password) {
        WebUI.setText(inputPassword, password);
        LogUtils.info("Set password value: " + password);
    }

    private void clickButtonLogin() {
        WebUI.waitForElementVisible(buttonLogin);
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCRM(String email, String password) {

        WebUI.openURL(url);
        WebUI.waitForPageLoaded();
        LogUtils.info("Navigate to URL" + url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        LogUtils.info("Verify login success");
        Assert.assertTrue(DriverManager.getDriver().findElement((menuDashboard)).isDisplayed(), "Menu Dashboard not displayed");
    }

    public void verifyLoginFail() {
        LogUtils.error("Verify login fail");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error Message not display.");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of Error Message not matc.");
    }

    public void verifyRedirectLoginPage() {
        LogUtils.info("Verify to redirect Login Page");
        Assert.assertTrue(DriverManager.getDriver().findElement(headerLoginPage).isDisplayed(), "Header page not displayed.");
        Assert.assertEquals(WebUI.getElementText(headerLoginPage), "Login", "Content of header Login page not match.");
    }

}
