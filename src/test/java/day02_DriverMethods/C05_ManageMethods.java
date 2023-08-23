package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();//->boş bir driver açacak
        driver.manage().window().maximize();

        /*
        Driver'i olusturtuktan sonra maximize yapmamiz bizim için gitmek istedigimiz sayfadaki web elementlere daha rahat
        sorunsuz ulasmamiz icin onemlidir.
        Bunun icin driver'i hemen olusturtuktan sonra manage().Window().Maximize() methodunu kullaniriz.
        Maximize yaptiktan sonra internetten kaynakli sayfa performasindan kaynakli sayfadaki elementler hemen yuklenemeyebilir.
        Dolayisiyla sayfaya gittikten sonra bir elemente, bir butona tiklamak istedigimizde hemen sayfa yuklenmez ise
        elementi bulamayacagi ve tiklama islemini gerceklestiremeyecegi icin testimiz fail verecektir.
        Bunun onune gecmek icin maximize methoddan sonra driver'imiza selenium'dan gelen implicitly wait atamasi yapariz
        Bu wait ile sayfanin tum elementlerinin olusmasini beklemesi icin max. bir sure belirtiriz.
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //techpro sayfasina gidiniz
        driver.get("https://techproeducation.com");
        //sayfa basliginin techPro icerdigini test ediniz
        if(driver.getTitle().contains("TechPro")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(3000);
        driver.close();
    }
}
