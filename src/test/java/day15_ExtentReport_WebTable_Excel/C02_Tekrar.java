package day15_ExtentReport_WebTable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Tekrar extends TestBase {
    //https://the-internet.herokuapp.com/tables sayfasına gidelim
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row' datalarını print edin  Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        WebElement tablo1=driver.findElement(By.xpath("(//table)[1]"));
        System.out.println(tablo1.getText());

        //Task 2 : 3. Row' datalarını print edin
        System.out.println("***************");

        WebElement satir3=driver.findElement(By.xpath("((//table)[1]//tbody//tr)[3]"));
        System.out.println(satir3.getText());

        //Task 3 : Son row daki dataları print edin
        System.out.println("****************");

        WebElement sonSatir=driver.findElement(By.xpath("//tbody//tr[last()]"));
        System.out.println(sonSatir.getText());



        //Task 4 : 5. Column datalarini print edin
        System.out.println("*****************");

        WebElement baslik5=driver.findElement(By.xpath("((//table)[1]//th)[5]"));
        System.out.println("baslik5 = " + baslik5.getText());//(//tbody)[1]//td[5]

        List<WebElement> besinciSutun=driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        for (WebElement w:besinciSutun) {
            System.out.println(w.getText());
        }


        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

        //(((//tbody)[1]//tr)[2]//td)[4]

        System.out.println("*******************");

        printdata(2,6);
    }

    private void printdata(int satir, int sutun) {

        WebElement satirSutun=driver.findElement(By.xpath("(((//tbody)[1]//tr)["+satir+"]//td)["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }
}
