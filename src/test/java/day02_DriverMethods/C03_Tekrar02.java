package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Tekrar02 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //Youtube ana sayfasina gidelim . https://www.youtube.com/
       driver.get("https://www.youtube.com/");

        //Amazon soyfasina gidelim. https://www.amazon.com/

        driver.navigate().to("https://www.amazon.com/");

        //Tekrar YouTube'sayfasina donelim

        driver.navigate().back();

        //Yeniden Amazon sayfasina gidelim

        driver.navigate().forward();

        //Sayfayi Refresh(yenile) yapalim

        driver.navigate().refresh();

        //sayfayi kapatalim

        driver.close();
    }
}
