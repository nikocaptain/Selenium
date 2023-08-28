package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    //https://the-internet.herokuapp.com/context_menu sitesine gidin
    //Kutuya sag tıklayın
    //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
    //Tamam diyerek alert'i kapatın

    @Test
    public void actions() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sag tıklayın

        WebElement kutu=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(kutu).perform();//-->locate ettigimiz web elemente sag click yapar
        //kullandigimiz action'i işleme alması icin perform() methodunu kullanmamız gerekiyor.


        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin

        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        //driver.switchTo().alert().getText() methodu ile alert alert uzerindeki mesajı aldık ve dogrulama yaptık
        bekle(3);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
    }
}
