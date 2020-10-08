package com.techproed.tests;

import org.testng.annotations.Test;

public class PriorityTest {

    /* eger @Beforemethod
       public void setUp(){
       }
       System.out.println("setUp");

       yaparsak her test ten sonra setUp yazar
    */

    @Test (priority = 1)
    public void amazonTest(){
        System.out.println("amazonTest");

    }

    @Test (priority = 2)
    public void googleTest() {
        System.out.println("goggleTest");

    }

    @Test (priority = 3)
    public void facebookTest() {
        System.out.println("facebookTest");

    }

    @Test (priority = 4)
    public void appleTest() {
        System.out.println("appleTest");

    }




    }
