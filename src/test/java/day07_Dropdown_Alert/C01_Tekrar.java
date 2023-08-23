package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C01_Tekrar extends TestBase {


    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */



    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        bekle(2);

       // 1.Method:
       // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year=driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month=driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day=driver.findElement(By.xpath("//*[@id='day']"));

        // b. Select objesi olustur
        // c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        Select selectyear=new Select(year);
        selectyear.selectByIndex(8);
        Select selectmonth=new Select(month);
        selectmonth.selectByValue("1");
        Select selectday=new Select(day);
        selectday.selectByVisibleText("20");



    }

    @Test
    public void test02() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
       // 2.Method:
       // a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletisimleri=driver.findElement(By.xpath("//select[@id='state']"));
        Select selecteyalet=new Select(eyaletisimleri);
       List<WebElement> eyaletListesi= selecteyalet.getOptions();
        eyaletListesi.forEach(t-> System.out.println(t.getText()));
        System.out.println(eyaletListesi.size());


    }

    @Test
    public void test03() {
       // 3.Method:
       // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement eyaletisimleri=driver.findElement(By.xpath("//select[@id='state']"));
        Select select=new Select(eyaletisimleri);
       WebElement actual= select.getFirstSelectedOption();
        System.out.println(actual.getText());
        String expected="Select a State";
        Assert.assertEquals(expected,actual.getText());

    }
}
