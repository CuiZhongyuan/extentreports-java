package com.ticket.code;

import org.testng.annotations.*;
@Test
public class TestDemo2 {
    @BeforeMethod
    public void testDemo1(){
        System.out.println("before methond方法执行");
    }
    @AfterMethod
    public void testDemo2(){
        System.out.println("after methond方法执行");
    }

  @Test(groups = "set")
    public void testDemo3(){
        System.out.println("beforeDemo3 teste-groupe方法执行");
    }
    @Test(groups = "get")
    public void testDemo4(){
        System.out.println("afterDemo4 test-groupe执行");
    }

    @BeforeClass
    public void testDemo5(){
        System.out.println("beforeDemo5 class方法执行");
    }
    @AfterClass
    public void testDemo6(){
        System.out.println("afterDemo6 class执行");
    }
    @BeforeSuite
    public void testDemo7(){
        System.out.println("beforeDemo7 suite方法执行");
    }
    @AfterSuite
    public void testDemo8(){
        System.out.println("afterDemo8 suite执行");
    }
    @BeforeGroups("set")
    public void testDemo9(){
        System.out.println("beforeDemo9 groupe方法执行");
    }
    @AfterGroups("get")
    public void testDemo10(){
        System.out.println("afterDemo10 groupe执行");
    }

}
