package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Tekrar extends TestBase {
        /*
        Eğer sadece bir webelementin resmini almak istersek;
            O elementin locate'ini alıp WE.getScreenShotAs() methodu ile webelementin resmini alabiliriz.
            Tüm sayfanın resmini almak istediğimizde TakeScreenShot arayüzünden bir obje oluşturup
        bu objeyi driver'a eşitliyorduk. Dolayısıyla driver'ın gittiği sayfanın resmini
        ts.getScreenShotAs methoduyla alabiliyorduk. Sadece bir webelementin resmini alacağimız için
        TakeScreenShot arayüzüne gerek kalmadan direk webelementin locate'i ile getScreenShotAs methodunu
        kullanarak yine aynı FileUtils class'i ile copyFile methodunu kullanarak resmi alıyoruz
         */

    //amazon sayfasına gidelim
    //arama kutusuna iphone yazdıralım
    //ekran resmini alalım
    //sonuc yazısı web elementinin resmini alalım

    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //arama kutusuna iphone yazdıralım
       WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
         String dosyayolu="target/resim/ekranResmi"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));
        //sonuc yazısı web elementinin resmini alalım

        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyyy").format(new Date());
        String path="target/webElementResim/resim"+date+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(path));
    }
}
