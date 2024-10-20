package com.anhtester.Bai26_ParallelExecutionPom.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class DashboardPage {


    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("(//a[@href='#'][normalize-space()='Logout'])[2]");
    private By optionProfile = By.xpath("(//a[normalize-space()='My Profile'])[2]");

    public CustomerPage clickMenuCustomers() {
        WebUI.clickElement(menuCustomer);
        System.out.println("Click on menu Customers");
        return new CustomerPage();
    }

    public void clickMenuProject() {
        WebUI.clickElement(menuProject);
        System.out.println("Click on menu Project");
    }

    public LoginPage logOut() throws InterruptedException {
        WebUI.clickElement(menuProject);
        System.out.println("Click on dropdown Profile");
        WebUI.sleep(3);
        WebUI.clickElement(dropdownProfile);
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");
        WebUI.sleep(2);

        return new LoginPage();

    }

}
