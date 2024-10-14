package com.anhtester.common.Bai27_ReadPropertiesFile;

import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadPropertiesFile {
    @Test
    public void testReadFile(){
        PropertiesHelper.loadAllFiles();
        System.out.println("BROWSER: "+ PropertiesHelper.getValue("browser"));
        System.out.println("URL: "+ PropertiesHelper.getValue("url"));
        System.out.println("EMAIL: "+ PropertiesHelper.getValue("email"));
        System.out.println("PASSWORD: "+ PropertiesHelper.getValue("password"));
        System.out.println("MESSGAGE1: "+ PropertiesHelper.getValue("message1"));
        System.out.println("TIMEOUT: "+ PropertiesHelper.getValue("timeout"));

    }

    @Test
    public void setDataToProperties(){
        //Chỉ định file cần set data
        PropertiesHelper.setFile("src/test/resources/configs/configs.properties");
//        PropertiesHelper.loadAllFiles();
        PropertiesHelper.setValue("headless","yes");
    }
}
