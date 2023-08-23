package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //Techpro sayfasina gidelim. https://techproeducation.com
        driver.get("https://techproeducation.com");
        //Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Basligi : "+driver.getTitle());
        //Sayfa basliginin "Techpro" icerdigini test edin
        if (driver.getTitle().contains("TechPro")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url'i : "+driver.getCurrentUrl());
        //Sayfa url'inin "techpro" icerdigini test edin.
        if (driver.getCurrentUrl().contains("techpro")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //Sayfa handle degerini yazdirin
        String techproSayfaHandleDegeri=driver.getWindowHandle();

        System.out.println("Sayfa Handle Degeri : "+techproSayfaHandleDegeri);
        /*
        getWindowHandle() methodu ile kendimiz isteyerek baska bir pencereye
        gecis yaptigimizda 2 tane pencere acmis olacagiz. dolayisiyla ilk actigimiz pencereye
        tekrar gecis yapmak istedigimizde ilk actigimiz pencereden sonra almis oldugumuz windowhandle degeri
        ile gecis yapabiliriz. pencereler arasi gecis konusunda bunu detayli gorecegiz. Birde bir sayfaya gittigimizde
        bir linke tıkladigimizda bizim kontrolumuz disinda yeni bir pencere acilabilir. Bu gibi durumlarda getWindoxHandles()
        methodu ile driver'in acmis oldugu pencerelerin handle degerlerini bir list'e assing ederiz ve istedigimiz
        pencereye index ile cok rahat gecis yapabiliriz
         */
        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().contains("text"));

        //sayfayi kapatin

        driver.close();//--> close methodu driverin en son actigi sayfayi kapatir.
        //driver.quit():--> bu method ise bizim actigimiz birden fazla sekme yada pencerelerin hepsini kapatmak icin kullanilir

    }
}
