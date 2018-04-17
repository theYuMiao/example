package com.heeexy.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	public static String toJson(Object obj) {
		
		return JSON.toJSONString(obj);
	}
	
	public static <T> T fromJson(String json, Class<T> T) {
		
		JSONObject object = JSON.parseObject(json);
		return object.toJavaObject(T);
	}
	
}
