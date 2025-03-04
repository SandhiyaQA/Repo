package PageObjectsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResellerOnBoard {
    WebDriver driver;
    ResellerOnBoard(WebDriver driver)
    {
       this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//div[contains(text(),'Reseller')]")
    private static WebElement reseller;

    @FindBy(xpath="//a[text()='Reseller Admin']")
    private static WebElement resellerAdminOnBoard;

    @FindBy(xpath = "//a[text()='Support Ticket']")
    private static WebElement supportTickerReseller;

    public static WebElement getReseller()
    {
        return reseller;
    }
    public static  WebElement getResellerAdminOnBoard()
    {
        return  resellerAdminOnBoard;
    }

    public static  WebElement getSupportTickerReseller()
    {
        return  supportTickerReseller;
    }
    }
