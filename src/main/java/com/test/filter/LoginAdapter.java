package com.test.filter;

import com.test.utils.CookieHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by zhangxiaotian on 18/3/9.
 */
public class LoginAdapter extends HandlerInterceptorAdapter {

    private final Log logger = LogFactory.getLog(getClass());

   @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
       HandlerMethod handlerMethod = (HandlerMethod) handler;
       if(!(handler instanceof  HandlerMethod)){
           return true;
       }

       NeedLogin needLogin =handlerMethod.getMethodAnnotation(NeedLogin.class);
       if(null==needLogin){
           return true;
       }
       boolean checkResult = checkLogin(request, response);
       if(checkResult){
           return true;
       }else{
           StringBuffer stringBuffer = new StringBuffer();
           stringBuffer.append(request.getContextPath());
           stringBuffer.append("/user/login");
           response.sendRedirect(stringBuffer.toString());
           return false;

       }

   }
   private  boolean checkLogin(HttpServletRequest request, HttpServletResponse response){
       CookieHelper cookieHelper = new CookieHelper();
       String username= cookieHelper.getCookieValue(request,"username");
       if(StringUtils.isNotBlank(username)){
           return true;
       }else {
           return false;
       }
   }
}
