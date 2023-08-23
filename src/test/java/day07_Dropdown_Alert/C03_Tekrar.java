package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Tekrar extends TestBase {
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
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.

        WebElement acceptalert= driver.findElement(By.xpath("(//button)[1]"));
        acceptalert.click();
        bekle(2);
        driver.switchTo().alert().accept();
       WebElement actual= driver.findElement(By.xpath("//*[@id='result']"));
       String expected="You successfully clicked an alert";
        Assert.assertEquals(expected,actual.getText());
    }

    @Test
    public void dissmisAlert() {
       // Bir metod olusturun: dismissAlert
       // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
       // "successfuly" icermedigini test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        WebElement dissmisalert= driver.findElement(By.xpath("(//button)[2]"));
        dissmisalert.click();
        bekle(2);
        driver.switchTo().alert().dismiss();
        WebElement actual=driver.findElement(By.cssSelector("p[id='result']"));
        String expected="successfuly";
        Assert.assertFalse(actual.getText().contains(expected));


    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);
       //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
       //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement sendkeys=driver.findElement(By.xpath("(//button)[3]"));
        sendkeys.click();
        bekle(2);
        driver.switchTo().alert().sendKeys("niyazi");
        driver.switchTo().alert().accept();
        WebElement actual=driver.findElement(By.cssSelector("p[id='result']"));
        String expected="niyazi";
        Assert.assertTrue(actual.getText().contains(expected));
        System.out.println(actual.getText());

    }
}
