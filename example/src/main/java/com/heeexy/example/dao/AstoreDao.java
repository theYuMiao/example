package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 */
public interface AstoreDao {
    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
	List<JSONObject> business(JSONObject jsonObject);
	
    /**
     * 更新经纬度信息
     *
     * @param jsonObject
     * @return
     */
    void updateLocationBusiness(JSONObject jsonObject);
    
}
