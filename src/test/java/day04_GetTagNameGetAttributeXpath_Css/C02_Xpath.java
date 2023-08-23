package day04_GetTagNameGetAttributeXpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        Bir webelementi locate etmek istediğimizde o elementin unique olması gerekir. Xpath kullanımını
        biliyorsak istediğimiz webelementi her zaman unique alabiliriz.
        */


        // a.web sayfasına gidin. https://www.amazon.com/

        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);



        // b.Search(ara) “city bike”(arama kutusunu xpath ile alınız)

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        /*
        Xpath kullanimina  // sembolleri ile baslariz. Bu sembollerden sonra tag name belirtmemiz gerekir.
        tag name yerine * sembolunu kullanabiliriz. Bu sembol tag name farketmeksizin anlamına gelir.
        sonra koseli parantez acip kullanacagimiz attribute'den once @ sembolu kullanmaliyiz.
        sonrasinda da attribute yazilip TEK TİRNAK icinde attribute'n degeri yazilmalidir ve koseli parantez kapatilmalidir.

        SYNTAX:
            //tagname[@attribueName='atributedegeri']
            //*[@*='attributedegeri'] -->eger bu kullanimda birden fazla sonuc verirse * koydugumuz yerlere
                                         tagname ve attributename'i belirtmemiz gerekir.Buna ragmen birden
                                         fazla sonuc verirse o web elementin index'ini asagidaki sekilde
                                         belirtiriz
                                         (//tagname[@attributename='attributedegeri'])[index]
        Xpath kullanamadığımız zaman bir webelementin locate'i ile alakalı birden fazla sonuç çıkarsa bütün sonuçları
        bir list'e atıp index ile o webelemnti handle etmen gerekecekti. Dolayısıyla yukarıdaki örnekteki gibi
        xpath kullanımında birden fazla sonuç alırsak direk xpath üzerinden index ile bunu çözebiliriz.
         */







        // c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(aramaSonucu.getText());

        //Sadece sonuc sayısını yazdırınız

        String sonucSayisi[]=aramaSonucu.getText().split(" ");
        System.out.println(sonucSayisi[2]);

        // d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        driver.findElement(By.xpath("(//h2//a)[1]")).click();//--> click() methodu tıklayarak linkinacilmasini yapar
        //xpath alirken direk tag'lari kullanarak unique snuc vermezse yukaridaki gibi index ile elementi handle edebiliriz

        //sayfayi kapatiniz

        driver.close();


    }
}
