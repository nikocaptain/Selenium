package erolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Text02 extends TestBase {
   //-Amazon sayfasına gidelim
   //-Arama Kutusundaki Dropdown menuyu yazdıralım
   //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil)
   // seçip başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım


    @Test
    public void test01() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        List<WebElement> listAramaKutusu=select.getOptions();
        int counter=0;
        for (WebElement w:listAramaKutusu) {
            System.out.println((counter+1)+". ddm : "+w.getText());
            counter++;
        }


        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil)
        // seçip başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        for (int i = 1; i < 6; i++) {
            ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
            select.selectByVisibleText(listAramaKutusu.get(i).getText());
            ddm.submit();
            bekle(1);
            driver.navigate().refresh();
        }




        }






    }

