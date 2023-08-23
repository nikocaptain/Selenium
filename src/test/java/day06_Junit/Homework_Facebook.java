package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework_Facebook {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
        Thread.sleep(2000);
    }

    @Test
    public void test01() throws InterruptedException {
        //yeni hesap oluturun
        WebElement login=driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        login.click();
        Thread.sleep(2000);

        //firstname giriniz
        //lastname giriniz
        //email yada numara giriniz
        //sifre giriniz

        WebElement firstName=driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("inci", Keys.TAB,"bölük",Keys.TAB,"5317890909",Keys.TAB,"Inci3458");

        //dogum tarihi giriniz

       WebElement day= driver.findElement(By.cssSelector("select[aria-label='Day']"));
       day.sendKeys("12");

        WebElement month= driver.findElement(By.cssSelector("select[aria-label='Month']"));
        month.sendKeys("Feb");

        WebElement year= driver.findElement(By.cssSelector("select[aria-label='Year']"));
        year.sendKeys("2010");

        //cinsiyet giriniz

        WebElement gender=driver.findElement(By.cssSelector("input[value='1']"));
        if(!gender.isSelected()){
            gender.click();
        }

        //kaydola basınız

        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        Thread.sleep(5000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
