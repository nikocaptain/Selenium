package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrnekCalisma02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //1.“https://www.saucedemo.com” Adresine gidin
       //2. Username kutusuna “standard_user” yazdirin
       //3. Password kutusuna “secret_sauce” yazdirin
       //4. Login tusuna basin
       //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       //6. Add to Cart butonuna basin
       //7. Alisveris sepetine tiklayin
       //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin.
       //9. Sayfayi kapatin

        //1.“https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin

        WebElement userName =driver.findElement(By.xpath("//*[@data-test='username']"));
        userName.sendKeys("standard_user", Keys.TAB,"secret_sauce");
        Thread.sleep(3000);
        userName.sendKeys(Keys.ENTER);

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement ilkUrun=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        Thread.sleep(2000);
        System.out.println(ilkUrun.getText());
        ilkUrun.click();
        Thread.sleep(2000);

        //6. Add to Cart butonuna basin

        driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000);

        //7. Alisveris sepetine tiklayin

        driver.findElement(By.xpath("(//a)[5]")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin.

        WebElement sepetteGorunuyorMu=driver.findElement(By.id("item_4_title_link"));
       if (sepetteGorunuyorMu.isEnabled()){
           System.out.println("sepette var test passed");
       }else {
           System.out.println("test failed");
       }

        //9. Sayfayi kapatin
        driver.close();


    }
}
