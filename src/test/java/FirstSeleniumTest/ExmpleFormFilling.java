package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AddRotatable;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ExmpleFormFilling {
    @Test
    public void registration_form() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Giru\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Register.html");

        driver.manage().window().maximize();

        WebElement FirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        FirstName.sendKeys("Chetana");

        WebElement LastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        LastName.sendKeys("Jadhav");

        WebElement Address = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        Address.sendKeys("Pune, Maharashtra, India");

        WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
        Email.sendKeys("demo@demo.com");

        WebElement Phone = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        Phone.sendKeys("1234567890");

        WebElement Gender = driver.findElement(By.xpath("//input[@value='FeMale']"));
        Gender.click();

        WebElement Hobbies1 = driver.findElement(By.xpath("//input[@value='Cricket']"));
        Hobbies1.click();

        WebElement Hobbies2 = driver.findElement(By.xpath("//input[@value='Movies']"));
        Hobbies2.click();

        WebElement language = driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']"));
        language.click();
        List<WebElement> languageList = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li/span"));

        for (int i = 0; i < languageList.size(); i++) {

            System.out.println("Option No " + (i + 1) + " is " + languageList.get(i).getText());
            if (languageList.get(i).getText().equals("French")) {
                Thread.sleep(2000);
                languageList.get(i).click();
                Thread.sleep(2000);
            }
        }
            WebElement Skills = driver.findElement(By.id("Skills"));
            Select dropdown1 = new Select(Skills);
            dropdown1.selectByVisibleText("AutoCAD");

            WebElement Countries = driver.findElement(By.id("countries"));
            Select dropdown2 = new Select(Countries);
            dropdown2.selectByValue("India");

            driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']")).click();
            driver.findElement(By.className("select2-search__field")).sendKeys("india");
            Actions act1 = new Actions(driver);
            act1.sendKeys(Keys.ENTER).build().perform();


            WebElement Year = driver.findElement(By.id("yearbox"));
            Select dropdown4 = new Select(Year);
            dropdown4.selectByValue("1996");

            WebElement Month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
            Select dropdown5 = new Select(Month);
            dropdown5.selectByValue("September");

            WebElement Day = driver.findElement(By.id("daybox"));
            Select dropdown6 = new Select(Day);
            dropdown6.selectByValue("12");

            WebElement Password = driver.findElement(By.xpath("//input[@id='firstpassword']"));
            Password.sendKeys("Chetu123");

            WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@id='secondpassword']"));
            ConfirmPassword.sendKeys("Chetu123");

            //WebElement submit = driver.findElement(By.id("submitbtn"));
            //submit.click();

           // driver.findElement(By.xpath("//button[@value='Refresh']")).click();
            //driver.close();


        }
    }

