package com.techproed.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    WebDriver driver;
    @BeforeClass

    public void setUp() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
}
  // beforeclass setup metdhodu sadece 1 kere her class tan önceçalışır

@Test
        public void test01(){

    driver.get("http://https://the-internet.herokuapp.com/javascript_alerts");


    driver.switchTo().alert().getText(); // -> alertin içerisindeki mesajı alır
    System.out.println("mesaj");


    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


    driver.switchTo().alert().sendKeys("Selamlar");//-> alertin içerisinde yazı gönderir

    driver.switchTo().alert().accept(); //->TAMAM butonuna tıklar (kabul et)

    driver.switchTo().alert().dismiss();//->VAZGEC butonuna tıklar (reddet)

   // <button onclick="jsPrompt()">Click for JS Prompt</button>
    //kaç farklı locator ile bulabiliriz


}

}
