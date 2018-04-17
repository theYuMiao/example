package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017-11-14 15:08:45
 */
public interface RrelationDao {
    /**
     * 查询用户数量
     *
     * @param jsonObject
     * @return
     */
    int countUser(JSONObject jsonObject);

    /**
     * 查询关联关系列表
     *
     * @param jsonObject
     * @return
     */
    List<JSONObject> custRelationST(JSONObject jsonObject);
    
    /**
     * 查询关联关系列表
     *
     * @param jsonObject
     * @return
     */
    List<JSONObject> custRelationList(JSONObject jsonObject);
  
}
