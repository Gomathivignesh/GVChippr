package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
public class ContentFeedUserLog implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer contentFeedUserLogId;
	private Integer userId;
	private String userEmail;
	private Integer energyScore;
	private Integer relaxScore;
	private Date createdDttm;
	
	
	public ContentFeedUserLog() {

	}


	public ContentFeedUserLog(Integer contentFeedUserLogId, Integer userId,
			String userEmail, Integer energyScore, Integer relaxScore,
			Date createdDttm) {
		super();
		this.contentFeedUserLogId = contentFeedUserLogId;
		this.userId = userId;
		this.userEmail = userEmail;
		this.energyScore = energyScore;
		this.relaxScore = relaxScore;
		this.createdDttm = createdDttm;
	}


	public Integer getContentFeedUserLogId() {
		return contentFeedUserLogId;
	}


	public void setContentFeedUserLogId(Integer contentFeedUserLogId) {
		this.contentFeedUserLogId = contentFeedUserLogId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public Integer getEnergyScore() {
		return energyScore;
	}


	public void setEnergyScore(Integer energyScore) {
		this.energyScore = energyScore;
	}


	public Integer getRelaxScore() {
		return relaxScore;
	}


	public void setRelaxScore(Integer relaxScore) {
		this.relaxScore = relaxScore;
	}


	public Date getCreatedDttm() {
		return createdDttm;
	}


	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}
	
	
	
}
