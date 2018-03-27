package com.test.dto;

import com.test.bean.TbAd;

/**
 * Created by zhangxiaotian on 18/2/24.
 */
public class TbAdForApi extends TbAd {
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
