package com.hc.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/*
 * 
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `hcid` int(10) DEFAULT NULL,
  `hcvalue` text,
  `hcstatus` varchar(15) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastupdated` datetime DEFAULT NULL
 */
@XmlRootElement
public class UserHealthCondition {
	private Integer id;
	private Integer userId;
	private Integer hcId;
	private String hcValue;
	private String hcStatus;
	private Date created;
	private Date lastUpdated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHcId() {
		return hcId;
	}
	public void setHcId(Integer hcId) {
		this.hcId = hcId;
	}
	public String getHcValue() {
		return hcValue;
	}
	public void setHcValue(String hcValue) {
		this.hcValue = hcValue;
	}
	public String getHcStatus() {
		return hcStatus;
	}
	public void setHcStatus(String hcStatus) {
		this.hcStatus = hcStatus;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((hcId == null) ? 0 : hcId.hashCode());
		result = prime * result
				+ ((hcStatus == null) ? 0 : hcStatus.hashCode());
		result = prime * result + ((hcValue == null) ? 0 : hcValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
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
		UserHealthCondition other = (UserHealthCondition) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (hcId == null) {
			if (other.hcId != null)
				return false;
		} else if (!hcId.equals(other.hcId))
			return false;
		if (hcStatus == null) {
			if (other.hcStatus != null)
				return false;
		} else if (!hcStatus.equals(other.hcStatus))
			return false;
		if (hcValue == null) {
			if (other.hcValue != null)
				return false;
		} else if (!hcValue.equals(other.hcValue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
