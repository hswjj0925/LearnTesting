package com.course.utils;

import com.course.model.InterfaceName;
import lombok.Data;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by wangkai on 18/5/26.
 */
@Data
public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    /*拼接URL*/
    public static String getURL(InterfaceName name)
    {
        String host_url = bundle.getString("test.url");
        String uri = null;
        String result_url;
        switch (name)
        {
            case LOGIN:
                uri = bundle.getString("login.uri");
                break;
            case ADDUSERINFO:
                uri = bundle.getString("addUser.uri");
                break;
            case GETUSERINFO:
                uri = bundle.getString("getUserInfo.uri");
                break;
            case GETUSERLIST:
                uri = bundle.getString("getUserList.uri");
                break;
            case UPDATEUSERINFO:
                uri = bundle.getString("updateUserInfo.uri");
                break;
            default:break;
        }
        result_url = host_url+uri;
        return result_url;
    }

}
