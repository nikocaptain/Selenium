package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);
        //Add Element butonuna basin

        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        Thread.sleep(3000);


        //Delete butonu'nun gorunur oldugunu test edin

        WebElement deleteButton=driver.findElement(By.cssSelector("button[class='added-manually']"));
        if (deleteButton.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //Delete tusuna basin

        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin

        WebElement addRemove=driver.findElement(By.cssSelector("div[id='content']"));

       boolean result= addRemove.isDisplayed();
        System.out.println(result);

        //sayfayi kapatiniz

        driver.close();
    }
}
