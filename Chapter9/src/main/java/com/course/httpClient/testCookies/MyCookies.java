package com.course.httpClient.testCookies;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by wangkai on 18/5/21.
 */
public class MyCookies {

    private String url;
    private ResourceBundle  bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void testCookie() throws IOException {


        //获得URL
        String uri = bundle.getString("test.get.cookie.url");
        String testUrl = url+uri;
        System.out.println(testUrl);
        //请求并获取响应
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response =client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获得Cookie并打印
        this.cookieStore = client.getCookieStore();
        List<Cookie>  cookieList =  cookieStore.getCookies();
        System.out.println(cookieList.size());
        String key =null;
        String value = null;
        for(Cookie cookie :cookieList){
            key = cookie.getName();
            value = cookie.getValue();
            System.out.println(key+"="+value);
        }
    }
    @Test(dependsOnMethods = {"testCookie"})
    public void testDoCookie() throws IOException {
        String uri = bundle.getString("test.get.with.cookie.url");
        String testUrl = url+uri;
        HttpGet get = new HttpGet(testUrl);

        DefaultHttpClient client = new DefaultHttpClient();
        //将上一请求返回的cookie放入请求
        client.setCookieStore(this.cookieStore);
        //发出get请求
        HttpResponse response = client.execute(get);

        //获得响应的状态码
        int Code = response.getStatusLine().getStatusCode();
        //做出判断
        if(200 == Code){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
    }

        @Test(dependsOnMethods = {"testCookie"})
        public void testPostWithParam() throws IOException {
            //获取url
            String url = bundle.getString("test.demo.with.post.url");
            String test_url = this.url+url;
            System.out.println(test_url);

            //申明client和post方法
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(test_url);
            //设置cookie
            client.setCookieStore(this.cookieStore);
            //设置请求头信息
            post.setHeader("content-Type","Application/json");
            //设置json参数
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","wangjiajia");
            jsonObject.put("age","18");

            StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
            post.setEntity(entity);
            //发请求并获得响应
            HttpResponse response = client.execute(post);
            //获取返回json
            String result = EntityUtils.toString(response.getEntity());
            //直接打印result
            System.out.println(result);
            //做一个简单的判断
            JSONObject jsonResult = new JSONObject(result);
            String success = (String) jsonResult.get("wangjiajia");
            String ok = (String)jsonResult.get("status");
            System.out.println(ok);
            Assert.assertEquals("success",success);
            Assert.assertEquals("ok",ok);


    }
}
