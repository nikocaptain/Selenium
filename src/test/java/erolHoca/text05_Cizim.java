package erolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class text05_Cizim extends TestBase {
      //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
      //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
      //- Çizimden sonra clear butonuna basınız
      //- Sayfayi kapatiniz


    @Test
    public void test01() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi= driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(yaziTahtasi).perform();

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-10,0);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,10);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10,0);
        }

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,-11);
        }

        actions.release().perform();
        bekle(2);


        bekle(3);
        WebElement clearWE=driver.findElement(By.xpath("(//*[@type='button'])[1]"));
        actions.moveToElement(clearWE).click().perform();

        //- Çizimden sonra clear butonuna basınız
        //- Sayfayi kapatiniz
    }
}
