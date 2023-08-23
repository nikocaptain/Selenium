package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_Tekrar extends TestBase {

    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "TechPro Education" olduğunu doğrulayın
    //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
    //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:

    @Test
    public void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz

        driver.get("https://www.techproeducation.com");
        String techprohandle= driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın

        Assert.assertEquals("TechPro Education",driver.getTitle());


        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubehandle= driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedhandle= driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:

        driver.switchTo().window(techprohandle);
        bekle(2);

        //youtube sayfasına geçiniz:

        driver.switchTo().window(youtubehandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:

        driver.switchTo().window(linkedhandle);

        driver.quit();

    }
}
