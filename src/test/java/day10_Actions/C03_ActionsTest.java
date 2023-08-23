package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {

    //Techproeducation sayfasina gidelim
    //Sayfayi istedigimiz bir miktar asagiya dogru scroll yapalim
    //Sayfayi istedigimiz bir miktar yukariya dogru scroll yapalim



    @Test
    public void actions1() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Sayfayi istedigimiz bir miktar asagiya dogru scroll yapalim

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //Sayfayi istedigimiz bir miktar yukariya dogru scroll yapalim

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

        /*
        Sayfanin ortalaarindaki bir webelementi locate etmek istediginizde driver sayfayi actigi zaman webelementi
        goremedigi icin bazen sayfayi az bir asagiya dogru scroll yapmamiz gerekebilir. Bunun icin yukaridaki ornekteki gibi
        Page_DOWN ile bunu gerceklestirebiliriz.

         */

        //Locate'i alinan webelement gelmiyorsa
        // 1-locate mi yanlış 2-frame içinde mi 3-driver elementi goremiyor mu diye sorgulamaya başlarız

        /*
        Sayfanın ortalarındaki bir webelementi locate etmek istediğimizde driver sayfayı açtığı zaman
        webelementi göremediği için bazen sayfayı az bir aşağıya doğru scroll yapmamız gerekebilir. Bunun
        için yukarıdaki örnekteki gibi Page_Down ile bunu gerçekleştirebiliriz.
        Sayfadaki bir webelementi locate ettiğimiz halde nosuchelementexception alıyorsak;
        1-Locate'i tekrar kontrol ederiz buna rağmen aynı hatayı alıyorsak;
        2-Webelementin iframe içinde olup olmadığına bakarız. Yine aynı hatayı alıyorsak;
        3-Driver webelementi göremiyordur, dolayısıyla actions class'ı kullanarak scroll yapıp
        elementin görünür olmasını sağlarız.
        */
    }

    @Test
    public void actions2() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //sayfanin en altına scroll yapalim

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();//-->Sayfanın en altına scroll yapar
        bekle(2);

        //sayfanin en ustune scroll yapalim

        actions.sendKeys(Keys.HOME).perform();//-->Sayfanın en ustune scroll yapar



    }

    @Test
    public void actions3() {

        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Events yazisina kadar scroll yapalim
        WebElement eventYazisi=driver.findElement(By.xpath("(//a[.='Programs'])[2]"));
        new Actions(driver).scrollToElement(eventYazisi).perform();
        bekle(5);
    }
}
