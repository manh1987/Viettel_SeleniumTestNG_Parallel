package com.anhtester.Bai30_TakeScreenshot_RecordVideo;

import com.anhtester.Bai26_ParallelExecutionPom.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoTakeScreenshot extends BaseTest {
    LoginPage loginPage;

    @Test (testName = "TC_01")
    public void testLoginCRM_Success() {
        //Khởi tạo đối tượng class LoginPage để truyê giá trị driver từ BaseTest
        //Để class LoginPage nhận được giá trị driver thì mới thực thi các hàm trong class page được
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","sheet1");
        loginPage.loginCRM(
                excelHelper.getCellData("username",2),
                excelHelper.getCellData("password",2)
        );


//        // Tạo tham chiếu của TakesScreenshot
//        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
//// Gọi hàm để chụp ảnh màn hình - getScreenshotAs
//        File source = ts.getScreenshotAs(OutputType.FILE);
//// Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
//        File theDir = new File("./screenshots/");
//        if (!theDir.exists()) {
//            theDir.mkdirs(); //Tạo moi thư mục
//        }
////Lưu file ảnh với tên cụ thể vào đường dẫn
//        try {
//            FileHandler.copy(source, new File("./screenshots/testLoginCRM_Success2.png"));
//            System.out.println("Take screenshot testLoginCRM_Success successfully");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        CaptureHelper.takeScreenshot("testLoginCRM_Success");
        loginPage.verifyLoginSuccess();
    }

}
