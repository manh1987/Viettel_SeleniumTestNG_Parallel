package com.anhtester.common.BaiaBai29_DataProvider;

import com.anhtester.keywords.WebUI;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class DemoDataProvider {


    //Truyền noi cung cấp dữ liệu vao trong testcase @Test
    @Test (dataProvider = "dataLogin",dataProviderClass = DataProviderFactory.class)
    public  void testLoginSuccess(String email, String password){
        System.out.println("Email: "+ email);
        System.out.println("Password: "+ password);
        WebUI.sleep(2);
    }

    @Test (dataProvider = "dataAddCustomer",dataProviderClass = DataProviderFactory.class)
    public void testAddNewCustomer(String name,int age, String address){
        System.out.println("Ho va ten: "+ name);
        System.out.println("Tuoi: "+ age);
        System.out.println("Dia chi: "+ address);
    }

    @Test (dataProvider = "dataLoginFromExcel",dataProviderClass = DataProviderFactory.class)
    public  void testLoginFromExcelFile(String email, String password){
        System.out.println("Email: "+ email);
        System.out.println("Password: "+ password);
        WebUI.sleep(2);
    }



}
