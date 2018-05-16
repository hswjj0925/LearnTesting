package com.course.testCode.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by wangkai on 18/5/16.
 */
public class testParam {
    @Test
    @Parameters({"name","age"})
    public void test1(String name , int age)
    {
        System.out.println("aaaa");
    }
}
