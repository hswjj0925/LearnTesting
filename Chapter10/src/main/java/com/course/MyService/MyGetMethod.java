package com.course.MyService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by wangkai on 18/5/22.
 */
@RestController
public class MyGetMethod {

    //响应含有cookie的get请求
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "success to get cookie";
    }

    //含有cookie的请求
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies))
            return "必须携带cookies信息";
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true"))
                return "携带cookie请求成功";
        }
        return "必须携带cookies信息";
    }

    /*含有参数的get请求*/
    @RequestMapping(value = "/get/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> list = new HashMap <>();
        list.put("衣服",100);
        list.put("鞋子",200);
        list.put("书",20);
        return list;
    }


}
