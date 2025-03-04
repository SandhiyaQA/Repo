package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
    static WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }




    @FindBy(xpath="//input[@placeholder='Please Enter Email']")
    public WebElement userName;

    @FindBy(xpath="//input[@placeholder='Password']")
    public  WebElement password;

    @FindBy(id="login__submit")
    public    WebElement submit;


    public  WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmit() {
        return submit;
    }


}
