package day15_ExtentReport_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel {

    @Test
    public void test01() throws IOException {
        /*
        Eger projemizde excel dosyasindan veri almak istiyorsak oncelikle mvnrepository.com
        adresinden arama cubuguna "poi" yazarak 'apache poi' ve 'poi_ooxml' dependencylerini pom.xml dosyamiza kopyalamamiz gerekir
        Her iki dependency'nin versiyonlari ayni olmali
         */
        //1- Projemize resources package'ı altına koyduğumuz excel dosyamızın yolunu alırız

        String dosyaYolu="src/test/java/resources/Capitals.xlsx";

        //2- Dosyayı okuyabilmemiz için javada akışa almamız gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3- Java ortamında bir excel dosyası oluşturabilmek için
        Workbook workbook = WorkbookFactory.create(fis);

        //4_olusturdugumuz excel dosyasında sayfa secmemiz gerekir
        Sheet sheet=workbook.getSheet("Sheet1");

        //5- Belirttiğimiz sayfadaki satır bilgisini secmemiz gerekir
        Row row=sheet.getRow(0);//index '0' dan baslar


        //5- Belirttiğimiz sayfadaki hucre bilgisini secmemiz gerekir

        Cell cell=row.getCell(0);

        //Sout içinde cell bilgisini yazdırdıgımızda 1. satir 1. hucredeki bilgiyi verir.

        System.out.println(cell);

        /*
        NOT: Excel dosyanız açıkken işlem yapmayınız
        Excel dosyasında herhangi bir hücrede değişiklik yaptıysanız excel'i kapatırken kaydetmeyiniz
        */

    }

    @Test
    public void Test02() throws IOException {
        //Pratik çözüm
        //1. satir 1. sutundaki veriyi yazdiriniz.

        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");

        Workbook workbook=WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));//COUNTRY

    }
}
