package com.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.dto.UploadImageDto;
import com.test.service.UploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    private final Log logger = LogFactory.getLog(getClass());

    @Value("${image.savePath}")
    private String imageSavePath;

    @Value("${image.url}")
    private String imageUrl;

    @Override
    public JSONObject uploadImage(UploadImageDto uploadImageDto) throws IOException {
        JSONObject object = new JSONObject();
        try {
            if(uploadImageDto.getImgFile()!=null&&uploadImageDto.getImgFile().getSize()>0){
                 String fileName = System.currentTimeMillis() + "_" + uploadImageDto.getImgFile().getOriginalFilename();
               File file = new File(imageSavePath+ fileName);
               File fileFolder = new File(imageSavePath);
               if (!fileFolder.exists()) {
                   fileFolder.mkdir();
               }
               uploadImageDto.getImgFile().transferTo(file);
                object.put("imgName", fileName);
                object.put("imgUrl", imageUrl + fileName);
             }
         }catch (Exception ex){

        }
        return object;
    }

}
