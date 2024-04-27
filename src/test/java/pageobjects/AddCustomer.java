package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
    WebDriver driver;
    public AddCustomer(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    By customer= By.xpath("//a[@href='#']/p[contains(text(),'Customers')]");
    By customerMenuItem = By.xpath("//a/p[.=' Customers']");
    By btnaddNewCustomer = By.xpath("//a[@class='btn btn-primary']");
    By email= By.id("Email");
    By password = By.id("Paaword");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By rdGenderMale = By.id("Gender_Male");
    By rdGenderFemale = By.id("Gender_Female");
    By txtcompanyName = By.xpath("//input[@id='Company']");
    By txtCustomerRoles = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']");
    By listAdministrator = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[.='Administrators']");
    By listForumModerators = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[.='Forum Moderators']");By listGuest = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[.='Guests']");
    By listRegistered = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[.='Registered']");
    By listVendore = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[.='Vendors']");
    By chIsTaxExempt = By.id("IsTaxExempt");
    By btnSave = By.xpath("//button[@name='save']");
    By txtManagetOfVendor = By.xpath("//select[@id='VendorId']");
    //action methods


    public void setPassword(String pwd) {
        driver.findElement(password).sendKeys("");
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys("");;
    }

    public void setFirstName(String fname) {
        driver.findElement(firstName).sendKeys("");
    }

    public void setLastName(String lName) {
        driver.findElement(lastName).sendKeys("");;
    }


    public void clickOnCustomer()throws InterruptedException{
       Thread.sleep(1000);
        driver.findElement(customer).click();
    }
    public void clickOnCustomerMenuItems(){
        driver.findElement(customerMenuItem).click();
    }
    public void clickOnSaveButton(){
        driver.findElement(btnSave).click();

    }
    public void clickOnAddNewCustomer(){
        driver.findElement(btnaddNewCustomer).click();

    }
    public String currentRoles(String cRoles){
        WebElement listItem;
        if(cRoles.equals("Administractor")){
            listItem= driver.findElement(listAdministrator);

        } else if (cRoles.equals("Vendors")) {
            listItem=driver.findElement(listVendore);

        } else if (cRoles.equals("Guest")) {
            listItem= driver.findElement(listGuest);

        } else if (cRoles.equals("ForumModerators")) {
           listItem= driver.findElement(listForumModerators);
        } else if (cRoles.equals("Registered")) {
            listItem= driver.findElement(listRegistered);

        } else {
            listItem=driver.findElement(listGuest);
        }
        listItem.click();
        return cRoles;
    }
    public void setTxtManagetOfVendor(String value){
        Select select = new Select(driver.findElement(txtManagetOfVendor));
       select.selectByVisibleText(value);
    }
    public void setGender(String gender){
        if (gender.equals("female")){
            driver.findElement(rdGenderFemale).click();
        } else if (gender.equals("male")) {
            driver.findElement(rdGenderMale).click();

        }

    }
}
