package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_Tekrar extends TestBase {

    //  https://the-internet.herokuapp.com/windows adresine gidin.
    //  ilk sayfasının Handle degerini alın yazdırın
    //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
    //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
    //  "Click Here" butonuna tıklayın.
    //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
    //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
    //  ikinci sayfaya tekrar geçin.
    //  ilk sayfaya tekrar dönün.

    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle=driver.getWindowHandle();
        System.out.println(ilkSayfaHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.

        WebElement openilkSayfa=driver.findElement(By.xpath("//h3"));

        Assert.assertEquals("Opening a new window",openilkSayfa.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere=driver.findElement(By.xpath("(//a)[2]"));
        clickHere.click();

        Set<String> pencereler=driver.getWindowHandles();//driveri açılan yeni pencereye gonderdik
        for (String w:pencereler) {
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
            }
        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.

        Assert.assertEquals("New Window",driver.getTitle());
        String ikincisayfaHandle=driver.getWindowHandle();

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        Assert.assertEquals("The Internet",driver.getTitle());
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikincisayfaHandle);
        //  ilk sayfaya tekrar dönün.

        driver.switchTo().window(ilkSayfaHandle);
    }
}
