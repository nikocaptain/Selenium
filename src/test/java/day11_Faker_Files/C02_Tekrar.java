package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    //"https://facebook.com"  Adresine gidin
    //"create new account"  butonuna basin
    //"firstName" giris kutusuna bir isim yazin
    //"surname" giris kutusuna bir soyisim yazin
    //"email" giris kutusuna bir email yazin
    //"email" onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.


    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //"create new account"  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //"firstName" giris kutusuna bir isim yazin
        //"surname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        WebElement firstname= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        firstname.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,email);
        bekle(2);
        firstname.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,email,Keys.TAB,faker.internet().password(),
                Keys.TAB,Keys.TAB,"15",Keys.TAB,"Şub",Keys.TAB,"2018",Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT,Keys.ENTER);
        bekle(2);

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement maleRadio=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        Assert.assertTrue(maleRadio.isSelected());
       // WebElement femaleRadio=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
       // Assert.assertFalse(femaleRadio.isSelected());
       // WebElement ozelRadio=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
       // Assert.assertFalse(ozelRadio.isSelected());

    }
}
