package erolHoca;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Text03 extends TestBase {
//*** Aşağıdaki task'i Junit framework'ü ile yapınız
//-https://the-internet.herokuapp.com/windows sayfasına gidiniz
// -Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
//-Elemental Selenium linkine tıklayınız
//-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
//-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
//"
//A free weekly email of tips to help make
//Selenium one of the most robust browser
//automation tools out there.
//"
//-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
//-Language dropdown menuden java seçiniz
//-Join the mailing list buttonuna tıklayınız
//-Sayfada Thank you! yazısının çıktığını doğrulayınız


    @Test
    public void test01() {
        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");
        // -Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement elementalSeleniumWE=driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertEquals("Elemental Selenium",elementalSeleniumWE.getText());
        //-Elemental Selenium linkine tıklayınız
        elementalSeleniumWE.click();

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));
        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        Assert.assertEquals("https://elementalselenium.com/",driver.getCurrentUrl());
        //"
        //A free weekly email of tips to help make
        //Selenium one of the most robust browser
        //automation tools out there.
        //"
        //-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
        Faker faker=new Faker();
        String fakerMail=faker.internet().emailAddress();
        WebElement emailWE=driver.findElement(By.xpath("//input[@id='email']"));
        emailWE.sendKeys(fakerMail);
        //-Language dropdown menuden java seçiniz
        WebElement ddm=driver.findElement(By.xpath("//select"));
        Select select=new Select(ddm);
        select.selectByValue("Java");
        //-Join the mailing list buttonuna tıklayınız
        driver.findElement(By.xpath("(//input)[2]")).click();
        //-Sayfada Thank you! yazısının çıktığını doğrulayınız
        WebElement sonucyazisi=driver.findElement(By.xpath("//h1"));
        Assert.assertEquals("Thank you!",sonucyazisi.getText());
    }
}
