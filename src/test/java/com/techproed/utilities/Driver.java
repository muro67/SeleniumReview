package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver; // ->(hafızada null)

    public static WebDriver getDriver() { //projemin herhangi bir yerinde bu methodu çağırdığım zaman
        //bana driver return  edecek
        //driver i kullanmak için  önce driver nesnesi oluşturmamız lazım çünkü null olarak gözüküyor

        if(driver == null){
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;


           }



        }

           /*
            yani yukarıda dedikki ister firefox ister chrome kullanabilirim aşağıdaki gibi tek tek yazmak yerine böyle yaptık

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); //driver nesnesi oluşturduk
            // hafızada görünmesi için yoksza null gözükürdü. if yaparak dedikki her seferinde değil sadece bir kere oluştur,
            //eğer yoksa yani null ise oluştur yoksa bir kere oluştur birden fazla değil.

          //firefox
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            */




        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver() {

        if(driver !=null){ //if yaparak dedikki closeDriver nesnesini her seferinde değil sadece bir kere oluştur,
            //eğer yoksa yani null ise oluştur yoksa bir kere oluştur birden fazla değil.
        driver.quit();
        driver = null; //hafızadan temizledik
        }


        }
    }










