package com.hc.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"increment", "promoteScore", "maxScore","courseDuration","freeUserSequencesM",
					   "freeUserSequencesA","freeUserSequencesE"})
public class SystemPreferenceInfo extends BaseObject implements Serializable{

	private static final long serialVersionUID = 1L;

	int increment;
	int promoteScore;
	int maxScore;
	float courseDuration;
	int freeUserSequencesM;
	int freeUserSequencesA;
	int freeUserSequencesE;
	
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public int getPromoteScore() {
		return promoteScore;
	}
	public void setPromoteScore(int promoteScore) {
		this.promoteScore = promoteScore;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public float getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(float courseDuration) {
		this.courseDuration = courseDuration;
	}
	public int getFreeUserSequencesM() {
		return freeUserSequencesM;
	}
	public void setFreeUserSequencesM(int freeUserSequencesM) {
		this.freeUserSequencesM = freeUserSequencesM;
	}
	public int getFreeUserSequencesA() {
		return freeUserSequencesA;
	}
	public void setFreeUserSequencesA(int freeUserSequencesA) {
		this.freeUserSequencesA = freeUserSequencesA;
	}
	public int getFreeUserSequencesE() {
		return freeUserSequencesE;
	}
	public void setFreeUserSequencesE(int freeUserSequencesE) {
		this.freeUserSequencesE = freeUserSequencesE;
	}
	
	
}
