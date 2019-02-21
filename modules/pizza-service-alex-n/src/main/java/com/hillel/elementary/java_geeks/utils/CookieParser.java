package com.hillel.elementary.java_geeks.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieParser {

    private CookieParser() {
    }

    public static String getCookieValue(String cookieName, HttpServletRequest req){
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
