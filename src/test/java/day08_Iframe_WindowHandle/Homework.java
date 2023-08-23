package day08_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Homework extends TestBase {
    // 1-https://html.com/tags/iframe/ sayfaya gidiniz.
    // 2- Youtube videosunda play butonuna basınız


    @Test
    public void test01() {
        // 1-https://html.com/tags/iframe/ sayfaya gidiniz.
        driver.get("https://html.com/tags/iframe/");

        // 2- Youtube videosunda play butonuna basınız
        //*[@src='https://www.youtube.com/embed/owsfdh4gxyc']

        driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']")).click();

       WebElement yazdir= driver.findElement(By.xpath("//*[@class='toc_title']"));
        System.out.println(yazdir.getText());
    }
}
