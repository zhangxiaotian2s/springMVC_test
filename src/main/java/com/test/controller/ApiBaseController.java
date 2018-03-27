package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.utils.CommonErrors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

public class ApiBaseController {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    CommonErrors errMsgs;

    @Autowired
    protected HttpServletRequest request;

    //接口正确信息统一返回接口
    protected JSONObject successBackJsonData(Object object) {

        JSONObject resultJson = new JSONObject();
        if(object!=null) {
            resultJson.put("data", object);
        }else {
            resultJson.put("data", "");
        }
        resultJson.put("success", 1);
        resultJson.put("error", "");

        return resultJson;
    }
   // 接口错误信息统一返回处理
    protected JSONObject errBackJsonData(String code, String message) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("success", 0);
        resultJson.put("data","");
        resultJson.put("error", errMsgs.getErrMap(code, message));
        return resultJson;
    }
  //请求头信息获取
    protected HashMap<String, String> getRequestHeaders() {
        HashMap<String, String> requestHeaders = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            requestHeaders.put(headerName, headerValue);
        }
        return requestHeaders;
    }
   //参数返回
    protected HashMap<String, String> getRequestParams() {
        HashMap<String, String> requestParams = new HashMap<String, String>();
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            requestParams.put(paramName, paramValue);
        }
        return requestParams;
    }



}
