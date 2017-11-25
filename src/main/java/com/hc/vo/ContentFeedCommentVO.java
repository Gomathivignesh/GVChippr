package com.hc.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class ContentFeedCommentVO {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private String emailId; 
	private Integer contentFeedId; 
	private String firstName; 
	private String lastName;
	private String commentText; 
	private String ratings;
	private Date createdDttm;
	//private Date updatedDttm;
	
	private Integer likes;
	
	
	public ContentFeedCommentVO() {

	}
	
	public ContentFeedCommentVO(Integer id, Integer userId, String emailId,
			Integer contentFeedId, String firstName, String lastName,
			String commentText, String ratings, Date createdDttm,
			Date updatedDttm, Integer likes) {
		super();
		this.id = id;
		this.userId = userId;
		this.emailId = emailId;
		this.contentFeedId = contentFeedId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.commentText = commentText;
		this.ratings = ratings;
		this.createdDttm = createdDttm;
//		this.updatedDttm = updatedDttm;
		this.likes = likes;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getContentFeedId() {
		return contentFeedId;
	}
	public void setContentFeedId(Integer contentFeedId) {
		this.contentFeedId = contentFeedId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public Date getCreatedDttm() {
		return createdDttm;
	}
	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	} 
	
}
