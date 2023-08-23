package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    @Test
    public void test01() {
        /*
    StaleElementReferenceException
    Locate ettiğimiz bir webelemente clik yapma işleminden sonra yada bir text gönderme işleminden sonra
    navigate().refresh(), back() yada  forward() methodlarını kullanırsak ve locatini aldığımız webelementi
    tekrar kullanmak istersek bu exceptionu alırız. dolayısı ile bu exception u handle etmek için
    elementin locatini refresh(), back() yada  forward() işlemlerinden sonra tekrar almamız gerekir
    birden fazla elementi bir list içine atıp loop içinde herbirine clik yapıp yine back() methodunu
    kullanırsak ilk elemente clik yapar ikinci elemnti eskimiş olarak görür ve clik işlemini yapmaz.
    dolayısı ile loop içinde yeniden list elementlerinin atamasını yapmamız gerekir
    List<WebElement> linkler =driver.findElements(By.xpath((sdfsdf));
    for(i=0, i<linler.size, i++){
    linkler.get(i).clik
    driver.navigate().back()
    linkler=driver.findElements(By.xpath("sdfsdf")); --> staleElementExc. almamak için list'i tekrar tanımladık
    }
    */
        //arama kutusunda iphone aratınız
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        bekle(2);

    //ana sayfaya dönüp
        driver.navigate().back();
        bekle(2);

    //samsung aratınız
        WebElement aramaKutusuWE = driver.findElement(By.id("twotabsearchtextbox"));
        //StaleElementReferenceException hatasını handle etmek için navigate() methodundan sonra yeniden aynı locate'i kullandık
        aramaKutusuWE.sendKeys("samsung",Keys.ENTER);


    }
}
