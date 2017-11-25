package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
//@XmlType(propOrder = { "content_feed_id", "category", "title", "image_url", "content_url", "enable","start_date", "end_date" })
//@XmlType(propOrder = { "content_feed_id", "category", "title", "image_url", "content_url", "enable","start_date", "end_date" })
public class ContentFeed implements Serializable {

	/**
  `content_feed_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `content_url` varchar(256) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
	 */
	private static final long serialVersionUID = 1L;
	private Integer contentFeedId;
	private String category;
	private Integer categoryOrderId;
	private String title;
	private String imageUrl;
	private String contentUrl;
	private String contentText;
	private String feedType;
	
	private Boolean enable;
	private Date startDate;
	private Date endDate;
	
	public ContentFeed() {

	}

	public ContentFeed(Integer contentFeedId, String category,
			Integer categoryOrderId, String title, String imageUrl,
			String contentUrl,String contentText, String feedType, Boolean enable, Date startDate, Date endDate) {
		super();
		this.contentFeedId = contentFeedId;
		this.category = category;
		this.categoryOrderId = categoryOrderId;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getCategoryOrderId() {
		return categoryOrderId;
	}

	public void setCategoryOrderId(Integer categoryOrderId) {
		this.categoryOrderId = categoryOrderId;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
