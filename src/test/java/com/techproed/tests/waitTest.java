package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class waitTest extends TestBase {

    @Test
    public void implicitlywaitTest() {
     //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     // implicitly wait : Sayfadaki findElement işlemi gerçekleşirken,
     //                   belirlediğimiz maksimum süreye kadar bekliyor.
     //                   Öncesinde bulursa, bekleme işlemini bırakıp devam ediyor.
     //                   Örnek : Eğer 2. saniyede aranılan webelementi bulursa,
     //                           8 saniye daha BEKLEMİYOR. Direk alt satıra geçiyor.
      //  Mesela 10 saniye ara yani bekle sonra 10 saniyeden sonra dur diyebiliyoruz yani fail veriyor

        driver.get("http://google.com");
       // WebElement hamzaYilmazLink = driver.findElement(By.id("hamza_yilmaz"));
      WebElement aramaKutusu = driver.findElement(By.name("q"));


    // implcitywait  dinamiktir yani  bulur bulmaz bulmaz açar ama bulamazsa verdiğimiz süre kadar bekler sonra fail verir
        //ama Thread.sleep statiktir yani verdiğimiz süre kadar bekler kesin bekler
        //

    }

    @Test
    public void explicitwaitTest() {

        //WebDriverwait class ından nesne üretmek zorundayız
        // implcitywait ten önemli farkı burada herhangi bir webelement için özel bir bekleme
        //işlemi gerçekleştiriyoruz yani herkesi değil şahıs olarak bekleme yapıyoruz

        //explicitwait tin en önemli farkıbir kışul belirtiyoruz
        //örnek :aradığımız webelement tıklayabiliyor mu
        //örnek: aradığımız web element in yazısı "deneme" olsun

     driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver ,30); //bu kalıp ezberre bilmemiz lazım
        //yani explicitwait i kullanmak için ilk önce bunu yapmalıyız

        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());

      //  <button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>
      WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
      removeButton.click();


       //<p id="message">It's gone!</p>

       //WebElement Message = driver.findElement(By.id("message"));

        WebDriverWait wait1 = new WebDriverWait(driver,20);
        WebElement Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());

        //ikisinde de dinamik bir bekleme var ama arasındaki fark explicitwait  teki koşulu
        // yazıyoruz yani aradığım bu elementtin tıklanabilir veya görünür olması lazım
         //bir driver oluşturuyorsak implictwait vermek zorundayız
        // çünkü yükleme vb tüm hatalardan dolayı selenium bekliyor
        //yaptığımız örnekte remove a tıklayıp it s gone u  koşulunu göerdükten sonra bitirdi
        // testi eğer 30 saniye içinde görmeseydi hata verecekti ama önce gördü ve testi geçerli kıldı
        //Thread.sleep methodu javayı bekletir ama explicitwait selenium driver ı  bekletir.

        //timeout exeption hatası alırsak 30 saniye veya girilen saniye bekleyip ve bulamamış demektir







    }






}
