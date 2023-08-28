package day13_Exception_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {

        /*
    Bir sayfanın ekran görüntüsünü almak istersek;
    1-Almak istediğimiz ekran görüntüsünü kaydetmek istediğimiz yolu belirleriz
    2-TakeScreenShot arayüsünden obje oluşturup bunu driver'a eşitleriz
    TakesScreenShot ts =(TakeScreenShot) driver;
    3-FileUtils class'ından copyFile() methoduna parametre olarak oluşturmuş olduğumuz ts objesi ile
    getScreenShotAs() methonu kullanarak getScreenShotAs() methoduna da parametre olarak OutPutType.FILE
    seçerek bunu yeni bir dosyaya kaydetmesi için new File() diyerek almış olduğumuz dosyanın yolunu belirtiriz.
 */

        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //Sayfanın ekran görüntüsünü alınız

        String dosyayolu="src/test/java/utilities/EkranGoruntuleri/amazonScreenShot.jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));
    }

    @Test
    public void test02() throws IOException {
        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        //sayfanin resmini aliniz

        String dosyaYolu="target/screenShot/techpro.png";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
