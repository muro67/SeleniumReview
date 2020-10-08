package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class DependsOnMethodsTest extends TestBase {

    @Test
    public void test01(){ //sisteme giriş testi
        System.out.println("test01");
    }

    @Test (dependsOnMethods = "test01") // bu method eğer üsteki 01 testini çalıştırmak istersem
    // ama buraya "dependsonmethod" yazarak testi test 1 de run etmeden
    // test 2 de run ederek aynı anda çalıştırmayı sağlar yani hem test1 i hemde 2 yi aynı anda çalıştırır

    public void test02() { //girdikten sonraki diğer testler
        System.out.println("test02");

    }


}
