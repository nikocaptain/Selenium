package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasına gidiniz

        driver.get("https://amazon.com");
        Thread.sleep(2000);

        //arama kutusunu locate ediniz ve iphone aratiniz

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);






    }
}
