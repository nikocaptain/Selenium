package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        String techproAdres="https://techproeducation.com";
        //Techpro sayfasina gidelim. https://techproeducation.com
        driver.get(techproAdres);
        //Sayfa basliginin "Techpro" icerdigini test edin
        System.out.println("Sayfa adresi Techpro içeriyor mu : "+driver.getTitle().contains("Techpro"));
        //Sayfa adresini(url) yazdirin
       String techproUrl= driver.getCurrentUrl();
        System.out.println("techpro url'i : "+techproUrl);
        //Sayfa url'inin "techpro" icerdigini test edin.
        System.out.println("Sayfa url'i techpro iceriyor mu : "+techproUrl.contains("techpro"));
        //Sayfa handle degerini yazdirin
       String techproHandle= driver.getWindowHandle();
        System.out.println("Sayfa handle degeri : "+techproHandle);
        //Sayfa HTML kodlarinda "text" kelimesi gectigini test edin
        System.out.println("Sayfa html kodlari text iceriyor mu : "+driver.getPageSource().contains("text"));
        Thread.sleep(4000);
        //sayfayi kapatin
        driver.close();

    }
}
