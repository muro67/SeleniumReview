package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class ActionsTest extends TestBase {
    @Test
    public void sagTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        // <span class="context-menu-one btn btn-neutral">right click me</span>
        // linkText : HAYIR (çünkü link değil - "a" tagName'i yok)
        // className: HAYIR (çünkü class değerinin içerisinde BOŞLUK var)
        // tagName, xpath, cssSelector
        // By.xpath("//*[.='right click me']") -> içerdiği yazı "right click me" olan webelement
        WebElement rightClickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightClickMe).perform(); //contextClick sağa tıklamak için yazıyoruz kalıp ifade
    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        //<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick).perform(); //doubleClick çift tıklama yapmak için kullanılır kalıp değişmez
    }

    @Test
    public void hoverOver() { // mouse'u bir webelementin üzerine götürme
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        // <a href="" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin"
        // data-nav-role="signin" data-ux-jq-mouseenter="true"
        // id="nav-link-accountList" tabindex="0">

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform(); //moveToElement mouse u bir web elementin üzerine kullanmak için kullanırız kalıp ezberle
    }

    @Test
    public void asagiYukariGitme() {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        //web sayfasının en altına gitmek için
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //web sayfasında yukarı çıkmak istiyorsak
        //1. YÖNTEM -> PAGE_UP butonu
        actions.sendKeys(Keys.PAGE_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2. YÖNTEM -> ARROW_UP (yukarı yön tuşu)
        actions.sendKeys(Keys.ARROW_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // aşağı gitmek için kullanılıyor
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // alt yön tuşunu kullanarak, aşağı gidebilirsiniz
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.sendKeys(Keys.HOME).perform(); //sayfanın en üstüne çıkmak için kullanılabilir

    }

    @Test
    public void keyUpKeyDown() {
        // MERHABA nasılsınız
        // shift'e basılı tutarak merhaba               -> MERHABA
        // shift'ten elimizi kaldıracağız nasılsınız    -> nasılsınız
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.name("q"));//google daki arama kutusunu bu şekilde buluruz name"q"
        // aramaKutusu.sendKeys("merhaba nasılsınız");
        actions.moveToElement(aramaKutusu) //arama kutusuna git
                .click() //tıkla
                .keyDown(Keys.SHIFT) //şifte basılı tut (merhaba nasılsınız ıbüyük harfler yazar)
                .sendKeys("merhaba ")
                .keyUp(Keys.SHIFT) //elini butondan kaldır(küçük yazacak bu sefer)
                .sendKeys("nasılsınız")
                .perform();
    }
        }
