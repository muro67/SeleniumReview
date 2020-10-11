package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest  extends TestBase { //miras aldık comme dab


    // her test methodundan önce çalışır.
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test() {
   //diğer clastaki testlere ulaşabilmek için nesne oluşturmamız gerekiyor
   // ve parametre olarak şu anda kullandıüğımız
   // driver ı verirsek artık bu clasın içindeki tüm web elementleri kullanabiliriz


  // Tüm webelementlere veri göndermeniz göndermeniz gerekiyor.
// Save butonuna tıklamnız gerekiyor.
// Assert işlemi ile "Hotel was inserted successfully" yazısını doğrulayın

        FhcTripHotelCreatePage createPage = new FhcTripHotelCreatePage(driver); //nesne oluşturduk
        createPage.kodKutusu.sendKeys("1234");
        createPage.namekutusu.sendKeys("Murat");
        createPage.adres.sendKeys("lazsokak no:11");
        createPage.Tel.sendKeys("3184465");
        createPage.Mail.sendKeys("abc@gmail.com");
        Select select = new Select(createPage.idButon);
        select.selectByIndex(2);

        createPage.saveButon.click();
        WebDriverWait wait = new WebDriverWait(driver ,20);
        // 1yol  böyle yapabiliriz WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        boolean esitMi = wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"Hotel was inserted successfully"));
        //veya böyle de yapabiliriz üstteki gibi 2yol
        Assert.assertTrue(esitMi);

       // System.out.println(createPage.succes.getText());

        // örnek ConfigurationReader.getProperty("fhc_username") // manager2 yi verecek


    }

}
