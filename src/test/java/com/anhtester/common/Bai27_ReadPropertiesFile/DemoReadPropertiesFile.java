package com.anhtester.common.Bai27_ReadPropertiesFile;

import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadPropertiesFile {
    @Test
    public void testReadFile(){
        PropertiesHelper.loadAllFiles();
        System.out.println("BROWSER: "+ PropertiesHelper.getValue("browser"));
    }
}
