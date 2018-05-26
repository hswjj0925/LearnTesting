package com.course.MyService;

/**
 * Created by wangkai on 18/5/23.
 */
public class User {
    private String userName;
    private  String passwd;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }


}
