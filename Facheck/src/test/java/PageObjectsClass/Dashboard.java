package PageObjectsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObject {
    WebDriver driver;
    public loginPageObject(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(xpath="//input[@formcontrolname='email']")
    private static WebElement email;

    @FindBy(xpath="//input[@formcontrolname='password']")
    private static WebElement password;


    @FindBy(xpath=" //button[@type='submit']")
    private static WebElement submit;


    public static WebElement getEmail()
    {
        return email;
    }

    public static WebElement getPassword()
    {
        return password;
    }

    public static WebElement getSubmit()
    {
        return submit;
    }

}

