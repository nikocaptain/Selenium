package day17_JSExecutor_Log4j;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutorLocate extends TestBase {

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidelim

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini locate edelim
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement helloShadowWE= (WebElement) js.executeScript("return document.getElementById('content');");
        System.out.println(helloShadowWE.getText());
        Assert.assertEquals("Hello Shadow DOM",helloShadowWE.getText());

    }

    @Test
    public void test02() {
        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidelim

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini ve shadow DOM elementinin renklerini degistirelim
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement helloShadowWE= (WebElement) js.executeScript("return document.getElementById('content');");
        WebElement shadowDOMWE=driver.findElement(By.xpath("(//h1)[2]"));
        js.executeScript("arguments[0].style.color='red';arguments[1].style.color='blue';",shadowDOMWE,helloShadowWE);
    }

    @Test
    public void test03() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        bekle(8);

        //aramakutusunun attribute degerlerini yazdiralim
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String typeAttributeDegeri=js.executeScript("return document.getElementById('twotabsearchtextbox').type").toString();
        String nameAttributeDegeri=js.executeScript("return document.getElementById('twotabsearchtextbox').name").toString();
        String classAttributeDegeri=js.executeScript("return document.getElementById('twotabsearchtextbox').className").toString();
        System.out.println("typeAttributeDegeri = " + typeAttributeDegeri);
        System.out.println("nameAttributeDegeri = " + nameAttributeDegeri);
        System.out.println("classAttributeDegeri = " + classAttributeDegeri);

    }


}
