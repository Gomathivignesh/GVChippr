package com.hc.model;

import java.io.Serializable;

public class WeekDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer weekNumber;
	private String goal;
	private String score;
	private String planName;
	private String completedWorkOut;
	private String goalWorkOut;
	public Integer getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}
	
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
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
	
	
	
}
