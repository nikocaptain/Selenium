package day04_GetTagNameGetAttributeXpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        Thread.sleep(10000);

        // b.Search(ara) “city bike”(arama kutusunu xpath ile alınız)

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        // c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

       WebElement goruntulenmesonuc= driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        System.out.println(goruntulenmesonuc.getText());

        //Sadece sonuc sayısını yazdırınız

        String[] sonuc=goruntulenmesonuc.getText().split(" ");
        System.out.println(sonuc[2]);

        // d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        driver.findElement(By.xpath("//h2//a")).click();

        //sayfayi kapatiniz

        driver.close();


    }
}
