package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017/11/2 10:18
 */
public interface RecordService {
    /**
     * 用户列表
     *
     * @param jsonObject
     * @return
     */
    JSONObject custRecord(JSONObject jsonObject);
    
    
    /**
     * 消费商户依赖节点
     *
     * @param jsonObject
     * @return
     */
    JSONObject custRelation(JSONObject jsonObject);

}
