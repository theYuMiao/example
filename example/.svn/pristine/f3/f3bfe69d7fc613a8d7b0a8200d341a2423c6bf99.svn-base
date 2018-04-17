package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.RclusterDao;
import com.heeexy.example.dao.RcustDao;
import com.heeexy.example.dao.RrelationDao;
import com.heeexy.example.service.RecordService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.baidu.BaiduResult;
import com.heeexy.example.util.baidu.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017/11/2 10:18
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RcustDao rcustDao;
    @Autowired
    private RclusterDao rclusterDao;
    @Autowired
    private RrelationDao relationDao;
    @Autowired
    private GeocodingService geocodingService;

    /**
     * 装饰公司列表
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject custRecord(JSONObject jsonObject) {

    	String type = jsonObject.getString("type");
    	List<JSONObject> list = null;
    	
    	if(type.equals("one")){
    		list = rcustDao.listCust(jsonObject);
            for (JSONObject jsonObj : list) {
    			if( jsonObj.get("lat") == null && jsonObj.getString("address") != null ) {
    				BaiduResult result = geocodingService.geocoder(jsonObj.getString("address"), "address");
    				if( result != null ) {
    					jsonObj.put("lat", result.getLocation().get("lat"));
    					jsonObj.put("lng", result.getLocation().get("lng"));
    					
    					rcustDao.updateLocation(jsonObj);
    					//break;
    				}
    			}
    		}

            list = rcustDao.listCust(jsonObject);
    	}else if(type.equals("more")) {
    		list = rclusterDao.listCluster(jsonObject);
            for (JSONObject jsonObj : list) {
    			if( jsonObj.get("lat") == null && jsonObj.getString("address") != null ) {
    				BaiduResult result = geocodingService.geocoder(jsonObj.getString("address"), "address");
    				if( result != null ) {
    					jsonObj.put("lat", result.getLocation().get("lat"));
    					jsonObj.put("lng", result.getLocation().get("lng"));
    					
    					rclusterDao.updateLocation(jsonObj);
    					//break;
    				}
    			}
    		}

            list = rclusterDao.listCluster(jsonObject);
    	}
        
        return CommonUtil.successPage( list );
    }

	@Override
	public JSONObject custRelation(JSONObject jsonObject) {
		
		JSONObject resultObj = new JSONObject();
		List<JSONObject> relationST = relationDao.custRelationST(jsonObject);
		List<JSONObject> relationList = relationDao.custRelationList(jsonObject);
		resultObj.put("relationST", relationST);
		resultObj.put("relationList", relationList);
		
		return resultObj;
	}

   
}
