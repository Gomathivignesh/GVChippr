package com.hc.vo;

import java.util.Date;


public class ContentFeedANDFavourriteVO {

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
	
	
	private Integer id;
	//private Integer content_feed_type_id;
	//private String user_email_id;
	private Date created_dttm;
	
	private Integer commentLike;
	private Integer commentDislike;
	private Integer commentCount;
	
	private Integer energyScore;
	private Integer relaxScore;
	
	/**
	 * Instructor BIO
	 * */
	private String trainerImage;
	private String trainerName;
	private String trainerDesc;
	private String durationTime;
	
	
	public ContentFeedANDFavourriteVO() {

	}

	public ContentFeedANDFavourriteVO(Integer contentFeedId, String title,
			String imageUrl, String contentUrl, String contentText,
			String feedType, Boolean enable, Date startDate, Date endDate,
			Integer id, Date created_dttm, Integer commentLike,
			Integer commentDislike, Integer commentCount, Integer energyScore,
			Integer relaxScore) {
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
		this.id = id;
		this.created_dttm = created_dttm;
		this.commentLike = commentLike;
		this.commentDislike = commentDislike;
		this.commentCount = commentCount;
		this.energyScore = energyScore;
		this.relaxScore = relaxScore;
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated_dttm() {
		return created_dttm;
	}


	public void setCreated_dttm(Date created_dttm) {
		this.created_dttm = created_dttm;
	}

	public Integer getCommentLike() {
		return commentLike;
	}

	public void setCommentLike(Integer commentLike) {
		this.commentLike = commentLike;
	}

	public Integer getCommentDislike() {
		return commentDislike;
	}

	public void setCommentDislike(Integer commentDislike) {
		//this.commentDislike = commentDislike;
		this.commentDislike = getCommentCount()-getCommentLike();
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
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

	public String getTrainerImage() {
		return trainerImage;
	}

	public void setTrainerImage(String trainerImage) {
		this.trainerImage = trainerImage;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerDesc() {
		return trainerDesc;
	}

	public void setTrainerDesc(String trainerDesc) {
		this.trainerDesc = trainerDesc;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	
}
