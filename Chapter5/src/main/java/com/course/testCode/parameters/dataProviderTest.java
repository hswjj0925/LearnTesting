package com.course.testCode.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by wangkai on 18/5/16.
 */
public class dataProviderTest {

    @Test(dataProvider = "data")
    public void ppTest(String name,int age)
    {
        System.out.println("name = [" + name + "], age = [" + age + "]");
    }

    @DataProvider(name = "data")
    public Object[][] provider(){
        Object[][] o = new Object[][]{
                {"zhangsan",20},
                {"lisi",25}
        };
        return o;
    }

    @Test(dataProvider = "method")
    public void test1(String name,int age){
        System.out.println("test11111的name = [" + name + "], age = [" + age + "]");
    }

    @Test(dataProvider = "method")
    public void test2(String name,int age){
        System.out.println("test2222的name = [" + name + "], age = [" + age + "]");
    }

    @DataProvider(name = "method")
    public Object[][] provider11(Method method){
        Object[][] o = null;
         if(method.getName().equals("test1"))
         {
             o = new Object[][]{
                     {"wangwu",30},
                     {"zhaoliu",40}
             };
         }
        if(method.getName().equals("test2"))
        {
            o = new Object[][]{
                    {"zhouqi",33},
                    {"liba",44}
            };
        }

        return o;
    }
}
