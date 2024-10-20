package com.anhtester.BaiaBai29_DataProvider;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    //Khai báo nơi cung cấp dữ liệu - dùng @DataProvider
    @DataProvider(name = "dataLogin",parallel = true)
    public Object [][] dataLogin(){
        return  new Object[][] {
                {"admin@example.com","123456"},
                {"admin1@example.com","1234567"},
                {"admin2@example.com","12345678"}
        };
    }

    @DataProvider(name = "dataAddCustomer")
    public Object [][] dataAddCustomer(){
        return  new Object[][] {
                {"Hungf",25,"Ha Noi"},
                {"Phuong",32,"Ho Chi Minh"},
                {"Dieu",36,"Ha Noi"}

        };
    }

    @DataProvider(name = "dataLoginFromExcel",parallel = true)
    public Object [][] dataLoginFromExcel(){
        ExcelHelper excelHelper = new ExcelHelper();
        Object [][] data = excelHelper.getExcelData("src/test/resources/testdata/LoginData.xlsx","LoginData");
        System.out.println("Extract data from excel file:  "+data);
        return data;

        };

    @DataProvider(name = "dataLoginFromExcelMultiRow",parallel = true)
    public Object [][] dataLoginFromExcelMultiRow(){
        ExcelHelper excelHelper = new ExcelHelper();
        Object [][] data = excelHelper.getDataHashTable("src/test/resources/testdata/LoginData.xlsx","LoginData",2,3);
        System.out.println("Extract data from excel file:  "+data);
        return data;

    };
    }

