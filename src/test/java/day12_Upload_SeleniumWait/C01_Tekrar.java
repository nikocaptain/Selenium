package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //"File Uploaded!" textinin goruntulendigini test edelim.


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
       WebElement chooseFileWE = driver.findElement(By.id("file-upload"));
       //chooseFileWE.click();//hata verir sendkey uzerinden dosyayolu ile upload yapılır

        //Yuklemek istediginiz dosyayi secelim.

        //"C:\Users\Niyazi\Desktop\B171.txt"
        String dosyayolu="C:\\Users\\Niyazi\\Desktop\\B171.txt";
        chooseFileWE.sendKeys(dosyayolu);
        bekle(2);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        bekle(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.

        String  actual= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",actual);

    }
}
