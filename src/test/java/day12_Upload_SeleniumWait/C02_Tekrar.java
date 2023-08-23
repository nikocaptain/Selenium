package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_Tekrar extends TestBase {

    //https://the-internet.herokuapp.com/dynamic_loading/1
    //Start buttonuna tıkla
    //Hello World! Yazının sitede oldugunu test et


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();

        //loading goruldugunu test et

        WebElement loadingWE= driver.findElement(By.xpath("//div[@id='loading']"));
        Assert.assertTrue(loadingWE.isDisplayed());




        //Hello World! Yazının sitede oldugunu test et
        WebElement helloworldWE = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertTrue(helloworldWE.isDisplayed());

    }
}
