package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017-11-14 15:08:45
 */
public interface RclusterDao {
    /**
     * 查询用户数量
     *
     * @param jsonObject
     * @return
     */
    int countUser(JSONObject jsonObject);

    /**
     * 查询用户列表
     *
     * @param jsonObject
     * @return
     */
    List<JSONObject> listCluster(JSONObject jsonObject);

    /**
     * 更新经纬度信息
     *
     * @param jsonObject
     * @return
     */
    void updateLocation(JSONObject jsonObject);

   
}
