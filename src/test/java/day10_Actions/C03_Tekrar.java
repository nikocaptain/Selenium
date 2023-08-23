package day10_Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C03_Tekrar {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Techproeducation sayfasina gidelim
    //Sayfayi istedigimiz bir miktar asagiya dogru scroll yapalim
    //Sayfayi istedigimiz bir miktar ukariya dogru scroll yapalim

    @Test
    public void name() throws InterruptedException {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Sayfayi istedigimiz bir miktar asagiya dogru scroll yapalim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        //Sayfayi istedigimiz bir miktar ukariya dogru scroll yapalim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }
}
