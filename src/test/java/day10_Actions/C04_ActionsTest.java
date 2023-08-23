package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {

    //https://jqueryui.com/droppable/ adresine gidelim
   //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    @Test
    public void actions1() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        iframe ciktigi icin driver'i iframe'e gecirmem gerekir.
         */

        //driver.switchTo().frame(0);
        frameIndex(0);//testbase den geldi;
        bekle(2);

        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        bekle(2);
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions =new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();//-->drag elementini alip drop elementinin üzerine birakir
        WebElement dropped=driver.findElement(By.xpath("//*[.='Dropped!']"));
        Assert.assertTrue(dropped.isDisplayed());
    }

    @Test
    public void actions2() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        //driver.switchTo().frame(0);
        frameIndex(0);//testbase den geldi;
        bekle(2);

        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions =new Actions(driver);
        actions.clickAndHold(drag).//drag webelementini tut ve bekle
                moveToElement(drop).//drag webelementini tutup drop webelementinin uzerine goturur
                release().//basılı tuttugun webelementi serbest bırak
                perform();//action'i isleme aldik

    }

    @Test
    public void actions3() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        //driver.switchTo().frame(0);
        frameIndex(0);//testbase den geldi;
        bekle(2);

        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions =new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(145,25).release().perform();

        //homework
        //Drag webelementinin drop webelementinin üzerine bırakıldıgını test edin
    }
}
