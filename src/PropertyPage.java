import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ahmed
 * Date: 20/04/2013
 * Time: 02:44
 * To change this template use File | Settings | File Templates.
 */
public class PropertyPage extends TestBase
{
    @Test(description = "Opens a property page")
    public void openPropertyPage()
    {
        driver.get("http://www.rightmove.co.uk/property-for-sale/property-26170587.html");
    }

    @Test(description = "Check that property info at top of page is present and visible", dependsOnMethods = {"openPropertyPage"})
    public void propertyInfoTop()
    {
        //Find and store the info at the top of the page
        WebElement propertyType = driver.findElement(By.id("propertytype"));
        WebElement propertyPrice = driver.findElement(By.id("propertyprice"));
        WebElement addressContainer = driver.findElement(By.id("addresscontainer"));

        //Make sure all the info is displayed
        assertTrue(propertyType.isDisplayed());
        assertTrue(propertyPrice.isDisplayed());
        assertTrue(addressContainer.isDisplayed());
    }

    @Test(description = "Check that the gallery is present and visible", dependsOnMethods = {"propertyInfoTop"})
    public void gallery()
    {
        //Find and store the components of the gallery
        WebElement gallery = driver.findElement(By.id("gallery"));
        WebElement thumbnail = driver.findElement(By.id("thumbnailcontainer"));

        //Make sure the gallery components are displayed
        assertTrue(gallery.isDisplayed());
        assertTrue(thumbnail.isDisplayed());
    }

    @Test(description = "Check that request details section is present and displayed", dependsOnMethods = {"gallery"})
    public void requestDetails()
    {
        //Find and store the 'request details' elements
        WebElement branchNumber = driver.findElement(By.id("branchnumber"));
        WebElement requestDetails = driver.findElement(By.id("requestdetailsbutton"));

        //Make sure the 'request details' element are displayed
        assertTrue(branchNumber.isDisplayed());
        assertTrue(requestDetails.isDisplayed());
    }

    @Test(description = "Check that tabs are present and displayed", dependsOnMethods = {"requestDetails"})
    public void tabs()
    {
        //Find and store the tab element
        WebElement tabs = driver.findElement(By.id("tabs"));
        //Make sure the tab element is displayed
        assertTrue(tabs.isDisplayed());
    }

    @Test(dependsOnMethods = {"tabs"})
    public void tabClicks()
    {
        //Find and store the tabs that make up the tab container
        WebElement floorTab = driver.findElement(By.id("tabs-floorplans"));
        WebElement mapTab = driver.findElement(By.id("tabs-mapandschools"));
        WebElement streetTab = driver.findElement(By.id("link-streetview"));
        WebElement descriptionTab = driver.findElement(By.id("tabs-description"));

        //Make sure all the tabs are clickable
        floorTab.click();
        mapTab.click();
        streetTab.click();
        descriptionTab.click();

    }
}
