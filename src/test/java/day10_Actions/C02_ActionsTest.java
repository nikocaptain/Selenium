package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {

    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
    //Acilan sayfanin Title in "Your Account" icerdigini dogrula
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        bekle(2);
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountListsWE=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountListsWE).perform();//-->mouse locate ettigimiz webelementin üzerine götürdük
        driver.findElement(By.xpath("//*[text()='Account']")).click();


        //Acilan sayfanin Title in "Your Account" icerdigini dogrula

        Assert.assertEquals("Your Account",driver.getTitle());

    }
}
