package com.anhtester.common.Bai26_ParallelExecutionPom.testcase;


import com.anhtester.common.Bai26_ParallelExecutionPom.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai báo đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        //Khởi tạo đối tượng class LoginPage để truyê giá trị driver từ BaseTest
        //Để class LoginPage nhận được giá trị driver thì mới thực thi các hàm trong class page được
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");

        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "1234567");
        loginPage.verifyLoginFail();
    }
}
