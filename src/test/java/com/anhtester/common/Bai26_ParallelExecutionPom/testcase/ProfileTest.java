package com.anhtester.common.Bai26_ParallelExecutionPom.testcase;

import com.anhtester.common.Bai26_ParallelExecutionPom.pages.CustomerPage;
import com.anhtester.common.Bai26_ParallelExecutionPom.pages.DashboardPage;
import com.anhtester.common.Bai26_ParallelExecutionPom.pages.LoginPage;
import com.anhtester.common.Bai26_ParallelExecutionPom.pages.ProfilePage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProfilePage profilePage;
    private String CUSTOMER_NAME = "Viettel A1";

    @Test

    public void verifyProfile() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        profilePage = customerPage.searchCustomer(CUSTOMER_NAME);
        profilePage.verifyCustomerDetail(CUSTOMER_NAME);
    }


}
adfgadfgdfgadfgadfg