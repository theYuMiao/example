package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: hxy
 * @description: 文章Dao层
 * @date: 2017/10/24 16:06
 */
public interface AmapDao {

    /**
     * 文章列表
     *
     * @param jsonObject
     * @return
     */
    List<JSONObject> map(JSONObject jsonObject);

}
