package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class FileUpload {
    @Test
    public void fileUpload(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/upload/");

        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFileButton.sendKeys("C:\\Users\\Giru\\Desktop");

        WebElement checkbox =driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();

        WebElement pressButton = driver.findElement(By.xpath("//button[@type='button']"));
        pressButton.click();
    }
}
