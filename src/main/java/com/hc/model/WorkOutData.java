package com.hc.model;

public class WorkOutData {

	private String planName;
	private String workOutName;
	private String duration;
	private String completionMin;
	private int catId;
	private String catName;
	private String lastUpdated;
	private String range;
	private String totalTime;
	private int isCompleted;
	private int isOnDemand;
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getWorkOutName() {
		return workOutName;
	}
	public void setWorkOutName(String workOutName) {
		this.workOutName = workOutName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCompletionMin() {
		return completionMin;
	}
	public void setCompletionMin(String completionMin) {
		this.completionMin = completionMin;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public int getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(int isCompleted) {
		this.isCompleted = isCompleted;
	}
	public int getIsOnDemand() {
		return isOnDemand;
	}
	public void setIsOnDemand(int isOnDemand) {
		this.isOnDemand = isOnDemand;
	}
}
