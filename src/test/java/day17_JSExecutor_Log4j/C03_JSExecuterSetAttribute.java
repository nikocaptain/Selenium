package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuterSetAttribute extends TestBase {

    //amazon sayfasına gidelim
    //arama kutusuna java yazdıralım
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //arama kutusuna java yazdıralım

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='java'",aramakutusu);
    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //arama kutusuna java yazdıralım

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','niyazi')",aramakutusu);

        driver.findElement(By.id("niyazi")).sendKeys("java");
    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //arama kutusuna iphone yazdıralım

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        jsSendkeys(aramakutusu,"iphone");
    }
}
