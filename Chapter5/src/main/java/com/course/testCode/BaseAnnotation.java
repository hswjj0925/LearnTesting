package com.course.testCode;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.*;

/**
 * Created by wangkai on 18/5/15.
 */
public class BaseAnnotation {

   @Test
   public void testCase2(){
        System.out.println("第二个测试用例");

    }

    @Test
    public void testCase1(){
        System.out.println("第一个测试用例");

    }

    @BeforeMethod
    public void beforeTest()
    {
        System.out.println("测试方法之前运行");
    }

    @AfterMethod
    public void afterTest(){
        System.out.println("测试方法之后运行");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("类执行之前运行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("类执行之后运行");
    }

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("测试套件执行之前运行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("测试套件执行之后运行");
    }


}
