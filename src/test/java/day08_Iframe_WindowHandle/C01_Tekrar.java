package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=iframe
    //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
    //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
    //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz


    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=iframe sayfasina gidiniz

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim

        WebElement anaSayfa=driver.findElement(By.xpath("(//p)[1]"));
        Assert.assertTrue(anaSayfa.getText().contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        WebElement application=driver.findElement(By.xpath("//h1"));
        Assert.assertEquals("Applications lists",application.getText());
        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().defaultContent();
        Assert.assertEquals("iframe",driver.getTitle());

        //driver.switchTo().frame(3);
        //WebElement about=driver.findElement(By.xpath("(//h4)[4]"));
        //System.out.println(about.getText());
    }
}
