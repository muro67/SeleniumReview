package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {


    @BeforeMethod   //her test methodundan önce çalışır
    public void beforeMethod() {
        driver.get("http://fhctrip-qa.com/admin/HotelroomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test
    public void basliklar() {  // başlıkları : //thead//th ile buluruz

    }

    @AfterMethod  //her test methodundan sonra çalışır
    public void afterMethod() {

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th")); // tüm başlıkları verecek
        for (WebElement w : basliklar) {  //başlıkları bu şeklide alıcaz kalıp formül ezberle
            System.out.println(w.getText());
        }
    }

    @Test
    public void tumSatirlar() {
        //sayfadaki tümsatırları bulur : //tbody/tr

        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w : tumSatirlar) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void sutunYazdirma() {
        // 5. sütun : //tbody/tr/td[5]
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement w : besinciSutun) { //kalıp hiç değişmiyor
            System.out.println(w.getText());
        }
    }
    @Test
    public void hucreYazdirma(){
        //tbody/tr[2]/td[5] : 2. satır 5. sütun gibi istediğimiz hücreyi yazdırma.
        WebElement hucre = driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));
        System.out.println(hucre.getText());
    }
}

