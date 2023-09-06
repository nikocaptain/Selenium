package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {
//BlueRentalCar sayfasına gidelim
//Login butonuna basalım
//Excel dosyasından aldığımız herhangi bir kullanıcı adı ve password ile login olalim
//Login olduğumuzu doğrulayalım


    @Test
    public void test01() throws IOException {

        //BlueRentalCar sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");
        bekle(2);
        //Login butonuna basalım
        driver.findElement(By.xpath("(//a)[1]")).click();
        bekle(2);

        //Excel dosyasından aldığımız herhangi bir kullanıcı adı ve password ile login olalim

        FileInputStream fis=new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);

       String userEmail= workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
       String password=workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement emailWE=driver.findElement(By.cssSelector("#formBasicEmail"));
        emailWE.sendKeys(userEmail, Keys.TAB,password,Keys.ENTER);



        //Login olduğumuzu doğrulayalım

        driver.findElement(By.cssSelector("#dropdown-basic-button")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[.='Profile']")).click();

        String emailText=driver.findElement(By.xpath("//em")).getText();

        Assert.assertEquals(userEmail,emailText);

    }
}
