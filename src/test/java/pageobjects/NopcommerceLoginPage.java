package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NopcommerceLoginPage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement userid;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInButton;

    public NopcommerceLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserid(String username) {
        System.out.println("driver" + driver);
        System.out.println("check userid");
        userid.clear();
        userid.sendKeys(username);
    }

    public void setPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        logInButton.click();
    }
}
