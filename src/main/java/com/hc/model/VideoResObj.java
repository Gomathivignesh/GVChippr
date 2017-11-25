package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.UserTypeEnums;

public class VideoResObj implements Serializable {
	private String workOutId;
	
	private String energy_score;

    private String comment_count;

    private String title;

    private String duration_time;

    private String trainer_name;

    private String image_url;

    private String videoId;

    private String content_text;

    private String feed_type;

    private String day;

    private String trainer_image;

    private String relax_score;

    private String content_url;
    
    private String catId;
    
    private String planId;
    
    private String trainer_bio;
    
    private String subCatId;
    private String AudioUrl;
    
    private Integer isCompleted;
    private String watchedTime;
    
    private String onDemandId;
    public Integer getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Integer isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getWatchedTime() {
		return watchedTime;
	}

	public void setWatchedTime(String watchedTime) {
		this.watchedTime = watchedTime;
	}

	public String getAudioDuration() {
		return audioDuration;
	}

	public void setAudioDuration(String audioDuration) {
		this.audioDuration = audioDuration;
	}

	public String getGuidedImgAudioDuration() {
		return guidedImgAudioDuration;
	}

	public void setGuidedImgAudioDuration(String guidedImgAudioDuration) {
		this.guidedImgAudioDuration = guidedImgAudioDuration;
	}

	private String audioDuration;
    
    private String guidedImgAudioDuration;
    
    private String AudioGuidedImg;
    public String getAudioGuidedImg() {
		return AudioGuidedImg;
	}

	public void setAudioGuidedImg(String audioGuidedImg) {
		AudioGuidedImg = audioGuidedImg;
	}

	public String getAudioUrl() {
		return AudioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		AudioUrl = audioUrl;
	}

	private String BtCode="";
    public String getBtCode() {
		return BtCode;
	}

	public void setBtCode(String btCode) {
		BtCode = btCode;
	}

	private int Btstatus;

    public int getBtstatus() {
		return Btstatus;
	}

	public void setBtstatus(int btstatus) {
		Btstatus = btstatus;
	}

	public String getEnergy_score ()
    {
        return energy_score;
    }

    public void setEnergy_score (String energy_score)
    {
        this.energy_score = energy_score;
    }

    public String getComment_count ()
    {
        return comment_count;
    }

    public void setComment_count (String comment_count)
    {
        this.comment_count = comment_count;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDuration_time ()
    {
        return duration_time;
    }

    public void setDuration_time (String duration_time)
    {
        this.duration_time = duration_time;
    }

    public String getTrainer_name ()
    {
        return trainer_name;
    }

    public void setTrainer_name (String trainer_name)
    {
        this.trainer_name = trainer_name;
    }

    public String getImage_url ()
    {
        return image_url;
    }

    public void setImage_url (String image_url)
    {
        this.image_url = image_url;
    }

    public String getVideoId ()
    {
        return videoId;
    }

    public void setVideoId (String videoId)
    {
        this.videoId = videoId;
    }

    public String getContent_text ()
    {
        return content_text;
    }

    public void setContent_text (String content_text)
    {
        this.content_text = content_text;
    }

    public String getFeed_type ()
    {
        return feed_type;
    }

    public void setFeed_type (String feed_type)
    {
        this.feed_type = feed_type;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    public String getTrainer_image ()
    {
        return trainer_image;
    }

    public void setTrainer_image (String trainer_image)
    {
        this.trainer_image = trainer_image;
    }

    public String getRelax_score ()
    {
        return relax_score;
    }

    public void setRelax_score (String relax_score)
    {
        this.relax_score = relax_score;
    }

    public String getContent_url ()
    {
        return content_url;
    }

    public void setContent_url (String content_url)
    {
        this.content_url = content_url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [energy_score = "+energy_score+", comment_count = "+comment_count+", title = "+title+", duration_time = "+duration_time+", trainer_name = "+trainer_name+", image_url = "+image_url+", videoId = "+videoId+", content_text = "+content_text+", feed_type = "+feed_type+", day = "+day+", trainer_image = "+trainer_image+", relax_score = "+relax_score+", content_url = "+content_url+"]";
    }

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getWorkOutId() {
		return workOutId;
	}

	public void setWorkOutId(String workOutId) {
		this.workOutId = workOutId;
	}

	public String getTrainer_bio() {
		return trainer_bio;
	}

	public void setTrainer_bio(String trainer_bio) {
		this.trainer_bio = trainer_bio;
	}

	public String getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(String subCatId) {
		this.subCatId = subCatId;
	}

	public String getOnDemandId() {
		return onDemandId;
	}

	public void setOnDemandId(String onDemandId) {
		this.onDemandId = onDemandId;
	}

	}
			