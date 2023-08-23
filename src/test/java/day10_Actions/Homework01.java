package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework01 extends TestBase {

    @Test
    public void actions1() {
        //homework
        //Drag webelementinin drop webelementinin üzerine bırakıldıgını test edin

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        frameIndex(0);//testbase den geldi;
        bekle(2);

        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        bekle(2);
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions =new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

        //Drag webelementinin drop webelementinin üzerine bırakıldıgını test edin
        WebElement dropped=driver.findElement(By.xpath("//*[.='Dropped!']"));
        Assert.assertTrue(dropped.isDisplayed());
    }
}
