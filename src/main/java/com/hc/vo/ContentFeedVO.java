package com.hc.vo;

import java.util.Date;

public class ContentFeedVO {


	private Integer contentFeedId;
	//private String category;
	//private Integer categoryOrderId;
	private String title;
	private String imageUrl;
	private String contentUrl;
	private String contentText;
	private String feedType;
	
	private Boolean enable;
	private Date startDate;
	private Date endDate;
	
	public ContentFeedVO() {

	}

	public ContentFeedVO(Integer contentFeedId, String title, String imageUrl,
			String contentUrl,String contentText, String feedType, Boolean enable, Date startDate, Date endDate) {
		super();
		this.contentFeedId = contentFeedId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.contentUrl = contentUrl;
		this.contentText = contentText;
		this.feedType = feedType;
		this.enable = enable;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getContentFeedId() {
		return contentFeedId;
	}


	public void setContentFeedId(Integer contentFeedId) {
		this.contentFeedId = contentFeedId;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getContentUrl() {
		return contentUrl;
	}


	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}


	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public Boolean getEnable() {
		return enable;
	}


	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
