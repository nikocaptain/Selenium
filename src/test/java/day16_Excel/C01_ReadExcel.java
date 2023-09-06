package day16_Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {

    //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    //Kullanılan satır sayısın bulun
    //Sayfadaki satır sayısını yazdırınız
    //Ülke-Başkent şeklinde verileri yazdırın

    @Test
    public void test01() throws IOException {
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);


        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sutun1=workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();

        /*
    Cell değişkenini String ile casting yaparsak belittiğimiz satır ve sütunda boş bir veri varsa null değer
    döndürür. Ama Cell değişkeninde toString() methodu kullanırsak boş bir veri varsa nullpointerException fırlatır.
        */

        System.out.println(satir3Sutun1);//France

        Assert.assertEquals("France",satir3Sutun1);



        //Kullanılan satır sayısın bulun

        System.out.println("kullanilan satir sayisi : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());

        /*
        getPhysicalNumberOfRows() methodu içi dolu olan satirlarin sayısını verir. Index 1 den başlar
        */

        //Sayfadaki satır sayısını yazdırınız

        System.out.println("sayfadaki satir sayisi : "+workbook.getSheet("Sheet1").getLastRowNum());

        /*
        getLastRowNum() methodu sayfadaki dolu boş farketmeksizin en son kullanılan satıra kadar olan satırların sayısını verir
        */

        //Ülke-Başkent şeklinde verileri yazdırın

        /*
        getPhysicalNumberOfCells() methodu belirtilen satırdaki kullanılan hücrelerin sayısını verir
        */

        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {

                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");

            }
            System.out.println();

        }
    }

    @Test
    public void test02() throws IOException {

        //Ülke-Başkent şeklinde verileri yazdırın (MAP ile)

        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);

        Map<String ,String> ulkeBaskent=new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            String ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir=workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir);

        }
        System.out.println(ulkeBaskent);
    }
}
