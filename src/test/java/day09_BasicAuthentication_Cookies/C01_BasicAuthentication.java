package day09_BasicAuthentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {
    //Aşağıdaki bilgileri kullanarak authentication yapınız:

    //Url: https://the-internet.herokuapp.com/basic_auth
    //Username: admin
    //Password: admin

    //Başarılı girişi doğrulayın.Congratulations! You must have the proper credentials. yazısının ciktigini dogrulayin
    //Elemental Selenium linkine tıklayınız
    //basligin Elemental Selenium icerdigini kontrol ediniz
    @Test
    public void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:

        //    Url: https://the-internet.herokuapp.com/basic_auth

        //    Username: admin
        //    Password: admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //    Başarılı girişi doğrulayın.Congratulations! You must have the proper credentials. yazısının ciktigini dogrulayin

        String actualtext=driver.findElement(By.xpath("//p")).getText();

        String expected="Congratulations! You must have the proper credentials.";

        Assert.assertEquals(expected,actualtext);

        ///Elemental Selenium linkine tıklayınız

        driver.findElement(By.xpath("(//a)[2]")).click();

        //basligin Elemental Selenium icerdigini kontrol ediniz

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //window(1);

        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));



    }
}
