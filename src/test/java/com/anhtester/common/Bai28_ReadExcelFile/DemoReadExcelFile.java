package com.anhtester.common.Bai28_ReadExcelFile;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExcelFile {
    @Test
    public void testGetDataFormExcelFilel(){
        //Gọi hàm setExcelFile để chỉ định file excel v sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","Sheet1");

        //Gọi hàm getCellData để đọc data theo từng  ô
        System.out.println(excelHelper.getCellData("username",1));
        System.out.println(excelHelper.getCellData("username",2));
        System.out.println(excelHelper.getCellData("password",1));
        System.out.println(excelHelper.getCellData("password",2));
    }

    @Test
    public void  testsetDataToExcelFile(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","Sheet2");

        //Gọi hàm setcellData để ghi data vao từng ô chỉ định
        excelHelper.setCellData("anhtester@email.com","email",1);
        excelHelper.setCellData("123456","password",1);
        excelHelper.setCellData("project manager","role",1);
    }
}
