package com.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.bean.TbAd;
import com.test.bean.TbAdExample;
import com.test.dao.TbAdMapper;

import com.test.dto.TbAdForApi;
import com.test.service.AdService;
import com.test.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiaotian on 18/2/24.
 */
@Service
public class AdServiceImpl implements AdService {
    private final Log logger = LogFactory.getLog(getClass());

    @Value("${image.url}")
    private String imageUrl;

    @Autowired
    private TbAdMapper tbAdMapper;

    PageUtils pageUtils = new PageUtils();


    @Value("${image.savePath}")
    private String imageSavePath;

    @Override
    public boolean add(TbAd tbAd) {

         int  result=   tbAdMapper.insert(tbAd);
         logger.error(result);
         if(result>0){
             return true;
         }else{
             return false;
         }

    }

    @Override
    public JSONObject serchAdList(TbAdExample tbAdExample,PageInfo pageInfo) {
        JSONObject jsonObject = new JSONObject();

         try {

             PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
             List<TbAd>list = tbAdMapper.selectByExample(tbAdExample);
             PageInfo<TbAd> pageInfoObj = new PageInfo<TbAd>(list);
             List<TbAdForApi> listApi = new ArrayList<>();
             // 增加返回imageUrl
             for (TbAd  ad : list){
                 TbAdForApi adForApi = new TbAdForApi();
                 BeanUtils.copyProperties(ad, adForApi);
                 adForApi.setImgUrl(imageUrl+ad.getImgFileName());
                 listApi.add(adForApi);
             }
             //返回 列表和分页信息
             jsonObject.put("list", listApi);
             jsonObject.put("pageInfo", pageUtils.pageInfoBack(pageInfoObj));

         }catch (Exception ex){
             logger.error(ex);
         }

        return jsonObject;
    }

     @Override
    public boolean adUpdate(TbAd tbAd){
         try {
             int i = tbAdMapper.updateByPrimaryKeySelective(tbAd);
             if (i > 0) {
                 return true;
             } else {
                 return false;
             }
         }catch (Exception ex){
             logger.error(ex);
             return false;
         }
     }

    @Override
    public boolean AdDeletet(Integer id){
        try {
            int i = tbAdMapper.deleteByPrimaryKey(id);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }catch (Exception ex){
            logger.error(ex);
            return false;
        }
    }
}
