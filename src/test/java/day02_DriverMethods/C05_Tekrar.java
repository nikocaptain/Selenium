package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //techpro sayfasina gidiniz
        driver.get("https://techproeducation.com");
        Thread.sleep(2000);
        //sayfa basliginin techPro icerdigini test ediniz
       String title= driver.getTitle();
        System.out.println(title);
       if (title.contains("techPro")){
           System.out.println("TEST PASSED");
       }else {
           System.out.println("TEST FAILED");
       }
        //Sayfayi kapatiniz
        driver.close();
    }
}
