package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Techpro sayfasina gidelim
        driver.navigate().to("https://techproeducation.com");

        //arama kutusunu locate edip java aratalim

        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        Thread.sleep(2000);

        //cikan seceneklerden full stack java developer secenegine tiklayalim

        List<WebElement> linkler=driver.findElements(By.linkText("Full Stack Java Developer"));
        for (WebElement w:linkler) {
            System.out.println(w.getText());
        }
        linkler.get(0).click();

        //basligin Java icerdigini test edelim

        if (driver.getTitle().contains("Java")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //saydaki linkleri lambda ile konsola yazdiralim
        List<WebElement> sayfalinkler=driver.findElements(By.tagName("a"));
        System.out.println(sayfalinkler.size());


        sayfalinkler.stream().forEach(t-> System.out.println(t.getText()));

    }
}
