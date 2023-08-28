package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
        /*
        Eğer sadece bir webelementin resmini almak istersek;
            O elementin locate'ini alıp WE.getScreenShotAs() methodu ile webelementin resmini alabiliriz.
            Tüm sayfanın resmini almak istediğimizde TakeScreenShot arayüzünden bir obje oluşturup
        bu objeyi driver'a eşitliyorduk. Dolayısıyla driver'ın gittiği sayfanın resmini
        ts.getScreenShotAs methoduyla alabiliyorduk. Sadece bir webelementin resmini alacağimız için
        TakeScreenShot arayüzüne gerek kalmadan direk webelementin locate'i ile getScreenShotAs methodunu
        kullanarak yine aynı FileUtils class'i ile copyFile methodunu kullanarak resmi alıyoruz
         */

    //aazon sayfasına gidelim
    //arama kutusuna iphone yazdıralım
    //ekran resmini alalım
    //sonuc yazısı web elementinin resmini alalım


    @Test
    public void test01() throws IOException {
        //aazon sayfasına gidelim
        driver.get("https://amazon.com");
        //arama kutusuna iphone yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım

        ekranResmi();

        //sonuc yazısı web elementinin resmini alalım

        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu="target/WebElementEkranGoruntusu/WEscreenShot"+tarih+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyayolu));

    }

    @Test
    public void test02() {
        //aazon sayfasına gidelim
        driver.get("https://amazon.com");
        //arama kutusuna iphone yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım

        ekranResmi();

        //sonuc yazısı web elementinin resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        webElementResmi(sonucYazisi);
    }
}
