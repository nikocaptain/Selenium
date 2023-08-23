package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Tekrar  {

    @Test
    public void test01() {
        //"C:\Users\Niyazi\Desktop\New Microsoft Word Document.docx"
        String  dosyaYolu="C:\\Users\\Niyazi\\Desktop\\New Microsoft Word Document.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println("*******************");
    }

    @Test
    public void test02() {
        String kendianayolum=System.getProperty("user.home");
        System.out.println(kendianayolum);//C:\Users\Niyazi

        //C:\Users\Niyazi         \Desktop\New Microsoft Word Document.docx

        String ortakyol="\\Desktop\\New Microsoft Word Document.docx";

        String dosyayolu=kendianayolum+ortakyol;
        System.out.println(dosyayolu);

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }
}
