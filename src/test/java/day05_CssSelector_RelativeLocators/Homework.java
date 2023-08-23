package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Homework {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        ÖDEV:
        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        Add Element butonuna basin 100 kez basınız
        Delete butonuna 90 kez basınız
        Ve 90 kez basıldığını doğrulayınız
         */

       // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

       // Add Element butonuna basin 100 kez basınız

        for (int i = 0; i < 100; i++) {
            WebElement addTikla= driver.findElement(By.xpath("//*[text()='Add Element']"));
            addTikla.click();
        }
        List<WebElement> deleteSayisi=driver.findElements(By.cssSelector("button[class='added-manually']"));
        System.out.println(deleteSayisi.size());
        Thread.sleep(2000);

        //Delete butonuna 90 kez basınız
        for (int i = 0; i < 90; i++) {
            WebElement deleteClick=driver.findElement(By.cssSelector("button[class='added-manually']"));
            deleteClick.click();
        }

        List<WebElement> deleteSayisiSonra=driver.findElements(By.cssSelector("button[class='added-manually']"));
        System.out.println(deleteSayisiSonra.size());


        // Ve 90 kez basıldığını doğrulayınız

        if (deleteSayisi.size()-deleteSayisiSonra.size()==90){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }





    }
}
