package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar02 extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=iframe
    //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
    //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
    //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String actualtext=driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualtext.contains("black border"));
        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
       WebElement actualApp= driver.findElement(By.xpath("//h1"));
       Assert.assertEquals("Applications lists",actualApp.getText());
        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().parentFrame();
        WebElement actualiframe= driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("iframe",actualiframe.getText());
    }
}
