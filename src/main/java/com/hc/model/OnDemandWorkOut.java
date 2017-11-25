package com.hc.model;

import java.io.Serializable;
import java.sql.Date;

public class OnDemandWorkOut implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String workOutId;
	private Integer videoId;
	private Integer userId;
	private String watchedTime;
	private Integer isWatched;
	private Integer catId;
	private String lastUpdated;
	private String created;
	private String onDemandId;
	public String getWorkOutId() {
		return workOutId;
	}
	public void setWorkOutId(String workOutId) {
		this.workOutId = workOutId;
	}
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getWatchedTime() {
		return watchedTime;
	}
	public void setWatchedTime(String watchedTime) {
		this.watchedTime = watchedTime;
	}
	public Integer getIsWatched() {
		return isWatched;
	}
	public void setIsWatched(Integer isWatched) {
		this.isWatched = isWatched;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOnDemandId() {
		return onDemandId;
	}
	public void setOnDemandId(String onDemandId) {
		this.onDemandId = onDemandId;
	}
	
	
}
