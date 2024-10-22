package com.anhtester.Bai31_TestListener.testcase;


import com.anhtester.Bai31_TestListener.pages.CustomerPage;
import com.anhtester.Bai31_TestListener.pages.DashboardPage;
import com.anhtester.Bai31_TestListener.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void openCustomer() {
//        loginPage = new LoginPage(driver);
//        loginPage.loginCRM("admin@example.com","123456");
//        loginPage.verifyLoginSuccess();
//        dashboardPage = new DashboardPage(driver);
//        dashboardPage.clickMenuCustomers();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        //dashboardPage = new DashboardPage(driver);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();

        //customerPage = new CustomerPage(driver);
        customerPage.verifyRedirectCustomerPageSuccess();
    }

    @Test
    public void testLogout() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
//        dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.logOut();
        loginPage.verifyRedirectLoginPage();
    }

}
