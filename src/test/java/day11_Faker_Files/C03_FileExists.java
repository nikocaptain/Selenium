package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;

import javax.sql.rowset.serial.SerialStruct;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExists {
    @Test
    public void test01() {
            /*
Bilgisayarımızdaki herhangi bir dosyanın varlığını test edebilmemiz için;
    1-Öncelikle varlığını test etmek istediğimiz dosyanın yolunu alırız.
    Dosyanın yolunu alabilmek dosya üzerine sağ klik yapıp YOL OLARAK KOPYALA seceneği ile
    dosyanın yolunu kopyalar dosyaYolu isminde String bir değişkene assing ederiz.
    (Windows'un alt sürümlerinden birini kullanıyorsanız pratik olarak dosya yolu almak için
    shift tuşuna basılı tutarak sağ klik yaparsanız YOL OLARAK KOPYALA seçeneği çıkmış olur ve o
    klik yaparak aynı yukarıda anlatıldığı gibi dosya yolunu alabilirsiniz.)
    2-Aldığımız dosya yolunu Files.exists(Paths.get(DOSYAYOLU)) kodu ile dosyanın varlığını test
    edebiliriz.
 */
        //Bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayalım
        //"C:\Users\Niyazi\Desktop\New Microsoft Word Document.docx"
        String dosyaYolu="C:\\Users\\Niyazi\\Desktop\\New Microsoft Word Document.docx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));//eger dosya varsa true yoksa false yazdırır.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println("******************");
    }

    @Test
    public void test02() {
        //Bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayalım
        String kendiAnaYolum=System.getProperty("user.home");
        System.out.println(kendiAnaYolum);
        //"C:\Users\Niyazi      \Desktop\New Microsoft Word Document.docx"

        String ortakYol="/Desktop/New Microsoft Word Document.docx";

        String dosyaYolu=kendiAnaYolum+ortakYol;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
