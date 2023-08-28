package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Tekrar extends TestBase {



    @Test
    public void test01() throws IOException {
        //kitapyurdu sayfasına gidelim

        driver.get("https://kitapyurdu.com");

        //sayfanin resmini alalım

        String tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyayolu="target/ekranGoruntuleri/ekranresmi"+tarih+".jpeg";

        TakesScreenshot ts= (TakesScreenshot) driver;

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));





    }

    @Test
    public void test02() {
        //Youtube sayfasına gidelim

        driver.get("https://youtube.com");

        //ekran resmini alalım

        ekranResmi();
    }
}
