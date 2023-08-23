package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasına gidiniz

        driver.get("https://amazon.com");
       // driver.navigate().refresh();
       // driver.navigate().refresh();

        //arama kutusunu locate ediniz ve iphone aratiniz

       /*
       <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
       autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir=
       "auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
        */

        /*
        eger bir web elementin locate'ini birden fazla kullanacaksak bir web elemente asagidaki gibi assign ederiz.
         */
       // WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
       //aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
       //aramaKutusu.submit();



        //Eger bir locate'i tek bir kere kullanacaksak ;
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        /*
        bir sayfada herhangi bir webelementi locate etmek icin sayfa uzerinde veya locate etmek istedigimiz webelement uzerinde sag klik
        yapip insert deriz. Locate almak istedigimiz element, id attributune sahip ise id locator'i ile id attribute degerini kullarak
        yukaridaki ornekteki gibi locate edebiliriz.
        Eger bir arama kutusunu locate edip bir test gönderirsek 2 sekilde enter tusuna bastirabiliriz.
        1. si submit() methodu;
        2. si tanimlanmis bir deger kumesi olan (enum) Keys.ENTER ;
         */

    }
}
