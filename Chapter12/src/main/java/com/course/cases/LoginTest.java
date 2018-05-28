package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.databaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by wangkai on 18/5/26.
 */
public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试用户登陆前的准备工作")
    public void beforeLogin(){
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.addUserUrl = ConfigFile.getURL(InterfaceName.ADDUSERINFO);
        TestConfig.getUserInfoUrl = ConfigFile.getURL(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getURL(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigFile.getURL(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getURL(InterfaceName.UPDATEUSERINFO);

    }

    @Test(groups = "loginTrue",description = "正确的测试")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = databaseUtil.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",1);
        System.out.println(loginCase);

        String result = getResult(loginCase);
        System.out.println("ccc"+result);
        System.out.println("bbb"+loginCase.getExpected());
        Assert.assertEquals(loginCase.getExpected(),result);

    }

    @Test(groups = "loginFalse",description = "错误的测试")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = databaseUtil.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase);
        String result = getResult(loginCase);
        System.out.println("aaa"+loginCase.getExpected());
        Assert.assertEquals(loginCase.getExpected(),result);

    }


    private String getResult(LoginCase loginCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.loginUrl);
        System.out.println(TestConfig.loginUrl);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName",loginCase.getUserName());
        jsonObject.put("passwd",loginCase.getPasswd());

        post.setHeader("Content-Type","Application/json");
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        String result = EntityUtils.toString(response.getEntity());
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();

        return result;
    }
}
