package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class OrnekCalisma {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. https://www.amazon.com/ sayfasina gidelim
        // 2. arama kutusunu locate edelim
        // 3. “Samsung headphones” ile arama yapalim
        // 4. Bulunan sonuc sayisini yazdiralim
        // 5. Ilk urunu tiklayalim
        // 6. Sayfadaki tum basliklari yazdiralim


        // 1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);

        // 2. arama kutusunu locate edelim

        WebElement samsung = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        // 3. “Samsung headphones” ile arama yapalim
        samsung.sendKeys("Samsung headphones", Keys.ENTER);
        Thread.sleep(2000);


        // 4. Bulunan sonuc sayisini yazdiralim

        WebElement sonucSayisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisi.getText());


        // 5. Ilk urunu tiklayalim

        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // 6. Sayfadaki tum basliklari yazdiralim

        List<WebElement> tumBasliklar=driver.findElements(By.xpath("//h1"));
        for (WebElement w:tumBasliklar) {
            System.out.println(w.getText());

        }




    }
}
