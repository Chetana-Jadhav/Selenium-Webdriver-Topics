package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Window_Handle_Using_Set {
    @Test
    public void windowHandle(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        WebElement NewTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        NewTabButton.click();
        System.out.println("Title of current window is :"+ driver.getTitle());
        Set<String>handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowID = it.next();
        String childWindowID = it.next();

        System.out.println("Parent window id is - " + parentWindowID);
        driver.switchTo().window(childWindowID);
        System.out.println("Child Window id is -"+ childWindowID);
        WebElement HeadingInChildWindow = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
       System.out.println("Text in the child window is : " +HeadingInChildWindow.getText());


    }
}
