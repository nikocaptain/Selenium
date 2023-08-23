package day04_GetTagNameGetAttributeXpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Arama kutusunu locate edelim

        WebElement aramaKutusu=driver.findElement(By.id("searchHeaderInput"));

        //arama kutusunun tag name'inin input olduğunu test edelim

       String gercektagname= aramaKutusu.getTagName();

       String beklenentagname="input";

       if (gercektagname.equals(beklenentagname)){
           System.out.println("test passed");
       }else {
           System.out.println("test failed");
       }

        //arama kutusunun class attribute'nun degerinin "form-input" oldugunu test ediniz

       String gercekattribute= aramaKutusu.getAttribute("class");
       String beklenenattribute="form-input";

       if (gercekattribute.equals(beklenenattribute)){
           System.out.println("test passed");
       }else {
           System.out.println("test failed");
       }

       //sayfayi kapatiniz

        driver.close();





    }
}
