package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.DurationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);

        //2.Signin buttonuna tiklayin

        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(2000);

        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin

        WebElement login=driver.findElement(By.cssSelector("input[type='text']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();//-->sayfaya giris yapabilmek icin back kullandik
        Thread.sleep(2000);

        //6.online banking altındaki Pay Bills sayfasina gidin

        driver.findElement(By.xpath("(//a)[11]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();
        Thread.sleep(2000);

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina “2020-09-10” yazdirin
        //9.Pay buttonuna tiklayin

        WebElement amount=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        amount.sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin

        WebElement actual=driver.findElement(By.cssSelector("div[id='alert_content']"));
        String actualElement=actual.getText();

        String expectedElement="The payment was successfully submitted.";

        if (actualElement.equals(expectedElement)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //sayfayi kapatiniz
        driver.close();

    }
}
