package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {

    //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
    //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
    //Textbox içindeki yazıyı siliniz.
    //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
    //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz

        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız

        WebElement kalinYazi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //Textbox içindeki yazıyı siliniz.

        driver.switchTo().frame(0);
        WebElement textbox=driver.findElement(By.xpath("//p"));
        textbox.clear();
        bekle(2);

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.

        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().parentFrame();
        WebElement elemental=driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertEquals("Elemental Selenium",elemental.getText());
    }
}
