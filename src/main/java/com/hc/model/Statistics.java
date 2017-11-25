package com.hc.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Statistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date date;
	private String score;
	private Boolean mileStoneCrossed;
	private String module;
	private String level;
	private double movingAvg;
	private String courseName;
	private long totalTimeSpent;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Boolean getMileStoneCrossed() {
		return mileStoneCrossed;
	}

	public void setMileStoneCrossed(Boolean mileStoneCrossed) {
		this.mileStoneCrossed = mileStoneCrossed;
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

	public double getMovingAvg() {
		return movingAvg;
	}

	public void setMovingAvg(double movingAvg) {
		this.movingAvg = movingAvg;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getTotalTimeSpent() {
		return totalTimeSpent;
	}

	public void setTotalTimeSpent(long totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

}
