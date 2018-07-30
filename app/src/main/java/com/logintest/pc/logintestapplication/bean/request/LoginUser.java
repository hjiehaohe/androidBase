package com.logintest.pc.logintestapplication.bean.request;

public class LoginUser {
    // username email
    String username_email;

    //password
    String password;

    public LoginUser()
    {
    }

    public LoginUser(String username_email, String password)
    {
        this.username_email = username_email;
        this.password = password;
    }

    public String getUsernameEmail()
    {
        return username_email;
    }

    public void setUsernameEmail(String username_email)
    {
        this.username_email = username_email;
    }

    public String getUserPassword()
    {
        return password;
    }

    public void setUserPassword(String password)
    {
        this.password = password;
    }
}
