package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Homework02 extends TestBase {
    /*
    1.http://zero.webappsecurity.com/ Adresine gidin
2.Sign in butonuna basin
3.Login kutusuna “username” yazin
4.Password kutusuna “password.” yazin
5.Sign in tusuna basin(not: navigate.Back yapınız)
6.Pay Bills sayfasina gidin
7.“Purchase Foreign Currency” tusuna basin
8.“Currency” drop down menusunden Eurozone’u secin
9.“amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */


    @Test
    public void test01() {
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2.Sign in butonuna basin
        driver.findElement(By.cssSelector("[class='icon-signin']")).click();
        bekle(1);

        //3.Login kutusuna “username” yazin
        //4.Password kutusuna “password.” yazin
        WebElement login=driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.navigate().back();


        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();
        bekle(2);
        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        bekle(2);
        //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement currency= driver.findElement(By.cssSelector("select[id='pc_currency']"));
        Select select=new Select(currency);
        select.selectByValue("EUR");
        bekle(2);
        //9.“amount” kutusuna bir sayi girin
        WebElement amount= driver.findElement(By.cssSelector("input[id='pc_amount']"));
        amount.sendKeys("1000");
        //10.“US Dollars” in secilmedigini test edin
        WebElement usdollar=driver.findElement(By.xpath("//*[@id='pc_inDollars_true']"));
        Assert.assertFalse(usdollar.isSelected());

        //11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();
        bekle(2);
        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();
        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expected="Foreign currency cash was successfully purchased.";
        WebElement actual=driver.findElement(By.cssSelector("[id='alert_content']"));
        Assert.assertEquals(expected,actual.getText());

    }
}
