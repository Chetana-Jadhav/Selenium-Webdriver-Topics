package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
    @Test
    public void Right_Click(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement righClickMeButton = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions act = new Actions(driver);
        act.contextClick(righClickMeButton).build().perform();
    }
}
