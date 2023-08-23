package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Tekrar extends TestBase {
    //Google anasayfasına gidelim
    //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions=new Actions(driver);

        actions.sendKeys(aramaKutusu, Keys.SHIFT,"selenium",Keys.SHIFT," java").perform();
        bekle(2);
        aramaKutusu.sendKeys(Keys.ENTER
        );

    }
}
