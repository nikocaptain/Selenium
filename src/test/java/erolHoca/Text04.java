package erolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Text04 extends TestBase {
    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    //New Tab butonunun görünür olduğunu doğrula


    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='card-body'])[3]")).click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement pleaseWE=driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']"));
        Assert.assertEquals("Please select an item from left to start practice.",pleaseWE.getText());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newtabWE=driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newtabWE.isDisplayed());
        //New Tab butonuna click yap
        newtabWE.click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        WebElement thisWE=driver.findElement(By.xpath("//h1"));
        Assert.assertEquals("This is a sample page",thisWE.getText());
        //İlk Tab'a geri dön
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newtab=driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newtab.isDisplayed());
    }
}
