package com.techproed.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    // private, default, protected, public
    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // extends miras almak yani  bir kere oluştur  her yerde kullan test kalabalığını önlemek için
// bir class a yazıp diğer class lara miras alıcaz



    //Web driver private yapsak miras olarak başka clas larda kullanamayı
    //eğer önüne hiç bir şey koymazsak default olur ve sadece içinde bulundugumuz paket te yani "utilities" pakatinde kullanabiliriz
    //protected yaparsak kendisi (kendi paketi) ve çocugu (diğer paket) yemek yiyebilir örneği yani içinde bulunduğu paket ve başka paketlerde extends edilmek suretiyle kullanılabilir
    //örnek protected WebDriver driver (bulundugu pakette)
    // diğer x paketinde public class DependsOnMethodsTest extends TestBase { gibi

    // abstract yaptık çünkü nesne üretmesini istemiyoruz. yani abstract varken nesne üretemeyiz TestBase clasında
    // eğer nesne üretmek istersek abstract ı kaldırmamız gerekir
    //kaldırırsak nese üretebiliriz TestBase testbase = new TestBase();


    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}





