package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.bean.TbAd;
import com.test.bean.TbAdExample;
import com.test.service.AdService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("/api/ad/")
public class AdApiController  extends ApiBaseController{

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AdService adService;


    /*
    * 广告列表
    * */
    @RequestMapping("/adList.do")
    @ResponseBody
     public JSONObject adList()  {

        Map<String, String> params = getRequestParams();
        int pageSize=10;
        int currentPage=1;
        try {
            if (params.get("pageSize") != null) {
                pageSize = Integer.parseInt(params.get("pageSize"));
            }
            if (params.get("currentPage") != null) {
                currentPage = Integer.parseInt(params.get("currentPage"));
            }
        }catch (Exception ex){
           // 参数错误
            return errBackJsonData("200002","");
        }
        if(pageSize<1){
            pageSize = 10;
        }
        if(currentPage<1){
            currentPage = 1;
        }
        PageInfo pageInfo = new PageInfo();
        TbAdExample tbAdExample = new TbAdExample();

        try {
             tbAdExample.setOrderByClause("`weight` desc , id desc");
             pageInfo.setPageNum(currentPage);
             pageInfo.setPageSize(pageSize);
             JSONObject listObject = adService.serchAdList(tbAdExample,pageInfo);
             return successBackJsonData(listObject);

        }catch (Exception ex){
           logger.error(ex);
            return errBackJsonData("000001","");
        }
    }

    /*
     * 广告添加
     * */
    @RequestMapping("/adAdd.do")
    @ResponseBody
    public  JSONObject adAdd(TbAd td){

        try {
          logger.error(td);
            boolean isadd=  adService.add(td);
            if(isadd==true){
                return successBackJsonData("");
            }else {
                return errBackJsonData("000001","");
            }
        }catch (Exception ex){
            return errBackJsonData("000001","");
        }

    }

    /*
    * 修改
    * */

    @RequestMapping("/adUpdate.do")
    @ResponseBody
     public  JSONObject adUpdate(TbAd tbAd){
        try {

            boolean isUpdate=  adService.adUpdate(tbAd);
            if(isUpdate==true){
                return  successBackJsonData("");
            }else {
                return errBackJsonData("000001","");
            }
        }catch (Exception ex){
            return errBackJsonData("000001","");
        }

    }

    /*
    * 删除
    * */

    @RequestMapping("/adDelete.do")
    @ResponseBody
    public  JSONObject deleteAd(Integer id){
        try {

            boolean isDelete=  adService.AdDeletet(id);
            if(isDelete==true){
                return  successBackJsonData("");
            }else {
                return errBackJsonData("000001","");
            }
        }catch (Exception ex){
            return errBackJsonData("000001","");
        }

    }

}
