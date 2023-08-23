package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        String amazon="https://www.amazon.com/";

       //1.amazon sayfasina gidelim. https://www.amazon.com/
        driver.get(amazon);
       //2.Sayfa basligini(title) yazdirin
       String amazonTitle= driver.getTitle();
        System.out.println("Sayfa basligi : "+amazonTitle);
       //3.Sayfa basliginin “Amazon” icerdigini test edin
        System.out.println("Sayfa basligi Amazon iceriyor mu : "+driver.getTitle().contains("Amazon"));
        //4.Sayfa adresini(url) yazdirin
       String amazonUrl= driver.getCurrentUrl();
        System.out.println("Amazon url'i : "+amazonUrl);
       //5.Sayfa url’inin “amazon” icerdigini test edin.
        System.out.println("Amazon Url'i amazon iceriyor mu : "+amazonUrl.contains("amazon"));
        //6.Sayfa handle degerini yazdirin
       String windowHandle = driver.getWindowHandle();
        System.out.println("Amazon Handle degeri : "+windowHandle);
       //7.Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        System.out.println("HTML kodlari Gateway içeriyor mu : "+driver.getPageSource().contains("Gateway"));
        Thread.sleep(3000);
        //8.Sayfayi kapatin.

        driver.close();

    }
}
