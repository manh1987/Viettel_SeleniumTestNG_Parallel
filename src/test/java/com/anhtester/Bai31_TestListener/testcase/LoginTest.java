package com.anhtester.Bai31_TestListener.testcase;


import com.anhtester.Bai31_TestListener.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai báo đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        //Khởi tạo đối tượng class LoginPage để truyê giá trị driver từ BaseTest
        //Để class LoginPage nhận được giá trị driver thì mới thực thi các hàm trong class page được
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","sheet1");
        loginPage.loginCRM(
                excelHelper.getCellData("username",1),
                excelHelper.getCellData("password",1)
        );

        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","sheet1");
        loginPage.loginCRM(
                excelHelper.getCellData("username",2),
                excelHelper.getCellData("password",2)
        );
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","sheet1");
        loginPage.loginCRM(
                excelHelper.getCellData("username",3),
                excelHelper.getCellData("password",3)
        );
        loginPage.verifyLoginFail();
    }
}
