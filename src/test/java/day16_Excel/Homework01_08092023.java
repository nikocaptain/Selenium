package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Homework01_08092023 {
    @Test
    public void test01() throws IOException {
        //-1.satirdaki 2.hucreye gidelim ve yazdiralim

        FileInputStream fis=new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String satirhucre=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("1. satir 2. hücre : "+satirhucre);

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim

        String afganBaskent=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",afganBaskent);

        //-Satir sayisini bulalim

        int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satir sayisi : "+satirSayisi);

        //-Fiziki olarak kullanilan satir sayisini bulun

       int fizikiSatirSayisi= workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println("fiziki satir sayisi : "+fizikiSatirSayisi);

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String > ingilizceUlkeBaskent=new LinkedHashMap<>();

        for (int i = 0; i < fizikiSatirSayisi; i++) {
            String ulke=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ingilizceUlkeBaskent.put(ulke,baskent+"\n");

        }
        System.out.println(ingilizceUlkeBaskent);
    }






}
