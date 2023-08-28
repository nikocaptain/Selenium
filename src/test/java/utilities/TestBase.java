package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {

    protected ExtentReports extentReport;//-->raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    protected ExtentTest extentTest;//-->Test adımlarına bilgi eklenir

    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
       // bekle(2);
       // driver.close();
    }

    //HARD WAIT

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Select VisibleText DDM

    public void selectVisible(WebElement ddm,String option){
        Select select=new Select(ddm);
        select.selectByVisibleText(option);
    }

    //Select Index DDM

    public void selectIndex(WebElement ddm,int index){
        Select select=new Select(ddm);
        select.selectByIndex(index);
    }


    //Window Handles
    public  void window(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //Iframe Index
    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }


    //UploadFile Robot Class
    public void robotUploadFilePath(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    bir web butona tikladigimizda kisa sureli ekranda duran ve kaybolan bir webelementin locate'ni nasil aliriz.
    Web sayfasinda sag tus incele dedikten sonra, 'source'(Kaynaklar) kismina basar ve butona tikladigimizda
    sagdaki pause isaretiyle web elementlerin yuklenmesini durdurabiliriz. Bu sekilde de kaybolan yazi veya elementin
    locateni rahatlikla alabiliriz.
     */

    //ScreenShot

    public void ekranResmi(){
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu="target/ekranGoruntusu/screenShot"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //robot mac için
    /*
    //UploadFile Robot Class
public void uploadFilePath(String dosyaYolu) {
    try {
       bekle(3);
       StringSelection stringSelection = new StringSelection(dosyaYolu);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
       Robot robot = new Robot();
       robot.keyPress(KeyEvent.VK_META);
       bekle(3);
       robot.keyPress(KeyEvent.VK_V);
       bekle(3);
       robot.keyRelease(KeyEvent.VK_META);
       bekle(3);
       robot.keyRelease(KeyEvent.VK_V);
       bekle(3);
       robot.keyPress(KeyEvent.VK_ENTER);
       bekle(3);
       robot.keyRelease(KeyEvent.VK_ENTER);
       bekle(3);
    } catch (AWTException e) {
       throw new RuntimeException(e);
    }
}
     */


    //Web Element ScreenShot

    public void webElementResmi(WebElement element){
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu="target/WebElementEkranGoruntusu/WEscreenShot"+tarih+".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyayolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Extent Report
    public void rapor(String browser,String reportName){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Erol");
        extentReport.setSystemInfo("browser",browser);
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);
    }


}
