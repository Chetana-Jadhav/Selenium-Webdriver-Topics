package FirstSeleniumTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {

    @Test
    public void Validate() {
        //open browser
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Giru\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //navigate url
        driver.get("https://www.amazon.in/");
        // find search bar and enter value
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("computer");
        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.manage().window().maximize();
        String expectedTitle = "Amazon.in : computer";
        String ActualTitle = driver.getTitle();
        // if(expectedTitle.equalsIgnoreCase(ActualTitle)){
        //   System.out.println("Test case Passed. expected page is displayed");

        // }
        // else {
        //  System.out.println("Testcase failed. Expected page is not displayed");
        //  }
        //Use of assertion using Junit to avoid if else for testcase status
        Assert.assertEquals(expectedTitle, ActualTitle);

        //driver.close();
    }

    @Test
    // @search
    // Scenario: User is able to filter the search based on price
    // Given User search for a Product as "Laptop"
    // When User enters minimum as "20000" and maximum as "50000" in the filter criteria
    // Then User is able to see results with price between "20000" and "50000"
    public void filterBasedOnPrice(){
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Giru\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //navigate url
        driver.get("https://www.amazon.in/");
        // find search bar and enter value
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.id("low-price")).sendKeys("20000");
        driver.findElement(By.id("high-price")).sendKeys("50000");
        driver.findElement(By.className("a-button-input")).click();
       // driver.close();
    }
    @Test
   // @product_details  @smoke
  //  Scenario: User is able to see the product details
  //  Given User searched for the product
   // When User click on any product
   // Then User is navigated to the new tab and product details are displayed
    public void productDetails() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Giru\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //navigate url
        driver.get("https://www.amazon.in/");
        // find search bar and enter value
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptop");
        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.partialLinkText("Lenovo IdeaPad Slim 3 (2021) | Intel Core i3 11th Gen |14\" ")).click();
        String currentTabHandle = driver.getWindowHandle();
        String newTabHandle = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentTabHandle))
                .findFirst()
                .get();
        driver.switchTo().window(newTabHandle);
        String expectedTitle = "Amazon.in: Buy Lenovo IdeaPad Slim 3 (2021) | Intel Core i3 11th Gen |14\" FHD IPS |Thin & Light Laptop | 4-Side Narrow Bezel (8GB/256GB SSD/Win10/Office/Backlit KB/Fingerprint Reader/Arctic Grey/1.41kg), 82H700J8IN Online at Low Prices in India | Lenovo Reviews & Ratings";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //driver.close();
    }
    @Test
        //Scenario: User is able to select the quantity and add to cart from Product details page
        //Given User is on the product details page
        //When User selects the product quantity as 2
        // And User clicks add to cart on the page on product details page
         // Then Product is added to the cart

        public void qntyandAddToCart () {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Giru\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //navigate url
        driver.get("https://www.amazon.in/");
        // find search bar and enter value
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptop");
        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.partialLinkText("Lenovo IdeaPad Slim 5 11th Gen Intel Core i5 14\" FHD IPS Thin & Light Laptop (8GB/512GB SSD/Win 10/Office/Intel Iris Xe Graphics/Fingerprint Reader/Graphite Grey/Aluminium Surface/1.39Kg), 82FE00QLIN")).click();

        //handle newly opened window
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        String parentWindowId = it.next();
        String childWindowId = it.next();


        driver.switchTo().window(childWindowId);

        //Handle dropdown of quantity
        Select dropdownQnty = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[5]/div[4]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[28]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/select[1]")));
        dropdownQnty.selectByValue("2");
        driver.findElement(By.id("add-to-cart-button")).click();
        //driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
        //to double click on button
        Actions NoThanksButton = new Actions(driver);
        NoThanksButton.moveToElement(driver.findElement(By.xpath("//input[@aria-labelledby='btnVasModalSkip-announce']"))).doubleClick().build().perform();
        String expectedTitle = "Amazon.in Shopping Cart";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.findElement(By.linkText("Mobiles")).click();

        //scrolling the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement phone = driver.findElement(By.xpath("//img[@alt='Samsung Galaxy M42 5G (Prism Dot Black, 8GB RAM, 128GB Storage)']"));
        js.executeScript("arguments[0].scrollIntoView();", phone);
        phone.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
        driver.quit();

    }
    @Test
    //Scenario: User can view his added items in the cart
    //Given User has added multiple products in the cart
   // When User navigates to the My Cart Page
   // Then User is able to see the list of all the added items with correct quantities as well as price totals is correct

    public void CartPage(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.partialLinkText("Lenovo IdeaPad Slim 5 11th Gen Intel Core i5 14\" FHD IPS Thin & Light Laptop (8GB/512GB SSD/Win 10/Office/Intel Iris Xe Graphics/Fingerprint Reader/Graphite Grey/Aluminium Surface/1.39Kg), 82FE00QLIN")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        Select dropdownQnty = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[5]/div[4]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[28]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/select[1]")));
        dropdownQnty.selectByValue("2");
        driver.findElement(By.id("add-to-cart-button")).click();
        Actions NoThanksButton = new Actions(driver);
        NoThanksButton.moveToElement(driver.findElement(By.xpath("//input[@aria-labelledby='btnVasModalSkip-announce']"))).doubleClick().build().perform();

        driver.findElement(By.linkText("Mobiles")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement phone = driver.findElement(By.xpath("//img[@alt='Samsung Galaxy M42 5G (Prism Dot Black, 8GB RAM, 128GB Storage)']"));
        js.executeScript("arguments[0].scrollIntoView();", phone);
        phone.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
        driver.findElement(By.id("nav-cart")).click();
        List<WebElement>  ProductsCount = driver.findElements(By.tagName(""));
        System.out.println("Total no of products on the page is " + ProductsCount.size());








        //driver.quit();





        }

}