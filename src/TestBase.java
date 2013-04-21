import com.thoughtworks.selenium.SeleneseTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created with IntelliJ IDEA.
 * User: ahmed
 * Date: 17/04/2013
 * Time: 03:25
 * To change this template use File | Settings | File Templates.
 */
public class TestBase extends SeleneseTestBase {

    //Selenium driver that will be used to carry out testing
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite(description = "Setup the driver before testing begins.")
    public void setUpSelenium()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterSuite(description = "Shutdown the driver once testing is complete.")
    public void shutDownSelenium()
    {
        driver.quit();
    }

}
