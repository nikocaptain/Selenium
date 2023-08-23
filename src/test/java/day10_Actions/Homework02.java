package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework02 extends TestBase {
    /*
    //Amazon sayfasına gidiniz
    //Sayfanın ortalarındaki bir webelementi locate edip o webelemente kadar scroll yapınız
    */

        /*
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         */

    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.navigate().to("https://amazon.com");
        //Sayfanın ortalarındaki bir webelementi locate edip o webelemente kadar scroll yapınız
        WebElement discoverFashion=driver.findElement(By.xpath("(//h2[@class='a-color-base headline truncate-2line'])[10]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(discoverFashion).perform();

    }

    @Test
    public void test02() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu=driver.findElement(By.cssSelector("textarea[id='APjFqb']"));
        aramaKutusu.sendKeys("Selenium", Keys.ENTER);
        bekle(2);
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        Actions actions=new Actions(driver);
        WebElement aramakutusu2=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu2.click();
        actions.keyDown(aramakutusu2,Keys.CONTROL).sendKeys("ax").keyUp(Keys.CONTROL).perform();

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        bekle(2);
        WebElement aramaKutusu3=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu3.click();
        actions.keyDown(aramaKutusu3,Keys.CONTROL).sendKeys("v",Keys.ENTER).perform();
    }
}
