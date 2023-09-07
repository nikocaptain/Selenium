package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_Tekrar extends TestBase {

    //BlueRentalCar sayfasına gidelim
    //Login butonuna basalım
    //Excel dosyasından aldığımız herhangi bir kullanıcı adı ve password ile login olalim
    //Login olduğumuzu doğrulayalım
    @Test
    public void test01() throws IOException {
        //BlueRentalCar sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");
        //Login butonuna basalım
        driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
        bekle(2);
        //Excel dosyasından aldığımız herhangi bir kullanıcı adı ve password ile login olalim
        FileInputStream fis=new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);
        String email=workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password=workbook.getSheet("customer_info").getRow(1).getCell(1).toString();
        WebElement emailWE=driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        emailWE.sendKeys(email, Keys.TAB,password,Keys.TAB,Keys.ENTER);
        bekle(2);
        //Login olduğumuzu doğrulayalım

        WebElement javaCorlena=driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        javaCorlena.click();
        driver.findElement(By.xpath("//*[.='Profile']")).click();
        bekle(2);

        WebElement emailtext= driver.findElement(By.xpath("//em"));
        Assert.assertTrue(emailtext.isDisplayed());


    }
}
