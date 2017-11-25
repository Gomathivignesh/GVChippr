package com.hc.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLevel {
	public String id;
	public String userId;
	public String currentModule;
	public String nextModule;
	public String currentLevel;
	public String nextLevel;
	public Integer currentLevelTime;
	public Date currentLevelStart;
	public Date currentLevelEnd;
	public String courseId;
	public Integer points;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrentModule() {
		return currentModule;
	}
	public void setCurrentModule(String currentModule) {
		this.currentModule = currentModule;
	}
	public String getNextModule() {
		return nextModule;
	}
	public void setNextModule(String nextModule) {
		this.nextModule = nextModule;
	}
	public String getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}
	public String getNextLevel() {
		return nextLevel;
	}
	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}
	public Integer getCurrentLevelTime() {
		return currentLevelTime;
	}
	public void setCurrentLevelTime(Integer currentLevelTime) {
		this.currentLevelTime = currentLevelTime;
	}
	public Date getCurrentLevelStart() {
		return currentLevelStart;
	}
	public void setCurrentLevelStart(Date currentLevelStart) {
		this.currentLevelStart = currentLevelStart;
	}
	public Date getCurrentLevelEnd() {
		return currentLevelEnd;
	}
	public void setCurrentLevelEnd(Date currentLevelEnd) {
		this.currentLevelEnd = currentLevelEnd;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((currentLevel == null) ? 0 : currentLevel.hashCode());
		result = prime * result
				+ ((currentLevelEnd == null) ? 0 : currentLevelEnd.hashCode());
		result = prime
				* result
				+ ((currentLevelStart == null) ? 0 : currentLevelStart
						.hashCode());
		result = prime
				* result
				+ ((currentLevelTime == null) ? 0 : currentLevelTime.hashCode());
		result = prime * result
				+ ((currentModule == null) ? 0 : currentModule.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nextLevel == null) ? 0 : nextLevel.hashCode());
		result = prime * result
				+ ((nextModule == null) ? 0 : nextModule.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserLevel other = (UserLevel) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (currentLevel == null) {
			if (other.currentLevel != null)
				return false;
		} else if (!currentLevel.equals(other.currentLevel))
			return false;
		if (currentLevelEnd == null) {
			if (other.currentLevelEnd != null)
				return false;
		} else if (!currentLevelEnd.equals(other.currentLevelEnd))
			return false;
		if (currentLevelStart == null) {
			if (other.currentLevelStart != null)
				return false;
		} else if (!currentLevelStart.equals(other.currentLevelStart))
			return false;
		if (currentLevelTime == null) {
			if (other.currentLevelTime != null)
				return false;
		} else if (!currentLevelTime.equals(other.currentLevelTime))
			return false;
		if (currentModule == null) {
			if (other.currentModule != null)
				return false;
		} else if (!currentModule.equals(other.currentModule))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nextLevel == null) {
			if (other.nextLevel != null)
				return false;
		} else if (!nextLevel.equals(other.nextLevel))
			return false;
		if (nextModule == null) {
			if (other.nextModule != null)
				return false;
		} else if (!nextModule.equals(other.nextModule))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}
