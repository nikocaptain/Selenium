package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        String amazonUrl="http://amazon.com";
        String techporUrl="https://techproeducation.com";
        //Amazon sayfasına gidiniz

        driver.get(amazonUrl);

        //sayfa başlıgını konsola yazdırınız
        String AmazonactualTitle= driver.getTitle();//gidilen sayfanın basligini verir
        System.out.println("Amazon sayfasi Basligi : "+AmazonactualTitle);


        //sayfanın Url'sini konsola yazdırınız
        String AmazonactualUrl= driver.getCurrentUrl();
        System.out.println("Amazon sayfasi Url'i = " + AmazonactualUrl);


        //Tecgproeducation sayfasina gidiniz
        driver.get(techporUrl);
        //sayfa başlıgını konsola yazdırınız
        String techproActualTitle= driver.getTitle();
        System.out.println("techpro sayfa basligi = " + techproActualTitle);

        //sayfanın Url'sini konsola yazdırınız
        String techproActualUrl=driver.getCurrentUrl();
        System.out.println("techpro sayfasi Url'i = " + techproActualUrl);



    }
}
