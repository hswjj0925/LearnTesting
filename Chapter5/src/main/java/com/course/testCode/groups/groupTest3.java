package com.course.testCode.groups;

import org.testng.annotations.Test;

/**
 * Created by wangkai on 18/5/15.
 */

@Test(groups = "group2")
public class groupTest3 {
    public void testGroup1(){
        System.out.println("groupTest3的group1测试");

    }

    public void testGroup2(){
        System.out.println("groupTest3的group2测试");

    }
}
