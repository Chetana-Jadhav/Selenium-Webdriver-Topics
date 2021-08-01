package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.lang.annotation.Documented;

public class doubleClick {
    @Test
    public void double_click(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
        Actions act = new Actions(driver);
        act.doubleClick(doubleClickButton).build().perform();
        Alert alertaccept = driver.switchTo().alert();
        alertaccept.accept();



    }
}
