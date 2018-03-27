package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.dto.UploadImageDto;
import com.test.service.UploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/common/")
public class FileUploadApiController  extends  ApiBaseController{

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UploadService uploadService;


   @RequestMapping("/uploadImage.do")
   @ResponseBody
    public JSONObject uploadImage(HttpServletRequest request ,HttpServletResponse response)  throws IOException{
       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
       try{
           if (multipartResolver.isMultipart(request)) {
               //转换request
               MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
               MultiValueMap<String, MultipartFile> multiValueMap = multipartHttpServletRequest.getMultiFileMap();

               List<MultipartFile> file =multiValueMap.get("file");

               if (!file.isEmpty()) {
                   UploadImageDto uploadImageDto = new UploadImageDto();
                   uploadImageDto.setImgFile(file.get(0));
                   //上传
                   JSONObject img = uploadService.uploadImage(uploadImageDto);
                   return successBackJsonData(img);
               }else{
                   return errBackJsonData("300002","");
               }
           }
       }catch(Exception ex){
           logger.error(ex);
       }
       return errBackJsonData("000001","");
   }
}
