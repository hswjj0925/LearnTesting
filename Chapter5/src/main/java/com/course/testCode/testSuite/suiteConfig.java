package com.course.testCode.testSuite;

import org.testng.annotations.*;

/**
 * Created by wangkai on 18/5/15.
 */
public class suiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite运行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest运行");

    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest运行");
    }
}
