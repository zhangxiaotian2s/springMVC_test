package com.test.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

public class PageUtils {
    // 分页信息统一包装处理



    public JSONObject pageInfoBack(PageInfo pageInfo) {
        JSONObject jsonObject = new JSONObject();
        //当前页
        jsonObject.put("currentPage", pageInfo.getPageNum());
        //每页的数量
        jsonObject.put("pageSize", pageInfo.getPageSize());
        //总页数
        jsonObject.put("pageTotal", pageInfo.getPages());
        //总数据条数
        jsonObject.put("totalNum", pageInfo.getTotal());


        return jsonObject;
    }
}
