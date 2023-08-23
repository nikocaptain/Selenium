package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Tekrar01 extends TestBase {
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

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

        driver.switchTo().alert().accept();
       WebElement actualtext= driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertEquals("You successfully clicked an alert",actualtext.getText());

    }

    @Test
    public void dismissAlert() {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        "successfuly" icermedigini test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        driver.switchTo().alert().dismiss();
        WebElement actualtext= driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertFalse(actualtext.getText().contains("successfuly"));

    }

    @Test
    public void sendKeysAlert() {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        driver.switchTo().alert().sendKeys("niyazi");
        bekle(2);
        driver.switchTo().alert().accept();
        WebElement actualtext= driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertTrue(actualtext.getText().contains("niyazi"));
    }
}
