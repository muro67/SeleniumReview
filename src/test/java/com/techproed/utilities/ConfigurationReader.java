package com.techproed.utilities;


import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {


    // static yapıyoruz çünkü hafızada direk yer edinsin diye static yapınca
    //program çalışır çalışmaz hafızada yer tutar ve ona direk erişim imkanı sağlarız sonra nesne oluşturmaya gerek kalmaz

    private static Properties properties;
    static{
        String dosyaYolu = "C:\\Users\\muro\\IdeaProjects\\SeleniumReviewTestNG\\configuration.properties";
        try{
            // okumak istediğiniz dosyanın, dosya yolunu göndermeniz gerekiyor.
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
        }
    }


        //statik blok static nesneleri tanımlayı içerisinde nesne oluşturmak
        //için kullanılır. static blok constructer dan bile önce çalışıyor. yani proje çalışır
      // çalışmaz önce static çalşır sonra static blok çalışır bu java nın kalıp kuralı
      //properties nesnesi kullanarak configuration.properties dosyasının içimndekileri alıcaz veya okicaz


            // okumak istediğimiz dosyanın dsya yolunu göndermemiz gerekiyor
            //biz configuration.properties dosyasını okicaz
            //okumak için dosyanın üzerine gel sağa tıkla


    public static String getProperty(String key){
     String deger = properties.getProperty(key);
     return deger;//kalıp bir class
    }
    //getirmek istediğimiz dosyadaki  sol tarafta bulununan
    //yani unique olan tüm bilgileri tırnakla beraber parantezin içine yazıyoruz o bize karşışındaki value değeri getiriyor.

}

