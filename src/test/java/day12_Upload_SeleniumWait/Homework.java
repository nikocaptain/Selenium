package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Homework extends TestBase {
    //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.Remove butonuna basin.
    //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6.Add buttonuna basin
    //7.It’s back mesajinin gorundugunu test edin


    //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2.Textbox’in etkin olmadigini(enabled) dogrulayın
    //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyi
    //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //5.Textbox’in etkin oldugunu(enabled) dogrulayın.


    @Test
    public void test01() {
        //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Remove butonuna basin.
        WebElement button=driver.findElement(By.xpath("(//button)[1]"));
        button.click();
        //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsgoneWE= driver.findElement(By.xpath("(//p)[2]"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(itsgoneWE));
        Assert.assertEquals("It's gone!",itsgoneWE.getText());
        //6.Add buttonuna basin

        button.click();

        //7.It’s back mesajinin gorundugunu test edin
        WebElement itsbackWE= driver.findElement(By.xpath("//*[@id='message']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsbackWE.isDisplayed());
        //Assert.assertEquals("It’s back",itsbackWE.getText());

    }

    @Test
    public void test02() {
        //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2.Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textboxWE= driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textboxWE.isEnabled());

        //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebElement enableWE=driver.findElement(By.xpath("(//button)[2]"));
        enableWE.click();
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(300));
        wait.until(ExpectedConditions.visibilityOf(textboxWE));

        //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsenableWE=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsenableWE.isDisplayed());


        //5.Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assert.assertTrue(textboxWE.isEnabled());
    }
}
