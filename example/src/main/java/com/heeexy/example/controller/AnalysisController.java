package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.AnalysisService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 */
@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService articleService;

    /**
     * 查询标签云列表(字符云图)
     *
     * @param request
     * @return
     */
    @GetMapping("/listTag")
    public JSONObject listTag(HttpServletRequest request) {
        return articleService.listTag(CommonUtil.request2Json(request));
    }

    /**
     * 知识图谱
     *
     * @param requestJson
     * @return
     */
    @GetMapping("/map")
    public JSONObject updateArticle(HttpServletRequest request) {
    	return articleService.map(CommonUtil.request2Json(request));
    }
    
    /**
     * 商圈分析
     *
     * @param requestJson
     * @return
     */
    @GetMapping("/business")
    public JSONObject business(HttpServletRequest request) {
    	return articleService.business(CommonUtil.request2Json(request));
    }
}
