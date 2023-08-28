package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase {

    //Techproeducation sayfasına gidelim
    //Events linkine tıklayalım
    //Basliğin Events olduğunu doğrulayalım
    //Ve sayfanın resmini alalım
    //Yeni bir sekmede amazon sayfasına gidelim
    //Ve sayfanın resmini alalım
    //Arama kutusunda iphone aratalım
    //Çıkan sonun yazısının resmini alalım
    //Techpro sayfasına geri dönelim
    //ve sayfanın resmini alalım

    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Events linkine tıklayalım
        WebElement eventWE=driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        eventWE.click();
        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(eventWE.getText().contains("Events"));
        //Ve sayfanın resmini alalım
        TakesScreenshot ts= (TakesScreenshot) driver;
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu="target/ekranfotosu/screenShot"+tarih+".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));


        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //Ve sayfanın resmini alalım
        TakesScreenshot tss= (TakesScreenshot) driver;
        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String path="target/ekranfotosu/screenShot"+date+".jpeg";
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File(path));
        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuc yazısının resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String zaman=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String yol="target/webElementEkranFotosu/screenShot"+zaman+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(yol));

        //Techpro sayfasına geri dönelim
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        //ve sayfanın resmini alalım

        TakesScreenshot screenShot= (TakesScreenshot) driver;
        String dateTime=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String pathYol="target/ekranfotosu/screenShot"+dateTime+".jpeg";
        FileUtils.copyFile(screenShot.getScreenshotAs(OutputType.FILE),new File(pathYol));
    }
}
