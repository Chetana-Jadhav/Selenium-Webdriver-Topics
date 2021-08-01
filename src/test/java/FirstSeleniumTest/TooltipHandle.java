package FirstSeleniumTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class TooltipHandle {
    @Test
    public void TooltipHandle(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/tool-tips/");
        WebElement hoverlink = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
        Actions act = new Actions(driver);
        act.moveToElement(hoverlink).build().perform();

        WebElement tooltip = driver.findElement(By.className("//div[@class='tooltip-inner' and text(),'You hovered over the Button']"));
        String tooltipText = tooltip.getText();

        Assert.assertEquals("You hovered over the Button",tooltipText);


    }

}
