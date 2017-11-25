package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Date;

@XmlRootElement
//@XmlType(name = { "id", "duartion","planId","created", "lastUpdated"})
public class Goal implements Serializable {

	public Goal()
	{
		
	}
	private static final long serialVersionUID = 1L;
	private Integer goalId;
	private Integer duration;
	private Integer planId;
	private Date created;
	private Date lastUpdated;	
	
	
	public Integer getGoalId() {
		return goalId;
	}

	public void setGoalId(Integer goalId) {
		this.goalId = goalId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result	+ ((goalId == null) ? 0 : goalId.hashCode());
		result = prime * result	+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result	+ ((planId == null) ? 0 : planId.hashCode());
		result = prime * result	+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());		
		
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
		Goal other = (Goal) obj;
		
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (goalId == null) {
			if (other.goalId != null)
				return false;
		} else if (!goalId.equals(other.goalId))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;		
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;		
		if (planId == null) {
			if (other.planId != null)
				return false;
		} else if (!planId.equals(other.planId))
			return false;
		return true;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", name=" + duration + "]";
	}

}
