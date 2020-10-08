package com.techproed.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



// artık arayacağımız web elementler bu class ların içerisinde olacak diğer claslara girip tek tek
 // düzeltmek yerine tek bir clas ta biriktiricez hepsini böylelikle hem zamandan hemde
 //kod kalitesinden kazançlı olucaz

public class FhcTripHotelCreatePage {
    WebDriver driver;
  public FhcTripHotelCreatePage(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver,this);
  // ******* bu constructer yani kalıp  yukarıdaki tüm işlemleri her zaman oluşturuyoruz bu şekilde ezberle
  }




  @FindBy (id = "Code")
   public WebElement kodKutusu;

   @FindBy (id = "Name")
    public WebElement namekutusu;

   @FindBy (id ="Address")
    public WebElement adres;

   @FindBy (id = "Phone")
    public WebElement Tel;

   @FindBy (id ="Email")
     public WebElement Mail;

   @FindBy (id = "IDGroup")
   public WebElement idButon;

   @FindBy (id = "btnSubmit")
    public WebElement saveButon;

   @FindBy(className = "bootbox-body")
    public WebElement succes;

   //bu web elementleri bir kere bulduk artık diğer tüm sayfalarda kullanabiliriz
    //tekrar tekrar bulmaya gerek yok diğer sayfalarda


}

