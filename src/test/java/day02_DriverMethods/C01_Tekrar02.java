package day02_DriverMethods;

import org.junit.Test;
import utilities.TestBase;

public class C01_Tekrar02 extends TestBase {
    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //sayfa başlıgını konsola yazdırınız

        System.out.println(driver.getTitle());

        //sayfanın Url'sini konsola yazdırınız

        System.out.println(driver.getCurrentUrl());

        //Tecgproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //sayfa başlıgını konsola yazdırınız
        System.out.println(driver.getTitle());

        //sayfanın Url'sini konsola yazdırınız

        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
