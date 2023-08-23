package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsTest extends TestBase {

    //Google anasayfasına gidelim
    //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramakutusu, Keys.SHIFT).//arama kutusunda shift tusuna basili tut
                sendKeys("selenium").//shift tusduna basili tutarak SELENIUM yazdiracak
                keyUp(Keys.SHIFT).//shift tusundan elini cek
                sendKeys("-java",Keys.ENTER).perform();
    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramakutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT," java",Keys.ENTER);
    }

        /*
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         */
}
