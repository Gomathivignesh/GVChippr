package com.hc.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserCourseLog {
	private Integer logId;
	private Integer userId;
	private Date loginDateTime;
	private Date logoutDateTime;
	private String startTime;
	private String endTime;
	private Integer courseId;
	private double courseDuration;
	private String ipAddress;
	private double inhaleTime;
	private double exhaleTime;
	private double retentionTime;
	private double otherTime;
	private String courseBucket;
	private double score;
	private Date created;
	private Date lastUpdated;
	private String deviceName;
	private String btId;
	
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	public Date getLogoutDateTime() {
		return logoutDateTime;
	}
	public void setLogoutDateTime(Date logoutDateTime) {
		this.logoutDateTime = logoutDateTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public double getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(double courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public double getInhaleTime() {
		return inhaleTime;
	}
	public void setInhaleTime(double inhaleTime) {
		this.inhaleTime = inhaleTime;
	}
	public double getExhaleTime() {
		return exhaleTime;
	}
	public void setExhaleTime(double exhaleTime) {
		this.exhaleTime = exhaleTime;
	}
	public double getRetentionTime() {
		return retentionTime;
	}
	public void setRetentionTime(double retentionTime) {
		this.retentionTime = retentionTime;
	}
	public double getOtherTime() {
		return otherTime;
	}
	public void setOtherTime(double otherTime) {
		this.otherTime = otherTime;
	}
	public String getCourseBucket() {
		return courseBucket;
	}
	public void setCourseBucket(String courseBucket) {
		this.courseBucket = courseBucket;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getBtId() {
		return btId;
	}
	public void setBtId(String btId) {
		this.btId = btId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseBucket == null) ? 0 : courseBucket.hashCode());
		long temp;
		temp = Double.doubleToLongBits(courseDuration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		temp = Double.doubleToLongBits(exhaleTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(inhaleTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
		result = prime * result
				+ ((loginDateTime == null) ? 0 : loginDateTime.hashCode());
		result = prime * result
				+ ((logoutDateTime == null) ? 0 : logoutDateTime.hashCode());
		temp = Double.doubleToLongBits(otherTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(retentionTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		UserCourseLog other = (UserCourseLog) obj;
		if (courseBucket == null) {
			if (other.courseBucket != null)
				return false;
		} else if (!courseBucket.equals(other.courseBucket))
			return false;
		if (Double.doubleToLongBits(courseDuration) != Double
				.doubleToLongBits(other.courseDuration))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (Double.doubleToLongBits(exhaleTime) != Double
				.doubleToLongBits(other.exhaleTime))
			return false;
		if (Double.doubleToLongBits(inhaleTime) != Double
				.doubleToLongBits(other.inhaleTime))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (logId == null) {
			if (other.logId != null)
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		if (loginDateTime == null) {
			if (other.loginDateTime != null)
				return false;
		} else if (!loginDateTime.equals(other.loginDateTime))
			return false;
		if (logoutDateTime == null) {
			if (other.logoutDateTime != null)
				return false;
		} else if (!logoutDateTime.equals(other.logoutDateTime))
			return false;
		if (Double.doubleToLongBits(otherTime) != Double
				.doubleToLongBits(other.otherTime))
			return false;
		if (Double.doubleToLongBits(retentionTime) != Double
				.doubleToLongBits(other.retentionTime))
			return false;
		if (Double.doubleToLongBits(score) != Double
				.doubleToLongBits(other.score))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	

}
