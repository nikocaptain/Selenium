package day04_GetTagNameGetAttributeXpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin

       WebElement addTikla= driver.findElement(By.xpath("//*[text()='Add Element']"));
       Thread.sleep(2000);
       addTikla.click();

        //3-Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButonu=driver.findElement(By.xpath("//*[.='Delete']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //4-Delete tusuna basin
        Thread.sleep(2000);
        deleteButonu.click();
        //5“Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveElement=driver.findElement(By.xpath("//h3"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //sayfayi kapatiniz

        driver.close();
    }
}
