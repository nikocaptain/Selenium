package day17_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuterScroll extends TestBase {

    //amazon sayfasina gidelim
    //Back To School Webelementine kadar scroll yapalım
    @Test
    public void test01() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Back To School Webelementine kadar scroll yapalım

        WebElement backToSchool=driver.findElement(By.xpath("//*[text()='Back to school']"));

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",backToSchool);

    }

    @Test
    public void test02() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");


        //Back To School Webelementine kadar scroll yapalım

        WebElement backToSchool=driver.findElement(By.xpath("//*[text()='Back to school']"));
        jsScroll(backToSchool);//Testbase deki method ile scroll yaptık
    }

    @Test
    public void test03() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        /*
    Yukarıdaki method js executor ile sayfanın en altına scroll yapar. Spesifik olarak bir webelemente
    scroll yapmadığımız için sayfayı scroll yaptığımız için script kodu window ile başlar scrollTo
    methodu ile x ve y kordinatı belirtmemiz gerekir. x'e 0 y'ye bir değer verirsek verdiğimiz değer
    kadar aşağıya doğru scroll yapar. Ama sayfanın en altına scroll yapmasını istersek y değeri yerine
    'document.body.scrollHeight' script kodunu kullanırız.
        */
        bekle(2);



        //Sayfanın en üstüne scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    public void test04() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım

        jsScrollEnd();
        bekle(2);

        //Sayfanın en üstüne scroll yapalım
        jsScrollHome();
    }
}
