package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframetest {
  // bir web sayfasının içerisine başka bir web sayfasını ekleyebildiğimiz bölüm
  //web sayfasının içerisine farklı bir web sayfası gömülmesine denir

//1 adım :sayfadaki iframe i bul
//2.adım : o iframe in içerisindeki <p> tag name ine sahip webelementi bulacağız
//3.adım :içerisine selemlar yazdıracağız
//4 adım :iframe den çıkış yapıp sayfamıza döneceğiz (defaultContent)
//5 adım :elemental selenium linkini tıklayacağız



  @Test

    public void test03(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
      driver.get("http://the-internet.herokuapp.com/iframe");

      //ilk önce iframe e geçiş yapacaz
      //1 yöntem index ile
      //driver.switchTo().frame(0);

      //2) id ya da name ile
      //driver.switchTo().frame("mce_0_ifr")

      //3) web element ile
      WebElement iframe = driver.findElement(By.tagName("iframe"));
      driver.switchTo().frame(iframe);

      WebElement yazibolumu =driver.findElement(By.tagName("p"));
      yazibolumu.clear();
      yazibolumu.sendKeys("Selamlar ıframe");


      driver.switchTo().defaultContent();

      //<a target="_blank" href="http://elementalselenium.com/">Elemental Selenium</a>

      // tagName  evet çünkü genelde <a şekilde olur, Linktext çünkü bu bir link ,partialLinkText çünkü bu bir link
      // ,xpath,cssSelector yaparak bulabiliriz

     WebElement link =driver.findElement(By.partialLinkText("Elemental Selenium"));
     link.click();



  }

}
