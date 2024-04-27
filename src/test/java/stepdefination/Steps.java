package stepdefination;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AddCustomer;
import pageobjects.NopcommerceLoginPage;

import java.time.Duration;

public class Steps {
    WebDriver driver= new ChromeDriver();

    NopcommerceLoginPage loginPage = new NopcommerceLoginPage(driver);;
    AddCustomer addcust = new AddCustomer(driver);


   //WebDriver driver = new ChromeDriver();
    //NopcommerceLoginPage loginPage = new NopcommerceLoginPage(driver);

    @Given("the web application {string} is launched in {string}")
    public void the_web_application_is_launched_in(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        //driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @When("the user enters the value {string} into userid textbox at NopcommerceLoginPage page")
    public void the_user_enters_the_value_into_userid_textbox_at_nopcommerce_login_page_page(String username) {
        // Write code here that turns the phrase above into concrete actions
        //loginPage.setUserid("admin@yourstore.com");
        loginPage.setUserid(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @When("the user enters the value {string} into the password texbox at NopcommerceLoginPage page")
    public void the_user_enters_the_value_into_the_password_texbox_at_nopcommerce_login_page_page(String pwd) {
        // Write code here that turns the phrase above into concrete actions

        //loginPage.setPassword("admin");
        loginPage.setPassword(pwd);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        System.out.println("after pwd enter");
    }

    @When("the user click on log in element at NopcommerceLoginPage page")
    public void the_user_click_on_log_in_element_at_nopcommerce_login_page_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("before log in");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @Then("user validates the pagetitle {string} is displayed")
    public void user_validates_the_pagetitle_is_displayed(String Homepage) {
        // Write code here that turns the phrase above into concrete actions
        //Homepage = "Dashboard / nopCommerce administration";
        Homepage = "Dashboard / nopCommerce administration";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(Homepage, actualTitle);

    }
    //new customer add steps
    @When("user click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        addcust.clickOnCustomer();
    }

    @When("user click on customer menu option")
    public void user_click_on_customer_menu_option() {
        // Write code here that turns the phrase above into concrete actions
        addcust.clickOnCustomerMenuItems();
    }

    @When("user click on addnew button")
    public void user_click_on_addnew_button() {
        // Write code here that turns the phrase above into concrete actions
        addcust.clickOnAddNewCustomer();
    }

    @When("fill the customer info")
    public void fill_the_customer_info() {
        // Write code here that turns the phrase above into concrete actions
        addcust.setEmail("");
        addcust.setFirstName("avanti");
        addcust.setLastName("Ahuja");
        addcust.setGender("female");
        addcust.currentRoles("Administractor");
        addcust.setTxtManagetOfVendor("Not a vendor");
        addcust.setPassword("avanti@123");
    }

    @Then("user can see confirmation message {string}")
    public void user_can_see_confirmation_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("",driver.getTitle());
    }

    @Then("close browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.close();
    }


}
