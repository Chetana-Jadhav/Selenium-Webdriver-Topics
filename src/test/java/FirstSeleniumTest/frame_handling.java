package FirstSeleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame_handling {
    @Test
    public void FrameHandling(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Frames.html");

        WebElement SingleFrameButton = driver.findElement(By.xpath("//a[contains(text(),'Single Iframe ')]"));
        SingleFrameButton.click();

        WebElement IFrame = driver.findElement(By.xpath("//iframe[@name='SingleFrame']"));
        driver.switchTo().frame(IFrame);

        WebElement InputBox = driver.findElement(By.xpath("//input[@type='text']"));
        InputBox.sendKeys("TestframeHandling");

        //switching back to main frame
        driver.switchTo().parentFrame();

        WebElement PageCenterText_Heading = driver.findElement(By.xpath("//h1[contains(text(),'Automation Demo Site ')]"));

        System.out.println(PageCenterText_Heading);
    }

    @Test
    public void MultiframeHandle(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Frames.html");
        WebElement multiIFramebutton = driver.findElement(By.xpath("//a[contains(text(), 'Iframe with in an Iframe')]"));
        multiIFramebutton.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing Multiframe");
        driver.switchTo().parentFrame();

    }
}
