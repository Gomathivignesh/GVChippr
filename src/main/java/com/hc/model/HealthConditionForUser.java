package com.hc.model;


public class HealthConditionForUser {
	
	String conditions;
	String description;
	int code;
	boolean userHasCondition;
	
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isUserHasCondition() {
		return userHasCondition;
	}
	public void setUserHasCondition(boolean userHasCondition) {
		this.userHasCondition = userHasCondition;
	}	
	
}
