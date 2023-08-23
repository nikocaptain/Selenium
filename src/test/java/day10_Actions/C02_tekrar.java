package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_tekrar extends TestBase {
    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
    //Acilan sayfanin Title in "Your Account" icerdigini dogrula

    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla

        WebElement accountList=driver.findElement(By.cssSelector("[id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        WebElement account=driver.findElement(By.xpath("//*[text()='Account']"));
        actions.click(account).perform();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertEquals("Your Account",driver.getTitle());
    }
}
