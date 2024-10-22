package com.anhtester.Bai31_TestListener.pages;

import com.anhtester.keywords.WebUI;
import org.testng.Assert;

public class ProfilePage extends CustomerPage {


    public void verifyCustomerDetail(String companyName) {
//        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), "Viettel A1", "");
        Assert.assertEquals(WebUI.getAttribute(inputCompany, "value"), "Viettel A1", "");
//        Assert.assertEquals(driver.findElement(inputVatNumber).getAttribute("value"), "10", "");
        Assert.assertEquals(WebUI.getAttribute(inputVatNumber, "value"), "10");
//        Assert.assertEquals(driver.findElement(inputPhoneNumber).getAttribute("value"), "0936366649", "");
        Assert.assertEquals(WebUI.getAttribute(inputPhoneNumber, "value"), "0936366649", "");
//        Assert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"), "https://crm.anhtester.com/admin/clients/client", "");
        Assert.assertEquals(WebUI.getAttribute(inputWebsite, "value"), "https://crm.anhtester.com/admin/clients/client", "");
//        Assert.assertEquals();
//        Assert.assertEquals();
    }


}
