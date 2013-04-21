import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ahmed
 * Date: 19/04/2013
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class HomePageSaleSearch extends TestBase
{
    @Test(description = "Opens RightMove homepage")
    public void openHomePage()
    {
        driver.get("http://www.rightmove.co.uk");
    }

    @Test(description = "Type 'W1' into search box and search sales", dependsOnMethods = { "openHomePage" })
    public void typeAndSearchW1()
    {
        //Find the search field
        WebElement searchField = driver.findElement(By.id("searchLocation"));
        //Type 'W1' into the search field
        searchField.sendKeys("W1, West London");
        //Find the 'For Sale' button
        WebElement forSale = driver.findElement(By.id("buy"));
        //Click the 'For Sale' button
        forSale.click();
    }

    @Test(description = "Choose search parameters and submit", dependsOnMethods = {"typeAndSearchW1"})
    public void specifySearch()
    {
        //Find all the search options
        WebElement radius = driver.findElement(By.id("radius"));
        WebElement type = driver.findElement(By.id("displayPropertyType"));
        WebElement bedMin = driver.findElement(By.id("minBedrooms"));
        WebElement bedMax = driver.findElement(By.id("maxBedrooms"));
        WebElement priceMin = driver.findElement(By.id("minPrice"));
        WebElement priceMax = driver.findElement(By.id("maxPrice"));
        WebElement addedToSite = driver.findElement(By.id("maxDaysSinceAdded"));

        //Select the radius
        Select select = new Select(radius);
        select.selectByValue("0.25");

        //Select the property type
        select = new Select(type);
        select.selectByValue("flats");

        //Select the min and max number of bedroom
        select = new Select(bedMin);
        select.selectByValue("1");
        select = new Select(bedMax);
        select.selectByValue("2");

        //Select the min and max price
        select = new Select(priceMin);
        select.selectByValue("50000");
        select = new Select(priceMax);
        select.selectByValue("325000");

        //Select the max amount of days since property added
        select = new Select(addedToSite);
        select.selectByValue("14");

        //Find 'Find Property' button and click it
        WebElement findPropertyButton = driver.findElement(By.id("submit"));
        findPropertyButton.click();
    }

    @Test(description = "Verify the property summaries are present and visible", dependsOnMethods = {"specifySearch"})
    public void checkSummaries()
    {
        //Find the 'summaries' element
        WebElement summaries = driver.findElement(By.id("summaries"));
        //Make sure the 'summaries' element is displayed
        assertTrue(summaries.isDisplayed());
    }
}
