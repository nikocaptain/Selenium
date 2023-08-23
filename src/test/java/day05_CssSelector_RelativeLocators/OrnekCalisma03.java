package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrnekCalisma03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        //3- cookies uyarisini kabul ederek kapatin
        //4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5. Arama cubuguna “Nutella” yazip aratin
        //6. Bulunan sonuc sayisini yazdirin
        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8. Sayfayi kapatin

        //2- https://www.google.com/ adresine gidin

        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin

        //4. Sayfa basliginin “Google” ifadesi icerdigini test edin

       String title= driver.getTitle();
       // System.out.println(title);
        if (title.contains("Google")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //5. Arama cubuguna “Nutella” yazip aratin

        WebElement nutellaYazdir=driver.findElement(By.cssSelector("textarea[jsname='yZiJbe']"));
        nutellaYazdir.sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(3000);

        //6. Bulunan sonuc sayisini yazdirin

       WebElement sonucSayisi= driver.findElement(By.cssSelector("div[id='result-stats']"));

        System.out.println(sonucSayisi.getText());

        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String[] sonuc=sonucSayisi.getText().split(" ");

        System.out.println(Arrays.toString(sonuc));

        String actual =sonuc[1];
        System.out.println(actual);

      actual=  actual.replaceAll("\\D","");
        System.out.println(actual);

        int gercek= Integer.parseInt(actual);

        if (gercek>10000000){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //8. Sayfayi kapatin

        driver.close();





    }
}
