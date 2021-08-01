package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    @Test
    public void drag_and_drop() throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
         // driver.get("https://demoqa.com/droppable");
        // WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
        //  WebElement dropArea = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[2]"));

        driver.get("http://demo.automationtesting.in/Static.html");

        WebElement element = driver.findElement(By.xpath("//img[@src='original.png' and @draggable='true']"));

        WebElement dropArea = driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions act = new Actions(driver);
        Thread.sleep(3000);
        act.dragAndDrop(element,dropArea).build().perform();


    }
}
