package FirstSeleniumTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_AlertHandling {
    @Test
    public void alertHandle(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Alerts.html");
        WebElement AlertWithOKButton = driver.findElement(By.xpath("//a[@href='#OKTab']"));
        AlertWithOKButton.click();
        WebElement AlertDisplayButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"));
        AlertDisplayButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text in the alert is:"+alert.getText());
        //Assert.assertEquals("I am an alert box!", alert.getText());
        if("I am an alert box!".equalsIgnoreCase(alert.getText())){
            alert.accept();
        } else {
            System.out.println("Text of alert does not match with expected Text");
        }
        WebElement AlertWithOkAndCancelButton = driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]"));
        AlertWithOkAndCancelButton.click();

        WebElement ConfirmationBoxDisplayButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
        ConfirmationBoxDisplayButton.click();

        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
        //Message after accepting or declining alert
        WebElement confirmMessage = driver.findElement(By.xpath("//p[contains(text(),'You Pressed Cancel')]"));
        Assert.assertEquals("You Pressed Cancel",confirmMessage.getText());
        System.out.println(confirmMessage.getText());

       }
    }

