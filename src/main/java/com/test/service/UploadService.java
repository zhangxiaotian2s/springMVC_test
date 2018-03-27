package com.test.service;

import com.alibaba.fastjson.JSONObject;
import com.test.dto.UploadImageDto;

import java.io.IOException;

public interface UploadService {

    /*
    * 图片上传
    * @param -> UploadImageDto
    * @return -> JSONObject
    * @exception
     * */
    JSONObject uploadImage(UploadImageDto uploadImageDto) throws IOException;
}
