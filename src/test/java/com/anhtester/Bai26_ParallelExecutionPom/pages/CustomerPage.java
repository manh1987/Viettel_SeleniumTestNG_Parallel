package com.anhtester.Bai26_ParallelExecutionPom.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CustomerPage {


    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@class='input-group']//input[@type='search']");

    //Trang Dashboard
    private By menuDashboard = By.xpath(" //ul[@id='side-menu']//span[normalize-space()='Dashboard']");
    private By menuProjects = By.xpath(" //ul[@id='side-menu']//span[normalize-space()='Projects']");
    private By menuCustomers = By.xpath(" //ul[@id='side-menu']//span[normalize-space()='Customers']");
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']//a[normalize-space()='Viettel VTX']");


    //Trang Customer List
    private By headerCustomersSummary = By.xpath("//span[normalize-space()='Customers Summary']");
    //private By buttonAddNewCustomer =By.xpath("//a[normalize-space()='New Customer']");
    public By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts1 = By.xpath("//a[normalize-space()='New Customer']/following-sibling::a[normalize-space()='Contacts']");
    private By buttonContacts = By.xpath("//a[contains(@href,'all_contacts')]");
    private By inputSearchCustomer = By.xpath("//div[@class='input-group']//input");
    //Trang Add NewCustomer
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVatNumber = By.xpath("//input[@id='vat']");
    public By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroups = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type ='search']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//button[@data-id='default_currency']/following-sibling::div//input[@type='search']");
    private By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    private By textareaAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropDownCountry = By.xpath("//div[@app-field-wrapper='country']//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("(//div[@class='dropdown-menu open'])[4]//input[@type = 'search']");
    private By buttonSaveAndCreateContact = By.xpath("//div[@id='profile-save-section']//button[1]");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    public void clickButtonAddNew() {
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void verifyRedirectCustomerPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement((headerCustomerPage)).isDisplayed(), "Không tìm thấy Customer header page");
        Assert.assertEquals(WebUI.getElementText(headerCustomerPage), "Customers Summary", "Giá trị header page không đúng");
    }

    public void inputDataCustomer(String companyName) throws InterruptedException {
        WebUI.setText(inputCompany, companyName);
        WebUI.setText(inputVatNumber, "10");
        WebUI.setText(inputPhoneNumber, "0936366649");
        WebUI.setText(inputWebsite, "https://crm.anhtester.com/admin/clients/client");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroups, "Gold");
        WebUI.sleep(1);
//        driver.findElement(inputSearchGroups).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchGroups, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(textareaAddress, "Hà Nội");
        WebUI.setText(inputCity, "Hà Nội");
        WebUI.setText(inputState, "Thăng Long");
        WebUI.setText(inputZipCode, "1234");
        WebUI.clickElement(dropDownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(3);
//        driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public ProfilePage searchCustomer(String companyName) throws InterruptedException {
        WebUI.setText(inputSearchCustomer, companyName);
        WebUI.sleep(2);
        WebUI.clickElement(firstItemCustomerOnTable);
        return new ProfilePage();
    }


}
