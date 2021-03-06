package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.AtagDao;
import com.heeexy.example.dao.AmapDao;
import com.heeexy.example.dao.AstoreDao;
import com.heeexy.example.service.AnalysisService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.baidu.BaiduResult;
import com.heeexy.example.util.baidu.GeocodingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AmapDao mapDao;
    @Autowired
    private AtagDao tagDao;
    @Autowired
    private AstoreDao astoreDao;
    @Autowired
    private GeocodingService geocodingService;


	@Override
	public JSONObject listTag(JSONObject jsonObject) {
		 List<JSONObject> list = tagDao.listTag(jsonObject);
	     return CommonUtil.successPage(list);
	}


	@Override
	public JSONObject map(JSONObject jsonObject) {
		 List<JSONObject> list = mapDao.map(jsonObject);
	     return CommonUtil.successPage(list);
	}

	@Override
	public JSONObject business(JSONObject jsonObject) {
		 List<JSONObject> list = astoreDao.business(jsonObject);
		 int i =0;
		 for (JSONObject jsonObj : list) {
			 if( (jsonObj.get("lat") == null||jsonObj.get("lat").equals("")) && jsonObj.getString("address") != null ) {
 				BaiduResult result = geocodingService.geocoder(jsonObj.getString("address"), "address");
 				if( result != null ) {
 					String lat = result.getLocation().get("lat");
 					String lng = result.getLocation().get("lng");
 					BaiduResult result2 = geocodingService.geocoder( lat+","+lng , "location" );
 					if( result2!=null ) {
 						jsonObj.put("business", result2.getBusiness());
 					}
 					jsonObj.put("lat", lat);
 					jsonObj.put("lng", lng);
 					
 					astoreDao.updateLocationBusiness(jsonObj);
 					System.out.println(i++);
 				}
 			}
		}
		 
		 
		 
	     return CommonUtil.successPage(list);
	}

}
