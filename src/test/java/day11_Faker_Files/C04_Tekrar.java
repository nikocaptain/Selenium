package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_Tekrar extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
    //b10 all test cases dosyasını indirelim
    //Dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test01() {


        //"C:\Users\Niyazi\Downloads\b10 all test cases, code.docx"

        String path="C:\\Users\\Niyazi\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            System.out.println("dosya bulunamadı");
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim

        driver.findElement(By.xpath("(//a)[3]")).click();
        bekle(5);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
