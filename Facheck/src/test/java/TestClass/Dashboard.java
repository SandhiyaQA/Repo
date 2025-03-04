package TestClass;

import BaseClass.BaseClass;
import PageObjectsClass.loginPageObject;
import actionclass.actionClass;
import configFileReader.configFileRead;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.time.Duration;
public class LoginPage extends BaseClass {
    actionClass act = new actionClass();

    boolean redirection=true;
    int Banner=0;

  @Test(priority =1)
    public void loginPage() {
        driver.navigate().refresh();
        PageFactory.initElements(driver, loginPageObject.class);
        act.sendKeys(loginPageObject.getEmail(), configFileRead.getUserName());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        act.sendKeys(loginPageObject.getPassword(), configFileRead.getPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        act.click(loginPageObject.getSubmit());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        System.out.println("Hello URL Launched");

    }




}
