package com.hc.model;

import java.io.Serializable;

public class WeekDetails2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer catId;
	private Integer dayId;
	//private String watchTime;	
	private String name;
	private String goal;
	private String planName;
	private String completedWorkOut;
	private String goalWorkOut;
	private String dayDesc;
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getCompletedWorkOut() {
		return completedWorkOut;
	}
	public void setCompletedWorkOut(String completedWorkOut) {
		this.completedWorkOut = completedWorkOut;
	}
	public String getGoalWorkOut() {
		return goalWorkOut;
	}
	public void setGoalWorkOut(String goalWorkOut) {
		this.goalWorkOut = goalWorkOut;
	}
	public Integer getDayId() {
		return dayId;
	}
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}
	public String getDayDesc() {
		return dayDesc;
	}
	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}
	
	
}
