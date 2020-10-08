package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class Ornek_HotelRoomCreation extends TestBase {

@BeforeMethod
public void beforeMethod() {

    driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin/Create");
    driver.findElement(By.id("UserName")).sendKeys("manager2"); //kullanıcı adı
    driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    WebElement idHotelDropdown = driver.findElement(By.id("IDHotel"));
    WebElement codeKutusu =driver.findElement(By.id("Code"));
    WebElement isimKutusu = driver.findElement(By.id("Name"));
    WebElement Lokasyon = driver.findElement(By.id("Location"));
    WebElement desckutusu = driver.findElement(By.xpath("(//textarea)[2]"));
    WebElement PriceKutusu = driver.findElement(By.id("Price"));
    WebElement fiyat500 = driver.findElement(By.xpath("//li[@data-id='500']"));
    WebElement roomDropdown = driver.findElement(By.id("IDGroupRoomType"));
    WebElement maxAdult = driver.findElement(By.id("MaxAdultCount"));
    WebElement maxChild = driver.findElement(By.id("MaxChildCount"));
    WebElement saveButon = driver.findElement(By.id("btnSubmit"));

    Select hotelDropdown =new Select(idHotelDropdown);
    hotelDropdown.selectByIndex(2);

    codeKutusu.sendKeys("1234");
    isimKutusu.sendKeys("COLAK");
    Lokasyon.sendKeys("Murat");
    desckutusu.sendKeys("bu oda Murat adına oluşturuldu");


    // drag and drop: yapmak için  actions class yapmamız lazım
    Actions actions =new Actions(driver);
    actions.dragAndDrop(fiyat500,PriceKutusu).perform();

    Select odaDropdown =new Select(roomDropdown);
    odaDropdown.selectByIndex(3);


    maxAdult.sendKeys("2");
    maxChild.sendKeys("5");

   saveButon.click();
   

}

}
