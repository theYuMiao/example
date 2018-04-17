package com.heeexy.example.util.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.heeexy.example.util.JsonUtil;

@Service
public class GeocodingService {

	private Logger logger = Logger.getLogger( GeocodingService.class );
	private static final String BAIDU_GEOCODING_URL = "http://api.map.baidu.com/geocoder/v2/?output=json&ak=lqNZ6ctoLaq3NNPixZdO7Inr2O4BmfdP";
	
	//最大解析次数
	private int maxParseCnt = 5;
	private String uuid = "";
	
	public BaiduResult geocoder( String location, String type ) {
		String resultStr = "";
		BaiduResult baiduResult = null;
		uuid = UUID.randomUUID().toString();
		boolean flag = true;
		int count = 0;
		while (flag && count < maxParseCnt) {
			logger.debug(uuid+"-第"+(count+1)+"次请求解析["+location+"].");
			if(type.equals("address")) {
				resultStr = this.geocoderLocationFromBaidu(location);
			}else {
				resultStr = this.geocoderBusinessFromBaidu(location);
			}
			logger.debug(uuid+"-LOCATION["+location+"] 请求解析结果:"+resultStr);
			if(StringUtils.isEmpty(resultStr)) {
				flag = false;
			}else {
				baiduResult = JsonUtil.fromJson(resultStr, BaiduResult.class);
				if (baiduResult.getStatus()==0) {
					flag = false; 
				}
			}

			count ++;
		}
		
		logger.debug(uuid+"-LOCATION["+location+"] ParseResult:"+JsonUtil.toJson(baiduResult));
		return baiduResult;
	}
	
	private String geocoderLocationFromBaidu(String location) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("address", location);
		
		return HttpRequestUtil.httpRequest(BAIDU_GEOCODING_URL, params, null);
	}
	
	private String geocoderBusinessFromBaidu(String location) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("location", location);
		
		return HttpRequestUtil.httpRequest(BAIDU_GEOCODING_URL, params, null);
	}
}
