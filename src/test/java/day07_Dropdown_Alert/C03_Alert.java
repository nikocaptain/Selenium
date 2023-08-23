package day07_Dropdown_Alert;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C03_Alert extends TestBase {
    /*
https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    "successfuly" icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

 */

    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.

        driver.findElement(By.xpath("(//button)[1]")).click();//1. buttop'a click yaptik
        bekle(2);
        driver.switchTo().//gecis methodu
                alert().//Alerte driver'i gecirme methodu
                accept();//alertU onayladık


        String actualresultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String expectedresultMessage="You successfully clicked an alert";
        Assert.assertEquals(expectedresultMessage,actualresultMessage);
    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();//2. button'a click yaptı
        bekle(2);
        driver.switchTo().
                alert().
                dismiss();//cancel yapar
        String actualresultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedResultMessage="successfuly";
       Assert.assertFalse(actualresultMessage.contains(unexpectedResultMessage));
    }

    @Test
    public void sendkeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();//2. button'a click yaptı
        bekle(2);
        driver.switchTo().alert().sendKeys("Niyazi");
        bekle(2);
        driver.switchTo().alert().accept();

        String actualresultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        Assert.assertTrue(actualresultMessage.contains("Niyazi"));
    }
}
