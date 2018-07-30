package com.logintest.pc.logintestapplication.bean.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginUserResponseBean {

    /**
     * _id : 5abe851ff373e6534e999531
     * username : content
     * nickname : null
     * email : content@omg.com
     * language : en
     * role : ["content mgnt"]
     * thumbnail : {"default":""}
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1YWJlODUxZmYzNzNlNjUzNGU5OTk1MzEiLCJhdWQiOiJQYW5lbCIsImlzcyI6IlBhbmVsIiwiaWF0IjoxNTMyMDc4NDU0LCJleHAiOjE1NjM2MzYwNTR9.ny5PK6klmXgOSUvVvySHaMu66IL0PxLII3aMLCVWprk
     */

    private String _id;
    private String username;
    private Object nickname;
    private String email;
    private String language;
    private ThumbnailBean thumbnail;
    private String token;
    private List<String> role;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ThumbnailBean getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailBean thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public static class ThumbnailBean {
        /**
         * default :
         */

        @SerializedName("default")
        private String defaultX;

        public String getDefaultX() {
            return defaultX;
        }

        public void setDefaultX(String defaultX) {
            this.defaultX = defaultX;
        }
    }
}
