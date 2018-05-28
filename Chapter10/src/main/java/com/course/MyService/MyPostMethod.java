package com.course.MyService;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by wangkai on 18/5/23.
 */
@RestController
public class MyPostMethod {

    /*一个简单的无参的post*/
    @RequestMapping(value = "/demo/post",method = RequestMethod.POST)
    public String myPost(){
        return "POST请求成功";
    }
    /*带cookie的post请求，并返回Cookie信息*/
    @RequestMapping(value = "/post/with/cookie",method = RequestMethod.POST)
    public String postWithCookie(HttpServletRequest request, HttpServletResponse response, @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        if(u.getUserName()==null)
            return "参数为空";
        if(Objects.isNull(cookies))
            return "必须携带cookie信息";
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login")
                    &&cookie.getValue().equals("true")
                    &&u.getUserName().equals("wangjiajia")
                    &&u.getPasswd().equals("123456"))
            {
                Cookie c = new Cookie("111","222");
                response.addCookie(c);

                return u.toString();
            }
        }
        return "post请求失败";
    }

    /*带参数的post请求*/

    @RequestMapping(value = "/post/with/param",method = RequestMethod.POST)
    public String postWithParam(HttpServletResponse response,@RequestParam String name,@RequestParam String passwd){
        if(name.equals("wangjiajia")&&passwd.equals("123456")){
            return "参数正确";
        }
        return "参数错误";
    }
    @RequestMapping(value = "/v1/login",method = RequestMethod.POST)
    public String postWithCookie(HttpServletRequest request,  @RequestBody JSONObject jsonObject) {

        String userName = (String) jsonObject.get("userName");
        String passwd = (String) jsonObject.get("passwd");

        if (userName.equals("wangjiajia") && passwd.equals("900925"))
            return "true";
        else return "false";

    }

}
