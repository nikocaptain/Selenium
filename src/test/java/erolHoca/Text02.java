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
    public void test01() throws InterruptedException {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> listAramaKutusu = select.getOptions();
        int counter = 0;
        for (WebElement w : listAramaKutusu) {
            System.out.println((counter + 1) + ". ddm : " + w.getText());
            counter++;
        }


        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil)
        // seçip başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        int sayac = 1;
        for (WebElement w : select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            sayac++;
            if (sayac >= 6) {
                break;
            }

        }


    }

}