package com.test.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxiaotian on 18/2/12.
 */
public class CookieHelper {

    /*
     *把cookie 构建到map 中
     * ReadCookieMap(request)
     */
    public static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> map = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }

    /*
    *获取cookie 中 name 的vue 方法
    * getCookieValue(request , "name")
    */
    public static String getCookieValue(HttpServletRequest request, String key) {
        Map<String, Cookie> map = new HashMap<String, Cookie>();
        if (map.containsKey(key)) {
            Cookie cookie = map.get(key);
            return cookie.getValue();
        }else {
            return null;
        }
    }
    /*
   *获取cookie 中 name 的vue 方法
   * getCookieValue("name",request )
   */
    public static String getCookieValue(String key,HttpServletRequest request) {
        Map<String, Cookie> map = new HashMap<String, Cookie>();
        if (map.containsKey(key)) {
            Cookie cookie = map.get(key);
            return cookie.getValue();
        }else {
            return null;
        }
    }

    /*
    *添加cookie 方法
    * addCooklie(response,"name","value");
    */
    public static void addCookie(HttpServletResponse response, String key, String value) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            return;
        }
        try {
            Cookie cookie = new Cookie(key, value);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *添加cookie 方法
    * addCooklie(response,"name","value",15555);
    */
    public static void addCookie(HttpServletResponse response, String key, String value, int timeout) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            return;
        }
        try {
            Cookie cookie = new Cookie(key, value);
            cookie.setPath("/");
            cookie.setMaxAge(timeout);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
