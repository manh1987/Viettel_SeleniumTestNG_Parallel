package com.anhtester.Bai26_ParallelExecutionPom.testcase;

import com.anhtester.common.BaseTest;
import com.anhtester.Bai26_ParallelExecutionPom.pages.CustomerPage;
import com.anhtester.Bai26_ParallelExecutionPom.pages.DashboardPage;
import com.anhtester.Bai26_ParallelExecutionPom.pages.LoginPage;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    private String CUSTOMER_NAME = "Viettel A12";

    @Test
    public void testAddNewCustomer() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);


    }

}
