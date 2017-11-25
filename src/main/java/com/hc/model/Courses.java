package com.hc.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "courses")
public class Courses {
	private int id;
	private String currentLevel;
	private String name;
	private String courseDay;
	private String module;
	private String level;
	private String subLevel;
	private String audioLink;
	private String videoLink;
	private String animationLink;
	private String breathSequence;
	private String breathCycle;
	private String ratio;
	private String courseDuration;
	private String description;
	private Date created;
	private Date lastUpdated;
	private String nextModule;
	private String nextLevel;
	private int hcBtId;
	private String BtId;
	private String imageUrl;
	private String trainerName;
	private String audioDuration;
	public String getAudioDuration() {
		return audioDuration;
	}

	public void setAudioDuration(String audioDuration) {
		this.audioDuration = audioDuration;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerBio() {
		return trainerBio;
	}

	public void setTrainerBio(String trainerBio) {
		this.trainerBio = trainerBio;
	}

	public String getTrainerImage() {
		return trainerImage;
	}

	public void setTrainerImage(String trainerImage) {
		this.trainerImage = trainerImage;
	}

	private String trainerBio;
	private String trainerImage;
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private int catId;
	
	
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getBtId() {
		return BtId;
	}

	public void setBtId(String btId) {
		BtId = btId;
	}

	private String nameOfTech;
	private String btDesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseDay() {
		return courseDay;
	}

	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSubLevel() {
		return subLevel;
	}

	public void setSubLevel(String subLevel) {
		this.subLevel = subLevel;
	}

	public String getAudioLink() {
		return audioLink;
	}

	public void setAudioLink(String audioLink) {
		this.audioLink = audioLink;
	}

	public String getBreathSequence() {
		return breathSequence;
	}

	public void setBreathSequence(String breathSequence) {
		this.breathSequence = breathSequence;
	}

	public String getBreathCycle() {
		return breathCycle;
	}

	public void setBreathCycle(String breathCycle) {
		this.breathCycle = breathCycle;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getNextModule() {
		return nextModule;
	}

	public void setNextModule(String nextModule) {
		this.nextModule = nextModule;
	}

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}

	public int getHcBtId() {
		return hcBtId;
	}

	public void setHcBtId(int hcBtId) {
		this.hcBtId = hcBtId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((videoLink == null) ? 0 : videoLink.hashCode());
		result = prime * result
				+ ((audioLink == null) ? 0 : audioLink.hashCode());
		result = prime * result
				+ ((breathCycle == null) ? 0 : breathCycle.hashCode());
		result = prime * result
				+ ((breathSequence == null) ? 0 : breathSequence.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((courseDuration == null) ? 0 : courseDuration.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((ratio == null) ? 0 : ratio.hashCode());
		result = prime * result
				+ ((subLevel == null) ? 0 : subLevel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courses other = (Courses) obj;
		if (videoLink == null) {
			if (other.videoLink != null)
				return false;
		} else if (!videoLink.equals(other.videoLink))
			return false;
		if (audioLink == null) {
			if (other.audioLink != null)
				return false;
		} else if (!audioLink.equals(other.audioLink))
			return false;
		if (breathCycle == null) {
			if (other.breathCycle != null)
				return false;
		} else if (!breathCycle.equals(other.breathCycle))
			return false;
		if (breathSequence == null) {
			if (other.breathSequence != null)
				return false;
		} else if (!breathSequence.equals(other.breathSequence))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (courseDuration == null) {
			if (other.courseDuration != null)
				return false;
		} else if (!courseDuration.equals(other.courseDuration))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (ratio == null) {
			if (other.ratio != null)
				return false;
		} else if (!ratio.equals(other.ratio))
			return false;
		if (subLevel == null) {
			if (other.subLevel != null)
				return false;
		} else if (!subLevel.equals(other.subLevel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", currentLevel=" + currentLevel
				+ ", name=" + name + ", module=" + module + ", level=" + level
				+ ", subLevel=" + subLevel + ", audioLink=" + audioLink
				+ ", animationLink=" + videoLink + ", breathSequence="
				+ breathSequence + ", breathCycle=" + breathCycle + ", ratio="
				+ ratio + ", courseDuration=" + courseDuration
				+ ", description=" + description + ", created=" + created
				+ ", lastUpdated=" + lastUpdated + "]";
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getAnimationLink() {
		return animationLink;
	}

	public void setAnimationLink(String animationLink) {
		this.animationLink = animationLink;
	}

	public String getNameOfTech() {
		return nameOfTech;
	}

	public void setNameOfTech(String nameOfTech) {
		this.nameOfTech = nameOfTech;
	}

	public String getBtDesc() {
		return btDesc;
	}

	public void setBtDesc(String btDesc) {
		this.btDesc = btDesc;
	}

}
