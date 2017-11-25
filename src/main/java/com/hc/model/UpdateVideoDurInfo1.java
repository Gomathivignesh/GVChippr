package com.hc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "userId", "videoList" })

/*
 * {

"userId":"1",
"videoList":[{"workOutId":"385","duration_time":"20:20"},{"workOutId":"386","duration_time":"30:30"}]
}
 * 
 */
public class UpdateVideoDurInfo1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private List<OnDemandWorkOut> videoList=new ArrayList<OnDemandWorkOut>();
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public List<OnDemandWorkOut> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<OnDemandWorkOut> videoList) {
		this.videoList = videoList;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
