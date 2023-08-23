package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {

    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil= driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month= driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day= driver.findElement(By.xpath("//*[@id='day']"));

        selectIndex(yil,5);

    }
}
