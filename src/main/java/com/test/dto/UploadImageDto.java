package com.test.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadImageDto {


    private MultipartFile imgFile;


    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
