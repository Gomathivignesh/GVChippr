package com.hc.model;

import java.io.Serializable;
import java.sql.Date;

public class WeeklyWorkOut implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String workOutId;
	private Integer weekNumber;
	private Integer videoId;
	private Integer userId;
	private String watchedTime;
	private Integer isWatched;
	private Integer dayId;
	private Integer catId;
	private Integer planId;
	private String title;
	private String image_url;
	private String content_url;
	private String content_text;
	private String feed_type;
	private String comment_count;
	private String energy_score;
	private String relax_score;
	private String trainer_image;
	private String trainer_name;
	private String duration_time;
	private String lastUpdated;
	private String created;
	private String planName;
	private String trainerBio;
	private String btm_code;
	private String audioUrl;
	private String audioGuidedImg;
	public String getBtm_code() {
		return btm_code;
	}
	public void setBtm_code(String btm_code) {
		this.btm_code = btm_code;
	}
	private String bt_status;
	
	public String getBt_status() {
		return bt_status;
	}
	public void setBt_status(String btm_status) {
		this.bt_status = btm_status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getContent_url() {
		return content_url;
	}
	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}
	public String getContent_text() {
		return content_text;
	}
	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}
	public String getFeed_type() {
		return feed_type;
	}
	public void setFeed_type(String feed_type) {
		this.feed_type = feed_type;
	}
	public String getComment_count() {
		return comment_count;
	}
	public void setComment_count(String comment_count) {
		this.comment_count = comment_count;
	}
	public String getEnergy_score() {
		return energy_score;
	}
	public void setEnergy_score(String energy_score) {
		this.energy_score = energy_score;
	}
	public String getRelax_score() {
		return relax_score;
	}
	public void setRelax_score(String relax_score) {
		this.relax_score = relax_score;
	}
	public String getTrainer_image() {
		return trainer_image;
	}
	public void setTrainer_image(String trainer_image) {
		this.trainer_image = trainer_image;
	}
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public String getDuration_time() {
		return duration_time;
	}
	public void setDuration_time(String duration_time) {
		this.duration_time = duration_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
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
	public Integer getDayId() {
		return dayId;
	}
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getWorkOutId() {
		return workOutId;
	}
	public void setWorkOutId(String workOutId) {
		this.workOutId = workOutId;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getTrainerBio() {
		return trainerBio;
	}
	public void setTrainerBio(String trainerBio) {
		this.trainerBio = trainerBio;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	public String getAudioGuidedImg() {
		return audioGuidedImg;
	}
	public void setAudioGuidedImg(String audioGuidedImg) {
		this.audioGuidedImg = audioGuidedImg;
	}
	
}
