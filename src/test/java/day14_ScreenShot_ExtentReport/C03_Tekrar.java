package day14_ScreenShot_ExtentReport;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_Tekrar extends TestBase {
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
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Events linkine tıklayalım
        driver.findElement(By.xpath("(//*[.='Events'])[1]")).click();
        //Basliğin Events olduğunu doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));
        //Ve sayfanın resmini alalım
        ekranResmi();
        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        bekle(5);
        //Ve sayfanın resmini alalım
        ekranResmi();
        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //Çıkan sonun yazısının resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi);
        //Techpro sayfasına geri dönelim
        window(0);
        //ve sayfanın resmini alalım
        ekranResmi();
    }
}
