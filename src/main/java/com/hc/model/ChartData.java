package com.hc.model;

public class ChartData {

	private int Id;
	private String totalTime;
	private String name;
	private String fromDate;
	private String toDate;
	private int isOnDemand;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public int getIsOnDemand() {
		return isOnDemand;
	}
	public void setIsOnDemand(int isOnDemand) {
		this.isOnDemand = isOnDemand;
	}
}
