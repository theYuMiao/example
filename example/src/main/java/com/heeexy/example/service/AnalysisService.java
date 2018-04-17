package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 */
public interface AnalysisService {

    /**
     * 标签云列表
     *
     * @param jsonObject
     * @return
     */
    JSONObject listTag(JSONObject jsonObject);

    /**
     * 知识图谱
     *
     * @param jsonObject
     * @return
     */
    JSONObject map(JSONObject jsonObject);
    
    /**
     * 商圈
     *
     * @param jsonObject
     * @return
     */
    JSONObject business(JSONObject jsonObject);

}
