package com.course.testCode.groups;

import org.testng.annotations.Test;

/**
 * Created by wangkai on 18/5/15.
 */
@Test(groups = "group1")
public class groupTest2 {
    public void testGroup1(){
        System.out.println("groupTest2的group1测试");

    }

    public void testGroup2(){
        System.out.println("groupTest2的group2测试");

    }
}
