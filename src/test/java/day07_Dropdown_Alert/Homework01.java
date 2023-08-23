package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Homework01 extends TestBase {
    /*
    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
     */

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        bekle(2);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement index = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(index);
        select.selectByIndex(1);
        bekle(2);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        bekle(2);
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> hepsi=driver.findElements(By.xpath("//*[@id='dropdown']"));
        for (WebElement w:hepsi) {
            System.out.println(w.getText());
        }

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
       Dimension boyut= driver.manage().window().getSize();
        System.out.println(boyut);
       Set<Cookie> oge=driver.manage().getCookies();
        System.out.println(oge.size());
        if (oge.size()==4){
            System.out.println("true");
        }else {
            System.out.println("false");
        }


    }
}
