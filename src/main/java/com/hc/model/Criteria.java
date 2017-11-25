package com.hc.model;

import java.io.Serializable;

public class Criteria implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer fitnessLevel;
	private Integer flexiblityType;
	private Integer bodyFocus;
	private Integer equipment;
	private Integer strengthnings;
	private Integer planId;
	public Integer getFlexiblityType() {
		return flexiblityType;
	}
	public void setFlexiblityType(Integer flexiblityType) {
		this.flexiblityType = flexiblityType;
	}
	public Integer getBodyFocus() {
		return bodyFocus;
	}
	public void setBodyFocus(Integer bodyFocus) {
		this.bodyFocus = bodyFocus;
	}
	public Integer getEquipment() {
		return equipment;
	}
	public void setEquipment(Integer equipment) {
		this.equipment = equipment;
	}
	public Integer getStrengthnings() {
		return strengthnings;
	}
	public void setStrengthnings(Integer strengthnings) {
		this.strengthnings = strengthnings;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getFitnessLevel() {
		return fitnessLevel;
	}
	public void setFitnessLevel(Integer fitnessLevel) {
		this.fitnessLevel = fitnessLevel;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
}
