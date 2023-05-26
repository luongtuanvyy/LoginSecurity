package com.lab.Lab1.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {
    public String get(String name, HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        for (Cookie ck : cookie) {
            if (ck.getName().equalsIgnoreCase(name)) {
                return ck.getValue();
            }
        }
        return "";
    }

    public void add(HttpServletResponse response, String name, String value, int hours) {
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(hours*60*60);
        response.addCookie(cookie);
    }
}


