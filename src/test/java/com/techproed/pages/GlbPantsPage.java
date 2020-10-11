package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbPantsPage {
    //contracter oluşturmak zorundayız unutma
    // çünkü page factory yi kullanmak zorundayız yani bu :PageFactory.initElements();
    //eğer kullanmazsak web elementini yani findby... bulamayız
    public GlbPantsPage() {
        PageFactory.initElements(Driver.getDriver() , this);
  //artık @Findby ile arama yapabiliriz
        

    }

   @FindBy ( xpath = "//p[@class='cat_bg_top']")
    public List<WebElement> basliklar;
   //tüm başlıkları xpath kullanarak aldık


}
