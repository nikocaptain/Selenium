package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplictWait_WebDriverWait extends TestBase {
    @Test
    public void test01() {
        /*
        SELENIUM WAIT :
            IMPLICITLY WAIT:--> driver'i olusturduktan sonra sayfadaki tum webelementlerin etkilesime
        girebilmesi icin belirtmis oldugumuz max. sure kadar driver'i bekletir.(Duration.ofSecond(15))

            EXPLICT WAIT/WebDriverWait--> bir webelementin sayfa yuklendikten sonra etkilesime girebilmesi icin mak.
        belirtmis oldugumuz sure kadar default olarak yarim saniyelik araliklarla bekler. ornegin bir webelemente
        tikladiktan sonra cikan bir webelement yada bir alert'in cikmasi testimizi her calistirfdigimizda farkli
        surelerde olusabilir.Dolayisiyla bunu sureyi kestiremedigimizden dolayi Thread.sleep ile yapmamiz cok mantikli
        ve profesyonelce olmaz.Bu gibi durumlarda webdriverwait ile bir webelementin olusmasini bekletmek daha
        profesyonelce ve daha dinamik olur.Bunun icin webdriwer wait klasindan bir obje olusturup parametre olarak driver'i
        ve max. sureyi belirtiriz
            EXPLICT WAIT/FluentWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için max.
        belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda bekler
         */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorldWE=driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));
        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE=new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        /*
        locate'ni aldigim webelementi gornur olana kdar bekle dedik ve bunu webelemente assign ettik.
         */
        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et

        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4)[2]")));
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("//h4)[2]")).getText());

        /*
bir web butona tikladigimizda kisa sureli ekranda duran ve kaybolan bir webelementin locate'ni nasil aliriz.
Web sayfasinda sag tus incele dedikten sonra, 'source'(Kaynaklar) kismina basar ve butona tikladigimizda
sagdaki pause isaretiyle web elementlerin yuklenmesini durudurabiliriz. Bu sekilde de kaybolan yazi veya elementin
locateni rahatlikla alabiliriz.
 */
    }
}
