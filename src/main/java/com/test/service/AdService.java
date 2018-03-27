package com.test.service;



import com.alibaba.fastjson.JSONObject;
import com.test.bean.TbAd;
import com.test.bean.TbAdExample;
import com.github.pagehelper.PageInfo;

/**
 * Created by zhangxiaotian on 18/2/24.
 */

public interface AdService {


    /*
     * 广告列表
     * @param -> TbAdExample，PageInfo
     * @return -> JSONObject
     * @exception
     * */
    JSONObject serchAdList(TbAdExample tbAdExample, PageInfo pageInfo);

    /*
     * 新增广告
     * @param -> TbAd
     * @return -> boolean
     * @exception
     * */
    boolean add(TbAd tbAd);


    /*
     * 修改广告
     * @param -> TbAd
     * @return -> boolean
     * @exception
     * */
    boolean adUpdate(TbAd tbAd );


    /*
     * 删除广告
     * @param -> id
     * @return -> boolean
     * @exception
     * */
    boolean AdDeletet(Integer id );






}
