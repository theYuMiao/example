package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.RecordService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hxy
 * @description: 文章相关Controller
 * @date: 2017/10/24 16:04
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     * 交易轨迹
     *
     * @param request
     * @return
     */
    @GetMapping("/location")
    public JSONObject custRecord(HttpServletRequest request) {
    	CommonUtil.hasAllRequired(CommonUtil.request2Json(request), "type");
        return recordService.custRecord(CommonUtil.request2Json(request));
    }

    /**
     * 商铺依赖关系
     *
     * @param request
     * @return
     */
    @GetMapping("/relation")
    public JSONObject custRe(HttpServletRequest request) {
        return recordService.custRelation(CommonUtil.request2Json(request));
    }
    
}
