package com.anhtester.helpers;

import com.anhtester.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureHelper {
    //Tạo format ngày giờ để xíu gắn dô cái name của screenshot hoặc record video không bị trùng tên (không bị ghi đè file)
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public static void takeScreenshot(String screenshotName){
        // Tạo tham chiếu của TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
// Gọi hàm để chụp ảnh màn hình - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
// Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
        File theDir = new File(SystemHelper.getCurrentDir()+PropertiesHelper.getValue("SCREENSHOT_PATH"));
        if (!theDir.exists()) {
            theDir.mkdirs(); //Tạo moi thư mục
        }
//Lưu file ảnh với tên cụ thể vào đường dẫn
        try {
            FileHandler.copy(source, new File(SystemHelper.getCurrentDir()+PropertiesHelper.getValue("SCREENSHOT_PATH")+ screenshotName +"_"+ dateFormat.format(new Date()) +".png"));
            System.out.println("Take screenshot "+ screenshotName +" successfully");
        } catch (IOException e) {
            System.out.println("ERROR. Can not Take screenshot "+ screenshotName +".");
        }
    }
}
