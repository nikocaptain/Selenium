package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {

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
        WebElement dosyaSecWe=driver.findElement(By.id("file-upload"));
        //dosyaSecWe.click();//hata verir
        //"C:\Users\Niyazi\Desktop\B171.txt"

        //Yuklemek istediginiz dosyayi secelim.

        String dosyaYolu="C:\\Users\\Niyazi\\Desktop\\B171.txt";
        dosyaSecWe.sendKeys(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        bekle(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.

        String fileuploadWE=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",fileuploadWE);

        driver.close();
    }

    @Test
    public void test02() {
        driver.get("https://www.ilovepdf.com/compress_pdf");
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();
        bekle(3);
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\testng.pdf";//bende dosya yok hata verir
        robotUploadFilePath(dosyaYolu);

        /*
            Upload file yaparken sendKeys() methodunun işlemediği durumlarda TestBase class'ında oluşturduğumuz
         uploadFilePath() methodu ile dosyayı çok rahat yükleyebiliriz. Bu methodu kullanırken ("erol hocaya bolca dua edelim") manuel olarak
         mause ve klavyeyi test esnasında hiçbir şekilde kullanmamamız gerekir. Mac kullanıcıları windows'taki
         ctrl+v tuş kombinasyonunun karşılık geldiği tuş kombinasyonunu Robot class'a belirtmesi gerekir.
         TestBase deki uploadFilePath() methodu sadece windows kullanıcıları için geçerlidir.

         */
    }
}
