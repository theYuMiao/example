package com.heeexy.example.util.baidu;

import java.util.HashMap;
import java.util.Map;

public class BaiduResult {

	private int status;
	private Result result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public Map<String, String> getLocation(){
		
		Map<String, String> map = new HashMap<>();
		map.put("lng", result == null ? "-" : result.getLocation().getLng() + "");
		map.put("lat", result == null ? "-" : result.getLocation().getLat() + "");
		
		return map;
	}
	
	public String getBusiness(){
		
		return result == null ? "-" : result.getBusiness() ;
	}
}

class Result {
	private Location location;
	private String precise;
	private String confidence;
	private String level;
	private String business;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getPrecise() {
		return precise;
	}

	public void setPrecise(String precise) {
		this.precise = precise;
	}

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}
	
}


class Location {
	private double lng;
	private double lat;

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
}


