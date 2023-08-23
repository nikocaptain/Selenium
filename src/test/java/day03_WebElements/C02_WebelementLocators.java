package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebelementLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Techpro sayfasina gidelim

        driver.navigate().to("https://techproeducation.com");

        //arama kutusunu locate edip java aratalim

        WebElement aramakutusu=driver.findElement(By.id("searchHeaderInput"));
        aramakutusu.sendKeys("java");
        Thread.sleep(3000);

        //Çıkan seçeneklerden full stack java developer seçeneğine tıklayalım

        //cikan seceneklerden full stack java developer secenegine tiklayalim
        List<WebElement> Linkler=driver.findElements(By.linkText("Full Stack Java Developer"));
         /*
            Eger birden fazla web elementi handle etmek istiyorsak bu webelementleri bir list'e atmamiz gerekir.
            List kullandigimiz zaman birden fazla webelement oldugu icin findelements() methodunu kullaniriz.

            Full Stack Java Developer linktext'ine sahip tüm webelmentleri WebElement türünde oluşturmuş olduğum
        liste attım

            Bir webElemente sahip text'i yada bir webelement üzerindeki yazıyı alabilmek ve yazdırabilmek için getText()
        methodunu kullanırız.
         */
        for (WebElement w:Linkler) {
            System.out.println(w.getText());

        }
        Linkler.get(0).click();
        //basligin Java icerdigini test edelim
        if (driver.getTitle().contains("Java")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        //sayfada kac tane link oldugunu yazdiralim
        List<WebElement> linklerListesi=driver.findElements(By.tagName("a"));
        System.out.println(linklerListesi.size());
        //saydaki linkleri lambda ile konsola yazdiralim
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        //sayfayi kapatalim
        driver.close();



    }
}
