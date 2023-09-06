package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class C01_Tekrar {
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

        String franceSatirSutun=workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(franceSatirSutun);
        Assert.assertEquals("France",franceSatirSutun);

        //Kullanılan satır sayısın bulun

        int kullanilanSatirSayisi=workbook.getSheet("Sheet1").getPhysicalNumberOfRows();

        System.out.println("kullanilan satir sayisi : "+kullanilanSatirSayisi);

        //Sayfadaki satır sayısını yazdırınız

        int satirSayisi=workbook.getSheet("Sheet1").getLastRowNum();

        System.out.println("sayfadaki satir sayisi : "+satirSayisi);

        //Ülke-Başkent şeklinde verileri yazdırın

        for (int i = 0; i < kullanilanSatirSayisi; i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {

                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");

            }
            System.out.println();


        }
    }

    @Test
    public void test02() throws IOException {
        //map kullanarak çözüm
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);
        //Ülke-Başkent şeklinde verileri yazdırın

        Map<String,String> ulkeBaskent=new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            String ulke= workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String baskent=workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,"\t"+baskent+"\n");
        }

        System.out.println(ulkeBaskent);

    }
}
