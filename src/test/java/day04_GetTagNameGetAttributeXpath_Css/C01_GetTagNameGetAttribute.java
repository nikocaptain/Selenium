package day04_GetTagNameGetAttributeXpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //techproeducation sayfasına gidelim

        driver.navigate().to("https://techproeducation.com");


        //Arama kutusunu locate edelim

        WebElement aramaKutusu=driver.findElement(By.id("searchHeaderInput"));

        //arama kutusunun tag name'inin input olduğunu test edelim

        System.out.println("Arama kutusu web elementi tagName'i : "+aramaKutusu.getTagName());

        String gercekTagName=aramaKutusu.getTagName();//-->input
        String istenenTagName="input";

        if (gercekTagName.equals(istenenTagName)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //arama kutusunun class attribute'nun degerinin "form-input" oldugunu test ediniz

        String gercekAttributeName=aramaKutusu.getAttribute("class");//->form-input
        System.out.println("class attribute degeri : "+gercekAttributeName);
        String beklenenAttributeDegeri="form-input";
        if (gercekAttributeName.equals(beklenenAttributeDegeri)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //sayfayi kapatiniz

        driver.close();
    }
}
