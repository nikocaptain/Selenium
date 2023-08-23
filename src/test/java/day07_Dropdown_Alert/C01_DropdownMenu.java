package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {
    /*
Dropdown menu: Altbasliklarin Listelendigi webelemente denir.
Bu webelementteki alt basliklara ulasabilmek bu altbasliklari handle edebilmek icin oncelikle
web elementin locate’ini aliriz.Sonra select class’indan bir obje olusturup parametre olarak locate’ini aldigimiz webelementi
yazariz. Ve bu obje ile selectByIndex(),selectByValue() ve selectByVisibleTest() methodlarini kullanarak
alt basliklari secebiliriz. getOptions() methodu bize bu alt basliklarin hepsini verir.
Cogu zaman bu dropdown webelementine sendkeys() methodu ile alt basliklardaki herhangi bir secenegi gonderebiliriz
Dropdown menudeki ilk seçili olan seceneği getFirstSelectedOption() methodu ile alabiliriz.,
:

 */


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
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {


        //a. Yil,ay,gün dropdown menu'leri locate ediniz

        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //b. Select objesi olustur

        Select selectyil = new Select(yil);
        Select selectay = new Select(ay);
        Select selectgun = new Select(gun);

        //c. Select object i kullanarak 3 farkli sekilde secim yapiniz

        selectyil.selectByIndex(5);
        selectay.selectByValue("4");
        selectgun.selectByVisibleText("15");


    }

    @Test
    public void test02() {

        //a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(eyaletler);
        List<WebElement> eyaletlerListesi = select.getOptions();
        //eyaletlerListesi.forEach(t-> System.out.println(t.getText()));
        for (WebElement w : eyaletlerListesi) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void test03() {
        // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(eyaletler);
        String seciliOlanOption = select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanOption);
        String expectedOption = "Select a State";
        Assert.assertEquals(expectedOption, seciliOlanOption);

    }

    @Test
    public void denemelist() {

        List<WebElement> eyaletlerListesi = driver.findElements(By.xpath("//select[@id='state']//option"));
        eyaletlerListesi.forEach(t -> System.out.println(t.getText()));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
